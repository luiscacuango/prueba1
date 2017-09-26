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
@Table(name = "pfun_funcion", schema = "personal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PfunFuncion.findAll", query = "SELECT p FROM PfunFuncion p"),
    @NamedQuery(name = "PfunFuncion.findByFunSecuen", query = "SELECT p FROM PfunFuncion p WHERE p.funSecuen = :funSecuen"),
    @NamedQuery(name = "PfunFuncion.findByFunFuncion", query = "SELECT p FROM PfunFuncion p WHERE p.funFuncion = :funFuncion")})
public class PfunFuncion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fun_secuen")
    private Integer funSecuen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "fun_funcion")
    private String funFuncion;
    @OneToMany(mappedBy = "funSecuen")
    private List<PperPersona> pperPersonaList;
    @JoinColumn(name = "uni_secuen", referencedColumnName = "uni_secuen")
    @ManyToOne
    private PuniUnidad uniSecuen;

    public PfunFuncion() {
    }

    public PfunFuncion(Integer funSecuen) {
        this.funSecuen = funSecuen;
    }

    public PfunFuncion(Integer funSecuen, String funFuncion) {
        this.funSecuen = funSecuen;
        this.funFuncion = funFuncion;
    }

    public Integer getFunSecuen() {
        return funSecuen;
    }

    public void setFunSecuen(Integer funSecuen) {
        this.funSecuen = funSecuen;
    }

    public String getFunFuncion() {
        return funFuncion;
    }

    public void setFunFuncion(String funFuncion) {
        this.funFuncion = funFuncion;
    }

    @XmlTransient
    public List<PperPersona> getPperPersonaList() {
        return pperPersonaList;
    }

    public void setPperPersonaList(List<PperPersona> pperPersonaList) {
        this.pperPersonaList = pperPersonaList;
    }

    public PuniUnidad getUniSecuen() {
        return uniSecuen;
    }

    public void setUniSecuen(PuniUnidad uniSecuen) {
        this.uniSecuen = uniSecuen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (funSecuen != null ? funSecuen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PfunFuncion)) {
            return false;
        }
        PfunFuncion other = (PfunFuncion) object;
        if ((this.funSecuen == null && other.funSecuen != null) || (this.funSecuen != null && !this.funSecuen.equals(other.funSecuen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.spp.ws.bdd.PfunFuncion[ funSecuen=" + funSecuen + " ]";
    }
    
}
