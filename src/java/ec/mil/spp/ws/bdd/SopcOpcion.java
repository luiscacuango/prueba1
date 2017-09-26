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
@Table(name = "sopc_opcion", schema = "seguridades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SopcOpcion.findAll", query = "SELECT s FROM SopcOpcion s"),
    @NamedQuery(name = "SopcOpcion.findByOpcSecuen", query = "SELECT s FROM SopcOpcion s WHERE s.opcSecuen = :opcSecuen"),
    @NamedQuery(name = "SopcOpcion.findByOpcOpcion", query = "SELECT s FROM SopcOpcion s WHERE s.opcOpcion = :opcOpcion"),
    @NamedQuery(name = "SopcOpcion.findByOpcOrden", query = "SELECT s FROM SopcOpcion s WHERE s.opcOrden = :opcOrden"),
    @NamedQuery(name = "SopcOpcion.findByOpcUrl", query = "SELECT s FROM SopcOpcion s WHERE s.opcUrl = :opcUrl")})
public class SopcOpcion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "opc_secuen")
    private Integer opcSecuen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "opc_opcion")
    private String opcOpcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "opc_orden")
    private int opcOrden;
    @Size(max = 100)
    @Column(name = "opc_url")
    private String opcUrl;
    @OneToMany(mappedBy = "sopOpcSecuen")
    private Collection<SopcOpcion> sopcOpcionCollection;
    @JoinColumn(name = "sop_opc_secuen", referencedColumnName = "opc_secuen")
    @ManyToOne
    private SopcOpcion sopOpcSecuen;
    @JoinColumn(name = "sis_secuen", referencedColumnName = "sis_secuen")
    @ManyToOne
    private SsisSistema sisSecuen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sopcOpcion")
    private Collection<SoxpOpciperf> soxpOpciperfCollection;

    public SopcOpcion() {
    }

    public SopcOpcion(Integer opcSecuen) {
        this.opcSecuen = opcSecuen;
    }

    public SopcOpcion(Integer opcSecuen, String opcOpcion, int opcOrden) {
        this.opcSecuen = opcSecuen;
        this.opcOpcion = opcOpcion;
        this.opcOrden = opcOrden;
    }

    public Integer getOpcSecuen() {
        return opcSecuen;
    }

    public void setOpcSecuen(Integer opcSecuen) {
        this.opcSecuen = opcSecuen;
    }

    public String getOpcOpcion() {
        return opcOpcion;
    }

    public void setOpcOpcion(String opcOpcion) {
        this.opcOpcion = opcOpcion;
    }

    public int getOpcOrden() {
        return opcOrden;
    }

    public void setOpcOrden(int opcOrden) {
        this.opcOrden = opcOrden;
    }

    public String getOpcUrl() {
        return opcUrl;
    }

    public void setOpcUrl(String opcUrl) {
        this.opcUrl = opcUrl;
    }

    @XmlTransient
    public Collection<SopcOpcion> getSopcOpcionCollection() {
        return sopcOpcionCollection;
    }

    public void setSopcOpcionCollection(Collection<SopcOpcion> sopcOpcionCollection) {
        this.sopcOpcionCollection = sopcOpcionCollection;
    }

    public SopcOpcion getSopOpcSecuen() {
        return sopOpcSecuen;
    }

    public void setSopOpcSecuen(SopcOpcion sopOpcSecuen) {
        this.sopOpcSecuen = sopOpcSecuen;
    }

    public SsisSistema getSisSecuen() {
        return sisSecuen;
    }

    public void setSisSecuen(SsisSistema sisSecuen) {
        this.sisSecuen = sisSecuen;
    }

    @XmlTransient
    public Collection<SoxpOpciperf> getSoxpOpciperfCollection() {
        return soxpOpciperfCollection;
    }

    public void setSoxpOpciperfCollection(Collection<SoxpOpciperf> soxpOpciperfCollection) {
        this.soxpOpciperfCollection = soxpOpciperfCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (opcSecuen != null ? opcSecuen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SopcOpcion)) {
            return false;
        }
        SopcOpcion other = (SopcOpcion) object;
        if ((this.opcSecuen == null && other.opcSecuen != null) || (this.opcSecuen != null && !this.opcSecuen.equals(other.opcSecuen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.spp.ws.bdd.SopcOpcion[ opcSecuen=" + opcSecuen + " ]";
    }
    
}
