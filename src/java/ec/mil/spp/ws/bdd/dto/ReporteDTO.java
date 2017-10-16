package ec.mil.spp.ws.bdd.dto;

/**
 *
 * @author Cbop. Cacuango Luis
 */
public class ReporteDTO {
    private int fila;
    private int valor;
    private String grupo;
    private String tipoEfectivo;
    private String novedad;
    private String persona;

    public ReporteDTO(){
        
    }
    
    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getTipoEfectivo() {
        return tipoEfectivo;
    }

    public void setTipoEfectivo(String tipoEfectivo) {
        this.tipoEfectivo = tipoEfectivo;
    }

    public String getNovedad() {
        return novedad;
    }

    public void setNovedad(String novedad) {
        this.novedad = novedad;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }
       
}
