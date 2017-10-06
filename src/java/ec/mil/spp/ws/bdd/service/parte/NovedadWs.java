package ec.mil.spp.ws.bdd.service.parte;

import ec.mil.spp.ws.bdd.PlypLiceperm;
import ec.mil.spp.ws.bdd.PperPersona;
import ec.mil.spp.ws.bdd.PtlpTiplicper;
import ec.mil.spp.ws.bdd.dto.NovedadDTO;
import ec.mil.spp.ws.bdd.dto.TipoNovedadDTO;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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

}
