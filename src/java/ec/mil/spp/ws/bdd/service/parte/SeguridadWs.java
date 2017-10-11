package ec.mil.spp.ws.bdd.service.parte;

import ec.mil.spp.negocio.util.UtilSPP;
import ec.mil.spp.ws.bdd.SusuUsuario;
import ec.mil.spp.ws.bdd.dto.UsuarioDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
@Stateless  //Para decir que es una transaccion
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
            TypedQuery<SusuUsuario> conUsu = em.createQuery("Select usu FROM SusuUsuario usu "
                    + " where usu.usuUsuario =:usuario and usu.usuPassword =:clave", SusuUsuario.class);
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

}
