package Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Clients extends Person{
    @OneToMany(mappedBy = "clients")
    private List<Produits> produitslist;

    public List<Produits> getProduitslist() {
        return produitslist;
    }

    public void setProduitslist(List<Produits> produitslist) {
        this.produitslist = produitslist;
    }
}
