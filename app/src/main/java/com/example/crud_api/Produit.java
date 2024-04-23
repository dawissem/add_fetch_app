package com.example.crud_api;

public class Produit {
    private String idProduit;
    private String nomProduit;
    private double prixProduit;

    public Produit() {
    }
    public Produit(String nomProduit) {
        this.prixProduit=prixProduit;
        this.nomProduit = nomProduit;
    }
    public double getPrixProduit(){return prixProduit;}
    public String getNomProduit() {
        return nomProduit;
    }

    public String getIdProduit() {
        return idProduit;
    }
    public void setIdProduit(String idProduit) {this.idProduit = idProduit;}

    public void setNomProduit(String nomProduit) {this.nomProduit = nomProduit;}
    public void setPrixProduit(double prixProduit){this.prixProduit= prixProduit;}
}