package Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Clients {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String email;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Produits> getProduitslist() {
        return produitslist;
    }

    public void setProduitslist(List<Produits> produitslist) {
        this.produitslist = produitslist;
    }

    @OneToMany(mappedBy = "clients")
    private List<Produits> produitslist;
}
