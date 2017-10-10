package ec.mil.spp.ws.bdd.service.parte;

import ec.mil.spp.ws.bdd.PlypLiceperm;
import ec.mil.spp.ws.bdd.PperPersona;
import ec.mil.spp.ws.bdd.PtlpTiplicper;
import ec.mil.spp.ws.bdd.dto.NovedadDTO;
import ec.mil.spp.ws.bdd.dto.PersonaDTO;
import ec.mil.spp.ws.bdd.dto.TipoNovedadDTO;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * @unidad SIPER
 * @author Cbop. Cacuango Luis 
 * Clase para controlar las opciones de novedades
 */
@Path("novedad")
public class NovedadWs {

    @PersistenceContext(unitName = "parteMovilWebPU")
    private EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("tiposNovedad")
    public List<TipoNovedadDTO> consultarTiposNovedad(@PathParam(value = "tipoEfectivo") String tipoEfectivo) throws Exception {
        List<TipoNovedadDTO> listaTipoNov = new ArrayList<>();
        List<String> listaTipoEfe = new ArrayList<>();
        listaTipoEfe.add("T");
        listaTipoEfe.add(tipoEfectivo);
        TypedQuery<PtlpTiplicper> conTipNov = em.createQuery("Select tipNov from PtlpTiplicper "
                + " tipNov where tipNov.tlpClase in :listaTipoEfe "
                + " order by tipNov.tlpTipo ", PtlpTiplicper.class);
        conTipNov.setParameter("listaTipoEfe", listaTipoEfe);
        TipoNovedadDTO tipNovLic = new TipoNovedadDTO(1, "Licencia");
        TipoNovedadDTO tipNovPer = new TipoNovedadDTO(2, "Permiso");
        TipoNovedadDTO tipNovNov = new TipoNovedadDTO(3, "Novedad");
        for (PtlpTiplicper tipPer : conTipNov.getResultList()) {
            TipoNovedadDTO tipInt = new TipoNovedadDTO();
            tipInt.setIdTipNov(tipPer.getTlpSecuen());
            tipInt.setDesTipNov(tipPer.getTlpDescri());
            if (tipPer.getTlpTipo().equals('P')) {
                tipNovPer.getListaSubtipos().add(tipInt);
            } else if (tipPer.getTlpTipo().equals('N')) {
                tipNovNov.getListaSubtipos().add(tipInt);
            } else {
                tipNovLic.getListaSubtipos().add(tipInt);
            }
        }
        listaTipoNov.add(tipNovLic);
        listaTipoNov.add(tipNovPer);
        listaTipoNov.add(tipNovNov);
        return listaTipoNov;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("guardarNovedad")
    public String guardarNovedad(NovedadDTO novedadDto) throws Exception {
        PlypLiceperm novedad = new PlypLiceperm();
        novedad.setCiuSecuen(BigInteger.valueOf(5));
        novedad.setPerSecuen(em.find(PperPersona.class, novedadDto.getPersona().getPerSecuen()));
        novedad.setTlpSecuen(em.find(PtlpTiplicper.class, novedadDto.getTipoLicencia()));
        novedad.setLypInicio(novedadDto.getLypInicio());
        novedad.setLypFin(novedadDto.getLypFin());
        novedad.setLypObserv(novedadDto.getLypObserv());
        novedad.setLypDias((short) novedadDto.getLypDias());
        novedad.setLypHoras((short) novedadDto.getLypHoras());
        novedad.setLypMinuto((short) novedadDto.getLypMinuto());
        novedad.setLypEntreg('S');
        novedad.setLypFecent(new Date());
        novedad.setLypDiaimp(null);
        novedad.setLypFecha(new Date());
        em.persist(novedad);
        return "Novedad registrada exitosamente";
    }

    /**
     *  Metodo para consultar al personal Disponible
     * @param fechaBus
     * @param perSecuen
     * @return
     * @throws Exception
     */
    @GET
    @Path("consultarPerDisponible")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonaDTO> consultarPersonaDisponible(@QueryParam(value = "fechaBus") Date fechaBus, 
            @QueryParam(value = "perSecuen") Long perSecuen) throws Exception{
            /***********************************************************************************
             * Consultar Personal Disponible
             * ********************************************************************************/
        PperPersona persona = em.find(PperPersona.class, perSecuen);
            List<PersonaDTO> listPersonal = new ArrayList<>();
            for (PperPersona perTmp:buscarPersonalPorGrupo(persona.getFunSecuen().getUniSecuen().getGdoSecuen().getGdoSecuen(), 
                     fechaBus)) {
                PersonaDTO personaDTO = new PersonaDTO();
                personaDTO.setPerSecuen(perTmp.getPerSecuen());
                personaDTO.setPerCedula(perTmp.getPerCedula());
                personaDTO.setPerApellido(perTmp.getPerApellido());
                personaDTO.setPerNombre(perTmp.getPerNombre());
                personaDTO.setNombreGrado(perTmp.getGmiSecuen().getGmiAbreviat());
                personaDTO.setTipoEfectivo(perTmp.getGmiSecuen().getGmiTipoefec().toString());
                listPersonal.add(personaDTO);
            }      
            return listPersonal;
    }
    
    /**
     *  Metodo para consultar al Personal con Novedad
     * @param fechaBus
     * @param perSecuen
     * @return
     * @throws Exception
     */
    @GET
    @Path("consultarPerNovedad")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonaDTO> consultarPersonalNovedad(@QueryParam(value = "fechaBus") Date fechaBus, 
            @QueryParam(value = "perSecuen") Long perSecuen) throws Exception{
            /***********************************************************************************
             * Cargar Personal con Novedades
             * ********************************************************************************/
        PperPersona persona = em.find(PperPersona.class, perSecuen);
            List<PersonaDTO> listPersonalNov = new ArrayList<>();
            for (PlypLiceperm licPerTmp:cargaNovedades(persona.getFunSecuen().getUniSecuen().getGdoSecuen().getGdoSecuen(), 
                     fechaBus)) {
                PersonaDTO personaDTO = new PersonaDTO();
                personaDTO.setPerSecuen(licPerTmp.getPerSecuen().getPerSecuen());
                personaDTO.setPerCedula(licPerTmp.getPerSecuen().getPerCedula());
                personaDTO.setPerApellido(licPerTmp.getPerSecuen().getPerApellido());
                personaDTO.setPerNombre(licPerTmp.getPerSecuen().getPerNombre());
                personaDTO.setPerNovedad(licPerTmp.getTlpSecuen().getTlpDescri());
                personaDTO.setPerFechaInicio(licPerTmp.getLypInicio());
                personaDTO.setPerFechaFin(licPerTmp.getLypFin());
                listPersonalNov.add(personaDTO);
            }            
            return listPersonalNov;
    }
    
    /**
     * Método para listar personal DISPONIBLE de un grupo por fecha
     * @param idGru
     * @param fecha
     * @return 
     */
    public List<PperPersona> buscarPersonalPorGrupo(Integer idGru, Date fecha) throws Exception {
        Query conPerGru = em.createNativeQuery("select p.per_secuen, p.per_nombre,"
                + "      p.per_apellido, gr.gmi_secuen, gr.gmi_grado"
                + " from personal.pper_persona p, personal.pfun_funcion f,"
                + "      personal.puni_unidad u, personal.pgdo_grupoope g, "
                + "      personal.pgmi_gradomil gr"
                + " where p.per_fecsalida is null and "
                + "       p.gmi_secuen = gr.gmi_secuen and "
                + "       p.fun_secuen = f.fun_secuen and "
                + "       f.uni_secuen = u.uni_secuen and "
                + "       u.gdo_secuen = g.gdo_secuen and "
                + "       g.gdo_secuen = ?1 and"
                + "       p.per_Secuen not in (Select per_secuen from personal.Plyp_Liceperm lyp"
                + "             where ?2 between lyp.lyp_Inicio::date and lyp.lyp_Fin::date)"
                + "       order by gr.gmi_orden, p.per_apellido", PperPersona.class);
        conPerGru.setParameter(1, idGru);
        conPerGru.setParameter(2, fecha);
        return conPerGru.getResultList();
    }

    /**
     * Método para cargar el parte por día y grupo
     *
     * @param idGru
     * @param fecha
     * @return
     */
    
    public List<PlypLiceperm> cargaNovedades(Integer idGru, Date fecha) {
        Query connoved = em.createNativeQuery("Select * "
                + "from personal.plyp_liceperm lyp, personal.pper_persona p,"
                + "     personal.pfun_funcion f, personal.puni_unidad u,"
                + "     personal.pgdo_grupoope g, personal.pgmi_gradomil gr"
                + "                 where lyp.per_secuen = p.per_Secuen"
                + "                   and p.gmi_secuen = gr.gmi_secuen"
                + "                   and p.fun_secuen = f.fun_secuen"
                + "                   and f.uni_secuen = u.uni_secuen"
                + "                   and u.gdo_secuen = g.gdo_secuen"
                + "                   and g.gdo_secuen = ?1"
                + "                   and ?2 between lyp.lyp_inicio::date and lyp.lyp_fin::date"
                + "                 order by lyp.lyp_Inicio desc", PlypLiceperm.class);
//        Query connoved = em.createQuery("Select lyp from PlypLiceperm lyp "
//                + " where lyp.perSecuen.funSecuen.unidad.grupo.gdoSecuen =:grupo"
//                + "  and :fecha between lyp.lypInicio and lyp.lypFin"
//                + " order by lyp.lypInicio desc");
        connoved.setParameter(1, idGru);
        connoved.setParameter(2, fecha);
        return connoved.getResultList();
    }
    
}
