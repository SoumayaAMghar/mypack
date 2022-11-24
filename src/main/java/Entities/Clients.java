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
    @OneToMany(mappedBy = "clients")
    private List<Produits> produitslist;
}
