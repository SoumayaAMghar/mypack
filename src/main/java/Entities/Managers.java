package Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Managers extends Person{
    @OneToOne
    private Villes villes;
}
