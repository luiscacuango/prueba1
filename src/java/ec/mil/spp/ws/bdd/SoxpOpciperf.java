/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.mil.spp.ws.bdd;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cbop. Cacuango Luis
 */
@Entity
@Table(name = "soxp_opciperf", schema = "seguridades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SoxpOpciperf.findAll", query = "SELECT s FROM SoxpOpciperf s"),
    @NamedQuery(name = "SoxpOpciperf.findByOpcSecuen", query = "SELECT s FROM SoxpOpciperf s WHERE s.soxpOpciperfPK.opcSecuen = :opcSecuen"),
    @NamedQuery(name = "SoxpOpciperf.findByPxsSecuen", query = "SELECT s FROM SoxpOpciperf s WHERE s.soxpOpciperfPK.pxsSecuen = :pxsSecuen"),
    @NamedQuery(name = "SoxpOpciperf.findByOxpTodo", query = "SELECT s FROM SoxpOpciperf s WHERE s.oxpTodo = :oxpTodo"),
    @NamedQuery(name = "SoxpOpciperf.findByOxpIngresa", query = "SELECT s FROM SoxpOpciperf s WHERE s.oxpIngresa = :oxpIngresa"),
    @NamedQuery(name = "SoxpOpciperf.findByOxpModifica", query = "SELECT s FROM SoxpOpciperf s WHERE s.oxpModifica = :oxpModifica"),
    @NamedQuery(name = "SoxpOpciperf.findByOxpElimina", query = "SELECT s FROM SoxpOpciperf s WHERE s.oxpElimina = :oxpElimina"),
    @NamedQuery(name = "SoxpOpciperf.findByOxpConsulta", query = "SELECT s FROM SoxpOpciperf s WHERE s.oxpConsulta = :oxpConsulta")})
public class SoxpOpciperf implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SoxpOpciperfPK soxpOpciperfPK;
    @Column(name = "oxp_todo")
    private Character oxpTodo;
    @Column(name = "oxp_ingresa")
    private Character oxpIngresa;
    @Column(name = "oxp_modifica")
    private Character oxpModifica;
    @Column(name = "oxp_elimina")
    private Character oxpElimina;
    @Column(name = "oxp_consulta")
    private Character oxpConsulta;
    @JoinColumn(name = "opc_secuen", referencedColumnName = "opc_secuen", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SopcOpcion sopcOpcion;
    @JoinColumn(name = "pxs_secuen", referencedColumnName = "pxs_secuen", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SpxsPerfil spxsPerfil;

    public SoxpOpciperf() {
    }

    public SoxpOpciperf(SoxpOpciperfPK soxpOpciperfPK) {
        this.soxpOpciperfPK = soxpOpciperfPK;
    }

    public SoxpOpciperf(int opcSecuen, int pxsSecuen) {
        this.soxpOpciperfPK = new SoxpOpciperfPK(opcSecuen, pxsSecuen);
    }

    public SoxpOpciperfPK getSoxpOpciperfPK() {
        return soxpOpciperfPK;
    }

    public void setSoxpOpciperfPK(SoxpOpciperfPK soxpOpciperfPK) {
        this.soxpOpciperfPK = soxpOpciperfPK;
    }

    public Character getOxpTodo() {
        return oxpTodo;
    }

    public void setOxpTodo(Character oxpTodo) {
        this.oxpTodo = oxpTodo;
    }

    public Character getOxpIngresa() {
        return oxpIngresa;
    }

    public void setOxpIngresa(Character oxpIngresa) {
        this.oxpIngresa = oxpIngresa;
    }

    public Character getOxpModifica() {
        return oxpModifica;
    }

    public void setOxpModifica(Character oxpModifica) {
        this.oxpModifica = oxpModifica;
    }

    public Character getOxpElimina() {
        return oxpElimina;
    }

    public void setOxpElimina(Character oxpElimina) {
        this.oxpElimina = oxpElimina;
    }

    public Character getOxpConsulta() {
        return oxpConsulta;
    }

    public void setOxpConsulta(Character oxpConsulta) {
        this.oxpConsulta = oxpConsulta;
    }

    public SopcOpcion getSopcOpcion() {
        return sopcOpcion;
    }

    public void setSopcOpcion(SopcOpcion sopcOpcion) {
        this.sopcOpcion = sopcOpcion;
    }

    public SpxsPerfil getSpxsPerfil() {
        return spxsPerfil;
    }

    public void setSpxsPerfil(SpxsPerfil spxsPerfil) {
        this.spxsPerfil = spxsPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (soxpOpciperfPK != null ? soxpOpciperfPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SoxpOpciperf)) {
            return false;
        }
        SoxpOpciperf other = (SoxpOpciperf) object;
        if ((this.soxpOpciperfPK == null && other.soxpOpciperfPK != null) || (this.soxpOpciperfPK != null && !this.soxpOpciperfPK.equals(other.soxpOpciperfPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.spp.ws.bdd.SoxpOpciperf[ soxpOpciperfPK=" + soxpOpciperfPK + " ]";
    }
    
}
