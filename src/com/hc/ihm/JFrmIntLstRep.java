/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hc.ihm;

import com.hc.Entites.Adresse;
import com.hc.Entites.Client;
import com.hc.Entites.Prospect;
import com.hc.Entites.Representant;
import com.hc.utils.Constantes.type_acces;
import com.hc.utils.GuiUtils;
import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import javax.swing.InputVerifier;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cflagollet
 */
public class JFrmIntLstRep extends javax.swing.JInternalFrame {

    private HashMap<Integer,Representant> hashRep;
    private HashMap<Integer,Prospect> hashProspect;
    private HashMap<Integer,Client> hashClient;
    private type_acces typAcc;
    
    /**
     * Creates new form JFrmIntRep
     */
    public JFrmIntLstRep(HashMap<Integer,Representant> hashRep, HashMap<Integer,Prospect> hashProspect,HashMap<Integer,Client> hashClient ) {
        initComponents();
        this.hashRep = hashRep;
        this.hashClient = hashClient;
        this.hashProspect = hashProspect;
        
        remplitTable();
       
        typAcc = type_acces.visualisation;
        
        //on disable tous les composants du jPanel1
        GuiUtils.setEnableRec(jPanel1,false);

        jLblErreur.setVisible(false);

        jTblRep.getSelectionModel().addListSelectionListener(new SharedListSelectionHandler()); 
        jTblRep.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jBtnNouveau = new javax.swing.JButton();
        jBtnModifier = new javax.swing.JButton();
        jBtnSupprimer = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTblRep = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jTxtNom = new javax.swing.JTextField();
        jTxtPrenom = new javax.swing.JTextField();
        jLblPrenom = new javax.swing.JLabel();
        jLblNom = new javax.swing.JLabel();
        jLblTxComm = new javax.swing.JLabel();
        jTxtTxComm = new javax.swing.JTextField();
        jBtnAnnuler = new javax.swing.JButton();
        jLblSalaire = new javax.swing.JLabel();
        jTxtSalaire = new javax.swing.JTextField();
        jBtnOK = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTxtNo = new javax.swing.JTextField();
        jLblErreur = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTxtAdrNo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTxtAdrRue = new javax.swing.JTextField();
        jTxtAdrCP = new javax.swing.JTextField();
        jTxtAdrVille = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTxtAdrCompl = new javax.swing.JTextField();
        jCboAdrPays = new javax.swing.JComboBox<>();

        jInternalFrame1.setClosable(true);
        jInternalFrame1.setMaximizable(true);
        jInternalFrame1.setTitle("Liste des représentants");
        jInternalFrame1.setPreferredSize(new java.awt.Dimension(906, 500));
        jInternalFrame1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 702, Short.MAX_VALUE)
        );

        jInternalFrame1.getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, -1, 702));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jInternalFrame1.getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, -1, -1));

        setClosable(true);
        setMaximizable(true);
        setTitle("Gestion des représentants");
        setPreferredSize(new java.awt.Dimension(906, 560));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBtnNouveau.setText("Nouveau");
        jBtnNouveau.setFocusPainted(false);
        jBtnNouveau.setFocusable(false);
        jBtnNouveau.setName("jBtnNouveau"); // NOI18N
        jBtnNouveau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNouveauModifierActionPerformed(evt);
            }
        });

        jBtnModifier.setText("Modifier");
        jBtnModifier.setEnabled(false);
        jBtnModifier.setFocusable(false);
        jBtnModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNouveauModifierActionPerformed(evt);
            }
        });

        jBtnSupprimer.setText("Supprimer");
        jBtnSupprimer.setEnabled(false);
        jBtnSupprimer.setFocusable(false);
        jBtnSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSupprimerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnNouveau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnModifier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnSupprimer, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jBtnNouveau, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(757, 0, -1, 120));

        jTblRep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTblRep.setFocusable(false);
        jScrollPane2.setViewportView(jTblRep);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 727, 173));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setEnabled(false);
        jPanel1.setName(""); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTxtNom.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTxtNom.setInputVerifier(new verifyTxtFieldString());
        jTxtNom.setNextFocusableComponent(jTxtPrenom);
        jPanel1.add(jTxtNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 170, -1));

        jTxtPrenom.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTxtPrenom.setInputVerifier(new verifyTxtFieldString());
        jTxtPrenom.setNextFocusableComponent(jTxtTxComm);
        jPanel1.add(jTxtPrenom, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 170, -1));

        jLblPrenom.setText("Prénom");
        jLblPrenom.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLblPrenom.setMinimumSize(null);
        jLblPrenom.setName("jLbl"); // NOI18N
        jPanel1.add(jLblPrenom, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 57, 20));

        jLblNom.setLabelFor(jTxtNom);
        jLblNom.setText("Nom");
        jLblNom.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLblNom.setName("jLbl"); // NOI18N
        jPanel1.add(jLblNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 30, 20));

        jLblTxComm.setText("Taux de commission");
        jPanel1.add(jLblTxComm, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 183, -1, 0));

        jTxtTxComm.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTxtTxComm.setInputVerifier(new verifyTxtFieldNumber());
        jTxtTxComm.setNextFocusableComponent(jTxtSalaire);
        jPanel1.add(jTxtTxComm, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 40, -1));

        jBtnAnnuler.setText("Annuler");
        jBtnAnnuler.setToolTipText("");
        jBtnAnnuler.setNextFocusableComponent(jTxtNom);
        jBtnAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAnnulerActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnAnnuler, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, -1, -1));

        jLblSalaire.setText("Salaire");
        jLblSalaire.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLblSalaire.setMinimumSize(null);
        jLblSalaire.setName("jLbl"); // NOI18N
        jPanel1.add(jLblSalaire, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, 20));

        jTxtSalaire.setToolTipText("");
        jTxtSalaire.setAutoscrolls(false);
        jTxtSalaire.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTxtSalaire.setInputVerifier(new verifyTxtFieldNumber());
        jTxtSalaire.setNextFocusableComponent(jTxtAdrNo);
        jPanel1.add(jTxtSalaire, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 70, -1));

        jBtnOK.setText("OK");
        jBtnOK.setNextFocusableComponent(jBtnAnnuler);
        jBtnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnOKActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, -1, -1));

        jLabel1.setText("Taux");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel1.setMinimumSize(null);
        jLabel1.setName("jLbl"); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, 20));

        jTxtNo.setEditable(false);
        jTxtNo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxtNo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTxtNo.setEnabled(false);
        jTxtNo.setFocusable(false);
        jTxtNo.setName("jTxtNo"); // NOI18N
        jTxtNo.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(jTxtNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, -1));

        jLblErreur.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLblErreur.setForeground(new java.awt.Color(255, 51, 0));
        jLblErreur.setText("Veuillez vérifier votre saisie !");
        jLblErreur.setEnabled(false);
        jLblErreur.setFocusable(false);
        jLblErreur.setName(""); // NOI18N
        jLblErreur.setOpaque(true);
        jLblErreur.setRequestFocusEnabled(false);
        jLblErreur.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(jLblErreur, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 284, 170, 20));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Adresse"));
        jPanel5.setName("Jpane"); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Numéro");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel2.setMinimumSize(null);
        jLabel2.setName("jLbl"); // NOI18N
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 57, 20));

        jTxtAdrNo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTxtAdrNo.setInputVerifier(new verifyTxtFieldInt());
        jTxtAdrNo.setNextFocusableComponent(jTxtAdrRue);
        jPanel5.add(jTxtAdrNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 40, -1));

        jLabel4.setText("Rue");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel4.setMinimumSize(null);
        jLabel4.setName("jLbl"); // NOI18N
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 57, 20));

        jTxtAdrRue.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTxtAdrRue.setInputVerifier(new verifyTxtFieldString());
        jTxtAdrRue.setNextFocusableComponent(jTxtAdrCompl);
        jTxtAdrRue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtAdrRueActionPerformed(evt);
            }
        });
        jPanel5.add(jTxtAdrRue, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 210, -1));

        jTxtAdrCP.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTxtAdrCP.setInputVerifier(new verifyTxtFieldInt());
        jTxtAdrCP.setNextFocusableComponent(jTxtAdrVille);
        jPanel5.add(jTxtAdrCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 60, -1));

        jTxtAdrVille.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTxtAdrVille.setInputVerifier(new verifyTxtFieldString());
        jTxtAdrVille.setNextFocusableComponent(jCboAdrPays);
        jPanel5.add(jTxtAdrVille, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 160, -1));

        jLabel5.setText("Code postal");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel5.setMinimumSize(null);
        jLabel5.setName("jLbl"); // NOI18N
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, 20));

        jLabel6.setText("Ville");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel6.setMinimumSize(null);
        jLabel6.setName("jLbl"); // NOI18N
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 50, 20));

        jLabel7.setText("Pays");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel7.setMinimumSize(null);
        jLabel7.setName("jLbl"); // NOI18N
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 50, 20));

        jLabel8.setText("Compléments");
        jLabel8.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel8.setMinimumSize(null);
        jLabel8.setName("jLbl"); // NOI18N
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 90, 20));

        jTxtAdrCompl.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTxtAdrCompl.setNextFocusableComponent(jTxtAdrCP);
        jTxtAdrCompl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtAdrComplActionPerformed(evt);
            }
        });
        jPanel5.add(jTxtAdrCompl, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 210, -1));

        jCboAdrPays.setEditable(true);
        jCboAdrPays.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Allemagne", "Angleterre", "Belgique", "Cameroun", "Espagne", "France", "Italie" }));
        jCboAdrPays.setSelectedIndex(5);
        jCboAdrPays.setNextFocusableComponent(jBtnOK);
        jPanel5.add(jCboAdrPays, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 330, 230));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 730, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //Listener pour les boutons Création et Modification
    private void jBtnNouveauModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNouveauModifierActionPerformed
        //Clic sur Modifier
        if (evt.getSource().equals((Object) jBtnModifier))  {
            typAcc = type_acces.modification;
        } else {
            remplitFiche(-1); //vide la fiche 
            typAcc = type_acces.creation;
        }
        
        //Liste et boutons du haut grisés
        GuiUtils.setEnableRec(jPanel4, false);
        GuiUtils.setEnableRec(jTblRep,false);
        
        GuiUtils.setEnableRec(jPanel1,true);  //fiche enabled
        jTxtNom.requestFocusInWindow();       //Focus sur le nom
    }//GEN-LAST:event_jBtnNouveauModifierActionPerformed

    private void jBtnAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAnnulerActionPerformed
        jTblRep.clearSelection();
        remplitFiche(-1);
        GuiUtils.setEnableRec(jPanel1,false);
        GuiUtils.setEnableRec(jPanel4, true);
        GuiUtils.setEnableRec(jTblRep,true);
        jBtnModifier.setEnabled(false);
        jBtnSupprimer.setEnabled(false);
        jLblErreur.setVisible(false);
        typAcc = type_acces.visualisation;
    }//GEN-LAST:event_jBtnAnnulerActionPerformed

    private void jBtnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnOKActionPerformed

        if (evt.getSource().equals(jBtnOK))
            if (verifyFields(jPanel1)) {
                sauveFiche();
        } else return;
        
        remplitFiche(-1);
        remplitTable();
        GuiUtils.setEnableRec(jPanel1,false);
        typAcc = type_acces.visualisation;
        GuiUtils.setEnableRec(jPanel4, true);
        GuiUtils.setEnableRec(jTblRep,true);
        jBtnModifier.setEnabled(false);
        jBtnSupprimer.setEnabled(false);
        jLblErreur.setVisible(false);
        
    }//GEN-LAST:event_jBtnOKActionPerformed

    private void jBtnOKAnnuActionPerformed(java.awt.event.ActionEvent evt) {                                       

        if (verifyFields(jPanel1)) {
            
            sauveFiche();
            remplitFiche(-1);
            
            remplitTable();
            GuiUtils.setEnableRec(jPanel1,false);
            typAcc = type_acces.visualisation;
            GuiUtils.setEnableRec(jPanel4, true);
            GuiUtils.setEnableRec(jTblRep,true);
            jBtnModifier.setEnabled(false);
            jBtnSupprimer.setEnabled(false);
        }
        
    }       
    
    private void jBtnSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSupprimerActionPerformed
        
        //
        //if (typAcc != type_acces.visualisation)
        //if (JOptionPane.showConfirmDialog(null,"Etes-vous sûr de vouloir abandonner vos modifications ?","Attention",JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) 
        //        return;
        //if (!verifRepNonUtilise())
        //    JOptionPane.showMessageDialog(null,"Suppression impossible. Ce représentant est utilisé","Attention",JOptionPane.ABORT);
        
        supprimeFiche();

    }//GEN-LAST:event_jBtnSupprimerActionPerformed

    private void jTxtAdrComplActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtAdrComplActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtAdrComplActionPerformed

    private void jTxtAdrRueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtAdrRueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtAdrRueActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAnnuler;
    private javax.swing.JButton jBtnModifier;
    private javax.swing.JButton jBtnNouveau;
    private javax.swing.JButton jBtnOK;
    private javax.swing.JButton jBtnSupprimer;
    private javax.swing.JComboBox<String> jCboAdrPays;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLblErreur;
    private javax.swing.JLabel jLblNom;
    private javax.swing.JLabel jLblPrenom;
    private javax.swing.JLabel jLblSalaire;
    private javax.swing.JLabel jLblTxComm;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTblRep;
    private javax.swing.JTextField jTxtAdrCP;
    private javax.swing.JTextField jTxtAdrCompl;
    private javax.swing.JTextField jTxtAdrNo;
    private javax.swing.JTextField jTxtAdrRue;
    private javax.swing.JTextField jTxtAdrVille;
    private javax.swing.JTextField jTxtNo;
    private javax.swing.JTextField jTxtNom;
    private javax.swing.JTextField jTxtPrenom;
    private javax.swing.JTextField jTxtSalaire;
    private javax.swing.JTextField jTxtTxComm;
    // End of variables declaration//GEN-END:variables

    private void remplitTable()
    {
        String [] cols = {"No","Nom","Prenom","Adresse","Salaire","Taux"}; 
        DefaultTableModel listData = new DefaultTableModel(cols,0); 
        
        for (Representant r : hashRep.values()) {
            String[] ts = {Integer.toString(r.getNo()),
                r.getNom(),
                r.getPrenom(),
                r.getAdrToString(),
                Double.toString(r.getSalaire()),
                Double.toString(r.getTxComm())};
            
         listData.addRow(ts);
        }

        jTblRep.setModel(listData);
        initTailleCols();
    }

    //Taille des colonnes
    private void initTailleCols() 
    {
        int[] tailleCol = {37,118,92,307,84,83};
        for (int i=0;i<tailleCol.length;i++)
            jTblRep.getColumnModel().getColumn(i).setPreferredWidth(tailleCol[i]);       
    }
    
    
    private void remplitFiche(int noRep) 
    {
        if (noRep != -1) {
        Representant r = hashRep.get(noRep);

        jTxtNom.setText(r.getNom());
        jTxtPrenom.setText(r.getPrenom());
        jTxtTxComm.setText(String.valueOf(r.getTxComm()));
        jTxtSalaire.setText(String.valueOf(r.getSalaire()));
        jTxtAdrNo.setText(String.valueOf(r.getAdresse().getNo()));
        jTxtAdrRue.setText(r.getAdresse().getRue());
        jTxtAdrCompl.setText(r.getAdresse().getCompl());
        jTxtAdrVille.setText(r.getAdresse().getVille());
        jTxtAdrCP.setText(String.valueOf(r.getAdresse().getCp()));
        jCboAdrPays.setSelectedItem(r.getAdresse().getPays());
        jTxtNo.setText(String.valueOf(r.getNo()));
        } else {
            jTxtNom.setText("");
            jTxtPrenom.setText("");
            jTxtTxComm.setText("");
            jTxtSalaire.setText("");
            jTxtAdrNo.setText("");
            jTxtAdrRue.setText("");
            jTxtAdrCompl.setText("");
            jTxtAdrVille.setText("");
            jTxtAdrCP.setText("");
            jCboAdrPays.setSelectedIndex(5);
            jTxtNo.setText("");
        }
            
        jLblErreur.setVisible(false);
    }
    
    private void sauveFiche()
    { 
        if (typAcc == type_acces.modification) {
            Representant r = new Representant(  Integer.parseInt(jTxtNo.getText()),
                                                Double.parseDouble(jTxtTxComm.getText()),
                                                Double.parseDouble(jTxtSalaire.getText()),
                                                jTxtNom.getText(),
                                                jTxtPrenom.getText(),
                                                new Adresse(Integer.parseInt(jTxtAdrNo.getText()), 
                                                            jTxtAdrRue.getText(),
                                                            jTxtAdrCompl.getText(),
                                                            Integer.parseInt(jTxtAdrCP.getText()),
                                                            jTxtAdrVille.getText(),
                                                            (String) jCboAdrPays.getSelectedItem()));

                    // Representant(int no, double txComm, double salaire, String nom, String prenom, Adresse adresse)
            hashRep.put(Integer.parseInt(jTxtNo.getText()),r);
        } else {
            Representant r = new Representant(  Double.parseDouble(jTxtTxComm.getText()),
                                                Double.parseDouble(jTxtSalaire.getText()),
                                                jTxtNom.getText(),
                                                jTxtPrenom.getText(),
                                                new Adresse(Integer.parseInt(jTxtAdrNo.getText()), 
                                                            jTxtAdrRue.getText(),
                                                            jTxtAdrCompl.getText(),
                                                            Integer.parseInt(jTxtAdrCP.getText()),
                                                            jTxtAdrVille.getText(),
                                                            (String) jCboAdrPays.getSelectedItem()));
            hashRep.put(Representant.getDernierNo(),r);
        }
        

    }
        
    private void supprimeFiche() {

        //Verification de l'intégrité des données (on ne peut pas supprimer un représentant s'il est utilisé ailleurs (client ou prospect)
        if (verifIntegriteRep(Integer.parseInt(jTxtNo.getText()))) {
            //Affichage boite de dialogue pour confirmation
            if (JOptionPane.showConfirmDialog(null,"Etes-vous sûr de vouloir supprimer ce représentant ?","Attention",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                Representant r = hashRep.get(Integer.parseInt(jTxtNo.getText()));
                hashRep.remove(Integer.parseInt(jTxtNo.getText()),r);
        
                jTblRep.clearSelection();         //On vide la Sélection
                remplitFiche(-1);                 //On vide la fiche
                remplitTable(); //Affichage nouvelle liste
                typAcc = type_acces.visualisation;
        
            }
        } else { // Sinon, on affiche un message d'alerte
            JOptionPane.showMessageDialog(null,"Impossible de supprimer ce représentant : utilisé","ERREUR",JOptionPane.WARNING_MESSAGE);
        }
                
    }
    // On vérifie que le représentant passé en param, n'existe pas dans les prospects et clients    
    //Verification de l'intégrité des données 
    private boolean verifIntegriteRep(int noRep)
    {   
        //parcourt des prospects
        for (Prospect p : hashProspect.values())
            if (p.getNoRepresentant() == noRep)
                return false;
        
        //parcourt des clients
        if (!hashClient.values().stream().noneMatch((c) -> (c.getNoRepresentant() == noRep))) {
            return false;
        }
         
        return true;
    }
    
    private boolean  verifyFields(Component container) 
    {    
       //ne fonctionne pas donc fait à la main pour l'instant

        
           Component[] components= ((Container) container).getComponents();
            for (Component c : components) {
                                //System.out.println("je controle " + c.getName());
                try {   
                    JComponent jc = (JComponent)c;
                    
                    if (jc.getInputVerifier()!=null) {
                        if (!jc.getInputVerifier().verify(jc)) {
                            System.out.println("ça chie dans la colle pour : " );
                            return false ;
                        }
                    }
              } catch (ClassCastException e) {
                //TODO : gestion exception
              }
            }
   
        //TODO : à refaire avec une boucle sur les composants
        if (!new verifyTxtFieldString().verify(jTxtNom)) return false ;
        if (!new verifyTxtFieldString().verify(jTxtPrenom)) return false ;
        if (!new verifyTxtFieldNumber().verify(jTxtTxComm)) return false ;        
        if (!new verifyTxtFieldNumber().verify(jTxtSalaire)) return false ;
        if (!new verifyTxtFieldInt().verify(jTxtAdrNo)) return false ;
        if (!new verifyTxtFieldString().verify(jTxtAdrRue)) return false ;
        if (!new verifyTxtFieldInt().verify(jTxtAdrCP)) return false ;
        if (!new verifyTxtFieldString().verify(jTxtAdrVille)) return false ;
        if (!new verifyTxtFieldCbo().verify(jCboAdrPays)) return false ;

        return true;               
    }
    
    //Pour un select (déselect) sur la jTable
    class SharedListSelectionHandler implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) { 
            ListSelectionModel lsm = (ListSelectionModel)e.getSource();
            
            GuiUtils.setEnableRec(jPanel1,false);
            
            if (lsm.isSelectionEmpty()) {
                jBtnModifier.setEnabled(false);
                jBtnSupprimer.setEnabled(false);
            }
            else {                
                int noRep = Integer.parseInt(jTblRep.getModel().getValueAt(jTblRep.getSelectedRow(),0).toString());
                remplitFiche(noRep);
                jBtnModifier.setEnabled(true);
                jBtnSupprimer.setEnabled(true);                
            }
        }
                
    }
    
    class verifyTxtFieldCbo extends InputVerifier {
        @Override
        public boolean verify(JComponent input) {
            JComboBox<String> tf = (JComboBox<String>) input;
            boolean bOk = !tf.getSelectedItem().toString().isEmpty();
            if (!bOk) tf.requestFocusInWindow();
            jLblErreur.setVisible(!bOk);
            return (bOk);
         }
    }
    
    class verifyTxtFieldString extends InputVerifier {
         @Override
        public boolean verify(JComponent input) {
           JTextField tf = (JTextField) input;
           boolean bOk = !tf.getText().isEmpty();
           jLblErreur.setVisible(!bOk);
           if (!bOk) tf.requestFocusInWindow();
           return (bOk);
        }
    }
    
    class verifyTxtFieldInt extends InputVerifier {
        @Override
        public boolean verify(JComponent input) {
            boolean bOk = true;
            JTextField tf = (JTextField) input;
            try {
                int i = Integer.parseInt(tf.getText());                 
                if (i<0) bOk=false;
            }
            catch (Exception e) {
                bOk = false;
            }
            jLblErreur.setVisible(!bOk);
            if (!bOk) tf.requestFocusInWindow();
            return bOk;
        }
    }

    class verifyTxtFieldNumber extends InputVerifier {
        @Override
        public boolean verify(JComponent input) {
            boolean bOk = true;
            JTextField tf = (JTextField) input;
            try {
                double d = Double.parseDouble(tf.getText());                 
                if (d<0) bOk=false;
            }
            catch (Exception e) {
                bOk = false;
            }
            jLblErreur.setVisible(!bOk);
            if (!bOk) tf.requestFocusInWindow();
            return bOk;
        }
    }
    
    

    //TODO : verifier que le champ taux <100
    //TODO : vérifier que le champ CP 5 chiffres
    
}
