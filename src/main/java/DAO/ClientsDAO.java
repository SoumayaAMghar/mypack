package DAO;

import config.Config;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import entities.ClientsEntity;
import java.util.*;


public class ClientsDAO {

    public boolean add(ClientsEntity client) {
        EntityManager entityManager = Config.getConfig().getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(client);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(ClientsEntity client) {
        EntityManager entityManager = Config.getConfig().getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(client);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ClientsEntity findById(int id) {
        EntityManager entityManager = Config.getConfig().getEntityManager();
        try {
            ClientsEntity client = entityManager.find(ClientsEntity.class, id);
            if (client != null) {
                return client;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean delete(int id) {
        EntityManager entityManager = Config.getConfig().getEntityManager();
        try {
            ClientsEntity client = entityManager.find(ClientsEntity.class, id);
            if (client != null) {
                entityManager.getTransaction().begin();
                entityManager.remove(client);
                entityManager.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ClientsEntity findByEmail(String email) {
        EntityManager entityManager = Config.getConfig().getEntityManager();
        try {
            TypedQuery<ClientsEntity> query = entityManager.createQuery("SELECT c FROM ClientsEntity c WHERE c.email = :email", ClientsEntity.class);
            query.setParameter("email", email);
            if (query.getSingleResult() != null) {
                return query.getSingleResult();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ClientsEntity> getAll() {
        EntityManager entityManager = Config.getConfig().getEntityManager();
        try {
            TypedQuery<ClientsEntity> query = entityManager.createQuery("SELECT c FROM ClientsEntity c", ClientsEntity.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ClientsEntity login(String email, String password) {
        EntityManager entityManager = Config.getConfig().getEntityManager();
        try {
            TypedQuery<ClientsEntity> query = entityManager.createQuery("SELECT c FROM ClientsEntity c WHERE c.email = :email AND c.password = :password", ClientsEntity.class);
            query.setParameter("email", email);
            query.setParameter("password", password);
            if (query.getSingleResult() != null) {
                return query.getSingleResult();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
