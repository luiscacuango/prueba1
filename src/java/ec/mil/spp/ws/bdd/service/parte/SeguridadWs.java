package ec.mil.spp.ws.bdd.service.parte;

import ec.mil.spp.negocio.util.UtilSPP;
import ec.mil.spp.ws.bdd.PlypLiceperm;
import ec.mil.spp.ws.bdd.PperPersona;
import ec.mil.spp.ws.bdd.SusuUsuario;
import ec.mil.spp.ws.bdd.dto.PersonaDTO;
import ec.mil.spp.ws.bdd.dto.UsuarioDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * @unidad SIPER
 * @author Cbop. Cacuango Luis
 */
@Path("seguridad")
public class SeguridadWs {
    
    @PersistenceContext(unitName = "parteMovilWebPU")
    private EntityManager em;
    
    @GET
    @Path("validarUsuario/{usuario}/{clave}")
    @Produces(MediaType.APPLICATION_JSON)
    public UsuarioDTO validarUsuario(@PathParam(value = "usuario") String usuario,
            @PathParam(value = "clave") String clave) throws Exception {
        UsuarioDTO usuarioDto;
        try {
            String claveDes = UtilSPP.encriptar(clave);
            TypedQuery<SusuUsuario> conUsu = em.createQuery("Select usu FROM SusuUsuario usu where usu.usuUsuario =:usuario and usu.usuPassword =:clave", SusuUsuario.class);
            conUsu.setParameter("usuario", usuario);
            conUsu.setParameter("clave", claveDes);
            SusuUsuario usuarioPer = conUsu.getSingleResult();
            //Composicion del objeto
            usuarioDto = new UsuarioDTO();
            usuarioDto.setUsuSecuen(usuarioPer.getUsuSecuen());
            usuarioDto.setUsuUsuario(usuarioPer.getUsuUsuario());
            usuarioDto.setUsuPassword(usuarioPer.getUsuPassword());
            usuarioDto.setPerSecuen(usuarioPer.getPerSecuen().getPerSecuen());
            usuarioDto.setPerCedula(usuarioPer.getPerSecuen().getPerCedula());
            usuarioDto.setPerNombre(usuarioPer.getPerSecuen().getPerNombre());
            usuarioDto.setPerApellido(usuarioPer.getPerSecuen().getPerApellido());
            usuarioDto.setPerfil("");
            usuarioDto.setEspecialidad(usuarioPer.getPerSecuen().getEspSecuen().getEspAbrevi());
            usuarioDto.setFuncion(usuarioPer.getPerSecuen().getFunSecuen().getFunFuncion());
            usuarioDto.setGrupo(usuarioPer.getPerSecuen().getFunSecuen().getUniSecuen().getGdoSecuen().getGdoAbreviat());
            usuarioDto.setUnidad(usuarioPer.getPerSecuen().getFunSecuen().getUniSecuen().getUniAbreviat());
            usuarioDto.setNombreGrado(usuarioPer.getPerSecuen().getGmiSecuen().getGmiAbreviat());
            /***********************************************************************************
             * Cargar Personal Disponible
             * ********************************************************************************/
            List<PersonaDTO> listPersonal = new ArrayList<>();
            for (PperPersona perTmp:buscarPersonalPorGrupo(usuarioPer.getPerSecuen().getFunSecuen().getUniSecuen().getGdoSecuen().getGdoSecuen(), new Date())) {
                PersonaDTO personaDTO = new PersonaDTO();
                personaDTO.setPerSecuen(perTmp.getPerSecuen());
                personaDTO.setPerCedula(perTmp.getPerCedula());
                personaDTO.setPerApellido(perTmp.getPerApellido());
                personaDTO.setPerNombre(perTmp.getPerNombre());
                personaDTO.setNombreGrado(perTmp.getGmiSecuen().getGmiAbreviat());
                listPersonal.add(personaDTO);
            }            
            usuarioDto.setListaPersonal(listPersonal);
            /***********************************************************************************
             * Cargar Personal Disponible
             * ********************************************************************************/
            List<PersonaDTO> listPersonalNov = new ArrayList<>();
            for (PlypLiceperm licPerTmp:cargaNovedades(usuarioPer.getPerSecuen().getFunSecuen().getUniSecuen().getGdoSecuen().getGdoSecuen(), new Date())) {
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
            usuarioDto.setListaPersonalNov(listPersonalNov);
        } catch (Exception e) {
            throw new Exception("Usuario no encontrado");
        }
        return usuarioDto;
    }
    
    @GET
    @Path("validarUsuarioDos")
    @Produces(MediaType.APPLICATION_JSON)
    public SusuUsuario validarUsuarioDos(@QueryParam(value = "usuario") String usuario,
            @QueryParam(value = "clave") String clave) {
        SusuUsuario usuarioDev;
        try {
            String claveDes = UtilSPP.encriptar(clave);
            TypedQuery<SusuUsuario> conUsu = em.createQuery("Select usu FROM SusuUsuario usu "
                    + "where usu.usuUsuario =:usuario and usu.usuPassword =:clave", SusuUsuario.class);
            conUsu.setParameter("usuario", usuario);
            conUsu.setParameter("clave", claveDes);
            usuarioDev = conUsu.getSingleResult();
        } catch (Exception e) {
            usuarioDev = null;
        }
        return usuarioDev;
    }
    
    @GET
    @Path("consultarTodos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<UsuarioDTO> consultarTodos() {
        UsuarioDTO usuarioDto;
        List<SusuUsuario> conTodUsu = em.createQuery("Select usu from SusuUsuario usu", SusuUsuario.class).getResultList();
        List<UsuarioDTO> listaUsuDto = new ArrayList();
        for (SusuUsuario object : conTodUsu) {
            usuarioDto = new UsuarioDTO();
            usuarioDto.setUsuSecuen(object.getUsuSecuen());
            usuarioDto.setUsuUsuario(object.getUsuUsuario());
            usuarioDto.setUsuPassword(object.getUsuPassword());
            usuarioDto.setPerSecuen(object.getPerSecuen().getPerSecuen());
            usuarioDto.setPerCedula(object.getPerSecuen().getPerCedula());
            usuarioDto.setPerNombre(object.getPerSecuen().getPerNombre());
            usuarioDto.setPerApellido(object.getPerSecuen().getPerApellido());
            listaUsuDto.add(usuarioDto);
            
        }
        return listaUsuDto;
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
