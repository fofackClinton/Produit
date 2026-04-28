package com.example.produit.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;

    @Column(name="nom_produit", length=50, nullable=false)
    private String nomProduit;
    
    @ManyToOne
    @JoinColumn(name="id_cat")
    private Category category;

    @Override
    public String toString() {
        return "Produit [idProduit=" + idProduit + ", nomProduit=" + nomProduit + ", category=" + category + "]";
    }

    public Produit(Long idProduit, String nomProduit, Category category) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.category = category;
    }

    public Long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
