package DAO;

import config.Config;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import entities.ChauffeursEntity;

import java.util.*;

public class ChauffeursDAO {
    public boolean add(ChauffeursEntity chauffeur) {
        EntityManager entityManager = Config.getConfig().getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(chauffeur);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(ChauffeursEntity chauffeur) {
        EntityManager entityManager = Config.getConfig().getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(chauffeur);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public ChauffeursEntity findById(int id) {
        EntityManager entityManager = Config.getConfig().getEntityManager();
        try {
            ChauffeursEntity chauffeur = entityManager.find(ChauffeursEntity.class, id);
            if (chauffeur != null) {
                return chauffeur;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean delete(int id) {
        EntityManager entityManager = Config.getConfig().getEntityManager();
        try {
            ChauffeursEntity chauffeur = entityManager.find(ChauffeursEntity.class, id);
            if (chauffeur != null) {
                entityManager.getTransaction().begin();
                entityManager.remove(chauffeur);
                entityManager.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<ChauffeursEntity> getAll() {
        EntityManager entityManager = Config.getConfig().getEntityManager();
        try {
            TypedQuery<ChauffeursEntity> query = entityManager.createQuery("SELECT c FROM ChauffeursEntity c", ChauffeursEntity.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
