package com.example.produit.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.produit.entities.Category;
import com.example.produit.entities.Produit;
import com.example.produit.repository.ProduitRepository;
import com.example.produit.services.ProduitService;

@Service
public class ProduitServiceImpl implements ProduitService {

    private final ProduitRepository produitRepository;

    public ProduitServiceImpl(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @Override
    public Produit saveProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public Produit getProduitById(Long id) {
         return produitRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }

    @Override
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    @Override
    public List<Produit> getProduitsByCategory(Category category) {
        return produitRepository.findByCategory(category);
    }

    @Override
    public List<Produit> findProduitsByNom(String nom) {
        return produitRepository.findByNomProduit(nom);
    }

    @Override
    public Produit updateProduit(Long id, Produit produit) {
        Produit existingProduit = produitRepository.findById(id).orElse(null);
        if (existingProduit != null) {
            existingProduit.setNomProduit(produit.getNomProduit());
            existingProduit.setCategory(produit.getCategory());
            return produitRepository.save(existingProduit);
        }
        return null;
    }

}
