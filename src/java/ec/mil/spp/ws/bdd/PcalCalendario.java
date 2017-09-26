/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.mil.spp.ws.bdd;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cbop. Cacuango Luis
 */
@Entity
@Table(name = "pcal_calendario", schema = "personal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PcalCalendario.findAll", query = "SELECT p FROM PcalCalendario p"),
    @NamedQuery(name = "PcalCalendario.findByCalSecuen", query = "SELECT p FROM PcalCalendario p WHERE p.calSecuen = :calSecuen"),
    @NamedQuery(name = "PcalCalendario.findByCalDescri", query = "SELECT p FROM PcalCalendario p WHERE p.calDescri = :calDescri"),
    @NamedQuery(name = "PcalCalendario.findByCalFecha", query = "SELECT p FROM PcalCalendario p WHERE p.calFecha = :calFecha"),
    @NamedQuery(name = "PcalCalendario.findByCalLabora", query = "SELECT p FROM PcalCalendario p WHERE p.calLabora = :calLabora")})
public class PcalCalendario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cal_secuen")
    private Integer calSecuen;
    @Size(max = 100)
    @Column(name = "cal_descri")
    private String calDescri;
    @Column(name = "cal_fecha")
    @Temporal(TemporalType.DATE)
    private Date calFecha;
    @Column(name = "cal_labora")
    private Character calLabora;

    public PcalCalendario() {
    }

    public PcalCalendario(Integer calSecuen) {
        this.calSecuen = calSecuen;
    }

    public Integer getCalSecuen() {
        return calSecuen;
    }

    public void setCalSecuen(Integer calSecuen) {
        this.calSecuen = calSecuen;
    }

    public String getCalDescri() {
        return calDescri;
    }

    public void setCalDescri(String calDescri) {
        this.calDescri = calDescri;
    }

    public Date getCalFecha() {
        return calFecha;
    }

    public void setCalFecha(Date calFecha) {
        this.calFecha = calFecha;
    }

    public Character getCalLabora() {
        return calLabora;
    }

    public void setCalLabora(Character calLabora) {
        this.calLabora = calLabora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (calSecuen != null ? calSecuen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PcalCalendario)) {
            return false;
        }
        PcalCalendario other = (PcalCalendario) object;
        if ((this.calSecuen == null && other.calSecuen != null) || (this.calSecuen != null && !this.calSecuen.equals(other.calSecuen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.spp.ws.bdd.PcalCalendario[ calSecuen=" + calSecuen + " ]";
    }
    
}
