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
@Table(name = "puni_unidad", schema = "personal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PuniUnidad.findAll", query = "SELECT p FROM PuniUnidad p"),
    @NamedQuery(name = "PuniUnidad.findByUniSecuen", query = "SELECT p FROM PuniUnidad p WHERE p.uniSecuen = :uniSecuen"),
    @NamedQuery(name = "PuniUnidad.findByUniAbreviat", query = "SELECT p FROM PuniUnidad p WHERE p.uniAbreviat = :uniAbreviat"),
    @NamedQuery(name = "PuniUnidad.findByUniUnidad", query = "SELECT p FROM PuniUnidad p WHERE p.uniUnidad = :uniUnidad")})
public class PuniUnidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "uni_secuen")
    private Integer uniSecuen;
    @Size(max = 10)
    @Column(name = "uni_abreviat")
    private String uniAbreviat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "uni_unidad")
    private String uniUnidad;
    @OneToMany(mappedBy = "uniSecuen")
    private List<PfunFuncion> pfunFuncionList;
    @JoinColumn(name = "gdo_secuen", referencedColumnName = "gdo_secuen")
    @ManyToOne
    private PgdoGrupoope gdoSecuen;

    public PuniUnidad() {
    }

    public PuniUnidad(Integer uniSecuen) {
        this.uniSecuen = uniSecuen;
    }

    public PuniUnidad(Integer uniSecuen, String uniUnidad) {
        this.uniSecuen = uniSecuen;
        this.uniUnidad = uniUnidad;
    }

    public Integer getUniSecuen() {
        return uniSecuen;
    }

    public void setUniSecuen(Integer uniSecuen) {
        this.uniSecuen = uniSecuen;
    }

    public String getUniAbreviat() {
        return uniAbreviat;
    }

    public void setUniAbreviat(String uniAbreviat) {
        this.uniAbreviat = uniAbreviat;
    }

    public String getUniUnidad() {
        return uniUnidad;
    }

    public void setUniUnidad(String uniUnidad) {
        this.uniUnidad = uniUnidad;
    }

    @XmlTransient
    public List<PfunFuncion> getPfunFuncionList() {
        return pfunFuncionList;
    }

    public void setPfunFuncionList(List<PfunFuncion> pfunFuncionList) {
        this.pfunFuncionList = pfunFuncionList;
    }

    public PgdoGrupoope getGdoSecuen() {
        return gdoSecuen;
    }

    public void setGdoSecuen(PgdoGrupoope gdoSecuen) {
        this.gdoSecuen = gdoSecuen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uniSecuen != null ? uniSecuen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PuniUnidad)) {
            return false;
        }
        PuniUnidad other = (PuniUnidad) object;
        if ((this.uniSecuen == null && other.uniSecuen != null) || (this.uniSecuen != null && !this.uniSecuen.equals(other.uniSecuen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.spp.ws.bdd.PuniUnidad[ uniSecuen=" + uniSecuen + " ]";
    }
    
}
