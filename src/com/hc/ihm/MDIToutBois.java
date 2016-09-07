/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hc.ihm;
import com.hc.Entites.*;
import com.hc.application.Principale;
import com.hc.utils.Constantes;
import com.hc.utils.FileUtils;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.beans.PropertyVetoException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author cflagollet
 */
public class MDIToutBois extends javax.swing.JFrame {

    private HashMap<Integer,Representant> hashRep;
    private HashMap<Integer,Client> hashClient;
    private HashMap<Integer,Prospect> hashProspect;
    private HashMap<String,Produit> hashProduit;
    private HashMap<Integer,Commande> hashCommande;
    /**
     * Creates new form MDIToutBois
     */

    public MDIToutBois( HashMap<Integer,Representant> hashRep,
                        HashMap<Integer,Client> hashClient,
                        HashMap<Integer,Prospect> hashProspect,
                        HashMap<String,Produit> hashProduit,
                        HashMap<Integer,Commande> hashCommande) 
    {
        
        super("TP Gestion société TOUTBOIS");
        initComponents();
        this.hashRep = hashRep;
        this.hashClient = hashClient;
        this.hashProspect = hashProspect;
        this.hashProduit = hashProduit;
        this.hashCommande = hashCommande;
        
        //centrer la fenetre
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setSize( 1024, 768);
        setLocation(dim.width/2 - getWidth()/2, dim.height/2 - getHeight()/2);
      

        //on ajoute un windowListener pour gérer la fermeture par clic sur la croix (fermeture)
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                quitteSauve();
            }
        });
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        gestionMenu = new javax.swing.JMenu();
        representantMenuItem = new javax.swing.JMenuItem();
        clientMenuItem = new javax.swing.JMenuItem();
        prospectMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();
        commandeMenu = new javax.swing.JMenu();
        produitMenuItem = new javax.swing.JMenuItem();
        commandeMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        gestionMenu.setMnemonic('f');
        gestionMenu.setText("Gestion");

        representantMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        representantMenuItem.setMnemonic('o');
        representantMenuItem.setText("Représentant");
        representantMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                representantMenuItemActionPerformed(evt);
            }
        });
        gestionMenu.add(representantMenuItem);

        clientMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        clientMenuItem.setMnemonic('s');
        clientMenuItem.setText("Client");
        clientMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientMenuItemActionPerformed(evt);
            }
        });
        gestionMenu.add(clientMenuItem);

        prospectMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        prospectMenuItem.setMnemonic('a');
        prospectMenuItem.setText("Prospect");
        prospectMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prospectMenuItemActionPerformed(evt);
            }
        });
        gestionMenu.add(prospectMenuItem);
        gestionMenu.add(jSeparator1);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Quitter");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        gestionMenu.add(exitMenuItem);

        menuBar.add(gestionMenu);

        commandeMenu.setText("Commandes");

        produitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        produitMenuItem.setText("Gestion des produits");
        produitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produitMenuItemActionPerformed(evt);
            }
        });
        commandeMenu.add(produitMenuItem);

        commandeMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        commandeMenuItem.setText("Gestion des commandes");
        commandeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commandeMenuItemActionPerformed(evt);
            }
        });
        commandeMenu.add(commandeMenuItem);

        menuBar.add(commandeMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Aide");

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("A propos");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        quitteSauve();
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void representantMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_representantMenuItemActionPerformed
        

        //On passe en revue les composants ouverts
        boolean bFound = false;
        for (Component c :  this.desktopPane.getComponents()) 
           //Si   on trouve la fenêtre des représentants, on lui donne le focus
           if (c instanceof com.hc.ihm.JFrmIntLstRep) {
                bFound=true;
                ((JFrmIntLstRep) c).pack();
                ((JFrmIntLstRep) c).toFront();
           }
        //Si on a pas trouvé, on crée la fenêtre   
       if (!bFound) {
            JFrmIntLstRep jFrmIntRep = new JFrmIntLstRep(hashRep,hashProspect,hashClient);
            desktopPane.add( jFrmIntRep );
            Dimension dim = desktopPane.getSize();
            jFrmIntRep.setLocation(dim.width/2 - jFrmIntRep.getWidth()/2, dim.height/2 - jFrmIntRep.getHeight()/2);
            jFrmIntRep.setVisible( true ); 
       }
       
    }//GEN-LAST:event_representantMenuItemActionPerformed

    private void prospectMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prospectMenuItemActionPerformed
        //On passe en revue les composants ouverts
        boolean bFound = false;
        
        for (Component c :  this.desktopPane.getComponents()) 
           //Si   on trouve la fenêtre des représentants, on lui donne le focus
           if (c instanceof com.hc.ihm.JFrmIntLstProspect) {
                bFound=true;
                ((JFrmIntLstProspect) c).pack();
                ((JFrmIntLstProspect) c).toFront();
           }
        //Si on a pas trouvé, on crée la fenêtre   
        if (!bFound) {
            JFrmIntLstProspect jFrmIntProspect = new JFrmIntLstProspect(hashProspect,hashRep);
            desktopPane.add( jFrmIntProspect );
            Dimension dim = desktopPane.getSize();
            jFrmIntProspect.setLocation(dim.width/2 - jFrmIntProspect.getWidth()/2, dim.height/2 - jFrmIntProspect.getHeight()/2);
            jFrmIntProspect.setVisible( true ); 
        }
    }//GEN-LAST:event_prospectMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        JOptionPane.showMessageDialog(desktopPane, "Gestion TOUTBOIS MDI\n\nVersion 0.1 17/08/2016\n\nAFPA-CDI-Groupe 1", "Informations", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void clientMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientMenuItemActionPerformed
        //On passe en revue les composants ouverts
        boolean bFound = false;
        for (Component c :  this.desktopPane.getComponents()) 
           //Si   on trouve la fenêtre des représentants, on lui donne le focus
           if (c instanceof com.hc.ihm.JFrmIntLstClient) {
                bFound=true;
                ((JFrmIntLstClient) c).pack();
                ((JFrmIntLstClient) c).toFront();
                // TODO : rafraichir la liste des représentants
              //  ((JFrmIntLstClient) c).requestFocusInWindow();
//TODO                c.setSelected(true);
           }
        //Si on a pas trouvé, on crée la fenêtre   
       if (!bFound) {
            JFrmIntLstClient jFrmIntClient = new JFrmIntLstClient(hashClient,hashRep);
            desktopPane.add( jFrmIntClient );
            Dimension dim = desktopPane.getSize();
            jFrmIntClient.setLocation(dim.width/2 - jFrmIntClient.getWidth()/2, dim.height/2 - jFrmIntClient.getHeight()/2);
            jFrmIntClient.setVisible( true ); 
       }
    }//GEN-LAST:event_clientMenuItemActionPerformed

    private void produitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produitMenuItemActionPerformed
        //On passe en revue les composants ouverts
        boolean bFound = false;
        for (Component c :  this.desktopPane.getComponents()) 
           //Si   on trouve la fenêtre des représentants, on lui donne le focus
           if (c instanceof com.hc.ihm.JFrmIntLstProduit) {
                bFound=true;
                ((JFrmIntLstProduit) c).pack();
                ((JFrmIntLstProduit) c).toFront();
                // TODO : rafraichir la liste des représentants
              //  ((JFrmIntLstClient) c).requestFocusInWindow();
//TODO                c.setSelected(true);
           }
        //Si on a pas trouvé, on crée la fenêtre   
        if (!bFound) {
            JFrmIntLstProduit jFrmIntProduit = new JFrmIntLstProduit(hashProduit);
            desktopPane.add( jFrmIntProduit );
            Dimension dim = desktopPane.getSize();
            jFrmIntProduit.setLocation(dim.width/2 - jFrmIntProduit.getWidth()/2, dim.height/2 - jFrmIntProduit.getHeight()/2);
            jFrmIntProduit.setVisible( true ); 
        }
    }//GEN-LAST:event_produitMenuItemActionPerformed

    private void commandeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commandeMenuItemActionPerformed
        //On passe en revue les composants ouverts
        boolean bFound = false;
        for (Component c :  this.desktopPane.getComponents()) 
           //Si   on trouve la fenêtre des représentants, on lui donne le focus
           if (c instanceof com.hc.ihm.JFrmIntLstCommande) {
                bFound=true;
                ((JFrmIntLstCommande) c).pack();
                ((JFrmIntLstCommande) c).toFront();
                // TODO : rafraichir la liste des représentants
              //  ((JFrmIntLstClient) c).requestFocusInWindow();
//TODO                c.setSelected(true);
           }
        //Si on a pas trouvé, on crée la fenêtre   
        if (!bFound) {
            JFrmIntLstCommande jFrmIntCommande = new JFrmIntLstCommande(hashCommande);
            desktopPane.add( jFrmIntCommande );
            Dimension dim = desktopPane.getSize();
            jFrmIntCommande.setLocation(dim.width/2 - jFrmIntCommande.getWidth()/2, dim.height/2 - jFrmIntCommande.getHeight()/2);
            jFrmIntCommande.setVisible( true ); 
        }
    }//GEN-LAST:event_commandeMenuItemActionPerformed

    private void quitteSauve() {
        List<String> lstRepString = FileUtils.codeFichierRep(hashRep);
        FileUtils.sauveFichier(lstRepString,Constantes.FICHIER_REP);
        
        List<String> lstClientString = FileUtils.codeFichierClient(hashClient);
        FileUtils.sauveFichier(lstClientString,Constantes.FICHIER_CLIENT);
        
        List<String> lstProspectString = FileUtils.codeFichierProspect(hashProspect);
        FileUtils.sauveFichier(lstProspectString,Constantes.FICHIER_PROSPECT);
              
        System.exit(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem clientMenuItem;
    private javax.swing.JMenu commandeMenu;
    private javax.swing.JMenuItem commandeMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu gestionMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem produitMenuItem;
    private javax.swing.JMenuItem prospectMenuItem;
    private javax.swing.JMenuItem representantMenuItem;
    // End of variables declaration//GEN-END:variables

    
}
