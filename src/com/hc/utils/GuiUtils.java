/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hc.utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author cflagollet
 */
public class GuiUtils {
        //Methode pour enable/disable un panel (quand on disable un container, les composants contenus ne sont pas disable !
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
    
    /* méthode de verification des champs appelée lors du clic sur OK
       car on ne passe pas forcément par tous les champs donc les inputVerifier ne sont pas appelés systématiquement
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
    
}


    



