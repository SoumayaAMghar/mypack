package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "chauffeurs")
public class ChauffeursEntity extends PersonEntity {
    private String depart;
    private String arrive;
    @OneToOne(mappedBy = "chauffeurs")
    private VehiculesEntity vehicules;

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getArrive() {
        return arrive;
    }

    public void setArrive(String arrive) {
        this.arrive = arrive;
    }

    public VehiculesEntity getVehicules() {
        return vehicules;
    }

    public void setVehicules(VehiculesEntity vehicules) {
        this.vehicules = vehicules;
    }
}
