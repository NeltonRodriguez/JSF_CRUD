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
@Table(name = "tipos_documentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposDocumentos.findAll", query = "SELECT t FROM TiposDocumentos t")
    , @NamedQuery(name = "TiposDocumentos.findByIdDocumento", query = "SELECT t FROM TiposDocumentos t WHERE t.idDocumento = :idDocumento")
    , @NamedQuery(name = "TiposDocumentos.findByDescripcion", query = "SELECT t FROM TiposDocumentos t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "TiposDocumentos.findByCuentaContable", query = "SELECT t FROM TiposDocumentos t WHERE t.cuentaContable = :cuentaContable")
    , @NamedQuery(name = "TiposDocumentos.findByEstado", query = "SELECT t FROM TiposDocumentos t WHERE t.estado = :estado")})
public class TiposDocumentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Documento")
    private Integer idDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Cuenta_Contable")
    private String cuentaContable;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoDocumento")
    private Collection<Transacciones> transaccionesCollection;

    public TiposDocumentos() {
    }

    public TiposDocumentos(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    public TiposDocumentos(Integer idDocumento, String descripcion, String cuentaContable, String estado) {
        this.idDocumento = idDocumento;
        this.descripcion = descripcion;
        this.cuentaContable = cuentaContable;
        this.estado = estado;
    }

    public Integer getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCuentaContable() {
        return cuentaContable;
    }

    public void setCuentaContable(String cuentaContable) {
        this.cuentaContable = cuentaContable;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
        hash += (idDocumento != null ? idDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposDocumentos)) {
            return false;
        }
        TiposDocumentos other = (TiposDocumentos) object;
        if ((this.idDocumento == null && other.idDocumento != null) || (this.idDocumento != null && !this.idDocumento.equals(other.idDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TiposDocumentos[ idDocumento=" + idDocumento + " ]";
    }
    
}
