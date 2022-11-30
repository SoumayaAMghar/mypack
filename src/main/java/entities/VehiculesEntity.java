package entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "vehicules")
public class VehiculesEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private type type;
   @OneToOne
   private ChauffeursEntity chauffeurs;

   @OneToMany(mappedBy = "vehicules")
   private List<ProduitsEntity> produitsList;

   public ChauffeursEntity getChauffeurs() {
      return chauffeurs;
   }

   public List<ProduitsEntity> getProduitsList() {
      return produitsList;
   }

   public void setProduitsList(List<ProduitsEntity> produitsList) {
      this.produitsList = produitsList;
   }

   public void setChauffeurs(ChauffeursEntity chauffeurs) {
      this.chauffeurs = chauffeurs;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public VehiculesEntity.type getType() {
      return type;
   }

   public void setType(VehiculesEntity.type type) {
      this.type = type;
   }
   enum type{
       voiture, petit_camion, grand_camion
   }
}
