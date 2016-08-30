/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hc.Entites;

/**
 *
 * @author cflagollet
 */
public class Personne {
    private String nom;
    private String prenom;
    private Adresse adresse;
    
    /* constructeur*/

    public Personne(String nom, String prenom, Adresse adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdrToString()
    {
        return adresse.toString();
    }
    
    public Adresse getAdresse() 
    {
        return adresse;
    }
}
