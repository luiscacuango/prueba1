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
@Table(name = "scaud_conf_auditoria", schema = "seguridades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScaudConfAuditoria.findAll", query = "SELECT s FROM ScaudConfAuditoria s"),
    @NamedQuery(name = "ScaudConfAuditoria.findByCaudSecuencia", query = "SELECT s FROM ScaudConfAuditoria s WHERE s.caudSecuencia = :caudSecuencia"),
    @NamedQuery(name = "ScaudConfAuditoria.findByCaudSchema", query = "SELECT s FROM ScaudConfAuditoria s WHERE s.caudSchema = :caudSchema"),
    @NamedQuery(name = "ScaudConfAuditoria.findByCaudTabla", query = "SELECT s FROM ScaudConfAuditoria s WHERE s.caudTabla = :caudTabla"),
    @NamedQuery(name = "ScaudConfAuditoria.findByCaudOpeguardar", query = "SELECT s FROM ScaudConfAuditoria s WHERE s.caudOpeguardar = :caudOpeguardar"),
    @NamedQuery(name = "ScaudConfAuditoria.findByCaudOpeactualizar", query = "SELECT s FROM ScaudConfAuditoria s WHERE s.caudOpeactualizar = :caudOpeactualizar"),
    @NamedQuery(name = "ScaudConfAuditoria.findByCaudOpeeliminar", query = "SELECT s FROM ScaudConfAuditoria s WHERE s.caudOpeeliminar = :caudOpeeliminar")})
public class ScaudConfAuditoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "caud_secuencia")
    private Integer caudSecuencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "caud_schema")
    private String caudSchema;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "caud_tabla")
    private String caudTabla;
    @Basic(optional = false)
    @NotNull
    @Column(name = "caud_opeguardar")
    private short caudOpeguardar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "caud_opeactualizar")
    private short caudOpeactualizar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "caud_opeeliminar")
    private short caudOpeeliminar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "caudSecuencia")
    private Collection<SdcaDconfAuditoria> sdcaDconfAuditoriaCollection;

    public ScaudConfAuditoria() {
    }

    public ScaudConfAuditoria(Integer caudSecuencia) {
        this.caudSecuencia = caudSecuencia;
    }

    public ScaudConfAuditoria(Integer caudSecuencia, String caudSchema, String caudTabla, short caudOpeguardar, short caudOpeactualizar, short caudOpeeliminar) {
        this.caudSecuencia = caudSecuencia;
        this.caudSchema = caudSchema;
        this.caudTabla = caudTabla;
        this.caudOpeguardar = caudOpeguardar;
        this.caudOpeactualizar = caudOpeactualizar;
        this.caudOpeeliminar = caudOpeeliminar;
    }

    public Integer getCaudSecuencia() {
        return caudSecuencia;
    }

    public void setCaudSecuencia(Integer caudSecuencia) {
        this.caudSecuencia = caudSecuencia;
    }

    public String getCaudSchema() {
        return caudSchema;
    }

    public void setCaudSchema(String caudSchema) {
        this.caudSchema = caudSchema;
    }

    public String getCaudTabla() {
        return caudTabla;
    }

    public void setCaudTabla(String caudTabla) {
        this.caudTabla = caudTabla;
    }

    public short getCaudOpeguardar() {
        return caudOpeguardar;
    }

    public void setCaudOpeguardar(short caudOpeguardar) {
        this.caudOpeguardar = caudOpeguardar;
    }

    public short getCaudOpeactualizar() {
        return caudOpeactualizar;
    }

    public void setCaudOpeactualizar(short caudOpeactualizar) {
        this.caudOpeactualizar = caudOpeactualizar;
    }

    public short getCaudOpeeliminar() {
        return caudOpeeliminar;
    }

    public void setCaudOpeeliminar(short caudOpeeliminar) {
        this.caudOpeeliminar = caudOpeeliminar;
    }

    @XmlTransient
    public Collection<SdcaDconfAuditoria> getSdcaDconfAuditoriaCollection() {
        return sdcaDconfAuditoriaCollection;
    }

    public void setSdcaDconfAuditoriaCollection(Collection<SdcaDconfAuditoria> sdcaDconfAuditoriaCollection) {
        this.sdcaDconfAuditoriaCollection = sdcaDconfAuditoriaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (caudSecuencia != null ? caudSecuencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ScaudConfAuditoria)) {
            return false;
        }
        ScaudConfAuditoria other = (ScaudConfAuditoria) object;
        if ((this.caudSecuencia == null && other.caudSecuencia != null) || (this.caudSecuencia != null && !this.caudSecuencia.equals(other.caudSecuencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.spp.ws.bdd.ScaudConfAuditoria[ caudSecuencia=" + caudSecuencia + " ]";
    }
    
}
