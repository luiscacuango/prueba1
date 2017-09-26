/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.mil.spp.ws.bdd;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "pesp_especial", schema = "personal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PespEspecial.findAll", query = "SELECT p FROM PespEspecial p"),
    @NamedQuery(name = "PespEspecial.findByEspSecuen", query = "SELECT p FROM PespEspecial p WHERE p.espSecuen = :espSecuen"),
    @NamedQuery(name = "PespEspecial.findByEspAbrevi", query = "SELECT p FROM PespEspecial p WHERE p.espAbrevi = :espAbrevi"),
    @NamedQuery(name = "PespEspecial.findByEspEspeci", query = "SELECT p FROM PespEspecial p WHERE p.espEspeci = :espEspeci")})
public class PespEspecial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "esp_secuen")
    private Integer espSecuen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "esp_abrevi")
    private String espAbrevi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "esp_especi")
    private String espEspeci;
    @OneToMany(mappedBy = "espSecuen")
    private List<PperPersona> pperPersonaList;
    @JoinColumn(name = "are_secuen", referencedColumnName = "are_secuen")
    @ManyToOne(optional = false)
    private PareArea areSecuen;

    public PespEspecial() {
    }

    public PespEspecial(Integer espSecuen) {
        this.espSecuen = espSecuen;
    }

    public PespEspecial(Integer espSecuen, String espAbrevi, String espEspeci) {
        this.espSecuen = espSecuen;
        this.espAbrevi = espAbrevi;
        this.espEspeci = espEspeci;
    }

    public Integer getEspSecuen() {
        return espSecuen;
    }

    public void setEspSecuen(Integer espSecuen) {
        this.espSecuen = espSecuen;
    }

    public String getEspAbrevi() {
        return espAbrevi;
    }

    public void setEspAbrevi(String espAbrevi) {
        this.espAbrevi = espAbrevi;
    }

    public String getEspEspeci() {
        return espEspeci;
    }

    public void setEspEspeci(String espEspeci) {
        this.espEspeci = espEspeci;
    }

    @XmlTransient
    public List<PperPersona> getPperPersonaList() {
        return pperPersonaList;
    }

    public void setPperPersonaList(List<PperPersona> pperPersonaList) {
        this.pperPersonaList = pperPersonaList;
    }

    public PareArea getAreSecuen() {
        return areSecuen;
    }

    public void setAreSecuen(PareArea areSecuen) {
        this.areSecuen = areSecuen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (espSecuen != null ? espSecuen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PespEspecial)) {
            return false;
        }
        PespEspecial other = (PespEspecial) object;
        if ((this.espSecuen == null && other.espSecuen != null) || (this.espSecuen != null && !this.espSecuen.equals(other.espSecuen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.spp.ws.bdd.PespEspecial[ espSecuen=" + espSecuen + " ]";
    }
    
}
