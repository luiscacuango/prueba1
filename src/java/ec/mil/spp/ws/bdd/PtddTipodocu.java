/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.mil.spp.ws.bdd;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cbop. Cacuango Luis
 */
@Entity
@Table(name = "ptdd_tipodocu", schema = "personal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PtddTipodocu.findAll", query = "SELECT p FROM PtddTipodocu p"),
    @NamedQuery(name = "PtddTipodocu.findByTddSecuen", query = "SELECT p FROM PtddTipodocu p WHERE p.tddSecuen = :tddSecuen"),
    @NamedQuery(name = "PtddTipodocu.findByTddDocumento", query = "SELECT p FROM PtddTipodocu p WHERE p.tddDocumento = :tddDocumento")})
public class PtddTipodocu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tdd_secuen")
    private Integer tddSecuen;
    @Size(max = 255)
    @Column(name = "tdd_documento")
    private String tddDocumento;

    public PtddTipodocu() {
    }

    public PtddTipodocu(Integer tddSecuen) {
        this.tddSecuen = tddSecuen;
    }

    public Integer getTddSecuen() {
        return tddSecuen;
    }

    public void setTddSecuen(Integer tddSecuen) {
        this.tddSecuen = tddSecuen;
    }

    public String getTddDocumento() {
        return tddDocumento;
    }

    public void setTddDocumento(String tddDocumento) {
        this.tddDocumento = tddDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tddSecuen != null ? tddSecuen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PtddTipodocu)) {
            return false;
        }
        PtddTipodocu other = (PtddTipodocu) object;
        if ((this.tddSecuen == null && other.tddSecuen != null) || (this.tddSecuen != null && !this.tddSecuen.equals(other.tddSecuen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.spp.ws.bdd.PtddTipodocu[ tddSecuen=" + tddSecuen + " ]";
    }
    
}
