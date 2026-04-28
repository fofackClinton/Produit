package com.example.produit.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCat;

    @Column(name="nom_cat", length=50, nullable=false, unique=true)
    private String nomCat;

    @Column(name="description_cat", length=255)
    private String descriptionCat;

    @OneToMany(mappedBy = "category")
    private List<Produit> produits;

    @Override
    public String toString() {
        return "Category [idCat=" + idCat + ", nomCat=" + nomCat + ", descriptionCat=" + descriptionCat + ", produits="
                + produits + "]";
    }

    public Category(String descriptionCat, Long idCat, String nomCat, List<Produit> produits) {
        this.descriptionCat = descriptionCat;
        this.idCat = idCat;
        this.nomCat = nomCat;
        this.produits = produits;
    }

    public Long getIdCat() {
        return idCat;
    }

    public void setIdCat(Long idCat) {
        this.idCat = idCat;
    }

    public String getNomCat() {
        return nomCat;
    }

    public void setNomCat(String nomCat) {
        this.nomCat = nomCat;
    }

    public String getDescriptionCat() {
        return descriptionCat;
    }

    public void setDescriptionCat(String descriptionCat) {
        this.descriptionCat = descriptionCat;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

   

}
