/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hc.utils;

import java.awt.Component;
import java.awt.Container;

/**
 *
 * @author cflagollet
 */
public class GuiUtils {
        //Methode pour enable/disable un panel (quand on disable un container, les composants contenus ne sont pas disable !
    public static void setEnableRec(Component container, boolean enable){
    
        container.setEnabled(enable);

        try {
            Component[] components= ((Container) container).getComponents();
            for (Component component : components) {
                setEnableRec(component, enable);
            }
        } catch (ClassCastException e) {
                //TODO : gestion exception
        }
    }
}
