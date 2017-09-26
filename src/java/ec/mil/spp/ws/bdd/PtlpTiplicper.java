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
@Table(name = "ptlp_tiplicper", schema = "personal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PtlpTiplicper.findAll", query = "SELECT p FROM PtlpTiplicper p"),
    @NamedQuery(name = "PtlpTiplicper.findByTlpSecuen", query = "SELECT p FROM PtlpTiplicper p WHERE p.tlpSecuen = :tlpSecuen"),
    @NamedQuery(name = "PtlpTiplicper.findByTlpDescri", query = "SELECT p FROM PtlpTiplicper p WHERE p.tlpDescri = :tlpDescri"),
    @NamedQuery(name = "PtlpTiplicper.findByTlpImputa", query = "SELECT p FROM PtlpTiplicper p WHERE p.tlpImputa = :tlpImputa"),
    @NamedQuery(name = "PtlpTiplicper.findByTlpSueldo", query = "SELECT p FROM PtlpTiplicper p WHERE p.tlpSueldo = :tlpSueldo"),
    @NamedQuery(name = "PtlpTiplicper.findByTlpDias", query = "SELECT p FROM PtlpTiplicper p WHERE p.tlpDias = :tlpDias"),
    @NamedQuery(name = "PtlpTiplicper.findByTlpAutori", query = "SELECT p FROM PtlpTiplicper p WHERE p.tlpAutori = :tlpAutori"),
    @NamedQuery(name = "PtlpTiplicper.findByTlpClase", query = "SELECT p FROM PtlpTiplicper p WHERE p.tlpClase = :tlpClase"),
    @NamedQuery(name = "PtlpTiplicper.findByTlpTipo", query = "SELECT p FROM PtlpTiplicper p WHERE p.tlpTipo = :tlpTipo")})
public class PtlpTiplicper implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tlp_secuen")
    private Short tlpSecuen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "tlp_descri")
    private String tlpDescri;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tlp_imputa")
    private Character tlpImputa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tlp_sueldo")
    private Character tlpSueldo;
    @Column(name = "tlp_dias")
    private Short tlpDias;
    @Column(name = "tlp_autori")
    private Character tlpAutori;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tlp_clase")
    private Character tlpClase;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tlp_tipo")
    private Character tlpTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tlpSecuen")
    private List<PpdnPartenov> ppdnPartenovList;
    @OneToMany(mappedBy = "tlpSecuen")
    private List<PlypLiceperm> plypLicepermList;

    public PtlpTiplicper() {
    }

    public PtlpTiplicper(Short tlpSecuen) {
        this.tlpSecuen = tlpSecuen;
    }

    public PtlpTiplicper(Short tlpSecuen, String tlpDescri, Character tlpImputa, Character tlpSueldo, Character tlpClase, Character tlpTipo) {
        this.tlpSecuen = tlpSecuen;
        this.tlpDescri = tlpDescri;
        this.tlpImputa = tlpImputa;
        this.tlpSueldo = tlpSueldo;
        this.tlpClase = tlpClase;
        this.tlpTipo = tlpTipo;
    }

    public Short getTlpSecuen() {
        return tlpSecuen;
    }

    public void setTlpSecuen(Short tlpSecuen) {
        this.tlpSecuen = tlpSecuen;
    }

    public String getTlpDescri() {
        return tlpDescri;
    }

    public void setTlpDescri(String tlpDescri) {
        this.tlpDescri = tlpDescri;
    }

    public Character getTlpImputa() {
        return tlpImputa;
    }

    public void setTlpImputa(Character tlpImputa) {
        this.tlpImputa = tlpImputa;
    }

    public Character getTlpSueldo() {
        return tlpSueldo;
    }

    public void setTlpSueldo(Character tlpSueldo) {
        this.tlpSueldo = tlpSueldo;
    }

    public Short getTlpDias() {
        return tlpDias;
    }

    public void setTlpDias(Short tlpDias) {
        this.tlpDias = tlpDias;
    }

    public Character getTlpAutori() {
        return tlpAutori;
    }

    public void setTlpAutori(Character tlpAutori) {
        this.tlpAutori = tlpAutori;
    }

    public Character getTlpClase() {
        return tlpClase;
    }

    public void setTlpClase(Character tlpClase) {
        this.tlpClase = tlpClase;
    }

    public Character getTlpTipo() {
        return tlpTipo;
    }

    public void setTlpTipo(Character tlpTipo) {
        this.tlpTipo = tlpTipo;
    }

    @XmlTransient
    public List<PpdnPartenov> getPpdnPartenovList() {
        return ppdnPartenovList;
    }

    public void setPpdnPartenovList(List<PpdnPartenov> ppdnPartenovList) {
        this.ppdnPartenovList = ppdnPartenovList;
    }

    @XmlTransient
    public List<PlypLiceperm> getPlypLicepermList() {
        return plypLicepermList;
    }

    public void setPlypLicepermList(List<PlypLiceperm> plypLicepermList) {
        this.plypLicepermList = plypLicepermList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tlpSecuen != null ? tlpSecuen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PtlpTiplicper)) {
            return false;
        }
        PtlpTiplicper other = (PtlpTiplicper) object;
        if ((this.tlpSecuen == null && other.tlpSecuen != null) || (this.tlpSecuen != null && !this.tlpSecuen.equals(other.tlpSecuen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.spp.ws.bdd.PtlpTiplicper[ tlpSecuen=" + tlpSecuen + " ]";
    }
    
}
