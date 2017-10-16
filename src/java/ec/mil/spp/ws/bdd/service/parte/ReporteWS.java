package ec.mil.spp.ws.bdd.service.parte;

import ec.mil.spp.ws.bdd.PgdoGrupoope;
import ec.mil.spp.ws.bdd.dto.GrupoDTO;
import ec.mil.spp.ws.bdd.dto.ReporteDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * @unidad SIPER
 * @author Cbop. Cacuango Luis
 */
@Stateless  //Para decir que es una transaccion
@Path("reporte")
public class ReporteWS {

    @PersistenceContext(unitName = "parteMovilWebPU")
    private EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("grupos")
    public List<GrupoDTO> consultarGrupos() throws Exception {
        List<GrupoDTO> grupos = new ArrayList<>();
        TypedQuery<PgdoGrupoope> conTipNov = em.createQuery("Select gru from PgdoGrupoope gru ", PgdoGrupoope.class);
        for (PgdoGrupoope gruTmp : conTipNov.getResultList()) {
            GrupoDTO grupoDto = new GrupoDTO();
            grupoDto.setGdoSecuen(gruTmp.getGdoSecuen());
            grupoDto.setGdoGrupoope(gruTmp.getGdoGrupoope());
            grupos.add(grupoDto);
        }
        return grupos;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("general")
    public List<ReporteDTO> consultarRepEst(@QueryParam(value = "sql") String sqlGrupos,
            @QueryParam(value = "fechaBus") String fecha) throws Exception {
        List<ReporteDTO> repEst = new ArrayList<>();
        Query conRepEst = em.createNativeQuery("select row_number() over (ORDER BY per.per_secuen)as fila, (case gmi_tipoefec when 'O' then '1OFIC.' when 'V' then '2VOLT.' else '3S.P.' end) gmi_tipoefec,\n"
                + "   (case when personal.f_estado(per.per_secuen,?1::date) is null Then 'DISPONIBLES'\n"
                + "    else personal.f_estado(per.per_secuen,?1::date) end) estado, ?1 as fec,\n"
                + "    gdo_grupoope as grupo, 1::int as total\n"
                + " from personal.pper_persona per, personal.pfun_funcion fun, personal.puni_unidad uni,\n"
                + "      personal.pgdo_grupoope gdo, personal.pgmi_gradomil gmi\n"
                + "   where per.fun_secuen = fun.fun_secuen\n"
                + "     and fun.uni_secuen = uni.uni_secuen\n"
                + "     and per.gmi_secuen = gmi.gmi_secuen\n"
                + "     and uni.gdo_secuen = gdo.gdo_secuen\n"
                + "     and per.per_fecingre <= ?1::date \n"
                + "     and (case when per.per_fecsalida is null Then current_date else per.per_fecsalida end) >= ?1::date \n"
                + sqlGrupos);
        conRepEst.setParameter(1, fecha);
        for (Object regTmp : conRepEst.getResultList()) {
            Object[] reg = (Object[]) regTmp;
            ReporteDTO repDto = new ReporteDTO();
            repDto.setFila(Integer.parseInt(reg[0].toString()));
            repDto.setTipoEfectivo(reg[1].toString());
            repDto.setNovedad(reg[2].toString());
            repDto.setGrupo(reg[4].toString());
            repDto.setValor(1);
            repEst.add(repDto);
        }
        return repEst;
    }
}
