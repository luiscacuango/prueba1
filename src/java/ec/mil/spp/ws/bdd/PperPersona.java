/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.mil.spp.ws.bdd;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cbop. Cacuango Luis
 */
@Entity
@Table(name = "pper_persona", schema = "personal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PperPersona.findAll", query = "SELECT p FROM PperPersona p"),
    @NamedQuery(name = "PperPersona.findByPerSecuen", query = "SELECT p FROM PperPersona p WHERE p.perSecuen = :perSecuen"),
    @NamedQuery(name = "PperPersona.findByIdEstcivFk", query = "SELECT p FROM PperPersona p WHERE p.idEstcivFk = :idEstcivFk"),
    @NamedQuery(name = "PperPersona.findByPerCedula", query = "SELECT p FROM PperPersona p WHERE p.perCedula = :perCedula"),
    @NamedQuery(name = "PperPersona.findByPerApellido", query = "SELECT p FROM PperPersona p WHERE p.perApellido = :perApellido"),
    @NamedQuery(name = "PperPersona.findByPerNombre", query = "SELECT p FROM PperPersona p WHERE p.perNombre = :perNombre"),
    @NamedQuery(name = "PperPersona.findByPerDireccion", query = "SELECT p FROM PperPersona p WHERE p.perDireccion = :perDireccion"),
    @NamedQuery(name = "PperPersona.findByPerTelefono", query = "SELECT p FROM PperPersona p WHERE p.perTelefono = :perTelefono"),
    @NamedQuery(name = "PperPersona.findByPerCelular", query = "SELECT p FROM PperPersona p WHERE p.perCelular = :perCelular"),
    @NamedQuery(name = "PperPersona.findByPerTipcue", query = "SELECT p FROM PperPersona p WHERE p.perTipcue = :perTipcue"),
    @NamedQuery(name = "PperPersona.findByPerNumecuen", query = "SELECT p FROM PperPersona p WHERE p.perNumecuen = :perNumecuen"),
    @NamedQuery(name = "PperPersona.findByPerMail", query = "SELECT p FROM PperPersona p WHERE p.perMail = :perMail"),
    @NamedQuery(name = "PperPersona.findByPerMailp", query = "SELECT p FROM PperPersona p WHERE p.perMailp = :perMailp"),
    @NamedQuery(name = "PperPersona.findByPerGenero", query = "SELECT p FROM PperPersona p WHERE p.perGenero = :perGenero"),
    @NamedQuery(name = "PperPersona.findByPerFecingre", query = "SELECT p FROM PperPersona p WHERE p.perFecingre = :perFecingre"),
    @NamedQuery(name = "PperPersona.findByPerFecsalida", query = "SELECT p FROM PperPersona p WHERE p.perFecsalida = :perFecsalida"),
    @NamedQuery(name = "PperPersona.findByPerFecnac", query = "SELECT p FROM PperPersona p WHERE p.perFecnac = :perFecnac"),
    @NamedQuery(name = "PperPersona.findByCiuSecuen", query = "SELECT p FROM PperPersona p WHERE p.ciuSecuen = :ciuSecuen"),
    @NamedQuery(name = "PperPersona.findByPerAntigu", query = "SELECT p FROM PperPersona p WHERE p.perAntigu = :perAntigu"),
    @NamedQuery(name = "PperPersona.findByPerDecjur", query = "SELECT p FROM PperPersona p WHERE p.perDecjur = :perDecjur")})
public class PperPersona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "per_secuen")
    private Long perSecuen;
    @Column(name = "id_estciv_fk")
    private Integer idEstcivFk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "per_cedula")
    private String perCedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "per_apellido")
    private String perApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "per_nombre")
    private String perNombre;
    @Size(max = 200)
    @Column(name = "per_direccion")
    private String perDireccion;
    @Size(max = 20)
    @Column(name = "per_telefono")
    private String perTelefono;
    @Size(max = 20)
    @Column(name = "per_celular")
    private String perCelular;
    @Column(name = "per_tipcue")
    private Character perTipcue;
    @Size(max = 20)
    @Column(name = "per_numecuen")
    private String perNumecuen;
    @Size(max = 50)
    @Column(name = "per_mail")
    private String perMail;
    @Size(max = 50)
    @Column(name = "per_mailp")
    private String perMailp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "per_genero")
    private Character perGenero;
    @Column(name = "per_fecingre")
    @Temporal(TemporalType.DATE)
    private Date perFecingre;
    @Column(name = "per_fecsalida")
    @Temporal(TemporalType.DATE)
    private Date perFecsalida;
    @Column(name = "per_fecnac")
    @Temporal(TemporalType.DATE)
    private Date perFecnac;
    @Column(name = "ciu_secuen")
    private BigInteger ciuSecuen;
    @Lob
    @Column(name = "per_foto")
    private byte[] perFoto;
    @Lob
    @Column(name = "per_firma")
    private byte[] perFirma;
    @Column(name = "per_antigu")
    private Integer perAntigu;
    @Column(name = "per_decjur")
    private Character perDecjur;
    @JoinColumn(name = "ban_secuen", referencedColumnName = "ban_secuen")
    @ManyToOne
    private PbanBanco banSecuen;
    @JoinColumn(name = "esp_secuen", referencedColumnName = "esp_secuen")
    @ManyToOne
    private PespEspecial espSecuen;
    @JoinColumn(name = "fun_secuen", referencedColumnName = "fun_secuen")
    @ManyToOne
    private PfunFuncion funSecuen;
    @JoinColumn(name = "gmi_secuen", referencedColumnName = "gmi_secuen")
    @ManyToOne
    private PgmiGradomil gmiSecuen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perSecuen")
    private List<PpdnPartenov> ppdnPartenovList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perSecuen")
    private List<PlypLiceperm> plypLicepermList;
    
    @OneToOne(mappedBy = "perSecuen")
    private SusuUsuario usuario;

    public PperPersona() {
    }

    public PperPersona(Long perSecuen) {
        this.perSecuen = perSecuen;
    }

    public PperPersona(Long perSecuen, String perCedula, String perApellido, String perNombre, Character perGenero) {
        this.perSecuen = perSecuen;
        this.perCedula = perCedula;
        this.perApellido = perApellido;
        this.perNombre = perNombre;
        this.perGenero = perGenero;
    }

    public Long getPerSecuen() {
        return perSecuen;
    }

    public void setPerSecuen(Long perSecuen) {
        this.perSecuen = perSecuen;
    }

    public Integer getIdEstcivFk() {
        return idEstcivFk;
    }

    public void setIdEstcivFk(Integer idEstcivFk) {
        this.idEstcivFk = idEstcivFk;
    }

    public String getPerCedula() {
        return perCedula;
    }

    public void setPerCedula(String perCedula) {
        this.perCedula = perCedula;
    }

    public String getPerApellido() {
        return perApellido;
    }

    public void setPerApellido(String perApellido) {
        this.perApellido = perApellido;
    }

    public String getPerNombre() {
        return perNombre;
    }

    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }

    public String getPerDireccion() {
        return perDireccion;
    }

    public void setPerDireccion(String perDireccion) {
        this.perDireccion = perDireccion;
    }

    public String getPerTelefono() {
        return perTelefono;
    }

    public void setPerTelefono(String perTelefono) {
        this.perTelefono = perTelefono;
    }

    public String getPerCelular() {
        return perCelular;
    }

    public void setPerCelular(String perCelular) {
        this.perCelular = perCelular;
    }

    public Character getPerTipcue() {
        return perTipcue;
    }

    public void setPerTipcue(Character perTipcue) {
        this.perTipcue = perTipcue;
    }

    public String getPerNumecuen() {
        return perNumecuen;
    }

    public void setPerNumecuen(String perNumecuen) {
        this.perNumecuen = perNumecuen;
    }

    public String getPerMail() {
        return perMail;
    }

    public void setPerMail(String perMail) {
        this.perMail = perMail;
    }

    public String getPerMailp() {
        return perMailp;
    }

    public void setPerMailp(String perMailp) {
        this.perMailp = perMailp;
    }

    public Character getPerGenero() {
        return perGenero;
    }

    public void setPerGenero(Character perGenero) {
        this.perGenero = perGenero;
    }

    public Date getPerFecingre() {
        return perFecingre;
    }

    public void setPerFecingre(Date perFecingre) {
        this.perFecingre = perFecingre;
    }

    public Date getPerFecsalida() {
        return perFecsalida;
    }

    public void setPerFecsalida(Date perFecsalida) {
        this.perFecsalida = perFecsalida;
    }

    public Date getPerFecnac() {
        return perFecnac;
    }

    public void setPerFecnac(Date perFecnac) {
        this.perFecnac = perFecnac;
    }

    public BigInteger getCiuSecuen() {
        return ciuSecuen;
    }

    public void setCiuSecuen(BigInteger ciuSecuen) {
        this.ciuSecuen = ciuSecuen;
    }

    public byte[] getPerFoto() {
        return perFoto;
    }

    public void setPerFoto(byte[] perFoto) {
        this.perFoto = perFoto;
    }

    public byte[] getPerFirma() {
        return perFirma;
    }

    public void setPerFirma(byte[] perFirma) {
        this.perFirma = perFirma;
    }

    public Integer getPerAntigu() {
        return perAntigu;
    }

    public void setPerAntigu(Integer perAntigu) {
        this.perAntigu = perAntigu;
    }

    public Character getPerDecjur() {
        return perDecjur;
    }

    public void setPerDecjur(Character perDecjur) {
        this.perDecjur = perDecjur;
    }

    public PbanBanco getBanSecuen() {
        return banSecuen;
    }

    public void setBanSecuen(PbanBanco banSecuen) {
        this.banSecuen = banSecuen;
    }

    public PespEspecial getEspSecuen() {
        return espSecuen;
    }

    public void setEspSecuen(PespEspecial espSecuen) {
        this.espSecuen = espSecuen;
    }

    public PfunFuncion getFunSecuen() {
        return funSecuen;
    }

    public void setFunSecuen(PfunFuncion funSecuen) {
        this.funSecuen = funSecuen;
    }

    public PgmiGradomil getGmiSecuen() {
        return gmiSecuen;
    }

    public void setGmiSecuen(PgmiGradomil gmiSecuen) {
        this.gmiSecuen = gmiSecuen;
    }

    public SusuUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(SusuUsuario usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public List<PpdnPartenov> getPpdnPartenovList() {
        return ppdnPartenovList;
    }

    public void setPpdnPartenovList(List<PpdnPartenov> ppdnPartenovList) {
        this.ppdnPartenovList = ppdnPartenovList;
    }

    @XmlTransient
    public List<PlypLiceperm> getPlypLicepermList() {
        return plypLicepermList;
    }

    public void setPlypLicepermList(List<PlypLiceperm> plypLicepermList) {
        this.plypLicepermList = plypLicepermList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perSecuen != null ? perSecuen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PperPersona)) {
            return false;
        }
        PperPersona other = (PperPersona) object;
        if ((this.perSecuen == null && other.perSecuen != null) || (this.perSecuen != null && !this.perSecuen.equals(other.perSecuen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.spp.ws.bdd.PperPersona[ perSecuen=" + perSecuen + " ]";
    }
    
}
