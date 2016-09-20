/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hc.utils;

import static com.hc.utils.Constantes.separator;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.InputVerifier;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;

/**
 * Classe utilitaire pour l'interface graphique
 * 
 * @author cflagollet
 */
public class GuiUtils {
        /** 
         * Methode pour enable/disable un panel (quand on disable un container, les composants contenus ne sont pas disable 
         */
    public static void setEnableRec(Component container, boolean enable){
    
        if  (( (container.getName() ==null ) ||
              (!container.getName().startsWith("jLbl")) ||
              (!container.getName().startsWith("jPane")) ) && !enable)
            container.setEnabled(enable);
        else
            if  ( (container.getName() ==null ) ||
              (!container.getName().startsWith("jTxtNo")))
                container.setEnabled(enable);
        
        if ((container.getName() !=null ) && container.getName().startsWith("jTbl")) {
            if (enable) 
                container.setForeground(Color.black);
            else 
                container.setForeground(Color.lightGray);
        }
            
        
        try {
            Component[] components= ((Container) container).getComponents();
            for (Component component : components)     
                setEnableRec(component, enable);
            
        } catch (ClassCastException e) {
                //TODO : gestion exception
        }
    }
    
    /** méthode de verification des champs appelée lors du clic sur OK
    *   car on ne passe pas forcément par tous les champs donc les inputVerifier ne sont pas appelés systématiquement
    * Non utilisé actuellement. A revoir
    */
    public static boolean  verifyFields(Component container) 
    {
        Component[] components= ((Container) container).getComponents();
        for (Component c : components) {
            try {   
                JComponent jc = (JComponent)c;
                if (jc.getInputVerifier()!=null) {
                    if (!jc.getInputVerifier().verify(jc)) 
                        return false ;                    
                }
            } catch (ClassCastException e) {
             //TODO : gestion exception
            }
        }
        return true;              
    }  
    
    public static boolean verifyTxtFieldCbo(Component input,JLabel jLabel)  {        
        
        JComboBox<String> tf = (JComboBox<String>) input;
        boolean bOk = (!tf.getSelectedItem().toString().isEmpty() || !tf.isEnabled());
        jLabel.setText("Veuillez vérifier votre saisie");
        if (!bOk) tf.requestFocusInWindow();
        jLabel.setVisible(!bOk);
        return (bOk);
    }
    
    
    public static boolean verifyTxtFieldString(Component input,JLabel jLabel) {
        JTextField tf = (JTextField) input;
        boolean bOk = ((!tf.getText().isEmpty() && !tf.getText().contains(separator)) || !tf.isEnabled());
        jLabel.setText("Veuillez vérifier votre saisie ");
        jLabel.setVisible(!bOk);
        if (!bOk) tf.requestFocusInWindow();
        return (bOk);
    }
    
    
    public static boolean verifyTxtFieldInt(Component input,JLabel jLabel) {
        boolean bOk = true;
        JTextField tf = (JTextField) input;
        if (tf.isEnabled()) {
            try {
                int i = Integer.parseInt(tf.getText());                 
                if (i<0) bOk=false;
            }
            catch (Exception e) {
                bOk = false;
            }
        }
        jLabel.setText("Veuillez vérifier votre saisie (Entier positif)");
        jLabel.setVisible(!bOk); 
        if (!bOk) tf.requestFocusInWindow(); 
        return bOk;
    }

    public static boolean verifyTxtFieldTaux(Component input,JLabel jLabel) {
        boolean bOk = true;
        JTextField tf = (JTextField) input;
        if (tf.isEnabled()) {
            try {
                Double d = Double.parseDouble(tf.getText());                 
                if ((d<0) || d>100) bOk=false;
            }
            catch (Exception e) {
                bOk = false;
            }
        }
        jLabel.setText("Veuillez vérifier votre saisie (0<taux<100)");
        jLabel.setVisible(!bOk);
        if (!bOk) tf.requestFocusInWindow();
        return bOk;
    }
    
    
    public static boolean verifyTxtFieldNumber(Component input,JLabel jLabel)  {
        boolean bOk = true;
        JTextField tf = (JTextField) input;
        if (tf.isEnabled()) {
            try {
                double d = Double.parseDouble(tf.getText());                 
                if (d<0) bOk=false;
            }
            catch (Exception e) {
                bOk = false;
            }
        }
        jLabel.setText("Veuillez vérifier votre saisie (nombre positif)");
        jLabel.setVisible(!bOk);
        if (!bOk) tf.requestFocusInWindow();
        return bOk;
    }
    
    public static boolean verifyFieldDate(Component input,JLabel jLabel){
        Date d; 
        boolean bOk = true;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yy");
        sdf.setLenient(false);
        JDatePickerImpl jDate = (JDatePickerImpl) input;
        if (jDate.isEnabled()) {
            try {
                d = (Date) jDate.getModel().getValue();
                if (d==null) bOk=false;
            } catch (Exception e) {
                bOk = false;
            }
        }
        jLabel.setText("Veuillez vérifier votre saisie (date incorrecte)");
        jLabel.setVisible(!bOk);
        if (!bOk) jDate.requestFocusInWindow();
        return bOk;
        
    }

   public static boolean verifyTxtFieldMail(Component input,JLabel jLabel){

        boolean bOk = true;
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        JTextField tf = (JTextField) input;
        if (tf.isEnabled()) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(tf.getText());
            bOk = matcher.matches();
        }
        jLabel.setText("Veuillez vérifier votre saisie (mail incorrect)");
        jLabel.setVisible(!bOk);
        if (!bOk) input.requestFocusInWindow();
        return bOk;
    }
    
}


    



