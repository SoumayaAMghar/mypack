package entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "villes")
public class VillesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne(mappedBy = "villes")
    private ManagersEntity managers;

    @OneToMany(mappedBy = "villes")
    private List<ProduitsEntity> produitsList;

    public Long getId() {
        return id;
    }

    public List<ProduitsEntity> getProduitsList() {
        return produitsList;
    }

    public void setProduitsList(List<ProduitsEntity> produitsList) {
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

    public ManagersEntity getManagers() {
        return managers;
    }

    public void setManagers(ManagersEntity managers) {
        this.managers = managers;
    }
}
