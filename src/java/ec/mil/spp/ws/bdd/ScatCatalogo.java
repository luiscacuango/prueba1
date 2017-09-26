/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.mil.spp.ws.bdd;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "scat_catalogo", schema = "seguridades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScatCatalogo.findAll", query = "SELECT s FROM ScatCatalogo s"),
    @NamedQuery(name = "ScatCatalogo.findByCatSecuen", query = "SELECT s FROM ScatCatalogo s WHERE s.catSecuen = :catSecuen"),
    @NamedQuery(name = "ScatCatalogo.findByCatNombre", query = "SELECT s FROM ScatCatalogo s WHERE s.catNombre = :catNombre"),
    @NamedQuery(name = "ScatCatalogo.findByCatDescri", query = "SELECT s FROM ScatCatalogo s WHERE s.catDescri = :catDescri")})
public class ScatCatalogo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cat_secuen")
    private Integer catSecuen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "cat_nombre")
    private String catNombre;
    @Size(max = 200)
    @Column(name = "cat_descri")
    private String catDescri;
    @OneToMany(mappedBy = "scaCatSecuen")
    private Collection<ScatCatalogo> scatCatalogoCollection;
    @JoinColumn(name = "sca_cat_secuen", referencedColumnName = "cat_secuen")
    @ManyToOne
    private ScatCatalogo scaCatSecuen;

    public ScatCatalogo() {
    }

    public ScatCatalogo(Integer catSecuen) {
        this.catSecuen = catSecuen;
    }

    public ScatCatalogo(Integer catSecuen, String catNombre) {
        this.catSecuen = catSecuen;
        this.catNombre = catNombre;
    }

    public Integer getCatSecuen() {
        return catSecuen;
    }

    public void setCatSecuen(Integer catSecuen) {
        this.catSecuen = catSecuen;
    }

    public String getCatNombre() {
        return catNombre;
    }

    public void setCatNombre(String catNombre) {
        this.catNombre = catNombre;
    }

    public String getCatDescri() {
        return catDescri;
    }

    public void setCatDescri(String catDescri) {
        this.catDescri = catDescri;
    }

    @XmlTransient
    public Collection<ScatCatalogo> getScatCatalogoCollection() {
        return scatCatalogoCollection;
    }

    public void setScatCatalogoCollection(Collection<ScatCatalogo> scatCatalogoCollection) {
        this.scatCatalogoCollection = scatCatalogoCollection;
    }

    public ScatCatalogo getScaCatSecuen() {
        return scaCatSecuen;
    }

    public void setScaCatSecuen(ScatCatalogo scaCatSecuen) {
        this.scaCatSecuen = scaCatSecuen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catSecuen != null ? catSecuen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ScatCatalogo)) {
            return false;
        }
        ScatCatalogo other = (ScatCatalogo) object;
        if ((this.catSecuen == null && other.catSecuen != null) || (this.catSecuen != null && !this.catSecuen.equals(other.catSecuen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.spp.ws.bdd.ScatCatalogo[ catSecuen=" + catSecuen + " ]";
    }
    
}
