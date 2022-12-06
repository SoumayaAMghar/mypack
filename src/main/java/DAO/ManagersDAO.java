package DAO;

import config.Config;
import jakarta.persistence.*;
import entities.*;


public class ManagersDAO {
//    public ManagersDAO() {
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mypack");
//        this.entityManager = entityManagerFactory.createEntityManager();
//    }
//
//    EntityManager entityManager;
//

    public boolean add(ManagersEntity manager){
        EntityManager entityManager = Config.getConfig().getEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(manager);
            entityManager.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(ManagersEntity manager){
        EntityManager entityManager = Config.getConfig().getEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(manager);
            entityManager.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

public ManagersEntity findById(int id) {
    EntityManager entityManager = Config.getConfig().getEntityManager();
    try {
        ManagersEntity manager = entityManager.find(ManagersEntity.class, id);
        if (manager != null) {
            return manager;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}

public boolean delete(int id) {
    EntityManager entityManager = Config.getConfig().getEntityManager();
    try {
        ManagersEntity manager = entityManager.find(ManagersEntity.class, id);
        if (manager != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(manager);
            entityManager.getTransaction().commit();
            return true;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}

public boolean findByEmail(String email) {
    EntityManager entityManager = Config.getConfig().getEntityManager();
    try {
        TypedQuery<ManagersEntity> query = entityManager.createQuery("SELECT m FROM ManagersEntity m WHERE m.email = :email", ManagersEntity.class);
        query.setParameter("email", email);
        if (query.getSingleResult() != null) {
            return true;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}

public ManagersEntity getAllManagers() {
    EntityManager entityManager = Config.getConfig().getEntityManager();
    try {
        TypedQuery<ManagersEntity> query = entityManager.createQuery("SELECT m FROM ManagersEntity m", ManagersEntity.class);
        return query.getSingleResult();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}


public boolean login(String email, String password) {
    try {
        EntityManager entityManager = Config.getConfig().getEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT m FROM ManagersEntity m where m.email =: email AND m.password =: password", ManagersEntity.class);
        query.setParameter("email",email);
        query.setParameter("password", password);
        ManagersEntity managersEntity = (ManagersEntity) query.getSingleResult();
        entityManager.getTransaction().commit();

        if (managersEntity != null){
            return true;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}

public ManagersEntity findManagersByVille(String ville) {
    EntityManager entityManager = Config.getConfig().getEntityManager();
    try {
        TypedQuery<ManagersEntity> query = entityManager.createQuery("SELECT m FROM ManagersEntity m WHERE m.villes = :ville", ManagersEntity.class);
        query.setParameter("ville", ville);
        return query.getSingleResult();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}



}
