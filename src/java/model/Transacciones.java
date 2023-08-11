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
@Table(name = "transacciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transacciones.findAll", query = "SELECT t FROM Transacciones t")
    , @NamedQuery(name = "Transacciones.findByIdTransaccion", query = "SELECT t FROM Transacciones t WHERE t.idTransaccion = :idTransaccion")
    , @NamedQuery(name = "Transacciones.findByTipoMovimiento", query = "SELECT t FROM Transacciones t WHERE t.tipoMovimiento = :tipoMovimiento")
    , @NamedQuery(name = "Transacciones.findByNumeroDocumento", query = "SELECT t FROM Transacciones t WHERE t.numeroDocumento = :numeroDocumento")
    , @NamedQuery(name = "Transacciones.findByFecha", query = "SELECT t FROM Transacciones t WHERE t.fecha = :fecha")
    , @NamedQuery(name = "Transacciones.findByMonto", query = "SELECT t FROM Transacciones t WHERE t.monto = :monto")})
public class Transacciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Transaccion")
    private Integer idTransaccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Tipo_Movimiento")
    private String tipoMovimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Numero_Documento")
    private int numeroDocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Monto")
    private int monto;
    @JoinColumn(name = "Id_Tipo_Documento", referencedColumnName = "Id_Documento")
    @ManyToOne(optional = false)
    private TiposDocumentos idTipoDocumento;
    @JoinColumn(name = "Id_Cliente", referencedColumnName = "Id_Cliente")
    @ManyToOne
    private Clientes idCliente;

    public Transacciones() {
    }

    public Transacciones(Integer idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Transacciones(Integer idTransaccion, String tipoMovimiento, int numeroDocumento, Date fecha, int monto) {
        this.idTransaccion = idTransaccion;
        this.tipoMovimiento = tipoMovimiento;
        this.numeroDocumento = numeroDocumento;
        this.fecha = fecha;
        this.monto = monto;
    }

    public Integer getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Integer idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public TiposDocumentos getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(TiposDocumentos idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
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
        hash += (idTransaccion != null ? idTransaccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transacciones)) {
            return false;
        }
        Transacciones other = (Transacciones) object;
        if ((this.idTransaccion == null && other.idTransaccion != null) || (this.idTransaccion != null && !this.idTransaccion.equals(other.idTransaccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Transacciones[ idTransaccion=" + idTransaccion + " ]";
    }
    
}
