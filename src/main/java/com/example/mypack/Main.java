package com.example.mypack;

import entities.ProduitsEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        System.out.println("heelloo");





        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mypack");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ProduitsEntity produits= new ProduitsEntity();
        produits.setCategorie("cloths");
        produits.setPoids(23.65);

        entityManager.getTransaction().begin();
        entityManager.persist(produits);
        entityManager.getTransaction().commit();
    }
}
