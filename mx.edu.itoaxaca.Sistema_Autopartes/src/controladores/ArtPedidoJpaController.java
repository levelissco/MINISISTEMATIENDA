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
import modelo.ArtPedido;

/**
 *
 * @author ISCO
 */
public class ArtPedidoJpaController implements Serializable {

    public ArtPedidoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ArtPedido artPedido) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(artPedido);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findArtPedido(artPedido.getArtPId()) != null) {
                throw new PreexistingEntityException("ArtPedido " + artPedido + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ArtPedido artPedido) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            artPedido = em.merge(artPedido);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = artPedido.getArtPId();
                if (findArtPedido(id) == null) {
                    throw new NonexistentEntityException("The artPedido with id " + id + " no longer exists.");
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
            ArtPedido artPedido;
            try {
                artPedido = em.getReference(ArtPedido.class, id);
                artPedido.getArtPId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The artPedido with id " + id + " no longer exists.", enfe);
            }
            em.remove(artPedido);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ArtPedido> findArtPedidoEntities() {
        return findArtPedidoEntities(true, -1, -1);
    }

    public List<ArtPedido> findArtPedidoEntities(int maxResults, int firstResult) {
        return findArtPedidoEntities(false, maxResults, firstResult);
    }

    private List<ArtPedido> findArtPedidoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ArtPedido.class));
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

    public ArtPedido findArtPedido(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ArtPedido.class, id);
        } finally {
            em.close();
        }
    }

    public int getArtPedidoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ArtPedido> rt = cq.from(ArtPedido.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
