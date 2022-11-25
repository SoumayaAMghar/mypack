package Entities;

import jakarta.persistence.*;

@Entity
public class Vehicules {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private type type;
   @OneToOne
   private Produits produits;

   enum type{
       voiture, petit_camion, grand_camion
   }
}
