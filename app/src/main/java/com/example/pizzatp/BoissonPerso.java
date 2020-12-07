package com.example.pizzatp;

public class BoissonPerso {
    double prix;
    String nom;
    int image;

    public BoissonPerso(double prix, String nom, int image) {
        this.prix = prix;
        this.image = image;
        this.nom = nom;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
