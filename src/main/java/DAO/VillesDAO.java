package DAO;

import config.Config;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import entities.VillesEntity;

import java.util.*;

public class VillesDAO {
    public boolean add(VillesEntity ville) {
        EntityManager entityManager = Config.getConfig().getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(ville);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(VillesEntity ville) {
        EntityManager entityManager = Config.getConfig().getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(ville);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public VillesEntity findById(int id) {
        EntityManager entityManager = Config.getConfig().getEntityManager();
        try {
            VillesEntity ville = entityManager.find(VillesEntity.class, id);
            if (ville != null) {
                return ville;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean delete(int id) {
        EntityManager entityManager = Config.getConfig().getEntityManager();
        try {
            VillesEntity ville = entityManager.find(VillesEntity.class, id);
            if (ville != null) {
                entityManager.getTransaction().begin();
                entityManager.remove(ville);
                entityManager.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<VillesEntity> findAll() {
        EntityManager entityManager = Config.getConfig().getEntityManager();
        try {
            TypedQuery<VillesEntity> query = entityManager.createQuery("SELECT v FROM VillesEntity v", VillesEntity.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
