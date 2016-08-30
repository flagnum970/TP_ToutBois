/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hc.Entites;

import java.util.Date;

/**
 *
 * @author cflagollet
 */
public class Prospect extends Entreprise {


    public static int getDernierNo() {
        return dernierNo;
    }
    private int noRepresentant;
    private Date dateVisite; // date de la derniere visite du representant
    private int no;
    private static int dernierNo=0;
    
    public Prospect( String enseigne, Adresse adresse, String mail, String telephone, String siret,int noRepresentant, Date dateVisite) {
        super(enseigne, adresse, mail, telephone, siret);
        this.noRepresentant = noRepresentant;
        this.dateVisite = dateVisite;
        dernierNo++;
        this.no= dernierNo;
    }

    public Prospect(int no, String enseigne, Adresse adresse, String mail, String telephone, String siret,int noRepresentant, Date dateVisite) {
        super(enseigne, adresse, mail, telephone, siret);
        this.noRepresentant = noRepresentant;
        this.dateVisite = dateVisite;
        this.no= no;
        if (no>dernierNo) dernierNo=no;
    }
    
        public int getNo() {
        return no;
    }

    
    public int getNoRepresentant() {
        return noRepresentant;
    }

    public void setNoRepresentant(int noRepresentant) {
        this.noRepresentant = noRepresentant;
    }

    public Date getDateVisite() {
        return dateVisite;
    }

    public void setDateVisite(Date dateVisite) {
        this.dateVisite = dateVisite;
    }
    
}
