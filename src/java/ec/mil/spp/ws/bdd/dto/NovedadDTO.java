package ec.mil.spp.ws.bdd.dto;

import java.util.Date;

/**
 * @author Cbop. Cacuango Luis
 */
public class NovedadDTO {
    private Long lypSecuen;
    private Date lypInicio;
    private Date lypFin;
    private String lypObserv;
    private int lypDias;
    private int lypHoras;
    private int lypMinuto;
    private int tipoLicencia;
    private PersonaDTO persona;

    public NovedadDTO() {
    }

    public Long getLypSecuen() {
        return lypSecuen;
    }

    public void setLypSecuen(Long lypSecuen) {
        this.lypSecuen = lypSecuen;
    }

    public Date getLypInicio() {
        return lypInicio;
    }

    public void setLypInicio(Date lypInicio) {
        this.lypInicio = lypInicio;
    }

    public Date getLypFin() {
        return lypFin;
    }

    public void setLypFin(Date lypFin) {
        this.lypFin = lypFin;
    }

    public String getLypObserv() {
        return lypObserv;
    }

    public void setLypObserv(String lypObserv) {
        this.lypObserv = lypObserv;
    }

    public int getLypDias() {
        return lypDias;
    }

    public void setLypDias(int lypDias) {
        this.lypDias = lypDias;
    }

    public int getLypHoras() {
        return lypHoras;
    }

    public void setLypHoras(int lypHoras) {
        this.lypHoras = lypHoras;
    }

    public int getLypMinuto() {
        return lypMinuto;
    }

    public void setLypMinuto(int lypMinuto) {
        this.lypMinuto = lypMinuto;
    }

    public int getTipoLicencia() {
        return tipoLicencia;
    }

    public void setTipoLicencia(int tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

    public PersonaDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }
    
    
    
}
