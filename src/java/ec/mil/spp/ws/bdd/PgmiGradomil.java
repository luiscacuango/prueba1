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
@Table(name = "pgmi_gradomil", schema = "personal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PgmiGradomil.findAll", query = "SELECT p FROM PgmiGradomil p"),
    @NamedQuery(name = "PgmiGradomil.findByGmiSecuen", query = "SELECT p FROM PgmiGradomil p WHERE p.gmiSecuen = :gmiSecuen"),
    @NamedQuery(name = "PgmiGradomil.findByFueSecuen", query = "SELECT p FROM PgmiGradomil p WHERE p.fueSecuen = :fueSecuen"),
    @NamedQuery(name = "PgmiGradomil.findByGmiAbreviat", query = "SELECT p FROM PgmiGradomil p WHERE p.gmiAbreviat = :gmiAbreviat"),
    @NamedQuery(name = "PgmiGradomil.findByGmiGrado", query = "SELECT p FROM PgmiGradomil p WHERE p.gmiGrado = :gmiGrado"),
    @NamedQuery(name = "PgmiGradomil.findByGmiTipoefec", query = "SELECT p FROM PgmiGradomil p WHERE p.gmiTipoefec = :gmiTipoefec"),
    @NamedQuery(name = "PgmiGradomil.findByGmiOrden", query = "SELECT p FROM PgmiGradomil p WHERE p.gmiOrden = :gmiOrden")})
public class PgmiGradomil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gmi_secuen")
    private Integer gmiSecuen;
    @Column(name = "fue_secuen")
    private Integer fueSecuen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "gmi_abreviat")
    private String gmiAbreviat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "gmi_grado")
    private String gmiGrado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gmi_tipoefec")
    private Character gmiTipoefec;
    @Column(name = "gmi_orden")
    private Integer gmiOrden;
    @OneToMany(mappedBy = "gmiSecuen")
    private List<PperPersona> pperPersonaList;

    public PgmiGradomil() {
    }

    public PgmiGradomil(Integer gmiSecuen) {
        this.gmiSecuen = gmiSecuen;
    }

    public PgmiGradomil(Integer gmiSecuen, String gmiAbreviat, String gmiGrado, Character gmiTipoefec) {
        this.gmiSecuen = gmiSecuen;
        this.gmiAbreviat = gmiAbreviat;
        this.gmiGrado = gmiGrado;
        this.gmiTipoefec = gmiTipoefec;
    }

    public Integer getGmiSecuen() {
        return gmiSecuen;
    }

    public void setGmiSecuen(Integer gmiSecuen) {
        this.gmiSecuen = gmiSecuen;
    }

    public Integer getFueSecuen() {
        return fueSecuen;
    }

    public void setFueSecuen(Integer fueSecuen) {
        this.fueSecuen = fueSecuen;
    }

    public String getGmiAbreviat() {
        return gmiAbreviat;
    }

    public void setGmiAbreviat(String gmiAbreviat) {
        this.gmiAbreviat = gmiAbreviat;
    }

    public String getGmiGrado() {
        return gmiGrado;
    }

    public void setGmiGrado(String gmiGrado) {
        this.gmiGrado = gmiGrado;
    }

    public Character getGmiTipoefec() {
        return gmiTipoefec;
    }

    public void setGmiTipoefec(Character gmiTipoefec) {
        this.gmiTipoefec = gmiTipoefec;
    }

    public Integer getGmiOrden() {
        return gmiOrden;
    }

    public void setGmiOrden(Integer gmiOrden) {
        this.gmiOrden = gmiOrden;
    }

    @XmlTransient
    public List<PperPersona> getPperPersonaList() {
        return pperPersonaList;
    }

    public void setPperPersonaList(List<PperPersona> pperPersonaList) {
        this.pperPersonaList = pperPersonaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gmiSecuen != null ? gmiSecuen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PgmiGradomil)) {
            return false;
        }
        PgmiGradomil other = (PgmiGradomil) object;
        if ((this.gmiSecuen == null && other.gmiSecuen != null) || (this.gmiSecuen != null && !this.gmiSecuen.equals(other.gmiSecuen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.spp.ws.bdd.PgmiGradomil[ gmiSecuen=" + gmiSecuen + " ]";
    }
    
}
