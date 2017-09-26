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
@Table(name = "pban_banco", schema = "personal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PbanBanco.findAll", query = "SELECT p FROM PbanBanco p"),
    @NamedQuery(name = "PbanBanco.findByBanSecuen", query = "SELECT p FROM PbanBanco p WHERE p.banSecuen = :banSecuen"),
    @NamedQuery(name = "PbanBanco.findByBanBanco", query = "SELECT p FROM PbanBanco p WHERE p.banBanco = :banBanco")})
public class PbanBanco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ban_secuen")
    private Integer banSecuen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ban_banco")
    private String banBanco;
    @OneToMany(mappedBy = "banSecuen")
    private List<PperPersona> pperPersonaList;

    public PbanBanco() {
    }

    public PbanBanco(Integer banSecuen) {
        this.banSecuen = banSecuen;
    }

    public PbanBanco(Integer banSecuen, String banBanco) {
        this.banSecuen = banSecuen;
        this.banBanco = banBanco;
    }

    public Integer getBanSecuen() {
        return banSecuen;
    }

    public void setBanSecuen(Integer banSecuen) {
        this.banSecuen = banSecuen;
    }

    public String getBanBanco() {
        return banBanco;
    }

    public void setBanBanco(String banBanco) {
        this.banBanco = banBanco;
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
        hash += (banSecuen != null ? banSecuen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PbanBanco)) {
            return false;
        }
        PbanBanco other = (PbanBanco) object;
        if ((this.banSecuen == null && other.banSecuen != null) || (this.banSecuen != null && !this.banSecuen.equals(other.banSecuen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.spp.ws.bdd.PbanBanco[ banSecuen=" + banSecuen + " ]";
    }
    
}
