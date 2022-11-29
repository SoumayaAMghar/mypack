package DAO;

import config.Config;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import entities.VehiculesEntity;

import java.util.*;

public class VehiculesDAO {
    public boolean add(VehiculesEntity vehicule) {
        EntityManager entityManager = Config.getConfig().getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(vehicule);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(VehiculesEntity vehicule) {
        EntityManager entityManager = Config.getConfig().getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(vehicule);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

public VehiculesEntity findById(int id) {
    EntityManager entityManager = Config.getConfig().getEntityManager();
    try {
        VehiculesEntity vehicule = entityManager.find(VehiculesEntity.class, id);
        if (vehicule != null) {
            return vehicule;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}

public boolean delete(int id) {
    EntityManager entityManager = Config.getConfig().getEntityManager();
    try {
        VehiculesEntity vehicule = entityManager.find(VehiculesEntity.class, id);
        if (vehicule != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(vehicule);
            entityManager.getTransaction().commit();
            return true;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}

public List<VehiculesEntity> findAll() {
    EntityManager entityManager = Config.getConfig().getEntityManager();
    try {
        TypedQuery<VehiculesEntity> query = entityManager.createQuery("SELECT v FROM VehiculesEntity v", VehiculesEntity.class);
        return query.getResultList();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}

}
