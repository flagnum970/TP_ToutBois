/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hc.ihm;

import com.hc.Entites.Adresse;
import com.hc.Entites.Client;
import com.hc.Entites.Representant;
import com.hc.utils.Constantes.type_acces;
import com.hc.utils.GuiUtils;
import java.awt.Component;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.InputVerifier;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author cflagollet
 */
public class JFrmIntLstClient extends javax.swing.JInternalFrame {

    private HashMap<Integer,Client> hashClient;
    private HashMap<Integer,Representant> hashRep;
    private type_acces typAcc;
  
    /**
     * Creates new form JFrmIntRep
     */
    public JFrmIntLstClient(HashMap<Integer,Client> hashClient,HashMap<Integer,Representant> hashRep) {
        initComponents();
        this.hashClient = hashClient;
        this.hashRep = hashRep;
        remplitTable();
       
        //on disable tous les composants du jPanel1 
        GuiUtils.setEnableRec(jPanel1,false);
        jLblErreur.setVisible(false);
        
        //SelectionListener
        jTblClient.getSelectionModel().addListSelectionListener(new SharedListSelectionHandler());
        jTblClient.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
   
                
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jTxtEnseigne = new javax.swing.JTextField();
        jTxtSiret = new javax.swing.JTextField();
        jLblSiret = new javax.swing.JLabel();
        jLblEnseigne = new javax.swing.JLabel();
        jTxtMail = new javax.swing.JTextField();
        jLblSalaire = new javax.swing.JLabel();
        jTxtNbComm = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTxtNo = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTxtAdrNo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTxtAdrCompl = new javax.swing.JTextField();
        jTxtAdrCP = new javax.swing.JTextField();
        jTxtAdrVille = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTxtAdrRue = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jCboAdrPays = new javax.swing.JComboBox<>();
        jTxtTel = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jCboRep = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jBtnOK = new javax.swing.JButton();
        jBtnAnnuler = new javax.swing.JButton();
        jLblErreur = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jBtnNouveau = new javax.swing.JButton();
        jBtnModifier = new javax.swing.JButton();
        jBtnSupprimer = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTblClient = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setTitle("Gestion des clients");
        setPreferredSize(new java.awt.Dimension(906, 500));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setEnabled(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTxtEnseigne.setInputVerifier(new verifyTxtFieldString());
        jTxtEnseigne.setNextFocusableComponent(jTxtSiret);
        jPanel1.add(jTxtEnseigne, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 230, -1));

        jTxtSiret.setToolTipText("");
        jTxtSiret.setInputVerifier(new verifyTxtFieldString());
        jTxtSiret.setNextFocusableComponent(jTxtMail);
        jPanel1.add(jTxtSiret, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 120, -1));

        jLblSiret.setText("Siret");
        jPanel1.add(jLblSiret, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 57, 20));

        jLblEnseigne.setText("Enseigne");
        jPanel1.add(jLblEnseigne, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, 20));

        jTxtMail.setInputVerifier(new verifyTxtFieldMail());
        jTxtMail.setNextFocusableComponent(jTxtTel);
        jPanel1.add(jTxtMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 170, -1));

        jLblSalaire.setText("Représentant");
        jPanel1.add(jLblSalaire, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, 20));

        jTxtNbComm.setToolTipText("");
        jTxtNbComm.setAutoscrolls(false);
        jTxtNbComm.setInputVerifier(new verifyTxtFieldNumber());
        jTxtNbComm.setNextFocusableComponent(jCboRep);
        jPanel1.add(jTxtNbComm, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 40, -1));

        jLabel1.setText("Mail");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, 20));

        jTxtNo.setEditable(false);
        jTxtNo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxtNo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTxtNo.setEnabled(false);
        jTxtNo.setFocusable(false);
        jTxtNo.setName("jTxtNo"); // NOI18N
        jTxtNo.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(jTxtNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 20));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Adresse"));
        jPanel5.setName("Jpane"); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Numéro");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 57, 20));

        jTxtAdrNo.setInputVerifier(new verifyTxtFieldInt());
        jTxtAdrNo.setNextFocusableComponent(jTxtAdrRue);
        jPanel5.add(jTxtAdrNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 40, -1));

        jLabel4.setText("Compléments");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 90, 20));

        jTxtAdrCompl.setNextFocusableComponent(jTxtAdrCP);
        jPanel5.add(jTxtAdrCompl, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 210, -1));

        jTxtAdrCP.setInputVerifier(new verifyTxtFieldInt());
        jTxtAdrCP.setNextFocusableComponent(jTxtAdrVille);
        jPanel5.add(jTxtAdrCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 60, -1));

        jTxtAdrVille.setInputVerifier(new verifyTxtFieldString());
        jTxtAdrVille.setNextFocusableComponent(jCboAdrPays);
        jPanel5.add(jTxtAdrVille, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 160, -1));

        jLabel5.setText("Code postal");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 20));

        jLabel6.setText("Ville");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 50, 20));

        jLabel7.setText("Pays");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 50, 20));

        jTxtAdrRue.setInputVerifier(new verifyTxtFieldString());
        jTxtAdrRue.setNextFocusableComponent(jTxtAdrCompl);
        jPanel5.add(jTxtAdrRue, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 210, -1));

        jLabel8.setText("Rue");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 57, 20));

        jCboAdrPays.setEditable(true);
        jCboAdrPays.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Allemagne", "Angleterre", "Belgique", "Cameroun", "Espagne", "France", "Italie" }));
        jCboAdrPays.setSelectedIndex(5);
        jCboAdrPays.setInputVerifier(new verifyTxtFieldCbo());
        jCboAdrPays.setNextFocusableComponent(jBtnOK);
        jPanel5.add(jCboAdrPays, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 120, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 330, 220));

        jTxtTel.setToolTipText("");
        jTxtTel.setAutoscrolls(false);
        jTxtTel.setInputVerifier(new verifyTxtFieldNumber());
        jTxtTel.setNextFocusableComponent(jTxtNbComm);
        jPanel1.add(jTxtTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 110, -1));

        jLabel25.setText("Téléphone");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, 20));

        jCboRep.setNextFocusableComponent(jTxtAdrNo);
        jPanel1.add(jCboRep, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 120, -1));

        jLabel15.setText("Nb comm.");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, 20));

        jBtnOK.setText("OK");
        jBtnOK.setNextFocusableComponent(jBtnAnnuler);
        jBtnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnOKAnnulerActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, -1, -1));

        jBtnAnnuler.setText("Annuler");
        jBtnAnnuler.setToolTipText("");
        jBtnAnnuler.setNextFocusableComponent(jTxtEnseigne);
        jBtnAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnOKAnnulerActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnAnnuler, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, -1, -1));

        jLblErreur.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLblErreur.setForeground(new java.awt.Color(255, 51, 0));
        jLblErreur.setText("Veuillez vérifier votre saisie !");
        jLblErreur.setEnabled(false);
        jLblErreur.setFocusable(false);
        jPanel1.add(jLblErreur, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 180, 20));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jBtnNouveau.setText("Nouveau");
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

        jTblClient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "N°", "Enseigne", "Adresse", "Mail", "Téléphone", "Siret", "Representant", "Nombre de commandes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTblClient.setFocusable(false);
        jScrollPane2.setViewportView(jTblClient);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnOKAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnOKAnnulerActionPerformed
  
        if (evt.getSource().equals(jBtnOK)) {
            if (verifyFields(jPanel1)) {
                sauveFiche();
            } else return;
        }

        jTblClient.clearSelection();
        remplitFiche(-1);
        remplitTable();
        GuiUtils.setEnableRec(jPanel1,false);   
        GuiUtils.setEnableRec(jPanel4, true);
        GuiUtils.setEnableRec(jTblClient,true);
        jBtnModifier.setEnabled(false);
        jBtnSupprimer.setEnabled(false);
        jLblErreur.setVisible(false);
        typAcc = type_acces.visualisation;
    }//GEN-LAST:event_jBtnOKAnnulerActionPerformed
    
    private void jBtnSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSupprimerActionPerformed
        supprimeFiche();
    }//GEN-LAST:event_jBtnSupprimerActionPerformed

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
        GuiUtils.setEnableRec(jTblClient,false);
        GuiUtils.setEnableRec(jPanel1,true);  //fiche enabled
        jTxtEnseigne.requestFocusInWindow();       //Focus sur le nom
    }//GEN-LAST:event_jBtnNouveauModifierActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAnnuler;
    private javax.swing.JButton jBtnModifier;
    private javax.swing.JButton jBtnNouveau;
    private javax.swing.JButton jBtnOK;
    private javax.swing.JButton jBtnSupprimer;
    private javax.swing.JComboBox<String> jCboAdrPays;
    private javax.swing.JComboBox<String> jCboRep;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLblEnseigne;
    private javax.swing.JLabel jLblErreur;
    private javax.swing.JLabel jLblSalaire;
    private javax.swing.JLabel jLblSiret;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTblClient;
    private javax.swing.JTextField jTxtAdrCP;
    private javax.swing.JTextField jTxtAdrCompl;
    private javax.swing.JTextField jTxtAdrNo;
    private javax.swing.JTextField jTxtAdrRue;
    private javax.swing.JTextField jTxtAdrVille;
    private javax.swing.JTextField jTxtEnseigne;
    private javax.swing.JTextField jTxtMail;
    private javax.swing.JTextField jTxtNbComm;
    private javax.swing.JTextField jTxtNo;
    private javax.swing.JTextField jTxtSiret;
    private javax.swing.JTextField jTxtTel;
    // End of variables declaration//GEN-END:variables

    private void remplitTable()
    {
        String[] cols = {"No","Enseigne","Adresse","Mail","Téléphone","Siret","Représentant","Nb commandes"}; 
        DefaultTableModel listData = new DefaultTableModel(cols,0); 
        
        if (hashClient!=null)
            for (Client c : hashClient.values()) {

                String[] ts = { Integer.toString(c.getNo()),
                                c.getEnseigne(),
                                c.getAdrToString(),
                                c.getMail(),
                                c.getTelephone(),
                                c.getSiret(),
                                c.getNoRepresentant() + " "+hashRep.get(c.getNoRepresentant()).getNom()+" "+hashRep.get(c.getNoRepresentant()).getPrenom(),
                                Integer.toString(c.getNbCommandes())};
            
                listData.addRow(ts);
            }
        jTblClient.setModel(listData);
        initTailleCols();
    }
    
    private void initTailleCols() 
    {
        int[] tailleCol = {27,113,197,81,82,49,127,45};
        for (int i=0;i<tailleCol.length;i++)
            jTblClient.getColumnModel().getColumn(i).setPreferredWidth(tailleCol[i]);       
    }

    
    private void remplitFiche(int noRep) 
    {
       int i=0,iRep=0;
       if (noRep != -1) {
            Client c = hashClient.get(noRep);

            jTxtNo.setText(String.valueOf(c.getNo())); 
            jTxtEnseigne.setText(c.getEnseigne());
            jTxtAdrNo.setText(String.valueOf(c.getAdresse().getNo()));
            jTxtAdrRue.setText(c.getAdresse().getRue());
            jTxtAdrCompl.setText(c.getAdresse().getCompl());
            jTxtAdrVille.setText(c.getAdresse().getVille());
            jTxtAdrCP.setText(String.valueOf(c.getAdresse().getCp()));
            jCboAdrPays.setSelectedItem(c.getAdresse().getPays());
            jTxtMail.setText(c.getMail());
            jTxtTel.setText(c.getTelephone());
            jTxtSiret.setText(c.getSiret());
            jTxtNbComm.setText(String.valueOf(c.getNbCommandes()));

             //Remplit la combobox des représentants

             jCboRep.removeAllItems();
             Collection<Representant> setRep = hashRep.values();
             for (Representant r : setRep) {
                 jCboRep.addItem(r.getNo() + " "+ r.getNom() + " "+ r.getPrenom());
                 if (r.getNo() == c.getNoRepresentant())
                     iRep = i;
                  i++;
             }
             jCboRep.setSelectedIndex(iRep);
        } else {
                jTxtEnseigne.setText("");
            jTxtSiret.setText("");
            jTxtMail.setText("");
            jTxtNbComm.setText("");
            jTxtTel.setText("");
            jTxtAdrNo.setText("");
            jTxtAdrCompl.setText("");
            jTxtAdrCompl.setText("");
            jTxtAdrVille.setText("");
            jTxtAdrCP.setText("");
          jCboAdrPays.setSelectedItem("");
            jTxtNo.setText("");
            jCboRep.removeAllItems();

            //cbo des representants
            Collection<Representant> setRep = hashRep.values();
            for (Representant r : setRep) 
                jCboRep.addItem(r.getNo() + " "+ r.getNom() + " "+ r.getPrenom());

        }

        jLblErreur.setVisible(false);
    }
    
    
    private void sauveFiche()
    { 
        //Recuperation du représentant à partir de la cbo
        int noRep=Integer.parseInt(jCboRep.getSelectedItem().toString().split(" ")[0]);
        
        if (typAcc == type_acces.modification) {
            Client c = new Client(              Integer.parseInt(jTxtNo.getText()),
                                                jTxtEnseigne.getText(),
                                                new Adresse(Integer.parseInt(jTxtAdrNo.getText()), 
                                                            jTxtAdrRue.getText(),
                                                            jTxtAdrCompl.getText(),
                                                            Integer.parseInt(jTxtAdrCP.getText()),
                                                            jTxtAdrVille.getText(),
                                                            (String) jCboAdrPays.getSelectedItem()),
                                                jTxtMail.getText(),
                                                jTxtTel.getText(),
                                                jTxtSiret.getText(),
                                                noRep,
                                                Integer.parseInt(jTxtNbComm.getText())
                                                );
            hashClient.put(Integer.parseInt(jTxtNo.getText()),c);
        } else {
            Client c = new Client (             jTxtEnseigne.getText(),
                                                new Adresse(Integer.parseInt(jTxtAdrNo.getText()), 
                                                            jTxtAdrRue.getText(),
                                                            jTxtAdrCompl.getText(),
                                                            Integer.parseInt(jTxtAdrCP.getText()),
                                                            jTxtAdrVille.getText(),
                                                            (String) jCboAdrPays.getSelectedItem()),
                                                 jTxtMail.getText(),
                                                jTxtTel.getText(),
                                                jTxtSiret.getText(),
                                                noRep,
                                                Integer.parseInt(jTxtNbComm.getText())
                                                );
            hashClient.put(Client.getDernierNo(),c); 
        }
        
        jTblClient.clearSelection();
        remplitFiche(-1);
        remplitTable();
        GuiUtils.setEnableRec(jPanel1,false);        
    }
    
    private void supprimeFiche() {

        //Verification de l'intégrité des données (on ne peut pas supprimer un représentant s'il est utilisé ailleurs (client ou prospect)
        if (verifIntegriteRep()) {
            //Affichage boite de dialogue pour confirmation
            if (JOptionPane.showConfirmDialog(null,"Etes-vous sûr de vouloir supprimer ce client ?","Attention",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                Client r = hashClient.get(Integer.parseInt(jTxtNo.getText()));
                hashClient.remove(Integer.parseInt(jTxtNo.getText()),r);
                //On vide tout
                jTblClient.clearSelection();
                remplitFiche(-1);
                //Affichage nouvelle liste
                remplitTable(); 
            }
        } else { // Sinon, on affiche un message d'alerte
                    //TODO JOoptionPanel ...
        }
                
    }
    
    //Verification de l'intégrité des données 
    private boolean verifIntegriteRep()
    {
        return true;
    }
    
    private boolean  verifyFields(Component container) 
    {    
       //ne fonctionne pas donc fait à la main pour l'instant
   /*         Component[] components= ((Container) container).getComponents();
            for (Component c : components) {
                                System.out.println("je controle " + c.getName());
              try {                  
                if (c instanceof JTextField) {
                    if (!getInputVerifier().verify((JComponent) c)) {
                    System.out.println("ça chie dans la colle pour : " + c.getName());
                    return false ;}
                }
              } catch (ClassCastException e) {
                //TODO : gestion exception
              }
            }
     */
    
        if (!new verifyTxtFieldString().verify(jTxtEnseigne)) return false ;
        if (!new verifyTxtFieldString().verify(jTxtSiret)) return false ;
        if (!new verifyTxtFieldInt().verify(jTxtNbComm)) return false ;
        if (!new verifyTxtFieldMail().verify(jTxtMail)) return false ;
        if (!new verifyTxtFieldInt().verify(jTxtAdrNo)) return false ;
        if (!new verifyTxtFieldString().verify(jTxtAdrRue)) return false ;
        if (!new verifyTxtFieldInt().verify(jTxtAdrCP)) return false ;
        if (!new verifyTxtFieldString().verify(jTxtAdrVille)) return false ;
        if (!new verifyTxtFieldCbo().verify(jCboAdrPays)) return false ;
        
        return true;        
        
    }
    
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
                //jTblRep.getsgetSelectedRow()
                int noRep = Integer.parseInt(jTblClient.getModel().getValueAt(jTblClient.getSelectedRow(),0).toString());
                remplitFiche(noRep);
                jBtnModifier.setEnabled(true);
                jBtnSupprimer.setEnabled(true);                
            }
        }
                
    }
    
    class verifyTxtFieldString extends InputVerifier {
         @Override
         public boolean verify(JComponent input) {
             JTextField tf = (JTextField) input;
             boolean bOk = !tf.getText().isEmpty();
             if (!bOk) tf.requestFocusInWindow();
             jLblErreur.setVisible(!bOk);
             return (bOk);
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
             if (!bOk) tf.requestFocusInWindow();
             jLblErreur.setVisible(!bOk);
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
            if (!bOk) tf.requestFocusInWindow();
            jLblErreur.setVisible(!bOk);
            return bOk;
        }
   }
    
    class verifyTxtFieldMail extends InputVerifier {
         @Override
         public boolean verify(JComponent input) {
             
             String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
             JTextField tf = (JTextField) input;
             
            Pattern pattern = Pattern.compile(regex);
             Matcher matcher = pattern.matcher(tf.getText());
             boolean bOk=matcher.matches();
             jLblErreur.setVisible(!bOk);
             if (!bOk) tf.requestFocusInWindow();
             return bOk;
         }
    }
    
    //TODO : verifier que le champ taux <100
    //TODO : vérifier que le champ CP 5 chiffres
    
}
