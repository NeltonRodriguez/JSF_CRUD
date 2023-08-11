/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Clientes;
import model.Clientes_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Balances;
import model.GestionAsientosContables;
import model.Transacciones;

/**
 *
 * @author 18492
 */
@Stateless
public class ClientesFacade extends AbstractFacade<Clientes> {

    @PersistenceContext(unitName = "ProyectoFinalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientesFacade() {
        super(Clientes.class);
    }

    public boolean isBalancesCollectionEmpty(Clientes entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Clientes> clientes = cq.from(Clientes.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(clientes, entity), cb.isNotEmpty(clientes.get(Clientes_.balancesCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Balances> findBalancesCollection(Clientes entity) {
        Clientes mergedEntity = this.getMergedEntity(entity);
        Collection<Balances> balancesCollection = mergedEntity.getBalancesCollection();
        balancesCollection.size();
        return balancesCollection;
    }

    public boolean isGestionAsientosContablesCollectionEmpty(Clientes entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Clientes> clientes = cq.from(Clientes.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(clientes, entity), cb.isNotEmpty(clientes.get(Clientes_.gestionAsientosContablesCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<GestionAsientosContables> findGestionAsientosContablesCollection(Clientes entity) {
        Clientes mergedEntity = this.getMergedEntity(entity);
        Collection<GestionAsientosContables> gestionAsientosContablesCollection = mergedEntity.getGestionAsientosContablesCollection();
        gestionAsientosContablesCollection.size();
        return gestionAsientosContablesCollection;
    }

    public boolean isTransaccionesCollectionEmpty(Clientes entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Clientes> clientes = cq.from(Clientes.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(clientes, entity), cb.isNotEmpty(clientes.get(Clientes_.transaccionesCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Transacciones> findTransaccionesCollection(Clientes entity) {
        Clientes mergedEntity = this.getMergedEntity(entity);
        Collection<Transacciones> transaccionesCollection = mergedEntity.getTransaccionesCollection();
        transaccionesCollection.size();
        return transaccionesCollection;
    }
    
}
