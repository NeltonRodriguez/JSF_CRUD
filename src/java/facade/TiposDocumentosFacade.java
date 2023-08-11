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
import model.TiposDocumentos;
import model.TiposDocumentos_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Transacciones;

/**
 *
 * @author 18492
 */
@Stateless
public class TiposDocumentosFacade extends AbstractFacade<TiposDocumentos> {

    @PersistenceContext(unitName = "ProyectoFinalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiposDocumentosFacade() {
        super(TiposDocumentos.class);
    }

    public boolean isTransaccionesCollectionEmpty(TiposDocumentos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TiposDocumentos> tiposDocumentos = cq.from(TiposDocumentos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tiposDocumentos, entity), cb.isNotEmpty(tiposDocumentos.get(TiposDocumentos_.transaccionesCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Transacciones> findTransaccionesCollection(TiposDocumentos entity) {
        TiposDocumentos mergedEntity = this.getMergedEntity(entity);
        Collection<Transacciones> transaccionesCollection = mergedEntity.getTransaccionesCollection();
        transaccionesCollection.size();
        return transaccionesCollection;
    }
    
}
