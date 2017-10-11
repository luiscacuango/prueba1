/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.mil.spp.ws.bdd;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cbop. Cacuango Luis
 */
@Entity
@Table(name = "plyp_liceperm", schema = "personal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlypLiceperm.findAll", query = "SELECT p FROM PlypLiceperm p"),
    @NamedQuery(name = "PlypLiceperm.findByLypSecuen", query = "SELECT p FROM PlypLiceperm p WHERE p.lypSecuen = :lypSecuen"),
    @NamedQuery(name = "PlypLiceperm.findByLypInicio", query = "SELECT p FROM PlypLiceperm p WHERE p.lypInicio = :lypInicio"),
    @NamedQuery(name = "PlypLiceperm.findByLypFin", query = "SELECT p FROM PlypLiceperm p WHERE p.lypFin = :lypFin"),
    @NamedQuery(name = "PlypLiceperm.findByLypObserv", query = "SELECT p FROM PlypLiceperm p WHERE p.lypObserv = :lypObserv"),
    @NamedQuery(name = "PlypLiceperm.findByLypFecha", query = "SELECT p FROM PlypLiceperm p WHERE p.lypFecha = :lypFecha"),
    @NamedQuery(name = "PlypLiceperm.findByCiuSecuen", query = "SELECT p FROM PlypLiceperm p WHERE p.ciuSecuen = :ciuSecuen"),
    @NamedQuery(name = "PlypLiceperm.findByLypEntreg", query = "SELECT p FROM PlypLiceperm p WHERE p.lypEntreg = :lypEntreg"),
    @NamedQuery(name = "PlypLiceperm.findByLypFecent", query = "SELECT p FROM PlypLiceperm p WHERE p.lypFecent = :lypFecent"),
    @NamedQuery(name = "PlypLiceperm.findByLypDias", query = "SELECT p FROM PlypLiceperm p WHERE p.lypDias = :lypDias"),
    @NamedQuery(name = "PlypLiceperm.findByLypHoras", query = "SELECT p FROM PlypLiceperm p WHERE p.lypHoras = :lypHoras"),
    @NamedQuery(name = "PlypLiceperm.findByLypMinuto", query = "SELECT p FROM PlypLiceperm p WHERE p.lypMinuto = :lypMinuto"),
    @NamedQuery(name = "PlypLiceperm.findByLypDiaimp", query = "SELECT p FROM PlypLiceperm p WHERE p.lypDiaimp = :lypDiaimp")})
public class PlypLiceperm implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lyp_secuen")
    private Long lypSecuen;
    @Basic(optional = false)
    @Column(name = "lyp_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lypInicio;
    @Basic(optional = false)
    @Column(name = "lyp_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lypFin;
    @Column(name = "lyp_observ")
    private String lypObserv;
    @Column(name = "lyp_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lypFecha;
    @Column(name = "ciu_secuen")
    private BigInteger ciuSecuen;
    @Column(name = "lyp_entreg")
    private Character lypEntreg;
    @Column(name = "lyp_fecent")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lypFecent;
    @Column(name = "lyp_dias")
    private Short lypDias;
    @Column(name = "lyp_horas")
    private Short lypHoras;
    @Column(name = "lyp_minuto")
    private Short lypMinuto;
    @Column(name = "lyp_diaimp")
    private Short lypDiaimp;
    @JoinColumn(name = "per_secuen", referencedColumnName = "per_secuen")
    @ManyToOne(optional = false)
    private PperPersona perSecuen;
    @JoinColumn(name = "tlp_secuen", referencedColumnName = "tlp_secuen")
    @ManyToOne
    private PtlpTiplicper tlpSecuen;

    public PlypLiceperm() {
    }

    public PlypLiceperm(Long lypSecuen) {
        this.lypSecuen = lypSecuen;
    }

    public PlypLiceperm(Long lypSecuen, Date lypInicio, Date lypFin) {
        this.lypSecuen = lypSecuen;
        this.lypInicio = lypInicio;
        this.lypFin = lypFin;
    }

    public Long getLypSecuen() {
        return lypSecuen;
    }

    public void setLypSecuen(Long lypSecuen) {
        this.lypSecuen = lypSecuen;
    }

    public Date getLypInicio() {
        return lypInicio;
    }

    public void setLypInicio(Date lypInicio) {
        this.lypInicio = lypInicio;
    }

    public Date getLypFin() {
        return lypFin;
    }

    public void setLypFin(Date lypFin) {
        this.lypFin = lypFin;
    }

    public String getLypObserv() {
        return lypObserv;
    }

    public void setLypObserv(String lypObserv) {
        this.lypObserv = lypObserv;
    }

    public Date getLypFecha() {
        return lypFecha;
    }

    public void setLypFecha(Date lypFecha) {
        this.lypFecha = lypFecha;
    }

    public BigInteger getCiuSecuen() {
        return ciuSecuen;
    }

    public void setCiuSecuen(BigInteger ciuSecuen) {
        this.ciuSecuen = ciuSecuen;
    }

    public Character getLypEntreg() {
        return lypEntreg;
    }

    public void setLypEntreg(Character lypEntreg) {
        this.lypEntreg = lypEntreg;
    }

    public Date getLypFecent() {
        return lypFecent;
    }

    public void setLypFecent(Date lypFecent) {
        this.lypFecent = lypFecent;
    }

    public Short getLypDias() {
        return lypDias;
    }

    public void setLypDias(Short lypDias) {
        this.lypDias = lypDias;
    }

    public Short getLypHoras() {
        return lypHoras;
    }

    public void setLypHoras(Short lypHoras) {
        this.lypHoras = lypHoras;
    }

    public Short getLypMinuto() {
        return lypMinuto;
    }

    public void setLypMinuto(Short lypMinuto) {
        this.lypMinuto = lypMinuto;
    }

    public Short getLypDiaimp() {
        return lypDiaimp;
    }

    public void setLypDiaimp(Short lypDiaimp) {
        this.lypDiaimp = lypDiaimp;
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
        hash += (lypSecuen != null ? lypSecuen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlypLiceperm)) {
            return false;
        }
        PlypLiceperm other = (PlypLiceperm) object;
        if ((this.lypSecuen == null && other.lypSecuen != null) || (this.lypSecuen != null && !this.lypSecuen.equals(other.lypSecuen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.spp.ws.bdd.PlypLiceperm[ lypSecuen=" + lypSecuen + " ]";
    }
    
}
