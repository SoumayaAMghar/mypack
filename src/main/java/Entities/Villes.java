package Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Villes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne(mappedBy = "villes")
    private Managers managers;

    @OneToMany(mappedBy = "villes")
    private List<Produits> produitsList;

    public Long getId() {
        return id;
    }

    public List<Produits> getProduitsList() {
        return produitsList;
    }

    public void setProduitsList(List<Produits> produitsList) {
        this.produitsList = produitsList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Managers getManagers() {
        return managers;
    }

    public void setManagers(Managers managers) {
        this.managers = managers;
    }
}
