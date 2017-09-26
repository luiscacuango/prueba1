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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "pare_area", schema = "personal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PareArea.findAll", query = "SELECT p FROM PareArea p"),
    @NamedQuery(name = "PareArea.findByAreSecuen", query = "SELECT p FROM PareArea p WHERE p.areSecuen = :areSecuen"),
    @NamedQuery(name = "PareArea.findByAreAbrevi", query = "SELECT p FROM PareArea p WHERE p.areAbrevi = :areAbrevi"),
    @NamedQuery(name = "PareArea.findByAreArea", query = "SELECT p FROM PareArea p WHERE p.areArea = :areArea")})
public class PareArea implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "are_secuen")
    private Integer areSecuen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "are_abrevi")
    private String areAbrevi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "are_area")
    private String areArea;
    @JoinColumn(name = "fue_secuen", referencedColumnName = "fue_secuen")
    @ManyToOne(optional = false)
    private PfueFuerza fueSecuen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areSecuen")
    private List<PespEspecial> pespEspecialList;

    public PareArea() {
    }

    public PareArea(Integer areSecuen) {
        this.areSecuen = areSecuen;
    }

    public PareArea(Integer areSecuen, String areAbrevi, String areArea) {
        this.areSecuen = areSecuen;
        this.areAbrevi = areAbrevi;
        this.areArea = areArea;
    }

    public Integer getAreSecuen() {
        return areSecuen;
    }

    public void setAreSecuen(Integer areSecuen) {
        this.areSecuen = areSecuen;
    }

    public String getAreAbrevi() {
        return areAbrevi;
    }

    public void setAreAbrevi(String areAbrevi) {
        this.areAbrevi = areAbrevi;
    }

    public String getAreArea() {
        return areArea;
    }

    public void setAreArea(String areArea) {
        this.areArea = areArea;
    }

    public PfueFuerza getFueSecuen() {
        return fueSecuen;
    }

    public void setFueSecuen(PfueFuerza fueSecuen) {
        this.fueSecuen = fueSecuen;
    }

    @XmlTransient
    public List<PespEspecial> getPespEspecialList() {
        return pespEspecialList;
    }

    public void setPespEspecialList(List<PespEspecial> pespEspecialList) {
        this.pespEspecialList = pespEspecialList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (areSecuen != null ? areSecuen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PareArea)) {
            return false;
        }
        PareArea other = (PareArea) object;
        if ((this.areSecuen == null && other.areSecuen != null) || (this.areSecuen != null && !this.areSecuen.equals(other.areSecuen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.spp.ws.bdd.PareArea[ areSecuen=" + areSecuen + " ]";
    }
    
}
