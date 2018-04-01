/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.NonexistentEntityException;
import controladores.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.ArtVenta;

/**
 *
 * @author ISCO
 */
public class ArtVentaJpaController implements Serializable {

    public ArtVentaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ArtVenta artVenta) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(artVenta);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findArtVenta(artVenta.getArtVId()) != null) {
                throw new PreexistingEntityException("ArtVenta " + artVenta + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ArtVenta artVenta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            artVenta = em.merge(artVenta);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = artVenta.getArtVId();
                if (findArtVenta(id) == null) {
                    throw new NonexistentEntityException("The artVenta with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ArtVenta artVenta;
            try {
                artVenta = em.getReference(ArtVenta.class, id);
                artVenta.getArtVId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The artVenta with id " + id + " no longer exists.", enfe);
            }
            em.remove(artVenta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ArtVenta> findArtVentaEntities() {
        return findArtVentaEntities(true, -1, -1);
    }

    public List<ArtVenta> findArtVentaEntities(int maxResults, int firstResult) {
        return findArtVentaEntities(false, maxResults, firstResult);
    }

    private List<ArtVenta> findArtVentaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ArtVenta.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public ArtVenta findArtVenta(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ArtVenta.class, id);
        } finally {
            em.close();
        }
    }

    public int getArtVentaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ArtVenta> rt = cq.from(ArtVenta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
