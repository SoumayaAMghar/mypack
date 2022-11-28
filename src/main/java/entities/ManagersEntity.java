package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class ManagersEntity extends PersonEntity {
    @OneToOne
    private VillesEntity villes;
}
