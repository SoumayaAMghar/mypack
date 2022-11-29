package DAO;

import config.Config;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import entities.ProduitsEntity;

import java.util.*;



public class ProduitsDAO {
    public boolean add(ProduitsEntity produit) {
        EntityManager entityManager = Config.getConfig().getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(produit);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(ProduitsEntity produit) {
        EntityManager entityManager = Config.getConfig().getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(produit);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ProduitsEntity findById(int id) {
        EntityManager entityManager = Config.getConfig().getEntityManager();
        try {
            ProduitsEntity produit = entityManager.find(ProduitsEntity.class, id);
            if (produit != null) {
                return produit;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean delete(int id) {
        EntityManager entityManager = Config.getConfig().getEntityManager();
        try {
            ProduitsEntity produit = entityManager.find(ProduitsEntity.class, id);
            if (produit != null) {
                entityManager.getTransaction().begin();
                entityManager.remove(produit);
                entityManager.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<ProduitsEntity> getAll() {
        EntityManager entityManager = Config.getConfig().getEntityManager();
        try {
            TypedQuery<ProduitsEntity> query = entityManager.createQuery("SELECT p FROM ProduitsEntity p", ProduitsEntity.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ProduitsEntity> getAllByCategorie(int id) {
        EntityManager entityManager = Config.getConfig().getEntityManager();
        try {
            TypedQuery<ProduitsEntity> query = entityManager.createQuery("SELECT p FROM ProduitsEntity p WHERE p.categorie = :id", ProduitsEntity.class);
            query.setParameter("id", id);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
