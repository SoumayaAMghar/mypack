package DAO;

import config.Config;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import entities.*;

public class AdminDAO {
    private EntityManager entityManager = Config.getConfig().getEntityManager();

    public boolean login(String email, String password){
        try{
        TypedQuery<AdminEntity> query = entityManager.createQuery("SELECT a FROM AdminEntity  a WHERE a.email = :email AND a.password = :password", AdminEntity.class);
        query.setParameter("email", email);
        query.setParameter("password", password);
       if (query.getSingleResult() != null){
           System.out.println("Admin found");
           return true;
       }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
