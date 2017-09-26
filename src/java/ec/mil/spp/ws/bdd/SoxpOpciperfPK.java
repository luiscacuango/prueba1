/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.mil.spp.ws.bdd;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Cbop. Cacuango Luis
 */
@Embeddable
public class SoxpOpciperfPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "opc_secuen")
    private int opcSecuen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pxs_secuen")
    private int pxsSecuen;

    public SoxpOpciperfPK() {
    }

    public SoxpOpciperfPK(int opcSecuen, int pxsSecuen) {
        this.opcSecuen = opcSecuen;
        this.pxsSecuen = pxsSecuen;
    }

    public int getOpcSecuen() {
        return opcSecuen;
    }

    public void setOpcSecuen(int opcSecuen) {
        this.opcSecuen = opcSecuen;
    }

    public int getPxsSecuen() {
        return pxsSecuen;
    }

    public void setPxsSecuen(int pxsSecuen) {
        this.pxsSecuen = pxsSecuen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) opcSecuen;
        hash += (int) pxsSecuen;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SoxpOpciperfPK)) {
            return false;
        }
        SoxpOpciperfPK other = (SoxpOpciperfPK) object;
        if (this.opcSecuen != other.opcSecuen) {
            return false;
        }
        if (this.pxsSecuen != other.pxsSecuen) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.spp.ws.bdd.SoxpOpciperfPK[ opcSecuen=" + opcSecuen + ", pxsSecuen=" + pxsSecuen + " ]";
    }
    
}
