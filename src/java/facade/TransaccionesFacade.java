/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Transacciones;
import model.Transacciones_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.TiposDocumentos;
import model.Clientes;

/**
 *
 * @author 18492
 */
@Stateless
public class TransaccionesFacade extends AbstractFacade<Transacciones> {

    @PersistenceContext(unitName = "ProyectoFinalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransaccionesFacade() {
        super(Transacciones.class);
    }

    public boolean isIdTipoDocumentoEmpty(Transacciones entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Transacciones> transacciones = cq.from(Transacciones.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(transacciones, entity), cb.isNotNull(transacciones.get(Transacciones_.idTipoDocumento)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public TiposDocumentos findIdTipoDocumento(Transacciones entity) {
        return this.getMergedEntity(entity).getIdTipoDocumento();
    }

    public boolean isIdClienteEmpty(Transacciones entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Transacciones> transacciones = cq.from(Transacciones.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(transacciones, entity), cb.isNotNull(transacciones.get(Transacciones_.idCliente)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Clientes findIdCliente(Transacciones entity) {
        return this.getMergedEntity(entity).getIdCliente();
    }
    
}
