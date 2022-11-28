package Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Vehicules {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private type type;
   @OneToOne
   private Chauffeurs chauffeurs;

   @OneToMany(mappedBy = "vehicules")
   private List<Produits> produitsList;

   public Chauffeurs getChauffeurs() {
      return chauffeurs;
   }

   public List<Produits> getProduitsList() {
      return produitsList;
   }

   public void setProduitsList(List<Produits> produitsList) {
      this.produitsList = produitsList;
   }

   public void setChauffeurs(Chauffeurs chauffeurs) {
      this.chauffeurs = chauffeurs;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Vehicules.type getType() {
      return type;
   }

   public void setType(Vehicules.type type) {
      this.type = type;
   }
   enum type{
       voiture, petit_camion, grand_camion
   }
}
