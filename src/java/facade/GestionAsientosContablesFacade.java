/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.GestionAsientosContables;
import model.GestionAsientosContables_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Clientes;

/**
 *
 * @author 18492
 */
@Stateless
public class GestionAsientosContablesFacade extends AbstractFacade<GestionAsientosContables> {

    @PersistenceContext(unitName = "ProyectoFinalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GestionAsientosContablesFacade() {
        super(GestionAsientosContables.class);
    }

    public boolean isIdClienteEmpty(GestionAsientosContables entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<GestionAsientosContables> gestionAsientosContables = cq.from(GestionAsientosContables.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(gestionAsientosContables, entity), cb.isNotNull(gestionAsientosContables.get(GestionAsientosContables_.idCliente)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Clientes findIdCliente(GestionAsientosContables entity) {
        return this.getMergedEntity(entity).getIdCliente();
    }
    
}
