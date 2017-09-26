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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cbop. Cacuango Luis
 */
@Entity
@Table(name = "saud_auditoria", schema = "seguridades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SaudAuditoria.findAll", query = "SELECT s FROM SaudAuditoria s"),
    @NamedQuery(name = "SaudAuditoria.findByAudId", query = "SELECT s FROM SaudAuditoria s WHERE s.audId = :audId"),
    @NamedQuery(name = "SaudAuditoria.findByAudUsuario", query = "SELECT s FROM SaudAuditoria s WHERE s.audUsuario = :audUsuario"),
    @NamedQuery(name = "SaudAuditoria.findByAudFecha", query = "SELECT s FROM SaudAuditoria s WHERE s.audFecha = :audFecha"),
    @NamedQuery(name = "SaudAuditoria.findByAudNumeroIp", query = "SELECT s FROM SaudAuditoria s WHERE s.audNumeroIp = :audNumeroIp"),
    @NamedQuery(name = "SaudAuditoria.findByAudEsquema", query = "SELECT s FROM SaudAuditoria s WHERE s.audEsquema = :audEsquema"),
    @NamedQuery(name = "SaudAuditoria.findByAudTabla", query = "SELECT s FROM SaudAuditoria s WHERE s.audTabla = :audTabla"),
    @NamedQuery(name = "SaudAuditoria.findByAudEvento", query = "SELECT s FROM SaudAuditoria s WHERE s.audEvento = :audEvento"),
    @NamedQuery(name = "SaudAuditoria.findByAudCampoAntes", query = "SELECT s FROM SaudAuditoria s WHERE s.audCampoAntes = :audCampoAntes"),
    @NamedQuery(name = "SaudAuditoria.findByAudCampoActual", query = "SELECT s FROM SaudAuditoria s WHERE s.audCampoActual = :audCampoActual")})
public class SaudAuditoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "aud_id")
    private Integer audId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "aud_usuario")
    private String audUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aud_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "aud_numero_ip")
    private String audNumeroIp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "aud_esquema")
    private String audEsquema;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "aud_tabla")
    private String audTabla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "aud_evento")
    private String audEvento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "aud_campo_antes")
    private String audCampoAntes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "aud_campo_actual")
    private String audCampoActual;

    public SaudAuditoria() {
    }

    public SaudAuditoria(Integer audId) {
        this.audId = audId;
    }

    public SaudAuditoria(Integer audId, String audUsuario, Date audFecha, String audNumeroIp, String audEsquema, String audTabla, String audEvento, String audCampoAntes, String audCampoActual) {
        this.audId = audId;
        this.audUsuario = audUsuario;
        this.audFecha = audFecha;
        this.audNumeroIp = audNumeroIp;
        this.audEsquema = audEsquema;
        this.audTabla = audTabla;
        this.audEvento = audEvento;
        this.audCampoAntes = audCampoAntes;
        this.audCampoActual = audCampoActual;
    }

    public Integer getAudId() {
        return audId;
    }

    public void setAudId(Integer audId) {
        this.audId = audId;
    }

    public String getAudUsuario() {
        return audUsuario;
    }

    public void setAudUsuario(String audUsuario) {
        this.audUsuario = audUsuario;
    }

    public Date getAudFecha() {
        return audFecha;
    }

    public void setAudFecha(Date audFecha) {
        this.audFecha = audFecha;
    }

    public String getAudNumeroIp() {
        return audNumeroIp;
    }

    public void setAudNumeroIp(String audNumeroIp) {
        this.audNumeroIp = audNumeroIp;
    }

    public String getAudEsquema() {
        return audEsquema;
    }

    public void setAudEsquema(String audEsquema) {
        this.audEsquema = audEsquema;
    }

    public String getAudTabla() {
        return audTabla;
    }

    public void setAudTabla(String audTabla) {
        this.audTabla = audTabla;
    }

    public String getAudEvento() {
        return audEvento;
    }

    public void setAudEvento(String audEvento) {
        this.audEvento = audEvento;
    }

    public String getAudCampoAntes() {
        return audCampoAntes;
    }

    public void setAudCampoAntes(String audCampoAntes) {
        this.audCampoAntes = audCampoAntes;
    }

    public String getAudCampoActual() {
        return audCampoActual;
    }

    public void setAudCampoActual(String audCampoActual) {
        this.audCampoActual = audCampoActual;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (audId != null ? audId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SaudAuditoria)) {
            return false;
        }
        SaudAuditoria other = (SaudAuditoria) object;
        if ((this.audId == null && other.audId != null) || (this.audId != null && !this.audId.equals(other.audId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.spp.ws.bdd.SaudAuditoria[ audId=" + audId + " ]";
    }
    
}
