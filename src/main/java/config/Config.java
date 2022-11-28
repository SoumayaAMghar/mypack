package config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;



public class Config {
    private static EntityManagerFactory entityManagerFactory;
   
    private static Config config = new Config();

    private Config(){
        this.entityManagerFactory = Persistence.createEntityManagerFactory("mypack");
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }

    public static Config getConfig(){
        return config;
    }


}
