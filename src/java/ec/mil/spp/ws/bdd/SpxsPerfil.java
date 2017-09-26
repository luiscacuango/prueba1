/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.mil.spp.ws.bdd;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "spxs_perfil", schema = "seguridades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SpxsPerfil.findAll", query = "SELECT s FROM SpxsPerfil s"),
    @NamedQuery(name = "SpxsPerfil.findByPxsSecuen", query = "SELECT s FROM SpxsPerfil s WHERE s.pxsSecuen = :pxsSecuen"),
    @NamedQuery(name = "SpxsPerfil.findByPxsPerfil", query = "SELECT s FROM SpxsPerfil s WHERE s.pxsPerfil = :pxsPerfil"),
    @NamedQuery(name = "SpxsPerfil.findByPxsDescri", query = "SELECT s FROM SpxsPerfil s WHERE s.pxsDescri = :pxsDescri")})
public class SpxsPerfil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pxs_secuen")
    private Integer pxsSecuen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pxs_perfil")
    private String pxsPerfil;
    @Size(max = 200)
    @Column(name = "pxs_descri")
    private String pxsDescri;
    @JoinTable(name = "suxp_usuaperf", joinColumns = {
        @JoinColumn(name = "pxs_secuen", referencedColumnName = "pxs_secuen")}, inverseJoinColumns = {
        @JoinColumn(name = "usu_secuen", referencedColumnName = "usu_secuen")})
    @ManyToMany
    private Collection<SusuUsuario> susuUsuarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "spxsPerfil")
    private Collection<SoxpOpciperf> soxpOpciperfCollection;
    @JoinColumn(name = "sis_secuen", referencedColumnName = "sis_secuen")
    @ManyToOne
    private SsisSistema sisSecuen;

    public SpxsPerfil() {
    }

    public SpxsPerfil(Integer pxsSecuen) {
        this.pxsSecuen = pxsSecuen;
    }

    public SpxsPerfil(Integer pxsSecuen, String pxsPerfil) {
        this.pxsSecuen = pxsSecuen;
        this.pxsPerfil = pxsPerfil;
    }

    public Integer getPxsSecuen() {
        return pxsSecuen;
    }

    public void setPxsSecuen(Integer pxsSecuen) {
        this.pxsSecuen = pxsSecuen;
    }

    public String getPxsPerfil() {
        return pxsPerfil;
    }

    public void setPxsPerfil(String pxsPerfil) {
        this.pxsPerfil = pxsPerfil;
    }

    public String getPxsDescri() {
        return pxsDescri;
    }

    public void setPxsDescri(String pxsDescri) {
        this.pxsDescri = pxsDescri;
    }

    @XmlTransient
    public Collection<SusuUsuario> getSusuUsuarioCollection() {
        return susuUsuarioCollection;
    }

    public void setSusuUsuarioCollection(Collection<SusuUsuario> susuUsuarioCollection) {
        this.susuUsuarioCollection = susuUsuarioCollection;
    }

    @XmlTransient
    public Collection<SoxpOpciperf> getSoxpOpciperfCollection() {
        return soxpOpciperfCollection;
    }

    public void setSoxpOpciperfCollection(Collection<SoxpOpciperf> soxpOpciperfCollection) {
        this.soxpOpciperfCollection = soxpOpciperfCollection;
    }

    public SsisSistema getSisSecuen() {
        return sisSecuen;
    }

    public void setSisSecuen(SsisSistema sisSecuen) {
        this.sisSecuen = sisSecuen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pxsSecuen != null ? pxsSecuen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpxsPerfil)) {
            return false;
        }
        SpxsPerfil other = (SpxsPerfil) object;
        if ((this.pxsSecuen == null && other.pxsSecuen != null) || (this.pxsSecuen != null && !this.pxsSecuen.equals(other.pxsSecuen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.spp.ws.bdd.SpxsPerfil[ pxsSecuen=" + pxsSecuen + " ]";
    }
    
}
