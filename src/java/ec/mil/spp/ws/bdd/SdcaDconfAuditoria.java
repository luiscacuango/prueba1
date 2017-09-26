/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.mil.spp.ws.bdd;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cbop. Cacuango Luis
 */
@Entity
@Table(name = "sdca_dconf_auditoria", schema = "seguridades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SdcaDconfAuditoria.findAll", query = "SELECT s FROM SdcaDconfAuditoria s"),
    @NamedQuery(name = "SdcaDconfAuditoria.findByDcaSecuencia", query = "SELECT s FROM SdcaDconfAuditoria s WHERE s.dcaSecuencia = :dcaSecuencia"),
    @NamedQuery(name = "SdcaDconfAuditoria.findByDcaNomcolumna", query = "SELECT s FROM SdcaDconfAuditoria s WHERE s.dcaNomcolumna = :dcaNomcolumna"),
    @NamedQuery(name = "SdcaDconfAuditoria.findByDcaTablaReferencia", query = "SELECT s FROM SdcaDconfAuditoria s WHERE s.dcaTablaReferencia = :dcaTablaReferencia"),
    @NamedQuery(name = "SdcaDconfAuditoria.findByDcaAliasColumna", query = "SELECT s FROM SdcaDconfAuditoria s WHERE s.dcaAliasColumna = :dcaAliasColumna")})
public class SdcaDconfAuditoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dca_secuencia")
    private Integer dcaSecuencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "dca_nomcolumna")
    private String dcaNomcolumna;
    @Size(max = 50)
    @Column(name = "dca_tabla_referencia")
    private String dcaTablaReferencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "dca_alias_columna")
    private String dcaAliasColumna;
    @JoinColumn(name = "caud_secuencia", referencedColumnName = "caud_secuencia")
    @ManyToOne(optional = false)
    private ScaudConfAuditoria caudSecuencia;

    public SdcaDconfAuditoria() {
    }

    public SdcaDconfAuditoria(Integer dcaSecuencia) {
        this.dcaSecuencia = dcaSecuencia;
    }

    public SdcaDconfAuditoria(Integer dcaSecuencia, String dcaNomcolumna, String dcaAliasColumna) {
        this.dcaSecuencia = dcaSecuencia;
        this.dcaNomcolumna = dcaNomcolumna;
        this.dcaAliasColumna = dcaAliasColumna;
    }

    public Integer getDcaSecuencia() {
        return dcaSecuencia;
    }

    public void setDcaSecuencia(Integer dcaSecuencia) {
        this.dcaSecuencia = dcaSecuencia;
    }

    public String getDcaNomcolumna() {
        return dcaNomcolumna;
    }

    public void setDcaNomcolumna(String dcaNomcolumna) {
        this.dcaNomcolumna = dcaNomcolumna;
    }

    public String getDcaTablaReferencia() {
        return dcaTablaReferencia;
    }

    public void setDcaTablaReferencia(String dcaTablaReferencia) {
        this.dcaTablaReferencia = dcaTablaReferencia;
    }

    public String getDcaAliasColumna() {
        return dcaAliasColumna;
    }

    public void setDcaAliasColumna(String dcaAliasColumna) {
        this.dcaAliasColumna = dcaAliasColumna;
    }

    public ScaudConfAuditoria getCaudSecuencia() {
        return caudSecuencia;
    }

    public void setCaudSecuencia(ScaudConfAuditoria caudSecuencia) {
        this.caudSecuencia = caudSecuencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dcaSecuencia != null ? dcaSecuencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SdcaDconfAuditoria)) {
            return false;
        }
        SdcaDconfAuditoria other = (SdcaDconfAuditoria) object;
        if ((this.dcaSecuencia == null && other.dcaSecuencia != null) || (this.dcaSecuencia != null && !this.dcaSecuencia.equals(other.dcaSecuencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.spp.ws.bdd.SdcaDconfAuditoria[ dcaSecuencia=" + dcaSecuencia + " ]";
    }
    
}
