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
@Table(name = "ssis_sistema", schema = "seguridades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SsisSistema.findAll", query = "SELECT s FROM SsisSistema s"),
    @NamedQuery(name = "SsisSistema.findBySisSecuen", query = "SELECT s FROM SsisSistema s WHERE s.sisSecuen = :sisSecuen"),
    @NamedQuery(name = "SsisSistema.findBySisSistema", query = "SELECT s FROM SsisSistema s WHERE s.sisSistema = :sisSistema")})
public class SsisSistema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sis_secuen")
    private Integer sisSecuen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "sis_sistema")
    private String sisSistema;
    @OneToMany(mappedBy = "sisSecuen")
    private Collection<SopcOpcion> sopcOpcionCollection;
    @OneToMany(mappedBy = "sisSecuen")
    private Collection<SpxsPerfil> spxsPerfilCollection;

    public SsisSistema() {
    }

    public SsisSistema(Integer sisSecuen) {
        this.sisSecuen = sisSecuen;
    }

    public SsisSistema(Integer sisSecuen, String sisSistema) {
        this.sisSecuen = sisSecuen;
        this.sisSistema = sisSistema;
    }

    public Integer getSisSecuen() {
        return sisSecuen;
    }

    public void setSisSecuen(Integer sisSecuen) {
        this.sisSecuen = sisSecuen;
    }

    public String getSisSistema() {
        return sisSistema;
    }

    public void setSisSistema(String sisSistema) {
        this.sisSistema = sisSistema;
    }

    @XmlTransient
    public Collection<SopcOpcion> getSopcOpcionCollection() {
        return sopcOpcionCollection;
    }

    public void setSopcOpcionCollection(Collection<SopcOpcion> sopcOpcionCollection) {
        this.sopcOpcionCollection = sopcOpcionCollection;
    }

    @XmlTransient
    public Collection<SpxsPerfil> getSpxsPerfilCollection() {
        return spxsPerfilCollection;
    }

    public void setSpxsPerfilCollection(Collection<SpxsPerfil> spxsPerfilCollection) {
        this.spxsPerfilCollection = spxsPerfilCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sisSecuen != null ? sisSecuen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SsisSistema)) {
            return false;
        }
        SsisSistema other = (SsisSistema) object;
        if ((this.sisSecuen == null && other.sisSecuen != null) || (this.sisSecuen != null && !this.sisSecuen.equals(other.sisSecuen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.spp.ws.bdd.SsisSistema[ sisSecuen=" + sisSecuen + " ]";
    }
    
}
