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
@Table(name = "pgdo_grupoope", schema = "personal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PgdoGrupoope.findAll", query = "SELECT p FROM PgdoGrupoope p"),
    @NamedQuery(name = "PgdoGrupoope.findByGdoSecuen", query = "SELECT p FROM PgdoGrupoope p WHERE p.gdoSecuen = :gdoSecuen"),
    @NamedQuery(name = "PgdoGrupoope.findByGdoGrupoope", query = "SELECT p FROM PgdoGrupoope p WHERE p.gdoGrupoope = :gdoGrupoope"),
    @NamedQuery(name = "PgdoGrupoope.findByGdoAbreviat", query = "SELECT p FROM PgdoGrupoope p WHERE p.gdoAbreviat = :gdoAbreviat"),
    @NamedQuery(name = "PgdoGrupoope.findByGdoTipo", query = "SELECT p FROM PgdoGrupoope p WHERE p.gdoTipo = :gdoTipo"),
    @NamedQuery(name = "PgdoGrupoope.findByGdoSecuenPadre", query = "SELECT p FROM PgdoGrupoope p WHERE p.gdoSecuenPadre = :gdoSecuenPadre")})
public class PgdoGrupoope implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gdo_secuen")
    private Integer gdoSecuen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "gdo_grupoope")
    private String gdoGrupoope;
    @Size(max = 20)
    @Column(name = "gdo_abreviat")
    private String gdoAbreviat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gdo_tipo")
    private Character gdoTipo;
    @Column(name = "gdo_secuen_padre")
    private Integer gdoSecuenPadre;
    @OneToMany(mappedBy = "gdoSecuen")
    private List<PuniUnidad> puniUnidadList;

    public PgdoGrupoope() {
    }

    public PgdoGrupoope(Integer gdoSecuen) {
        this.gdoSecuen = gdoSecuen;
    }

    public PgdoGrupoope(Integer gdoSecuen, String gdoGrupoope, Character gdoTipo) {
        this.gdoSecuen = gdoSecuen;
        this.gdoGrupoope = gdoGrupoope;
        this.gdoTipo = gdoTipo;
    }

    public Integer getGdoSecuen() {
        return gdoSecuen;
    }

    public void setGdoSecuen(Integer gdoSecuen) {
        this.gdoSecuen = gdoSecuen;
    }

    public String getGdoGrupoope() {
        return gdoGrupoope;
    }

    public void setGdoGrupoope(String gdoGrupoope) {
        this.gdoGrupoope = gdoGrupoope;
    }

    public String getGdoAbreviat() {
        return gdoAbreviat;
    }

    public void setGdoAbreviat(String gdoAbreviat) {
        this.gdoAbreviat = gdoAbreviat;
    }

    public Character getGdoTipo() {
        return gdoTipo;
    }

    public void setGdoTipo(Character gdoTipo) {
        this.gdoTipo = gdoTipo;
    }

    public Integer getGdoSecuenPadre() {
        return gdoSecuenPadre;
    }

    public void setGdoSecuenPadre(Integer gdoSecuenPadre) {
        this.gdoSecuenPadre = gdoSecuenPadre;
    }

    @XmlTransient
    public List<PuniUnidad> getPuniUnidadList() {
        return puniUnidadList;
    }

    public void setPuniUnidadList(List<PuniUnidad> puniUnidadList) {
        this.puniUnidadList = puniUnidadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gdoSecuen != null ? gdoSecuen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PgdoGrupoope)) {
            return false;
        }
        PgdoGrupoope other = (PgdoGrupoope) object;
        if ((this.gdoSecuen == null && other.gdoSecuen != null) || (this.gdoSecuen != null && !this.gdoSecuen.equals(other.gdoSecuen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.spp.ws.bdd.PgdoGrupoope[ gdoSecuen=" + gdoSecuen + " ]";
    }
    
}
