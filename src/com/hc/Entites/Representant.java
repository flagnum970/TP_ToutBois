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
public class Representant extends Personne {
    private static int dernierNo=0;
    private int no;
    private double txComm;
    private double salaire;

    public Representant(String nom, String prenom, double txComm, double salaire, Adresse adresse) {
        super(nom, prenom, adresse);
        this.txComm = txComm;
        this.salaire = salaire;
        dernierNo++;
        no= dernierNo;
    }

    public Representant(int no,  String nom, String prenom, double txComm, double salaire, Adresse adresse) {
        super(nom, prenom, adresse);
        this.no = no;
        this.txComm = txComm;
        this.salaire = salaire;
        if (no>dernierNo)
            dernierNo = no;
    }
    
    public int getNo() {
        return no;
    }

    public double getTxComm() {
        return txComm;
    }

    public void setTxComm(double txComm) {
        this.txComm = txComm;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    // dernier numéro doit être mis à jour avec le plus grand lu dans le fichier  
    public static void setDernierNo(int dernierNo) {
        Representant.dernierNo = dernierNo;
    }

    public static int getDernierNo() {
        return dernierNo;
    }
    
   
}
