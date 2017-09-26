package ec.mil.spp.ws.bdd.dto;

import java.util.List;

/**
 * @author Cbop. Cacuango Luis
 */
public class UsuarioDTO {
    private Integer usuSecuen;
    private String usuUsuario;
    private String usuPassword;
    private Long perSecuen;
    private String perCedula;
    private String perApellido;
    private String perNombre;
    private String nombreGrado;
    private String funcion;
    private String especialidad;
    private String unidad;
    private String grupo;
    private String perfil;
    private List<PersonaDTO> listaPersonal;
    private List<PersonaDTO> listaPersonalNov;

    public UsuarioDTO() {
    }

    public Integer getUsuSecuen() {
        return usuSecuen;
    }

    public void setUsuSecuen(Integer usuSecuen) {
        this.usuSecuen = usuSecuen;
    }

    public String getUsuUsuario() {
        return usuUsuario;
    }

    public void setUsuUsuario(String usuUsuario) {
        this.usuUsuario = usuUsuario;
    }

    public String getUsuPassword() {
        return usuPassword;
    }

    public void setUsuPassword(String usuPassword) {
        this.usuPassword = usuPassword;
    }

    public Long getPerSecuen() {
        return perSecuen;
    }

    public void setPerSecuen(Long perSecuen) {
        this.perSecuen = perSecuen;
    }

    public String getPerCedula() {
        return perCedula;
    }

    public void setPerCedula(String perCedula) {
        this.perCedula = perCedula;
    }

    public String getPerApellido() {
        return perApellido;
    }

    public void setPerApellido(String perApellido) {
        this.perApellido = perApellido;
    }

    public String getPerNombre() {
        return perNombre;
    }

    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }

    public String getNombreGrado() {
        return nombreGrado;
    }

    public void setNombreGrado(String nombreGrado) {
        this.nombreGrado = nombreGrado;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public List<PersonaDTO> getListaPersonal() {
        return listaPersonal;
    }

    public void setListaPersonal(List<PersonaDTO> listaPersonal) {
        this.listaPersonal = listaPersonal;
    }

    public List<PersonaDTO> getListaPersonalNov() {
        return listaPersonalNov;
    }

    public void setListaPersonalNov(List<PersonaDTO> listaPersonalNov) {
        this.listaPersonalNov = listaPersonalNov;
    }
    
    
}
