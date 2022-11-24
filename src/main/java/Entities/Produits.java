package Entities;

import jakarta.persistence.*;

@Entity
public class Produits {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private Float poids;
    private String categorie;
    private String statut;
    private String adress;
    @ManyToOne
    private Clients clients;
}

