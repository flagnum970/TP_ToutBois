/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hc.application;

import com.hc.Entites.Client;
import com.hc.Entites.Prospect;
import com.hc.Entites.Representant;
import com.hc.ihm.MDIToutBois;
import com.hc.utils.*;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cflagollet
 */
public class Principale {
        /**
     * @param args the command line arguments
     */
   
    
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
                
                //On crée la map des représentants, à partir du fichier
                //
                HashMap<Integer,Representant> hashRep;
                try {
                  lstLignes=  FileUtils.litFichier(Constantes.FICHIER_REP);
                } 
                catch (FileNotFoundException ex) {
                    Logger.getLogger(Principale.class.getName()).log(Level.SEVERE, null, ex);
                    System.exit(0);
                }
                hashRep=FileUtils.decodeRep(lstLignes) ;
        
                //On crée la map des clients, à partir du fichier
                //
                HashMap<Integer,Client> hashClient;
                try {
                  lstLignes=  FileUtils.litFichier(Constantes.FICHIER_CLIENT);
                } 
                catch (FileNotFoundException ex) {
                    Logger.getLogger(Principale.class.getName()).log(Level.SEVERE, null, ex);
                    System.exit(0);
                }
                hashClient=FileUtils.decodeClient(lstLignes) ;
                
                //On crée la map des prospects, à partir du fichier
                //
                HashMap<Integer,Prospect> hashProspect;
                try {
                  lstLignes=  FileUtils.litFichier(Constantes.FICHIER_PROSPECT);
                } 
                catch (FileNotFoundException ex) {
                    Logger.getLogger(Principale.class.getName()).log(Level.SEVERE, null, ex);
                    System.exit(0);
                }
                hashProspect=FileUtils.decodeProspect(lstLignes) ;
                
                //On appelle la fenêtre MDI avec nos hashmaps
                new MDIToutBois(hashRep,hashClient,hashProspect).setVisible(true);
               
                }
        });
    }
}
