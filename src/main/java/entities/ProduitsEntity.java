package entities;

import jakarta.persistence.*;

@Entity
public class ProduitsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private Double poids;
    private String categorie;
    private statut statut;
    private String destination;

    public VillesEntity getVilles() {
        return villes;
    }

    public void setVilles(VillesEntity villes) {
        this.villes = villes;
    }

    public VehiculesEntity getVehicules() {
        return vehicules;
    }

    public void setVehicules(VehiculesEntity vehicules) {
        this.vehicules = vehicules;
    }

    @ManyToOne
    private ClientsEntity clients;
    @ManyToOne
    private VillesEntity villes;
    @ManyToOne
    private VehiculesEntity vehicules;
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

    public ProduitsEntity.statut getStatut() {
        return statut;
    }

    public void setStatut(ProduitsEntity.statut statut) {
        this.statut = statut;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    public ClientsEntity getClients() {
        return clients;
    }

    public void setClients(ClientsEntity clients) {
        this.clients = clients;
    }

}

