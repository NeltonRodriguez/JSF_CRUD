/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 18492
 */
@Entity
@Table(name = "gestion_asientos_contables")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GestionAsientosContables.findAll", query = "SELECT g FROM GestionAsientosContables g")
    , @NamedQuery(name = "GestionAsientosContables.findByIdAsiento", query = "SELECT g FROM GestionAsientosContables g WHERE g.idAsiento = :idAsiento")
    , @NamedQuery(name = "GestionAsientosContables.findByDescripcion", query = "SELECT g FROM GestionAsientosContables g WHERE g.descripcion = :descripcion")
    , @NamedQuery(name = "GestionAsientosContables.findByCuenta", query = "SELECT g FROM GestionAsientosContables g WHERE g.cuenta = :cuenta")
    , @NamedQuery(name = "GestionAsientosContables.findByTipoMovimiento", query = "SELECT g FROM GestionAsientosContables g WHERE g.tipoMovimiento = :tipoMovimiento")
    , @NamedQuery(name = "GestionAsientosContables.findByFechaAsiento", query = "SELECT g FROM GestionAsientosContables g WHERE g.fechaAsiento = :fechaAsiento")
    , @NamedQuery(name = "GestionAsientosContables.findByMontoAsiento", query = "SELECT g FROM GestionAsientosContables g WHERE g.montoAsiento = :montoAsiento")
    , @NamedQuery(name = "GestionAsientosContables.findByEstado", query = "SELECT g FROM GestionAsientosContables g WHERE g.estado = :estado")})
public class GestionAsientosContables implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Asiento")
    private Integer idAsiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cuenta")
    private int cuenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Tipo_Movimiento")
    private String tipoMovimiento;
    @Column(name = "Fecha_Asiento")
    @Temporal(TemporalType.DATE)
    private Date fechaAsiento;
    @Column(name = "Monto_Asiento")
    private Integer montoAsiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Estado")
    private String estado;
    @JoinColumn(name = "Id_Cliente", referencedColumnName = "Id_Cliente")
    @ManyToOne(optional = false)
    private Clientes idCliente;

    public GestionAsientosContables() {
    }

    public GestionAsientosContables(Integer idAsiento) {
        this.idAsiento = idAsiento;
    }

    public GestionAsientosContables(Integer idAsiento, String descripcion, int cuenta, String tipoMovimiento, String estado) {
        this.idAsiento = idAsiento;
        this.descripcion = descripcion;
        this.cuenta = cuenta;
        this.tipoMovimiento = tipoMovimiento;
        this.estado = estado;
    }

    public Integer getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(Integer idAsiento) {
        this.idAsiento = idAsiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Date getFechaAsiento() {
        return fechaAsiento;
    }

    public void setFechaAsiento(Date fechaAsiento) {
        this.fechaAsiento = fechaAsiento;
    }

    public Integer getMontoAsiento() {
        return montoAsiento;
    }

    public void setMontoAsiento(Integer montoAsiento) {
        this.montoAsiento = montoAsiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Clientes getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Clientes idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsiento != null ? idAsiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GestionAsientosContables)) {
            return false;
        }
        GestionAsientosContables other = (GestionAsientosContables) object;
        if ((this.idAsiento == null && other.idAsiento != null) || (this.idAsiento != null && !this.idAsiento.equals(other.idAsiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.GestionAsientosContables[ idAsiento=" + idAsiento + " ]";
    }
    
}
