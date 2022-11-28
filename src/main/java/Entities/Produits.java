package Entities;

import jakarta.persistence.*;

@Entity
public class Produits {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private Double poids;
    private String categorie;
    private statut statut;
    private String destination;

    public Villes getVilles() {
        return villes;
    }

    public void setVilles(Villes villes) {
        this.villes = villes;
    }

    public Vehicules getVehicules() {
        return vehicules;
    }

    public void setVehicules(Vehicules vehicules) {
        this.vehicules = vehicules;
    }

    @ManyToOne
    private Clients clients;
    @ManyToOne
    private Villes villes;
    @ManyToOne
    private Vehicules vehicules;
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

enum statut{
        encours, delivre
}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPoids() {
        return poids;
    }

    public void setPoids(Double poids) {
        this.poids = poids;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Produits.statut getStatut() {
        return statut;
    }

    public void setStatut(Produits.statut statut) {
        this.statut = statut;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    public Clients getClients() {
        return clients;
    }

    public void setClients(Clients clients) {
        this.clients = clients;
    }

}

