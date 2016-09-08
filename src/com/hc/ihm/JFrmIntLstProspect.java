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
import javax.swing.JComboBox;
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
public class JFrmIntLstProspect extends javax.swing.JInternalFrame   {

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
    public JFrmIntLstProspect(HashMap<Integer,Prospect> hashProspect,HashMap<Integer,Representant> hashRep) {
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
        jTblProspect.getSelectionModel().addListSelectionListener(new SharedListSelectionHandler());
        jTblProspect.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateComponentFactory1 = new net.sourceforge.jdatepicker.JDateComponentFactory();
        jDatePickerUtil1 = new net.sourceforge.jdatepicker.util.JDatePickerUtil();
        jPanel4 = new javax.swing.JPanel();
        jBtnNouveau = new javax.swing.JButton();
        jBtnModifier = new javax.swing.JButton();
        jBtnSupprimer = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTblProspect = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jTxtEnseigne = new javax.swing.JTextField();
        jTxtSiret = new javax.swing.JTextField();
        jLblSiret = new javax.swing.JLabel();
        jLblEnseigne = new javax.swing.JLabel();
        jTxtMail = new javax.swing.JTextField();
        jLblSalaire = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTxtNo = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTxtAdrCompl = new javax.swing.JTextField();
        jTxtAdrCP = new javax.swing.JTextField();
        jTxtAdrVille = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTxtAdrRue = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTxtAdrNo = new javax.swing.JTextField();
        jCboAdrPays = new javax.swing.JComboBox<>();
        jTxtTel = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jCboRep = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLblErreur = new javax.swing.JLabel();
        jBtnOK = new javax.swing.JButton();
        jBtnAnnuler = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setTitle("Gestion des prospects");
        setPreferredSize(new java.awt.Dimension(906, 500));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                refreshComboRep(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jTblProspect.setModel(new javax.swing.table.DefaultTableModel(
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
        jTblProspect.setFocusable(false);
        jScrollPane2.setViewportView(jTblProspect);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 727, 110));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setEnabled(false);
        jPanel1.setName("Jpane"); // NOI18N
        jPanel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                refreshComboRep(evt);
            }
        });
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
        jPanel1.add(jLblSalaire, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, 20));

        jLabel1.setText("Mail");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, 20));

        jTxtNo.setEditable(false);
        jTxtNo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxtNo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTxtNo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTxtNo.setEnabled(false);
        jTxtNo.setFocusable(false);
        jTxtNo.setName("jTxtNo"); // NOI18N
        jTxtNo.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(jTxtNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, -1));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Adresse"));
        jPanel5.setName("Jpane"); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Numéro");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 57, 20));

        jLabel4.setText("Complements");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 80, 20));

        jTxtAdrCompl.setNextFocusableComponent(jTxtAdrCP);
        jPanel5.add(jTxtAdrCompl, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 210, -1));

        jTxtAdrCP.setInputVerifier(new verifyTxtFieldInt());
        jTxtAdrCP.setNextFocusableComponent(jTxtAdrVille);
        jPanel5.add(jTxtAdrCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 60, -1));

        jTxtAdrVille.setInputVerifier(new verifyTxtFieldString());
        jPanel5.add(jTxtAdrVille, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 160, -1));

        jLabel5.setText("Code postal");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 20));

        jLabel6.setText("Ville");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 50, 20));

        jLabel7.setText("Pays");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 50, 20));

        jTxtAdrRue.setInputVerifier(new verifyTxtFieldString());
        jTxtAdrRue.setNextFocusableComponent(jTxtAdrCP);
        jPanel5.add(jTxtAdrRue, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 210, -1));

        jLabel8.setText("Rue");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 57, 20));

        jTxtAdrNo.setInputVerifier(new verifyTxtFieldInt());
        jTxtAdrNo.setNextFocusableComponent(jTxtAdrCompl);
        jPanel5.add(jTxtAdrNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 40, -1));

        jCboAdrPays.setEditable(true);
        jCboAdrPays.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Allemagne", "Angleterre", "Belgique", "Cameroun", "Espagne", "France", "Italie" }));
        jPanel5.add(jCboAdrPays, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 120, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 330, 230));

        jTxtTel.setToolTipText("");
        jTxtTel.setAutoscrolls(false);
        jTxtTel.setInputVerifier(new verifyTxtFieldNumber());
        jPanel1.add(jTxtTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 110, -1));

        jLabel25.setText("Téléphone");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, 20));

        jCboRep.setNextFocusableComponent(jTxtAdrNo);
        jPanel1.add(jCboRep, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 120, -1));

        jLabel15.setText("Date visite");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, 20));

        jLblErreur.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLblErreur.setForeground(new java.awt.Color(255, 51, 0));
        jLblErreur.setText("Veuillez vérifier votre saisie !");
        jLblErreur.setEnabled(false);
        jLblErreur.setFocusable(false);
        jPanel1.add(jLblErreur, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 180, -1));

        jBtnOK.setText("OK");
        jBtnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnOKAnnulerActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, -1, -1));

        jBtnAnnuler.setText("Annuler");
        jBtnAnnuler.setToolTipText("");
        jBtnAnnuler.setNextFocusableComponent(jTxtEnseigne);
        jBtnAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnOKAnnulerActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnAnnuler, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 260, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 726, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnOKAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnOKAnnulerActionPerformed

        if (evt.getSource().equals(jBtnOK)) {
            if (verifyFields(jPanel1)) {
                sauveFiche();
            }
            else return;
        }

        jTblProspect.clearSelection();
        remplitFiche(-1);
        remplitTable();
        GuiUtils.setEnableRec(jPanel1,false);   
        GuiUtils.setEnableRec(jPanel4, true);
        GuiUtils.setEnableRec(jTblProspect,true);
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
            typAcc = Constantes.type_acces.modification;
        } else {
            remplitFiche(-1); //vide la fiche 
            typAcc = Constantes.type_acces.creation;
        }
  
       // jTblProspect.clearSelection();
        GuiUtils.setEnableRec(jPanel1,true); //Fiche modifiable
      
        //Liste et boutons du haut grisés
        GuiUtils.setEnableRec(jPanel4, false);
        GuiUtils.setEnableRec(jTblProspect,false);
        jTxtEnseigne.requestFocusInWindow();//Focus sur le nom
          
    }//GEN-LAST:event_jBtnNouveauModifierActionPerformed

    private void refreshComboRep(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_refreshComboRep
        // TODO add your handling code here:
        if (jPanel1.isEnabled())
            remplitComboRep(jCboRep.getSelectedIndex()) ;
    }//GEN-LAST:event_refreshComboRep


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAnnuler;
    private javax.swing.JButton jBtnModifier;
    private javax.swing.JButton jBtnNouveau;
    private javax.swing.JButton jBtnOK;
    private javax.swing.JButton jBtnSupprimer;
    private javax.swing.JComboBox<String> jCboAdrPays;
    private javax.swing.JComboBox<String> jCboRep;
    private net.sourceforge.jdatepicker.JDateComponentFactory jDateComponentFactory1;
    private net.sourceforge.jdatepicker.util.JDatePickerUtil jDatePickerUtil1;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTblProspect;
    private javax.swing.JTextField jTxtAdrCP;
    private javax.swing.JTextField jTxtAdrCompl;
    private javax.swing.JTextField jTxtAdrNo;
    private javax.swing.JTextField jTxtAdrRue;
    private javax.swing.JTextField jTxtAdrVille;
    private javax.swing.JTextField jTxtEnseigne;
    private javax.swing.JTextField jTxtMail;
    private javax.swing.JTextField jTxtNo;
    private javax.swing.JTextField jTxtSiret;
    private javax.swing.JTextField jTxtTel;
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
        jTblProspect.setModel(listData);
        initTailleCols();
        
    }
    private void initTailleCols() 
    {
        int[] tailleCol = {27,113,197,81,82,49,127,45};
        for (int i=0;i<tailleCol.length;i++)
            jTblProspect.getColumnModel().getColumn(i).setPreferredWidth(tailleCol[i]);       
    }

    
    private void remplitFiche(int noRep) 
    {
       int i=0,iRep=0;
       if (noRep != -1) { 
            Prospect p = hashProspect.get(noRep);

            jTxtNo.setText(String.valueOf(p.getNo())); 
            jTxtEnseigne.setText(p.getEnseigne());
            jTxtAdrNo.setText(String.valueOf(p.getAdresse().getNo()));
            jTxtAdrRue.setText(p.getAdresse().getRue());
            jTxtAdrCompl.setText(p.getAdresse().getCompl());
            jTxtAdrVille.setText(p.getAdresse().getVille());
            jTxtAdrCP.setText(String.valueOf(p.getAdresse().getCp()));
            jCboAdrPays.setSelectedItem(p.getAdresse().getPays());
            jTxtMail.setText(p.getMail());
            jTxtTel.setText(p.getTelephone());
            jTxtSiret.setText(p.getSiret());
            // init datepicker. -1 sur le mois, car janvier=0
            jDtPicker.getModel().setDate(Integer.parseInt(new SimpleDateFormat("YYYY").format(p.getDateVisite())),
                                          Integer.parseInt(new SimpleDateFormat("MM").format(p.getDateVisite()))-1,
                                          Integer.parseInt(new SimpleDateFormat("dd").format(p.getDateVisite())));
            jDtPicker.getModel().setSelected(true);
            remplitComboRep(p.getNoRepresentant());

            
       } else {
            jTxtEnseigne.setText("");
            jTxtSiret.setText("");
            jTxtMail.setText("");
            jTxtTel.setText("");
            jTxtAdrNo.setText("");
            jTxtAdrCompl.setText("");
            jTxtAdrVille.setText("");
            jTxtAdrCP.setText("");
            jCboAdrPays.setSelectedItem("");
            jTxtNo.setText("");

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
            jCboRep.removeAllItems();
            Collection<Representant> setRep = hashRep.values();
                
            for (Representant r : setRep) {
                jCboRep.addItem(r.getNo() + " "+ r.getNom() + " "+ r.getPrenom());
                if (r.getNo() == index)
                    iRep = i;
                 i++;
            }
            jCboRep.setSelectedIndex(iRep);
 
       /*     for (Representant r : setRep) 
                jCboRep.addItem(r.getNo()+" "+r.getNom()+" "+r.getPrenom()); ù*/
    }
    
    private void sauveFiche() 
    { 
        //Recuperation du représentant à partir de la cbo
        int noRep=Integer.parseInt(jCboRep.getSelectedItem().toString().split(" ")[0]);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        sdf.setLenient(false);
        Date d = (Date) jDtPicker.getModel().getValue();
        Date dateVisite = null;
        try {
            dateVisite = sdf.parse(sdf.format(d));
        } catch (ParseException ex) {
            Logger.getLogger(JFrmIntLstProspect.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        // en modif, on utilise le constructeur avec le n° de prospect
        if (typAcc == type_acces.modification) {
            Prospect c = new Prospect(          Integer.parseInt(jTxtNo.getText()),
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
                                               dateVisite
                                                );
            hashProspect.put(Integer.parseInt(jTxtNo.getText()),c);
        } else { // en création, on utilise le constructeur sans le n°
            Prospect c = new Prospect (         jTxtEnseigne.getText(),
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
                                                dateVisite
                                                );
            hashProspect.put(Prospect.getDernierNo(),c); 
        }
            
    }
   
    private void supprimeFiche() {

        //TODO : vérification des commandes éventuelle
        
        //Affichage boite de dialogue pour confirmation
        if (JOptionPane.showConfirmDialog(null,"Etes-vous sûr de vouloir supprimer ce client ?","Attention",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            Prospect r = hashProspect.get(Integer.parseInt(jTxtNo.getText()));
            hashProspect.remove(Integer.parseInt(jTxtNo.getText()),r);
            
            remplitFiche(-1);   //Fiche à vide
            remplitTable();      //Affichage nouvelle liste
        }
    }
    
    private boolean  verifyFields(Component container) 
    {    
    
        if (!new verifyTxtFieldString().verify(jTxtEnseigne)) return false;
        if (!new verifyTxtFieldString().verify(jTxtSiret)) return false;
        if (!new verifyTxtFieldCbo().verify(jCboRep)) return false;
        if (!new verifyTxtFieldMail().verify(jTxtMail)) return false;
        if (!new verifyFieldDate().verify(jDtPicker)) return false;
        if (!new verifyTxtFieldInt().verify(jTxtAdrNo)) return false;
        if (!new verifyTxtFieldString().verify(jTxtAdrRue)) return false;
        if (!new verifyTxtFieldString().verify(jTxtAdrVille)) return false;
        if (!new verifyTxtFieldCbo().verify(jCboAdrPays)) return false;
        if (!new verifyTxtFieldInt().verify(jTxtAdrCP)) return false;
        
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
                int noProspect = Integer.parseInt(jTblProspect.getModel().getValueAt(jTblProspect.getSelectedRow(),0).toString());
                remplitFiche(noProspect);
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
             if (!bOk) input.requestFocusInWindow();
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
            boolean bOk = matcher.matches();
            jLblErreur.setVisible(!bOk);
            if (!bOk) input.requestFocusInWindow();
            return bOk;
        }
    }
    
    //TODO : verifier que le champ taux <100
    //TODO : vérifier que le champ CP 5 chiffres
    
}
