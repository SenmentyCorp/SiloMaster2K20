/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import Model.*;

import java.io.*;
import java.time.Instant;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;

import java.util.Date;

/**
 *
 * @author Alex-PC
 */
public class ArchivageJSON {
    
    private ArrayList<Commande> lstCommande;
    private ArrayList<Lot> lstLot;
    private ArrayList<Poste> lstPoste;    

    public ArrayList<Commande> getLstCommande() {
        return lstCommande;
    }

    public ArrayList<Lot> getLstLot() {
        return lstLot;
    }

    public ArrayList<Poste> getLstPoste() {
        return lstPoste;
    }

    public ArchivageJSON() {
        this.lstCommande = new ArrayList<Commande>();
        this.lstLot = new ArrayList<Lot>();
        this.lstPoste = new ArrayList<Poste>();
    }
    
    public void readFileJSON(){

        final GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.create();

        this.lstCommande.clear();
        this.lstLot.clear();
        this.lstPoste.clear();

        //Lecture lots
        try{
            File fLot = new File("lots.json");
            if(fLot.exists()){
                BufferedReader bfRd = new BufferedReader(new FileReader("lots.json"));
                this.lstLot = gson.fromJson(bfRd, new TypeToken<ArrayList<Lot>>(){}.getType());   
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        /*          --- Non fonctionnel ---
        ArrayList<Cellule> lTemp = new ArrayList<Cellule>();
        //Lecture postes
        try{
            File fLot = new File("postes.json");
            if(fLot.exists()){
                BufferedReader bfRd = new BufferedReader(new FileReader("postes.json"));
                this.lstPoste = gson.fromJson(bfRd, new TypeToken<ArrayList<Poste>>(){}.getType()); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        
        //Lecture commandes
        try{
            File fLot = new File("commandes.json");
            if(fLot.exists()){
                BufferedReader bfRd = new BufferedReader(new FileReader("commandes.json"));
                this.lstCommande = gson.fromJson(bfRd, new TypeToken<ArrayList<Commande>>(){}.getType());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void writeFileJSON(){

        final GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.create();
        
        
        ArrayList<Poste> alPoste = (ArrayList<Poste>) this.lstPoste.clone();
        Collections.copy(alPoste, this.lstPoste);
        
        for(Poste p : alPoste){
            p.deleteObservers();
        }
        
        String postes = gson.toJson(alPoste);
        
        
        String lots = gson.toJson(this.lstLot);
        String commandes = gson.toJson(this.lstCommande);

        //Ecriture des lots
        try {
            File file = new File("lots.json");

            // créer le fichier s'il n'existe pas
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(lots);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Ecriture des postes
        try {
            File file = new File("postes.json");

            // créer le fichier s'il n'existe pas
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(postes);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //Ecriture des commandes
        try {
            File file = new File("commandes.json");

            // créer le fichier s'il n'existe pas
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(commandes);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
