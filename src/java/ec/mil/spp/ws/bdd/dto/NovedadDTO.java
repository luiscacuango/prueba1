package ec.mil.spp.ws.bdd.dto;

/**
 * @author Cbop. Cacuango Luis
 */
public class NovedadDTO {

    private Long lypSecuen;
    private String lypInicio;
    private String lypFin;
    private String lypObserv;
    private short lypDias;
    private short lypHoras;
    private short lypMinuto;
    private short tipoLicencia;
    private Long perSecuen;
    private PersonaDTO persona;

    public NovedadDTO() {
    }

    public Long getLypSecuen() {
        return lypSecuen;
    }

    public void setLypSecuen(Long lypSecuen) {
        this.lypSecuen = lypSecuen;
    }

    public String getLypInicio() {
        return lypInicio;
    }

    public void setLypInicio(String lypInicio) {
        this.lypInicio = lypInicio;
    }

    public String getLypFin() {
        return lypFin;
    }

    public void setLypFin(String lypFin) {
        this.lypFin = lypFin;
    }

    public String getLypObserv() {
        return lypObserv;
    }

    public void setLypObserv(String lypObserv) {
        this.lypObserv = lypObserv;
    }

    public short getLypDias() {
        return lypDias;
    }

    public void setLypDias(short lypDias) {
        this.lypDias = lypDias;
    }

    public short getLypHoras() {
        return lypHoras;
    }

    public void setLypHoras(short lypHoras) {
        this.lypHoras = lypHoras;
    }

    public short getLypMinuto() {
        return lypMinuto;
    }

    public void setLypMinuto(short lypMinuto) {
        this.lypMinuto = lypMinuto;
    }

    public short getTipoLicencia() {
        return tipoLicencia;
    }

    public void setTipoLicencia(short tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

    public Long getPerSecuen() {
        return perSecuen;
    }

    public void setPerSecuen(Long perSecuen) {
        this.perSecuen = perSecuen;
    }

    public PersonaDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }

}
