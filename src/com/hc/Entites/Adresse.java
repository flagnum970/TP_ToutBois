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
    private String compl;
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
    public Adresse(int no, String rue, String compl, int cp, String ville,String pays) {
        this.no = no;
        this.rue = rue;
        this.compl= compl;
        this.cp = cp;
        this.ville = ville;
        this.pays = pays;
    }

    public String getCompl() {
        return compl;
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


    @Override
   public String toString() {
       return this.no+" "+this.rue+" "+this.cp+" "+this.ville+" "+this.pays;
   }
    
    
    
}
