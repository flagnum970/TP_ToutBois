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
public class Client extends Entreprise {
    private int no;
    private int noRepresentant;
    private int nbCommandes;
    private static int dernierNo=0;

    //Constructeur sans le n° 
    public Client( String enseigne, Adresse adresse, String mail, String telephone, String siret,int noRepresentant, int nbCommandes) {
        super(enseigne, adresse, mail, telephone, siret);
        this.noRepresentant = noRepresentant;
        this.nbCommandes = nbCommandes;
        dernierNo++;
        this.no= dernierNo;
    }

    //Constructeur avec le n° passé en paramètre
    public Client(int no, String enseigne, Adresse adresse, String mail, String telephone, String siret,int noRepresentant, int nbCommandes) {
        super(enseigne, adresse, mail, telephone, siret);
        this.noRepresentant = noRepresentant;
        this.nbCommandes = nbCommandes;
        this.no= no;
        //On note le plus grand comme dernier no
        if (no>dernierNo) dernierNo=no;
    }
    
    public int getNo() {
        return no;
    }

    public void setNoRepresentant(int noRepresentant) {
        this.noRepresentant = noRepresentant;
    }

    public void setNbCommandes(int nbCommandes) {
        this.nbCommandes = nbCommandes;
    }

    public static void setDernierNo(int dernierNo) {
        Client.dernierNo = dernierNo;
    }



    public int getNoRepresentant() {
        return noRepresentant;
    }
    
    public int getNbCommandes() {
        return nbCommandes;
    }

    public static int getDernierNo() {
        return dernierNo;
    }
    
}
