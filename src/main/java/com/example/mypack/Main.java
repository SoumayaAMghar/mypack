package com.example.mypack;

import Entities.Clients;
import Entities.Produits;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.swing.event.CaretListener;

public class Main {
    public static void main(String[] args) {
        System.out.println("heelloo");





        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Produits produits= new Produits();
        produits.setAdress("Safi");
        produits.setCategorie("cloths");
        produits.setPoids(23.65);
        produits.setStatut("delivred");

        entityManager.getTransaction().begin();
        entityManager.persist(produits);
        entityManager.getTransaction().commit();
    }
}