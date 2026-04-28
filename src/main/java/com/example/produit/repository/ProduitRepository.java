package com.example.produit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.produit.entities.Category;
import com.example.produit.entities.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {
    List<Produit> findByCategory(Category category);

    List<Produit> findByNomProduit(String nomProduit);
 
    List<Produit> findByNomProduitContains(String nomproduit);

    // //requete JPQl 
    // @Query("select p from Produit p where p.nomProduit like %?1 and p.prixProduit > ?2")
    // List<Produit> findByNomPrix(String nom, Double prix);

    @Query("select p from Produit p where p.nomProduit like %:nom and p.prixProduit > :prix")
    List<Produit> findByNomPrix(@Param("nom") String nom, @Param("prix") Double prix);
    
    // @Query("select p from Produit p where p.category = :category")
    // List<Produit> findByCategory(@Param("category") Category category);

    List<Produit> findByCategoryIdCat(Long idCat);

    List<Produit> findByOrderByNomProduitAsc();

    @Query("select p from Produit p order by p.nomProduit ASC, p.prixProduit DESC")
    List<Produit> trierProduitsNomsPrix();
}
 