package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "managers")
@Data @AllArgsConstructor @NoArgsConstructor
public class ManagersEntity extends PersonEntity {
    @OneToOne
    private VillesEntity villes;
}
