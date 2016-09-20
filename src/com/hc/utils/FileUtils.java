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
import com.hc.application.Principale;
import static com.hc.utils.Constantes.separator;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * classe utilitaire de gestion des fichiers
 * 
 * @author cflagollet
 */
public class FileUtils {
    
    private static MySQLCli mysqlCli;
    
    public FileUtils(MySQLCli mysqlCli) 
    {     
        FileUtils.mysqlCli = mysqlCli;
    }
    
    /*** Lecture d'un fichier dont le chemin est passé en paramètre
     *   renvoie une list de String 
     * @param chemin
     * @return liste de String
     */
    public static List<String> litFichier(String chemin) 
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
    
    /** 
     * Méthode qui prend en entrée une liste de String et qui crée une hashMap de représentants <no représentant, Représentant>
     * @param lst
     * @return hasMap des représentants
     */
    public static HashMap<Integer,Representant> decodeRep(List<String> lst) 
    {        
        HashMap<Integer,Representant> hashRep = new HashMap<Integer,Representant>();
      
        for (String s : lst) {
            String[] ts = s.split(separator);
                                                    
            Adresse n = new Adresse(Integer.parseInt(ts[5]),ts[6], ts[7], Integer.parseInt(ts[8]),ts[9],ts[10]);
            try {
                Representant r = new Representant(  Integer.parseInt(ts[0]),
                                                    ts[1],
                                                    ts[2],
                                                    Double.parseDouble(ts[3]),
                                                    Double.parseDouble(ts[4]),
 
                                                    n);
                hashRep.put(Integer.parseInt(ts[0]), r);
            } catch (Exception e) {
                System.out.println("com.hc.utils.FileUtils.decodeRep()");
            }
            
        }
        
        return hashRep;
    }
 
    
    /** 
     * Méthodequi crée une hashMap de représentants <no client, Client>
     * @param mysqlCli
     * @return hasMap des représentants
     */
   public static HashMap<Integer,Representant> decodeRepSQL()
   {
       
        HashMap<Integer,Representant> hashRep = new HashMap<Integer,Representant>();
 
        //On crée la hashmap des représentants, à partir de la table
        ResultSet repSet = mysqlCli.exec("SELECT `noRep`, `nomRep`, `prenomRep`, `tauxRep`, `salaireRep`, `adrNoRep`, "
                                       + "`adrRueRep`, `adrComplRep`, `adrCPRep`, `adrVilleRep`, `adrPaysRep` from representant");

        try {
            while (repSet.next()) {
                Adresse a = new Adresse(repSet.getInt(6),repSet.getString(7),repSet.getString(8),repSet.getInt(9),repSet.getString(10),repSet.getString(11));
                Representant r = new Representant(  repSet.getInt(1),
                                                    repSet.getString(2),                                            
                                                    repSet.getString(3),
                                                    repSet.getDouble(4), 
                                                    repSet.getDouble(5),
                                                    a);
               hashRep.put( repSet.getInt(1),r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Principale.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hashRep;
    }                
    
      /** 
     * Méthode qui prend en entrée une connexion mySQL et qui crée une hashMap de clients <no client, Client>
     * @param mysqlCli
     * @return hasMap des Clients
     */
   public static HashMap<Integer,Client> decodeClientSQL()
   {
       
        HashMap<Integer,Client> hashClient = new HashMap<Integer,Client>();
 
        //On crée la hashmap des clients, à partir de la table
        ResultSet clientSet = mysqlCli.exec("SELECT `noClient`, `enseigne`, `siret`, `mail`, `tel`, `nbComm`, `noRep`,"+ 
        "`adrNoClient`, `adrRueClient`, `adrComplClient`, `adrCPClient`, `adrVilleClient` , `adrPaysClient` FROM `client`;");

        try {
            while (clientSet.next()) {
                Adresse a = new Adresse(clientSet.getInt(8),clientSet.getString(9),clientSet.getString(10),clientSet.getInt(11),clientSet.getString(12),clientSet.getString(13));
                Client c = new Client(      clientSet.getInt(1),
                                            clientSet.getString(2),                                            
                                            clientSet.getString(3),
                                            clientSet.getString(4), 
                                            clientSet.getString(5),
                                            clientSet.getInt(6),
                                            clientSet.getInt(7),
                                            a);
               hashClient.put( clientSet.getInt(1),c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Principale.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hashClient;
    }                
    
    public static HashMap<Integer,Prospect> decodeProspectSQL()
   {    
        HashMap<Integer,Prospect> hashProspect = new HashMap<Integer,Prospect>();
 
        //On crée la hashmap des Prospects, à partir de la table
        //ResultSet prospectSet = mysqlCli.exec("SELECT `noProspect`, `enseigne`, `siret`, `mail`, `tel`,  DATE_FORMAT(dateDerVisite, '%d-%m-%Y') as dateDerVisite, "
        ResultSet prospectSet = mysqlCli.exec("SELECT `noProspect`, `enseigne`, `siret`, `mail`, `tel`,  dateDerVisite, "                
                                            + "`noRep`, `adrNoProspect`, `adrRueProspect`, `adrComplProspect`, `adrCPProspect`,"
                                            + " `adrVilleProspect`, `AdrPaysProspect` FROM `prospect`");

        try {
            while (prospectSet.next()) {
                Adresse a = new Adresse(prospectSet.getInt(8),prospectSet.getString(9),prospectSet.getString(10),prospectSet.getInt(11),prospectSet.getString(12),prospectSet.getString(13));                
                Prospect p = new Prospect ( prospectSet.getInt(1),
                                            prospectSet.getString(2),                                            
                                            prospectSet.getString(3),
                                            prospectSet.getString(4), 
                                            prospectSet.getString(5),
                                            prospectSet.getDate(6),
                                            prospectSet.getInt(7),
                                            a);
               hashProspect.put( prospectSet.getInt(1),p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Principale.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hashProspect;
    } 
   
    /** 
     * Méthode qui prend en entrée une liste de String et qui crée une hashMap de clients <no client, Client>
     * @param lst
     * @return hasMap des Clients
     */
    public static HashMap<Integer,Client> decodeCliente(List<String> lst) 
    {        
        HashMap<Integer,Client> hashClient = new HashMap<Integer,Client>();
      
        for (String s : lst) {
            String[] ts = s.split(separator);
                                                    
            Adresse a = new Adresse(Integer.parseInt(ts[2]),ts[3], ts[4], Integer.parseInt(ts[5]),ts[6],ts[7]);
            try {
                Client c = new Client(  Integer.parseInt(ts[0]), 
                                                    ts[1],
                                                    ts[2],
                                                    ts[3],                                                    
                                                    ts[4],               
                                                    Integer.parseInt(ts[11]),
                                                    Integer.parseInt(ts[12]),
                                                    a
                            );
                
                hashClient.put(Integer.parseInt(ts[0]), c);
            } catch (Exception e) {
                System.out.println("com.hc.utils.FileUtils.decodeClient()");
            }
            
        }
        
        return hashClient;
    }
    
    /** 
     * Méthode qui prend en entrée une liste de String et qui crée une hashMap de Prospects <no Prospect, Prospect>
     * @param lst
     * @return hasMap des Prospects
     */
    public static HashMap<Integer,Prospect> decodeProspect(List<String> lst) 
    {        
        HashMap<Integer,Prospect> hashProspect = new HashMap<Integer,Prospect>();
      
        for (String s : lst) {
            String[] ts = s.split(separator);
                                                    
            Adresse a = new Adresse(Integer.parseInt(ts[7]),ts[8], ts[9],Integer.parseInt(ts[10]),ts[11],ts[12]);
            try {
                Prospect p = new Prospect(Integer.parseInt(ts[0]), // n, s, s, s, 0, 0);
                                                    ts[1],
                                                   
                                                    ts[2],
                                                    ts[3],                                                    
                                                    ts[4],               
                                                    new SimpleDateFormat("YYYY-MM-dd").parse(ts[5]),
                                                    Integer.parseInt(ts[6]),
                                                    a);
                hashProspect.put(Integer.parseInt(ts[0]), p);
            } catch (Exception e) {
                System.out.println("com.hc.utils.FileUtils.decodeRep()");
            }
            
        }
        
        return hashProspect;
    }
   
    
    /** 
     * Méthode qui prend en entrée une liste de String et qui crée une hashMap de produits <code Produits, Produits>
     * @param lst
     * @return hasMap des Produits
     */
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
    
    /** 
     * Méthode qui prend en entrée une liste de String et qui crée une hashMap de Commandes <no Commandes, Commandes>
     * @param lst
     * @return hasMap des commandes
     */
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
    
    
    /** 
     * Méthode qui prend une hashMap des produits et revoie une ligne de String
     * Utilisée pour la sauvegarde dans le fichier produits
     * @param hashProduit
     * @return list de String
     */
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
    
    
    /** 
     * Méthode qui prend une hashMap des produits et revoie une ligne de String
     * Utilisée pour la sauvegarde dans le fichier produits
     * @param hashProduit
     * @return list de String
     */
    public static List<String> codeFichierRep(HashMap<Integer,Representant> hashRep)
    {
        Set<Integer> setRep = hashRep.keySet();
        List<String> lstRep = new ArrayList<String>();
        
        for (Integer no : setRep) {
            Representant r = hashRep.get(no);
            String s =  no+separator+
                        r.getNom()+separator+
                        r.getPrenom()+separator+
                        r.getTxComm()+separator+
                        r.getSalaire()+separator+
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
                        p.getSiret()+separator+
                        p.getMail()+separator+
                        p.getTelephone()+separator+
                        p.getNoRepresentant()+separator+
                        new SimpleDateFormat("dd/MM/YYYY").format(p.getDateVisite()+separator+
                        p.getAdresse().getNo()+separator+
                        p.getAdresse().getRue()+separator+
                        p.getAdresse().getCompl()+separator+
                        p.getAdresse().getCp()+separator+
                        p.getAdresse().getVille()+separator+
                        p.getAdresse().getPays())+"\n";
                       

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
                        c.getMail()+separator+
                        c.getTelephone()+separator+
                        c.getSiret()+separator+
                        c.getNoRepresentant()+separator+
                        c.getNbCommandes()+separator+
                        c.getAdresse().getNo()+separator+
                        c.getAdresse().getRue()+separator+
                        c.getAdresse().getCompl()+separator+
                        c.getAdresse().getCp()+separator+
                        c.getAdresse().getVille()+separator+
                        c.getAdresse().getPays()+separator+"\n";
                    
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
    
    public static void close()
    {
        mysqlCli.close();
    }
    
    
    public static void sauveTableRep(HashMap<Integer,Representant> hashRep) 
    {
        
        mysqlCli.update("delete from `representant`;");
        for (Representant r : hashRep.values()) {
            String reqInsert = "INSERT INTO `representant`(`noRep`, `nomRep`, `prenomRep`, `tauxRep`, `salaireRep`, "
                        + "`adrNoRep`, `adrRueRep`, `adrComplRep`, `adrCPRep`, `adrVilleRep`, `adrPaysRep`) VALUES (";
            
            reqInsert += r.getNo()+ ",'"+r.getNom()+"','"+r.getPrenom()+"',"+r.getTxComm()+","+r.getSalaire()+","+
                         r.getAdresse().getNo()+",'"+r.getAdresse().getRue()+"','"+r.getAdresse().getCompl()+"',"+r.getAdresse().getCp()+ ",'"+
                         r.getAdresse().getVille()+"','"+r.getAdresse().getPays()+"');";
            mysqlCli.update(reqInsert);
            
        }   
    }


    public static void sauveTableClient(HashMap<Integer,Client> hashClient) 
    {
        
        mysqlCli.update("delete from `client`;");
        for (Client c : hashClient.values()) {
            String reqInsert ="INSERT INTO `client`(`noClient`, `enseigne`, `siret`, `mail`, `tel`, `nbComm`, `noRep`, "
                                + "`adrNoClient`, `adrRueClient`, `adrComplClient`, `adrCPClient`, `adrVilleClient`,`adrPaysClient`) VALUES (";
            
            reqInsert += c.getNo()+ ",'"+c.getEnseigne()+"','"+c.getSiret()+"','"+c.getMail()+"','"+c.getTelephone()+"',"+c.getNbCommandes()+","+
                         c.getNoRepresentant()+","+c.getAdresse().getNo()+",'"+c.getAdresse().getRue()+"','"+c.getAdresse().getCompl()+"',"+c.getAdresse().getCp()+ ",'"+
                         c.getAdresse().getVille()+"','"+c.getAdresse().getPays()+"');";
            mysqlCli.update(reqInsert);
            
        }   
    }
    
    public static void sauveTableProspect(HashMap<Integer,Prospect> hashProspect) 
    {
        
        mysqlCli.update("delete from `prospect`;");
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        
        for (Prospect p : hashProspect.values()) {
            String reqInsert = "INSERT INTO `prospect`(`noProspect`, `enseigne`, `siret`, `mail`, `tel`, `dateDerVisite`, `noRep`, "
                                + "`adrNoProspect`, `adrRueProspect`, `adrComplProspect`, `adrCPProspect`, `adrVilleProspect`, `AdrPaysProspect`) VALUES (";
            
            reqInsert += p.getNo()+ ",'"+p.getEnseigne()+"','"+p.getSiret()+"','"+p.getMail()+"','"+p.getTelephone()+"','"+
                         sdf.format(p.getDateVisite())+"',"+p.getNoRepresentant()+","+
                         p.getAdresse().getNo()+",'"+p.getAdresse().getRue()+"','"+p.getAdresse().getCompl()+"',"+p.getAdresse().getCp()+ ",'"+
                         p.getAdresse().getVille()+"','"+p.getAdresse().getPays()+"');";
            mysqlCli.update(reqInsert);
            
        }   
    }
    
}


