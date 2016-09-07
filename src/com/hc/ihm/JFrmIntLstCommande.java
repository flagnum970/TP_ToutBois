/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hc.ihm;

import com.hc.Entites.Adresse;
import com.hc.Entites.Prospect;
import com.hc.Entites.Representant;
import com.hc.utils.Constantes;
import com.hc.utils.Constantes.type_acces;
import com.hc.utils.DateLabelFormatter;
import com.hc.utils.GuiUtils;
import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;


/**
 *
 * @author cflagollet
 */
public class JFrmIntLstCommande extends javax.swing.JInternalFrame   {

    private HashMap<Integer,Prospect> hashProspect;
    private HashMap<Integer,Representant> hashRep;
    private type_acces typAcc;
    private UtilDateModel model ;
    private JDatePanelImpl datePanel ;
    private JDatePickerImpl jDtPicker ;
   
    /**
     * Creates new form JFrmIntRep
     * @param hashProspect
     * @param hashRep
     */
    public JFrmIntLstCommande(HashMap<Integer,Prospect> hashProspect,HashMap<Integer,Representant> hashRep) {
        initComponents();
        
        //On ajoute notre jDtPicker
        model = new UtilDateModel();
        datePanel = new JDatePanelImpl(model);
        jDtPicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        jPanel1.add(jDtPicker, new org.netbeans.lib.awtextra.AbsoluteConstraints(140,160,110,-1));
        jDtPicker.setInputVerifier(new verifyFieldDate());
        
        //Mise à jour des attributs
        this.hashProspect = hashProspect;
        this.hashRep = hashRep;
        
        //remplissage de la liste des prospects
        remplitTable();
       
        //on disable tous les composants du jPanel1 
        GuiUtils.setEnableRec(jPanel1,false);
        jLblErreur.setVisible(false);
       
        //SelectionListener
        jTblCommande.getSelectionModel().addListSelectionListener(new SharedListSelectionHandler());
        jTblCommande.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

   /*     jPanel1.getFocusOwner().addFocusListener(new java.awt.event.FocusAdapter() {
                        public void focusGained(FocusEvent e) {

                        System.out.print("focus");
                        }
                        @Override
                        public void focusLost(FocusEvent e) {

                        }
        }); */
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
        jLblEnseigne = new javax.swing.JLabel();
        jBtnAnnuler = new javax.swing.JButton();
        jBtnOK = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTxtNoClient = new javax.swing.JTextField();
        jLblErreur = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jTxtNo1 = new javax.swing.JTextField();
        jBtnVisuClient = new javax.swing.JButton();
        jCboEtat = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTblLgCommande = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jBtnNouveau1 = new javax.swing.JButton();
        jBtnModifier1 = new javax.swing.JButton();
        jBtnSupprimer1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jBtnNouveau = new javax.swing.JButton();
        jBtnModifier = new javax.swing.JButton();
        jBtnSupprimer = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTblCommande = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setTitle("Gestion des commandes");
        setPreferredSize(new java.awt.Dimension(906, 500));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                refreshComboRep(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setEnabled(false);
        jPanel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                refreshComboRep(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTxtEnseigne.setInputVerifier(new verifyTxtFieldString());
        jPanel1.add(jTxtEnseigne, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 230, -1));

        jLblEnseigne.setText("Client");
        jPanel1.add(jLblEnseigne, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 20));

        jBtnAnnuler.setText("Annuler");
        jBtnAnnuler.setToolTipText("");
        jBtnAnnuler.setNextFocusableComponent(jTxtEnseigne);
        jBtnAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAnnulerActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnAnnuler, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, -1, -1));

        jBtnOK.setText("OK");
        jBtnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnOKActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, -1, -1));

        jLabel1.setText("Date commande");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, -1, 20));

        jTxtNoClient.setEditable(false);
        jTxtNoClient.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        jTxtNoClient.setEnabled(false);
        jTxtNoClient.setFocusable(false);
        jTxtNoClient.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(jTxtNoClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 40, -1));

        jLblErreur.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLblErreur.setForeground(new java.awt.Color(255, 51, 0));
        jLblErreur.setText("Veuillez vérifier votre saisie !");
        jLblErreur.setEnabled(false);
        jLblErreur.setFocusable(false);
        jPanel1.add(jLblErreur, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 310, -1));

        jLabel25.setText("Date livraison");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, 20));

        jTxtNo1.setEditable(false);
        jTxtNo1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        jTxtNo1.setEnabled(false);
        jTxtNo1.setFocusable(false);
        jTxtNo1.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(jTxtNo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, -1));

        jBtnVisuClient.setText("*");
        jPanel1.add(jBtnVisuClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 30, -1));

        jCboEtat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "en cours", "validée", "facturée" }));
        jCboEtat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCboEtatActionPerformed(evt);
            }
        });
        jPanel1.add(jCboEtat, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 80, -1));

        jTblLgCommande.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "N°", "Enseigne", "Adresse", "Mail", "Téléphone", "Siret", "Representant", "Date visite"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
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
        jTblLgCommande.setFocusable(false);
        jScrollPane3.setViewportView(jTblLgCommande);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 727, 140));

        jBtnNouveau1.setText("Nouveau");
        jBtnNouveau1.setFocusable(false);
        jBtnNouveau1.setName("jBtnNouveau"); // NOI18N
        jBtnNouveau1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNouveau1ModifierActionPerformed(evt);
            }
        });

        jBtnModifier1.setText("Modifier");
        jBtnModifier1.setEnabled(false);
        jBtnModifier1.setFocusable(false);
        jBtnModifier1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnModifier1jBtnNouveauModifierActionPerformed(evt);
            }
        });

        jBtnSupprimer1.setText("Supprimer");
        jBtnSupprimer1.setEnabled(false);
        jBtnSupprimer1.setFocusable(false);
        jBtnSupprimer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSupprimer1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnNouveau1, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(jBtnModifier1, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(jBtnSupprimer1, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jBtnNouveau1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnModifier1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnSupprimer1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, -1, 120));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 871, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, -1, -1));

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
                    .addComponent(jBtnNouveau, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(jBtnModifier, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
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

        jTblCommande.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "N°", "Enseigne", "Adresse", "Mail", "Téléphone", "Siret", "Representant", "Date visite"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
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
        jTblCommande.setFocusable(false);
        jScrollPane2.setViewportView(jTblCommande);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 727, 173));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAnnulerActionPerformed
        jTblCommande.clearSelection();
        remplitFiche(-1);
        GuiUtils.setEnableRec(jPanel1,false);
        GuiUtils.setEnableRec(jPanel4, true);
        GuiUtils.setEnableRec(jTblCommande,true);
        jBtnModifier.setEnabled(false);
        jBtnSupprimer.setEnabled(false);
        jLblErreur.setVisible(false);
        typAcc = type_acces.visualisation;
       
    }//GEN-LAST:event_jBtnAnnulerActionPerformed

    private void jBtnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnOKActionPerformed

        if (verifyFields(jPanel1)) {
            sauveFiche();
            jTblCommande.clearSelection();
            remplitFiche(-1);
            remplitTable();
            GuiUtils.setEnableRec(jPanel1,false);   
            GuiUtils.setEnableRec(jPanel4, true);
            GuiUtils.setEnableRec(jTblCommande,true);
            jBtnModifier.setEnabled(false);
            jBtnSupprimer.setEnabled(false);
            jLblErreur.setVisible(false);
            typAcc = type_acces.visualisation;
        }
    }//GEN-LAST:event_jBtnOKActionPerformed

    private void jBtnSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSupprimerActionPerformed
        supprimeFiche();
    }//GEN-LAST:event_jBtnSupprimerActionPerformed

    private void jBtnNouveauModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNouveauModifierActionPerformed
         
        //Clic sur Modifier
        if (evt.getSource().equals((Object) jBtnModifier))  {
            typAcc = Constantes.type_acces.modification;
        } else {
            remplitFiche(-1); //vide la fiche 
            typAcc = Constantes.type_acces.creation;
        }
  
       // jTblProspect.clearSelection();
        GuiUtils.setEnableRec(jPanel1,true); //Fiche modifiable
      
        //Liste et boutons du haut grisés
        GuiUtils.setEnableRec(jPanel4, false);
        GuiUtils.setEnableRec(jTblCommande,false);
        jTxtNoClient.setEnabled(false); //Numéro non modifiable
        jTxtEnseigne.requestFocusInWindow();//Focus sur le nom
          
    }//GEN-LAST:event_jBtnNouveauModifierActionPerformed

    private void refreshComboRep(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_refreshComboRep
        // TODO add your handling code here:
        if (jPanel1.isEnabled())
            remplitComboRep(jCboEtat.getSelectedIndex()) ;
    }//GEN-LAST:event_refreshComboRep

    private void jCboEtatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCboEtatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCboEtatActionPerformed

    private void jBtnNouveau1ModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNouveau1ModifierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnNouveau1ModifierActionPerformed

    private void jBtnModifier1jBtnNouveauModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnModifier1jBtnNouveauModifierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnModifier1jBtnNouveauModifierActionPerformed

    private void jBtnSupprimer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSupprimer1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnSupprimer1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAnnuler;
    private javax.swing.JButton jBtnModifier;
    private javax.swing.JButton jBtnModifier1;
    private javax.swing.JButton jBtnNouveau;
    private javax.swing.JButton jBtnNouveau1;
    private javax.swing.JButton jBtnOK;
    private javax.swing.JButton jBtnSupprimer;
    private javax.swing.JButton jBtnSupprimer1;
    private javax.swing.JButton jBtnVisuClient;
    private javax.swing.JComboBox<String> jCboEtat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLblEnseigne;
    private javax.swing.JLabel jLblErreur;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTblCommande;
    private javax.swing.JTable jTblLgCommande;
    private javax.swing.JTextField jTxtEnseigne;
    private javax.swing.JTextField jTxtNo1;
    private javax.swing.JTextField jTxtNoClient;
    // End of variables declaration//GEN-END:variables

    private void remplitTable()
    {
        String [] cols = {"No","Enseigne","Adresse","Mail","Téléphone","Siret","Représentant","Date visite"}; 
        DefaultTableModel listData = new DefaultTableModel(cols,0); 
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        if (hashProspect!=null)
            for (Prospect p : hashProspect.values()) {

                String[] ts = {Integer.toString(p.getNo()),
                    p.getEnseigne(),
                    p.getAdrToString(),
                    p.getMail(),
                    p.getTelephone(),
                    p.getSiret(),
                    p.getNoRepresentant() + " "+hashRep.get(p.getNoRepresentant()).getNom()+" "+hashRep.get(p.getNoRepresentant()).getPrenom(),
                        sdf.format(p.getDateVisite())
                };
            
                listData.addRow(ts);
            }
        jTblCommande.setModel(listData);
        initTailleCols();
        
    }
    private void initTailleCols() 
    {
        int[] tailleCol = {27,113,197,81,82,49,127,45};
        for (int i=0;i<tailleCol.length;i++)
            jTblCommande.getColumnModel().getColumn(i).setPreferredWidth(tailleCol[i]);       
    }

    
    private void remplitFiche(int noRep) 
    {
       int i=0,iRep=0;
       if (noRep != -1) { 
            Prospect p = hashProspect.get(noRep);

            jTxtNoClient.setText(String.valueOf(p.getNo())); 
            jTxtEnseigne.setText(p.getEnseigne());
   /*         jTxtAdrNo.setText(String.valueOf(p.getAdresse().getNo()));
            jTxtAdrRue.setText(p.getAdresse().getRue());
            jTxtAdrVille.setText(p.getAdresse().getVille());
            jTxtAdrCP.setText(String.valueOf(p.getAdresse().getCp()));
            jTxtAdrPays.setText(p.getAdresse().getPays());
            jTxtMail.setText(p.getMail());
            jTxtTel.setText(p.getTelephone());
            jTxtSiret.setText(p.getSiret()); */
            // init datepicker. -1 sur le mois, car janvier=0
            jDtPicker.getModel().setDate(Integer.parseInt(new SimpleDateFormat("YYYY").format(p.getDateVisite())),
                                          Integer.parseInt(new SimpleDateFormat("MM").format(p.getDateVisite()))-1,
                                          Integer.parseInt(new SimpleDateFormat("dd").format(p.getDateVisite())));
            jDtPicker.getModel().setSelected(true);

            remplitComboRep(p.getNoRepresentant());
            //Remplit la combobox des représentants et select du bon
  /*          jCboEtat.removeAllItems();
            Collection<Representant> setRep = hashRep.values();
            for (Representant r : setRep) {
                jCboEtat.addItem(r.getNo() + " "+ r.getNom() + " "+ r.getPrenom());
                if (r.getNo() == p.getNoRepresentant())
                    iRep = i;
                 i++;
            }
            jCboEtat.setSelectedIndex(iRep); */
            
       } else {
            jTxtEnseigne.setText("");
            /*jTxtSiret.setText("");
            jTxtMail.setText("");
            jTxtTel.setText("");
            jTxtAdrNo.setText("");
            jTxtAdrRue.setText("");
            jTxtAdrVille.setText("");
            jTxtAdrCP.setText("");
            jTxtAdrPays.setText(""); */
            jTxtNoClient.setText("");

            //DatePicker 
            jDtPicker.getModel().setValue(null);

            //cbo des representants
            remplitComboRep(-1);
        }
       jLblErreur.setVisible(false);
    }
   
    private void remplitComboRep(int index) 
    {
            int i=0,iRep =0;    
            jCboEtat.removeAllItems();
            Collection<Representant> setRep = hashRep.values();
                
            for (Representant r : setRep) {
                jCboEtat.addItem(r.getNo() + " "+ r.getNom() + " "+ r.getPrenom());
                if (r.getNo() == index)
                    iRep = i;
                 i++;
            }
            jCboEtat.setSelectedIndex(iRep);
 
       /*     for (Representant r : setRep) 
                jCboEtat.addItem(r.getNo()+" "+r.getNom()+" "+r.getPrenom()); ù*/
    }
    
    private void sauveFiche() 
    { 
        //Recuperation du représentant à partir de la cbo
        int noRep=Integer.parseInt(jCboEtat.getSelectedItem().toString().split(" ")[0]);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        sdf.setLenient(false);
        Date d = (Date) jDtPicker.getModel().getValue();
        Date dateVisite = null;
        try {
            dateVisite = sdf.parse(sdf.format(d));
        } catch (ParseException ex) {
            Logger.getLogger(JFrmIntLstCommande.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        // en modif, on utilise le constructeur avec le n° de prospect
     /*   if (typAcc == type_acces.modification) {
            Prospect c = new Prospect(          Integer.parseInt(jTxtNoClient.getText()),
                                                jTxtEnseigne.getText(),
                                                new Adresse(Integer.parseInt(jTxtAdrNo.getText()), 
                                                            jTxtAdrRue.getText(),
                                                            Integer.parseInt(jTxtAdrCP.getText()),
                                                            jTxtAdrVille.getText(),
                                                            jTxtAdrPays.getText()),
                                                jTxtMail.getText(),
                                                jTxtTel.getText(),
                                                jTxtSiret.getText(),
                                                noRep,
                                               dateVisite
                                                );
            hashProspect.put(Integer.parseInt(jTxtNoClient.getText()),c);
        } else { // en création, on utilise le constructeur sans le n°
            Prospect c = new Prospect (         jTxtEnseigne.getText(),
                                                new Adresse(Integer.parseInt(jTxtAdrNo.getText()), 
                                                            jTxtAdrRue.getText(),
                                                            Integer.parseInt(jTxtAdrCP.getText()),
                                                            jTxtAdrVille.getText(),
                                                            jTxtAdrPays.getText()),
                                                jTxtMail.getText(),
                                                jTxtTel.getText(),
                                                jTxtSiret.getText(),
                                                noRep,
                                                dateVisite
                                                ); 
            hashProspect.put(Prospect.getDernierNo(),c); 
        }
            */
    }
   
    private void supprimeFiche() {

        //Affichage boite de dialogue pour confirmation
        if (JOptionPane.showConfirmDialog(null,"Etes-vous sûr de vouloir supprimer ce client ?","Attention",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            Prospect r = hashProspect.get(Integer.parseInt(jTxtNoClient.getText()));
            hashProspect.remove(Integer.parseInt(jTxtNoClient.getText()),r);
            //On vide tout
            jTblCommande.clearSelection();
            remplitFiche(-1);
            //Affichage nouvelle liste
            remplitTable(); 
        }
                
    }
    
  
    private boolean  verifyFields(Component container) 
    {    
    
        if (!new verifyTxtFieldString().verify(jTxtEnseigne)) return false ;
        if (!new verifyFieldDate().verify(jDtPicker)) return false ;
         
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
                int noProspect = Integer.parseInt(jTblCommande.getModel().getValueAt(jTblCommande.getSelectedRow(),0).toString());
                remplitFiche(noProspect);
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
             jLblErreur.setVisible(!bOk);
             return (bOk);
         }
    }
    
    class verifyTxtFieldInt extends InputVerifier {
         @Override
         public boolean verify(JComponent input) {
             boolean bOk = true;
             JTextField tf = (JTextField) input;
             //System.out.println("nom "+tf.getL.getName());
             try {
                 int i = Integer.parseInt(tf.getText());                 
             }
             catch (Exception e) {
                 bOk = false;
             }
             //tf.getParent().getComponents().
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
            }
            catch (Exception e) {
                bOk = false;
            }
            jLblErreur.setVisible(!bOk);
            tf.requestFocusInWindow();
            return bOk;
        }
   }
    
    class verifyFieldDate extends InputVerifier {
        @Override
        public boolean verify(JComponent input) {
            Date d; 
            boolean bOk = true;
               
            SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yy");
            sdf.setLenient(false);
            JDatePickerImpl jDate = (JDatePickerImpl) input;
            try {
                d = (Date) jDate.getModel().getValue();
                if (d==null) bOk=false;
            } catch (Exception e) {
                bOk = false;
            }
             jLblErreur.setVisible(!bOk);
             input.requestFocusInWindow();
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
            jLblErreur.setVisible(!matcher.matches());
            return matcher.matches();
        }
    }
    
    //TODO : verifier que le champ taux <100
    //TODO : vérifier que le champ CP 5 chiffres
    
}