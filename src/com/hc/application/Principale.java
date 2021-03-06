/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hc.application;

import com.hc.Entites.Adresse;
import com.hc.Entites.Client;
import com.hc.Entites.Commande;
import com.hc.Entites.Produit;
import com.hc.Entites.Prospect;
import com.hc.Entites.Representant;
import com.hc.ihm.MDIToutBois;
import com.hc.utils.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe principale de l'application
 * Cette classe charge les  fichiers et instancie une Hashmap pour chaque Entité :
 * Représentant, client, prospect, produit, commande
 * Ensuite, elle crée et affiche la fenêtre MDI principale
 * @author cflagollet
 */
public class Principale {
         
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MDIToutBois.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MDIToutBois.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MDIToutBois.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MDIToutBois.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                List<String> lstLignes=null;
                
                //Avant tout, on se connecte à la BDD
                MySQLCli mysqlCli = new MySQLCli("//localhost/toutbois", "root", "Paulilou_20");
                if (mysqlCli.connect()) {
                    System.err.println("Connexion OK");
                } else System.err.println("erreur connexion");
        
                FileUtils fu = new FileUtils(mysqlCli);
                    
                //Création de la hashMap des clients à partir de la base mySql
                HashMap<Integer,Representant> hashRep=FileUtils.decodeRepSQL();
                HashMap<Integer,Client> hashClient =FileUtils.decodeClientSQL();
                HashMap<Integer,Prospect> hashProspect=FileUtils.decodeProspectSQL();
                HashMap<Integer,Commande> hashCommande=null;
                HashMap<String,Produit> hashProduit=null;
                
                //On crée la map des représentants, à partir du fichier
                //lstLignes=  FileUtils.litFichier(Constantes.FICHIER_REP);
                //hashRep=FileUtils.decodeRep(lstLignes) ;
        
                //On crée la map des clients, à partir du fichier
                //HashMap<Integer,Client> hashClient;
                //lstLignes=  FileUtils.litFichier(Constantes.FICHIER_CLIENT);
                //hashClient=FileUtils.decodeClient(lstLignes) ;
             
                //On crée la map des prospects, à partir du fichier
                //HashMap<Integer,Prospect> hashProspect;
                //lstLignes=  FileUtils.litFichier(Constantes.FICHIER_PROSPECT);
                //hashProspect=FileUtils.decodeProspect(lstLignes) ;
                
                //On crée la map des produits, à partir du fichier
                //HashMap<String,Produit> hashProduit;
                //lstLignes=  FileUtils.litFichier(Constantes.FICHIER_PRODUIT);
                //hashProduit=FileUtils.decodeProduit(lstLignes) ;
                
                //On crée la map des produits, à partir du fichier
                //HashMap<Integer,Commande> hashCommande;
                //lstLignes=  FileUtils.litFichier(Constantes.FICHIER_COMMANDE);
                //hashCommande=FileUtils.decodeCommande(lstLignes) ;
                
                //On appelle la fenêtre MDI avec nos hashmaps
                new MDIToutBois(hashRep,hashClient,hashProspect,hashProduit,hashCommande).setVisible(true);
                
                }
        });
    }
}
