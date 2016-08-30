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
public class Adresse {
    private int no;
    private String rue;
    private int cp;
    private String ville;
    private String pays;

    /***
     * Adresse 
     * 
     * @param no
     * @param rue
     * @param cp
     * @param ville 
     */
    public Adresse(int no, String rue, int cp, String ville,String pays) {
        this.no = no;
        this.rue = rue;
        this.cp = cp;
        this.ville = ville;
        this.pays = pays;
    }

    public int getNo() {
        return no;
    }

    public String getRue() {
        return rue;
    }

    public int getCp() {
        return cp;
    }

    public String getVille() {
        return ville;
    }

    public String getPays() {
        return pays;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
    
   public String toString() {
       return this.no+" "+this.rue+" "+this.cp+" "+this.ville+" "+this.pays;
   }
    
    
    
}
