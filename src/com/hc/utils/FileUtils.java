/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hc.utils;

import com.hc.Entites.Adresse;
import com.hc.Entites.Client;
import com.hc.Entites.Prospect;
import com.hc.Entites.Representant;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 *
 * @author cflagollet
 */
public class FileUtils {
   
    private FileUtils() 
    {     
    }
    
    /*** Lecture d'un fichier dont le chemin est passé en paramètre
     *   renvoie une list de String 
     * @param chemin
     * @return
     * @throws FileNotFoundException 
     */
    
    public static List<String> litFichier(String chemin) throws FileNotFoundException
    {
        String line;
        List<String> lst = new ArrayList<String>();
        
        try
        {
            File f = new File (chemin);
            FileReader fr = new FileReader (f);
            BufferedReader br = new BufferedReader (fr);
            line="";
            try
            {
                while(line != null)
                {
                    line = br.readLine();
                    if (line!= null) 
                        lst.add(line);                   
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
        
        return lst;
        
    }
    
    public static HashMap<Integer,Representant> decodeRep(List<String> lst) 
    {        
        HashMap<Integer,Representant> hashRep = new HashMap<Integer,Representant>();
      
        for (String s : lst) {
            String[] ts = s.split(";");
                                                    
            Adresse n = new Adresse(Integer.parseInt(ts[5]),ts[6],Integer.parseInt(ts[7]),ts[8],ts[9]);
            try {
                Representant r = new Representant(  Integer.parseInt(ts[0]),
                                                    Double.parseDouble(ts[1]),
                                                    Double.parseDouble(ts[2]),
                                                    ts[3],
                                                    ts[4],
                                                    new Adresse(Integer.parseInt(ts[5]),ts[6],Integer.parseInt(ts[7]),ts[8],ts[9]));
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
            String[] ts = s.split(";");
                                                    
            Adresse n = new Adresse(Integer.parseInt(ts[2]),ts[3],Integer.parseInt(ts[4]),ts[5],ts[6]);
            try {
                Client c = new Client(  Integer.parseInt(ts[0]), // n, s, s, s, 0, 0);
                                                    ts[1],
                                                    n,
                                                    ts[7],
                                                    ts[8],                                                    
                                                    ts[9],               
                                                    Integer.parseInt(ts[10]),
                                                    Integer.parseInt(ts[11]));
                
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
            String[] ts = s.split(";");
                                                    
            Adresse n = new Adresse(Integer.parseInt(ts[2]),ts[3],Integer.parseInt(ts[4]),ts[5],ts[6]);
            try {
                Prospect p = new Prospect(Integer.parseInt(ts[0]), // n, s, s, s, 0, 0);
                                                    ts[1],
                                                    n,
                                                    ts[7],
                                                    ts[8],                                                    
                                                    ts[9],               
                                                    Integer.parseInt(ts[10]),
                                                    new SimpleDateFormat("dd/MM/YYYY").parse(ts[11]));
                hashProspect.put(Integer.parseInt(ts[0]), p);
            } catch (Exception e) {
                System.out.println("com.hc.utils.FileUtils.decodeRep()");
            }
            
        }
        
        return hashProspect;
    }
    
    public static List<String> codeFichierRep(HashMap<Integer,Representant> hashRep)
    {
        Set<Integer> setRep = hashRep.keySet();
        List<String> lstRep = new ArrayList<String>();
        
        for (Integer no : setRep) {
            Representant r = hashRep.get(no);
            String s =  no+";"+
                        r.getTxComm()+";"+
                        r.getSalaire()+";"+
                        r.getNom()+";"+
                        r.getPrenom()+";"+
                        r.getAdresse().getNo()+";"+
                        r.getAdresse().getRue()+";"+
                        r.getAdresse().getCp()+";"+
                        r.getAdresse().getVille()+";"+
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
            String s =  no+";"+
                        p.getEnseigne()+";"+                        
                        p.getAdresse().getNo()+";"+
                        p.getAdresse().getRue()+";"+
                        p.getAdresse().getCp()+";"+
                        p.getAdresse().getVille()+";"+
                        p.getAdresse().getPays()+";"+
                        p.getMail()+";"+
                        p.getTelephone()+";"+
                        p.getSiret()+";"+
                        p.getNoRepresentant()+";"+
                        new SimpleDateFormat("dd/MM/YYYY").format(p.getDateVisite());
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
            String s =  no+";"+
                        c.getEnseigne()+";"+                        
                        c.getAdresse().getNo()+";"+
                        c.getAdresse().getRue()+";"+
                        c.getAdresse().getCp()+";"+
                        c.getAdresse().getVille()+";"+
                        c.getAdresse().getPays()+";"+
                        c.getMail()+";"+
                        c.getTelephone()+";"+
                        c.getSiret()+";"+
                        c.getNoRepresentant()+";"+
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
                for (String s : lst)
                    br.write(s);
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


