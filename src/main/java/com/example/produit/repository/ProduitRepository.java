package com.example.produit.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.produit.entities.Category;
import com.example.produit.entities.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {
    List<Produit> findByCategory(Category category);

    List<Produit> findByNomProduit(String nomProduit);
}
