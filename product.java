package tech.getarrays.productmanager.model;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
public class product implements Serializable {


    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private  Long id ;
    private  String nom ;
    private  Long prix ;
    private Long quantite ;





    public product () {}

    public product (String nom, Long prix, Long quantite) {
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;

    }
















    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }



    public Long getPrix() {
        return prix;
    }

    public void setPrix(Long prix) {
        this.prix = prix;
    }



    public Long getQuantite() {
        return quantite;
    }

    public void setQuantite(Long quantite) {
        this.quantite = quantite;
    }






    @Override
    public String toString() {
        return "product{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix='" + prix + '\'' +
                ", quantite='" + quantite + '\'' +
                '}';
    }















}

