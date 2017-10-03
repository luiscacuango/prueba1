package ec.mil.spp.ws.bdd.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @unidad SIPER
 * @author Cbop. Cacuango Luis
 * Clase que representa el objeto de los tipos de novedad
 */
public class TipoNovedadDTO {
    private int idTipNov;
    private String desTipNov;
    private List<TipoNovedadDTO> listaSubtipos;
    
    public TipoNovedadDTO(){
        
    }
    
    public TipoNovedadDTO(int idTipNov, String desTipNov){
        this.idTipNov = idTipNov;
        this.desTipNov = desTipNov;
        this.listaSubtipos = new ArrayList<>();
    }

    public int getIdTipNov() {
        return idTipNov;
    }

    public void setIdTipNov(int idTipNov) {
        this.idTipNov = idTipNov;
    }

    public String getDesTipNov() {
        return desTipNov;
    }

    public void setDesTipNov(String desTipNov) {
        this.desTipNov = desTipNov;
    }

    public List<TipoNovedadDTO> getListaSubtipos() {
        return listaSubtipos;
    }

    public void setListaSubtipos(List<TipoNovedadDTO> listaSubtipos) {
        this.listaSubtipos = listaSubtipos;
    }
    
    
}
