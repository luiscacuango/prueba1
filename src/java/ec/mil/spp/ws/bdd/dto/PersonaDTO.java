package ec.mil.spp.ws.bdd.dto;

import java.util.Date;
import java.util.List;

/**
 * @author Cbop. Cacuango Luis
 */
public class PersonaDTO {

    private Long perSecuen;
    private String perCedula;
    private String perApellido;
    private String perNombre;
    private String perNovedad;
    private Date perFechaInicio;
    private Date perFechaFin;
    private String nombreGrado;
    private String tipoEfectivo;
    private List<NovedadDTO> listaNovedad;
    
    

    public PersonaDTO() {
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

    public String getPerNovedad() {
        return perNovedad;
    }

    public void setPerNovedad(String perNovedad) {
        this.perNovedad = perNovedad;
    }

    public Date getPerFechaInicio() {
        return perFechaInicio;
    }

    public void setPerFechaInicio(Date perFechaInicio) {
        this.perFechaInicio = perFechaInicio;
    }

    public Date getPerFechaFin() {
        return perFechaFin;
    }

    public void setPerFechaFin(Date perFechaFin) {
        this.perFechaFin = perFechaFin;
    }

    public String getNombreGrado() {
        return nombreGrado;
    }

    public void setNombreGrado(String nombreGrado) {
        this.nombreGrado = nombreGrado;
    }

    public List<NovedadDTO> getListaNovedad() {
        return listaNovedad;
    }

    public void setListaNovedad(List<NovedadDTO> listaNovedad) {
        this.listaNovedad = listaNovedad;
    }

    public String getTipoEfectivo() {
        return tipoEfectivo;
    }

    public void setTipoEfectivo(String tipoEfectivo) {
        this.tipoEfectivo = tipoEfectivo;
    }

}
