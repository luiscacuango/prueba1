/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.mil.spp.ws.bdd;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cbop. Cacuango Luis
 */
@Entity
@Table(name = "ppdn_partenov", schema = "personal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PpdnPartenov.findAll", query = "SELECT p FROM PpdnPartenov p"),
    @NamedQuery(name = "PpdnPartenov.findByPdnSecuen", query = "SELECT p FROM PpdnPartenov p WHERE p.pdnSecuen = :pdnSecuen"),
    @NamedQuery(name = "PpdnPartenov.findByPdnFecha", query = "SELECT p FROM PpdnPartenov p WHERE p.pdnFecha = :pdnFecha")})
public class PpdnPartenov implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pdn_secuen")
    private Long pdnSecuen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pdn_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pdnFecha;
    @JoinColumn(name = "per_secuen", referencedColumnName = "per_secuen")
    @ManyToOne(optional = false)
    private PperPersona perSecuen;
    @JoinColumn(name = "tlp_secuen", referencedColumnName = "tlp_secuen")
    @ManyToOne(optional = false)
    private PtlpTiplicper tlpSecuen;

    public PpdnPartenov() {
    }

    public PpdnPartenov(Long pdnSecuen) {
        this.pdnSecuen = pdnSecuen;
    }

    public PpdnPartenov(Long pdnSecuen, Date pdnFecha) {
        this.pdnSecuen = pdnSecuen;
        this.pdnFecha = pdnFecha;
    }

    public Long getPdnSecuen() {
        return pdnSecuen;
    }

    public void setPdnSecuen(Long pdnSecuen) {
        this.pdnSecuen = pdnSecuen;
    }

    public Date getPdnFecha() {
        return pdnFecha;
    }

    public void setPdnFecha(Date pdnFecha) {
        this.pdnFecha = pdnFecha;
    }

    public PperPersona getPerSecuen() {
        return perSecuen;
    }

    public void setPerSecuen(PperPersona perSecuen) {
        this.perSecuen = perSecuen;
    }

    public PtlpTiplicper getTlpSecuen() {
        return tlpSecuen;
    }

    public void setTlpSecuen(PtlpTiplicper tlpSecuen) {
        this.tlpSecuen = tlpSecuen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pdnSecuen != null ? pdnSecuen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PpdnPartenov)) {
            return false;
        }
        PpdnPartenov other = (PpdnPartenov) object;
        if ((this.pdnSecuen == null && other.pdnSecuen != null) || (this.pdnSecuen != null && !this.pdnSecuen.equals(other.pdnSecuen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.spp.ws.bdd.PpdnPartenov[ pdnSecuen=" + pdnSecuen + " ]";
    }
    
}
