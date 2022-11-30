package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "managers")
public class ManagersEntity extends PersonEntity {
    @OneToOne
    private VillesEntity villes;
}
