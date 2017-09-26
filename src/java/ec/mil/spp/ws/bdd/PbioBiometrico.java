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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cbop. Cacuango Luis
 */
@Entity
@Table(name = "pbio_biometrico", schema = "personal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PbioBiometrico.findAll", query = "SELECT p FROM PbioBiometrico p"),
    @NamedQuery(name = "PbioBiometrico.findByBioSec", query = "SELECT p FROM PbioBiometrico p WHERE p.bioSec = :bioSec"),
    @NamedQuery(name = "PbioBiometrico.findByPerCedula", query = "SELECT p FROM PbioBiometrico p WHERE p.perCedula = :perCedula"),
    @NamedQuery(name = "PbioBiometrico.findByBioFecha", query = "SELECT p FROM PbioBiometrico p WHERE p.bioFecha = :bioFecha")})
public class PbioBiometrico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bio_sec")
    private Long bioSec;
    @Size(max = 20)
    @Column(name = "per_cedula")
    private String perCedula;
    @Column(name = "bio_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bioFecha;

    public PbioBiometrico() {
    }

    public PbioBiometrico(Long bioSec) {
        this.bioSec = bioSec;
    }

    public Long getBioSec() {
        return bioSec;
    }

    public void setBioSec(Long bioSec) {
        this.bioSec = bioSec;
    }

    public String getPerCedula() {
        return perCedula;
    }

    public void setPerCedula(String perCedula) {
        this.perCedula = perCedula;
    }

    public Date getBioFecha() {
        return bioFecha;
    }

    public void setBioFecha(Date bioFecha) {
        this.bioFecha = bioFecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bioSec != null ? bioSec.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PbioBiometrico)) {
            return false;
        }
        PbioBiometrico other = (PbioBiometrico) object;
        if ((this.bioSec == null && other.bioSec != null) || (this.bioSec != null && !this.bioSec.equals(other.bioSec))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.spp.ws.bdd.PbioBiometrico[ bioSec=" + bioSec + " ]";
    }
    
}
