package entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "clients")
public class ClientsEntity extends PersonEntity {
    @OneToMany(mappedBy = "clients")
    private List<ProduitsEntity> produitslist;

    public List<ProduitsEntity> getProduitslist() {
        return produitslist;
    }

    public void setProduitslist(List<ProduitsEntity> produitslist) {
        this.produitslist = produitslist;
    }
}
