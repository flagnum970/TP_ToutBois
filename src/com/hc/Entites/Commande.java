/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hc.Entites;

import java.util.Date;
import java.util.List;

/**
 *
 * @author cflagollet
 */
public class Commande {
    public enum etat_commande {enCours,validee,facturee};
    
    private int no;
    private static int dernierNo=0;
    private Date dtCommande;
    private Date dtLivraison;
    private List<LigneCommande> lgComm;
    private etat_commande etat;

    /**
     *
     * @param dtCommande
     * @param dtLivraison
     * @param lgComm
     * @param etat : initialisée à 'en cours'
     */
    public Commande(Date dtCommande, Date dtLivraison,List<LigneCommande>lgComm) {
        no = ++dernierNo;
        this.dtCommande = dtCommande; //on passe la date car pas forcément la date du jour !
        this.dtLivraison = dtLivraison;
        this.lgComm = lgComm;
        this.etat = etat_commande.enCours;
    }

    public static int getDernierNo() {
        return dernierNo;
    }

    public Date getDtCommande() {
        return dtCommande;
    }

    public void setDtCommande(Date dtCommande) {
        this.dtCommande = dtCommande;
    }

    public Date getDtLivraison() {
        return dtLivraison;
    }

    public void setDtLivraison(Date dtLivraison) {
        this.dtLivraison = dtLivraison;
    }

    public List<LigneCommande> getLgComm() {
        return lgComm;
    }

    public void LgCommAdd(LigneCommande lg) {
        lgComm.add(lg);
    }
    public void LgCommRemove(LigneCommande lg) {
        lgComm.remove(lg);
    }
    
    public void LgCommSet(int i,LigneCommande lg)  {
        lgComm.set(i, lg);
    }
    
    public etat_commande getEtat() {
        return etat;
    }

    public void setEtat(etat_commande etat) {
        this.etat = etat;
    }
    
    
    
}
