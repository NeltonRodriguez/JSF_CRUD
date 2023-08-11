/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 18492
 */
@Entity
@Table(name = "balances")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Balances.findAll", query = "SELECT b FROM Balances b")
    , @NamedQuery(name = "Balances.findByIdBalance", query = "SELECT b FROM Balances b WHERE b.idBalance = :idBalance")
    , @NamedQuery(name = "Balances.findByFechaCorte", query = "SELECT b FROM Balances b WHERE b.fechaCorte = :fechaCorte")
    , @NamedQuery(name = "Balances.findByAntiguedadPromedioSaldos", query = "SELECT b FROM Balances b WHERE b.antiguedadPromedioSaldos = :antiguedadPromedioSaldos")
    , @NamedQuery(name = "Balances.findByMonto", query = "SELECT b FROM Balances b WHERE b.monto = :monto")})
public class Balances implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Balance")
    private Integer idBalance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_Corte")
    @Temporal(TemporalType.DATE)
    private Date fechaCorte;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "Antiguedad_Promedio_Saldos")
    private BigDecimal antiguedadPromedioSaldos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Monto")
    private int monto;
    @JoinColumn(name = "Id_Cliente", referencedColumnName = "Id_Cliente")
    @ManyToOne(optional = false)
    private Clientes idCliente;

    public Balances() {
    }

    public Balances(Integer idBalance) {
        this.idBalance = idBalance;
    }

    public Balances(Integer idBalance, Date fechaCorte, BigDecimal antiguedadPromedioSaldos, int monto) {
        this.idBalance = idBalance;
        this.fechaCorte = fechaCorte;
        this.antiguedadPromedioSaldos = antiguedadPromedioSaldos;
        this.monto = monto;
    }

    public Integer getIdBalance() {
        return idBalance;
    }

    public void setIdBalance(Integer idBalance) {
        this.idBalance = idBalance;
    }

    public Date getFechaCorte() {
        return fechaCorte;
    }

    public void setFechaCorte(Date fechaCorte) {
        this.fechaCorte = fechaCorte;
    }

    public BigDecimal getAntiguedadPromedioSaldos() {
        return antiguedadPromedioSaldos;
    }

    public void setAntiguedadPromedioSaldos(BigDecimal antiguedadPromedioSaldos) {
        this.antiguedadPromedioSaldos = antiguedadPromedioSaldos;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
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
        hash += (idBalance != null ? idBalance.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Balances)) {
            return false;
        }
        Balances other = (Balances) object;
        if ((this.idBalance == null && other.idBalance != null) || (this.idBalance != null && !this.idBalance.equals(other.idBalance))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Balances[ idBalance=" + idBalance + " ]";
    }
    
}
