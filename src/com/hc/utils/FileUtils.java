/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */   
package com.hc.utils;

import com.hc.Entites.Adresse;
import com.hc.Entites.Client;
import com.hc.Entites.Commande;
import com.hc.Entites.Produit;
import com.hc.Entites.Prospect;
import com.hc.Entites.Representant;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author cflagollet
 */
public class FileUtils {
    private final static String separator=";";
    private FileUtils() 
    {     
    }
    
    /*** Lecture d'un fichier dont le chemin est passé en paramètre
     *   renvoie une list de String 
     * @param chemin
     * @return 
     */
    
    public static List<String> litFichier(String chemin) // throws FileNotFoundException
    {
        String line;
        List<String> lst = new ArrayList<String>();
        
        try
        {
        /*    File f = new File (chemin);
            FileReader fr = new FileReader(f); */
            InputStream is = new FileInputStream(chemin);
            InputStreamReader isr = new InputStreamReader(is);
            
            BufferedReader br = new BufferedReader(isr);

            try
            {
                while ((line = br.readLine()) != null)
                   lst.add(line);                   
                
            }          
            finally {        
                br.close();
                isr.close();
            }   
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println ("Le fichier n'a pas été trouvé "+fnfe.getMessage());
        } 
        catch (IOException ioe)
        {
            System.out.println ("Erreur lors de la lecture : " + ioe.getMessage());
        }
        
        return lst;
        
    }
    
    public static HashMap<Integer,Representant> decodeRep(List<String> lst) 
    {        
        HashMap<Integer,Representant> hashRep = new HashMap<Integer,Representant>();
      
        for (String s : lst) {
            String[] ts = s.split(separator);
                                                    
            Adresse n = new Adresse(Integer.parseInt(ts[5]),ts[6], ts[7], Integer.parseInt(ts[8]),ts[9],ts[10]);
            try {
                Representant r = new Representant(  Integer.parseInt(ts[0]),
                                                    Double.parseDouble(ts[1]),
                                                    Double.parseDouble(ts[2]),
                                                    ts[3],
                                                    ts[4],
                                                    n);
                hashRep.put(Integer.parseInt(ts[0]), r);
            } catch (Exception e) {
                System.out.println("com.hc.utils.FileUtils.decodeRep()");
            }
            
        }
        
        return hashRep;
    }
    
    public static HashMap<Integer,Client> decodeClient(List<String> lst) 
    {        
        HashMap<Integer,Client> hashClient = new HashMap<Integer,Client>();
      
        for (String s : lst) {
            String[] ts = s.split(separator);
                                                    
            Adresse n = new Adresse(Integer.parseInt(ts[2]),ts[3], ts[4], Integer.parseInt(ts[5]),ts[6],ts[7]);
            try {
                Client c = new Client(  Integer.parseInt(ts[0]), // n, s, s, s, 0, 0);
                                                    ts[1],
                                                    n,
                                                    ts[8],
                                                    ts[9],                                                    
                                                    ts[10],               
                                                    Integer.parseInt(ts[11]),
                                                    Integer.parseInt(ts[12]));
                
                hashClient.put(Integer.parseInt(ts[0]), c);
            } catch (Exception e) {
                System.out.println("com.hc.utils.FileUtils.decodeRep()");
            }
            
        }
        
        return hashClient;
    }
    
    public static HashMap<Integer,Prospect> decodeProspect(List<String> lst) 
    {        
        HashMap<Integer,Prospect> hashProspect = new HashMap<Integer,Prospect>();
      
        for (String s : lst) {
            String[] ts = s.split(separator);
                                                    
            Adresse n = new Adresse(Integer.parseInt(ts[2]),ts[3], ts[4],Integer.parseInt(ts[5]),ts[6],ts[7]);
            try {
                Prospect p = new Prospect(Integer.parseInt(ts[0]), // n, s, s, s, 0, 0);
                                                    ts[1],
                                                    n,
                                                    ts[8],
                                                    ts[9],                                                    
                                                    ts[10],               
                                                    Integer.parseInt(ts[11]),
                                                    new SimpleDateFormat("dd/MM/YYYY").parse(ts[12]));
                hashProspect.put(Integer.parseInt(ts[0]), p);
            } catch (Exception e) {
                System.out.println("com.hc.utils.FileUtils.decodeRep()");
            }
            
        }
        
        return hashProspect;
    }
   
    public static HashMap<String,Produit> decodeProduit(List<String> lst) 
    {        
        HashMap<String,Produit> hashProduit = new HashMap<String,Produit>();
      
        for (String s : lst) {
            String[] ts = s.split(separator);
                                                    
            
            try {
                Produit p = new Produit(   ts[0], 
                                            ts[1],
                                            Double.parseDouble(ts[2]),    
                                            Integer.parseInt(ts[3]));
                hashProduit.put(ts[0], p);
            } catch (Exception e) {
                System.out.println("com.hc.utils.FileUtils.decodeRep()");
            }
            
        }
        
        return hashProduit;
    }
    
        public static HashMap<Integer,Commande> decodeCommande(List<String> lst) 
    {        
        HashMap<Integer,Commande> hashCommande = new HashMap<Integer,Commande>();
      
        for (String s : lst) {
            String[] ts = s.split(separator);
                                                    
            Adresse n = new Adresse(Integer.parseInt(ts[5]),ts[6],ts[7],Integer.parseInt(ts[8]),ts[9],ts[10]);
            try {
                Commande c = new Commande(  Integer.parseInt(ts[0]),
                                            new SimpleDateFormat("dd/MM/YYYY").parse(ts[1]), 
                                            new SimpleDateFormat("dd/MM/YYYY").parse(ts[2]),
                                            null);
                hashCommande.put(Integer.parseInt(ts[0]), c);
            } catch (Exception e) {
                System.out.println("com.hc.utils.FileUtils.decodeCommande() : "+e.getLocalizedMessage());
            }
            
        }
        
        return hashCommande;
    }
    
    
    public static List<String> codeFichierProduit(HashMap<String,Produit> hashProduit)
    {
        Set<String> setProduit = hashProduit.keySet();
        List<String> lstProduit = new ArrayList<String>();
        
        for (String code : setProduit) {
            Produit p= hashProduit.get(code);
            String s =  code+separator+
                        p.getDesignation()+separator+
                        p.getPrixHT()+separator+
                        p.getQteStock()+"\n";
                        
            lstProduit.add(s);
        }
        return lstProduit;
    }
    
    
    public static List<String> codeFichierRep(HashMap<Integer,Representant> hashRep)
    {
        Set<Integer> setRep = hashRep.keySet();
        List<String> lstRep = new ArrayList<String>();
        
        for (Integer no : setRep) {
            Representant r = hashRep.get(no);
            String s =  no+separator+
                        r.getTxComm()+separator+
                        r.getSalaire()+separator+
                        r.getNom()+separator+
                        r.getPrenom()+separator+
                        r.getAdresse().getNo()+separator+
                        r.getAdresse().getRue()+separator+
                        r.getAdresse().getCompl()+separator+
                        r.getAdresse().getCp()+separator+
                        r.getAdresse().getVille()+separator+
                        r.getAdresse().getPays()+"\n";
            lstRep.add(s);
        }
        return lstRep;
    }
    
    public static List<String> codeFichierProspect(HashMap<Integer,Prospect> hashProspect)
    {
        Set<Integer> setRep = hashProspect.keySet();
        List<String> lstRep = new ArrayList<String>();
        
        for (Integer no : setRep) {
            Prospect p = hashProspect.get(no);
            String s =  no+separator+
                        p.getEnseigne()+separator+                        
                        p.getAdresse().getNo()+separator+
                        p.getAdresse().getRue()+separator+
                        p.getAdresse().getCompl()+separator+
                        p.getAdresse().getCp()+separator+
                        p.getAdresse().getVille()+separator+
                        p.getAdresse().getPays()+separator+
                        p.getMail()+separator+
                        p.getTelephone()+separator+
                        p.getSiret()+separator+
                        p.getNoRepresentant()+separator+
                        new SimpleDateFormat("dd/MM/YYYY").format(p.getDateVisite())+"\n";
            lstRep.add(s);
        }
        return lstRep;
    }
    
    public static List<String> codeFichierClient(HashMap<Integer,Client> hashClient)
    {
        Set<Integer> setClient = hashClient.keySet();
        List<String> lstClient = new ArrayList<String>();
        
        for (Integer no : setClient) {
            Client c = hashClient.get(no);
            String s =  no+separator+
                        c.getEnseigne()+separator+                        
                        c.getAdresse().getNo()+separator+
                        c.getAdresse().getRue()+separator+
                        c.getAdresse().getCompl()+separator+
                        c.getAdresse().getCp()+separator+
                        c.getAdresse().getVille()+separator+
                        c.getAdresse().getPays()+separator+
                        c.getMail()+separator+
                        c.getTelephone()+separator+
                        c.getSiret()+separator+
                        c.getNoRepresentant()+separator+
                        c.getNbCommandes()+"\n";
                    
            lstClient.add(s);
        }
        return lstClient;
    }
    
    public static void sauveFichier(List<String> lst,String chemin) 
    {
        try
        {
            File f = new File (chemin);
            FileWriter fr = new FileWriter (f);
            BufferedWriter br = new BufferedWriter (fr);
            try
            {
                for (String s : lst) {
                    br.write(s);
                }
            }
            
            finally {        
                br.close();
                fr.close();
            }   
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println ("Le fichier n'a pas été trouvé"+fnfe.getMessage());
        }
        catch (IOException ioe)
        {
            System.out.println ("Erreur lors de la lecture : " + ioe.getMessage());
        }
        
    }
}


