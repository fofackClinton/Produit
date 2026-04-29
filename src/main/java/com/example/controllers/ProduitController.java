package com.example.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.produit.entities.Produit;
import com.example.produit.services.ProduitService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.produit.entities.Category;




@Controller
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProduitController {

    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping(value="/all", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Produit> getAllProduct() {
        return produitService.getAllProduits();
    }
    
    @GetMapping(value= "/{id}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Produit getProduitById(@PathVariable("id") Long id) {
        return produitService.getProduitById(id);
    }

    @PostMapping(value ="/create", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Produit postMethodName(@RequestBody Produit produit) {
        return produitService.saveProduit(produit);
    }

    @PutMapping(value = "/update/{id}", produces = APPLICATION_JSON_VALUE, consumes=APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Produit updateProduit(@PathVariable("id") Long id, @RequestBody Produit produit) {
        return produitService.updateProduit(id, produit);
    }

    @GetMapping(value="/getByCategory", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.FOUND)
    public List<Produit> getProduitByCategory(@RequestBody Category category) {
        return produitService.getProduitsByCategory(category);
    }

    @GetMapping(value="/getproduitByname/{name}", produces=APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.FOUND)
    public List<Produit> getMethodName(@PathVariable("name") String name) {
        return produitService.findProduitsByNom(name);
    }
    
    @DeleteMapping(value=("delete/{id}"))
    public void deleteProduit(@PathVariable("id") Long id){
        produitService.deleteProduit(id);
    }
    
}
