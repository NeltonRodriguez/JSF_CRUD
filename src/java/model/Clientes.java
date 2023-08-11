/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
 * @author 18492
 */
@Entity
@Table(name = "clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c")
    , @NamedQuery(name = "Clientes.findByIdCliente", query = "SELECT c FROM Clientes c WHERE c.idCliente = :idCliente")
    , @NamedQuery(name = "Clientes.findByNombre", query = "SELECT c FROM Clientes c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Clientes.findByCedula", query = "SELECT c FROM Clientes c WHERE c.cedula = :cedula")
    , @NamedQuery(name = "Clientes.findByLimiteCredito", query = "SELECT c FROM Clientes c WHERE c.limiteCredito = :limiteCredito")
    , @NamedQuery(name = "Clientes.findByEstado", query = "SELECT c FROM Clientes c WHERE c.estado = :estado")})
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Cliente")
    private Integer idCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Cedula")
    private String cedula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Limite_Credito")
    private int limiteCredito;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private Collection<Balances> balancesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private Collection<GestionAsientosContables> gestionAsientosContablesCollection;
    @OneToMany(mappedBy = "idCliente")
    private Collection<Transacciones> transaccionesCollection;

    public Clientes() {
    }

    public Clientes(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Clientes(Integer idCliente, String nombre, String cedula, int limiteCredito, String estado) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.cedula = cedula;
        this.limiteCredito = limiteCredito;
        this.estado = estado;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(int limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Balances> getBalancesCollection() {
        return balancesCollection;
    }

    public void setBalancesCollection(Collection<Balances> balancesCollection) {
        this.balancesCollection = balancesCollection;
    }

    @XmlTransient
    public Collection<GestionAsientosContables> getGestionAsientosContablesCollection() {
        return gestionAsientosContablesCollection;
    }

    public void setGestionAsientosContablesCollection(Collection<GestionAsientosContables> gestionAsientosContablesCollection) {
        this.gestionAsientosContablesCollection = gestionAsientosContablesCollection;
    }

    @XmlTransient
    public Collection<Transacciones> getTransaccionesCollection() {
        return transaccionesCollection;
    }

    public void setTransaccionesCollection(Collection<Transacciones> transaccionesCollection) {
        this.transaccionesCollection = transaccionesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Clientes[ idCliente=" + idCliente + " ]";
    }
    
}
