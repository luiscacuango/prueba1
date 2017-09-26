/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.mil.spp.ws.bdd;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cbop. Cacuango Luis
 */
@Entity
@Table(name = "pfue_fuerza", schema = "personal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PfueFuerza.findAll", query = "SELECT p FROM PfueFuerza p"),
    @NamedQuery(name = "PfueFuerza.findByFueSecuen", query = "SELECT p FROM PfueFuerza p WHERE p.fueSecuen = :fueSecuen"),
    @NamedQuery(name = "PfueFuerza.findByFueFuerza", query = "SELECT p FROM PfueFuerza p WHERE p.fueFuerza = :fueFuerza"),
    @NamedQuery(name = "PfueFuerza.findByFueAbrevi", query = "SELECT p FROM PfueFuerza p WHERE p.fueAbrevi = :fueAbrevi")})
public class PfueFuerza implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fue_secuen")
    private Integer fueSecuen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "fue_fuerza")
    private String fueFuerza;
    @Size(max = 10)
    @Column(name = "fue_abrevi")
    private String fueAbrevi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fueSecuen")
    private List<PareArea> pareAreaList;

    public PfueFuerza() {
    }

    public PfueFuerza(Integer fueSecuen) {
        this.fueSecuen = fueSecuen;
    }

    public PfueFuerza(Integer fueSecuen, String fueFuerza) {
        this.fueSecuen = fueSecuen;
        this.fueFuerza = fueFuerza;
    }

    public Integer getFueSecuen() {
        return fueSecuen;
    }

    public void setFueSecuen(Integer fueSecuen) {
        this.fueSecuen = fueSecuen;
    }

    public String getFueFuerza() {
        return fueFuerza;
    }

    public void setFueFuerza(String fueFuerza) {
        this.fueFuerza = fueFuerza;
    }

    public String getFueAbrevi() {
        return fueAbrevi;
    }

    public void setFueAbrevi(String fueAbrevi) {
        this.fueAbrevi = fueAbrevi;
    }

    @XmlTransient
    public List<PareArea> getPareAreaList() {
        return pareAreaList;
    }

    public void setPareAreaList(List<PareArea> pareAreaList) {
        this.pareAreaList = pareAreaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fueSecuen != null ? fueSecuen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PfueFuerza)) {
            return false;
        }
        PfueFuerza other = (PfueFuerza) object;
        if ((this.fueSecuen == null && other.fueSecuen != null) || (this.fueSecuen != null && !this.fueSecuen.equals(other.fueSecuen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.spp.ws.bdd.PfueFuerza[ fueSecuen=" + fueSecuen + " ]";
    }
    
}
