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
public class Produit {
    private String code;
    private String designation;
    private double prixHT;
    private int qteStock;
    private static int dernierNo;
    
    public Produit(String code, String designation, double prixHT, int qteStock) {
        this.code = code;
        this.designation = designation;
        this.prixHT = prixHT;
        this.qteStock = qteStock;
    }

    //Constructeur sans le code : Généré automatiquement 
    //format : 3 lettres (type de produit) : on met 'IND' (indeterminé)
    //         un n° (6 chriffes)
    //
    public Produit(  String designation,double prixHT, int qteStock) {
        this.code = "IND"+ (++dernierNo);
        this.designation = designation;
        this.prixHT = prixHT;
        this.qteStock = qteStock;
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }
    
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrixHT() {
        return prixHT;
    }

    public void setPrixHT(double prixHT) {
        this.prixHT = prixHT;
    }

    public int getQteStock() {
        return qteStock;
    }

    public void setQteStock(int qteStock) {
        this.qteStock = qteStock;
    }
 
}
