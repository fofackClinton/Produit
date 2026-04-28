package com.example.produit.services;

import java.util.List;

import com.example.produit.entities.Category;
import com.example.produit.entities.Produit;

public interface ProduitService {

    Produit saveProduit(Produit produit);

    String getProduitById(Long id);

    void deleteProduit(Long id);

    List<Produit> getAllProduits();

    List<Produit> getProduitsByCategory(Category category);

    List<Produit> findProduitsByNom(String nom);

    Produit updateProduit(Long id, Produit produit);


}
