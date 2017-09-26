package ec.mil.spp.ws.bdd;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cbop. Cacuango Luis
 */
@Entity
@Table(name = "susu_usuario", schema = "seguridades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SusuUsuario.findAll", query = "SELECT s FROM SusuUsuario s"),
    @NamedQuery(name = "SusuUsuario.findByUsuSecuen", query = "SELECT s FROM SusuUsuario s WHERE s.usuSecuen = :usuSecuen"),
    @NamedQuery(name = "SusuUsuario.findByPerSecuen", query = "SELECT s FROM SusuUsuario s WHERE s.perSecuen = :perSecuen"),
    @NamedQuery(name = "SusuUsuario.findByUsuUsuario", query = "SELECT s FROM SusuUsuario s WHERE s.usuUsuario = :usuUsuario"),
    @NamedQuery(name = "SusuUsuario.findByUsuPassword", query = "SELECT s FROM SusuUsuario s WHERE s.usuPassword = :usuPassword"),
    @NamedQuery(name = "SusuUsuario.findByUsuFecvig", query = "SELECT s FROM SusuUsuario s WHERE s.usuFecvig = :usuFecvig"),
    @NamedQuery(name = "SusuUsuario.findByUsuPregunFk", query = "SELECT s FROM SusuUsuario s WHERE s.usuPregunFk = :usuPregunFk"),
    @NamedQuery(name = "SusuUsuario.findByUsuRespue", query = "SELECT s FROM SusuUsuario s WHERE s.usuRespue = :usuRespue")})
public class SusuUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usu_secuen")
    private Integer usuSecuen;
    @Size(max = 20)
    @Column(name = "usu_usuario")
    private String usuUsuario;
    @Size(max = 100)
    @Column(name = "usu_password")
    private String usuPassword;
    @Column(name = "usu_fecvig")
    @Temporal(TemporalType.DATE)
    private Date usuFecvig;
    @Column(name = "usu_pregun_fk")
    private Integer usuPregunFk;
    @Size(max = 200)
    @Column(name = "usu_respue")
    private String usuRespue;
    @ManyToMany(mappedBy = "susuUsuarioCollection")
    private Collection<SpxsPerfil> spxsPerfilCollection;
    @OneToOne
    @JoinColumn(name = "per_secuen")
    private PperPersona perSecuen;
    
    public SusuUsuario() {
    }

    public SusuUsuario(Integer usuSecuen) {
        this.usuSecuen = usuSecuen;
    }

    public Integer getUsuSecuen() {
        return usuSecuen;
    }

    public void setUsuSecuen(Integer usuSecuen) {
        this.usuSecuen = usuSecuen;
    }

    public PperPersona getPerSecuen() {
        return perSecuen;
    }

    public void setPerSecuen(PperPersona perSecuen) {
        this.perSecuen = perSecuen;
    }

    public String getUsuUsuario() {
        return usuUsuario;
    }

    public void setUsuUsuario(String usuUsuario) {
        this.usuUsuario = usuUsuario;
    }

    public String getUsuPassword() {
        return usuPassword;
    }

    public void setUsuPassword(String usuPassword) {
        this.usuPassword = usuPassword;
    }

    public Date getUsuFecvig() {
        return usuFecvig;
    }

    public void setUsuFecvig(Date usuFecvig) {
        this.usuFecvig = usuFecvig;
    }

    public Integer getUsuPregunFk() {
        return usuPregunFk;
    }

    public void setUsuPregunFk(Integer usuPregunFk) {
        this.usuPregunFk = usuPregunFk;
    }

    public String getUsuRespue() {
        return usuRespue;
    }

    public void setUsuRespue(String usuRespue) {
        this.usuRespue = usuRespue;
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
        hash += (usuSecuen != null ? usuSecuen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SusuUsuario)) {
            return false;
        }
        SusuUsuario other = (SusuUsuario) object;
        if ((this.usuSecuen == null && other.usuSecuen != null) || (this.usuSecuen != null && !this.usuSecuen.equals(other.usuSecuen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.spp.ws.bdd.SusuUsuario[ usuSecuen=" + usuSecuen + " ]";
    }
    
}
