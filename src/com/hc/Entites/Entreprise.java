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
public class Entreprise {
    protected String enseigne;
    protected Adresse adresse;
    protected String mail;
    protected  String telephone;
    protected String siret;

    public Entreprise(String enseigne, Adresse adresse, String mail, String telephone, String siret) {
        this.enseigne = enseigne;
        this.adresse = adresse;
        this.mail = mail;
        this.telephone = telephone;
        this.siret = siret;
    }

    public String getEnseigne() {
        return enseigne;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setEnseigne(String enseigne) {
        this.enseigne = enseigne;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getMail() {
        return mail;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getSiret() {
        return siret;
    }
    
    public String getAdrToString()
    {
        return adresse.toString();
    }
    
}
