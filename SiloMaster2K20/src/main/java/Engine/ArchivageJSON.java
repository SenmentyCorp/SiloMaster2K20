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
import java.io.BufferedReader;
import java.io.FileReader;

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

        //Lecture lots
        try{
            BufferedReader bfRd = new BufferedReader(new FileReader("lots.json"));
            this.lstLot = gson.fromJson(bfRd, ArrayList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Lecture postes
        try{
            BufferedReader bfRd = new BufferedReader(new FileReader("postes.json"));
            this.lstPoste = gson.fromJson(bfRd, ArrayList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Lecture commandes
        try{
            BufferedReader bfRd = new BufferedReader(new FileReader("commandes.json"));
            this.lstCommande = gson.fromJson(bfRd, ArrayList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void writeFileJSON(){

        final GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.create();

        Commande c = new Commande(1, Date.from(Instant.now()), Date.from(Instant.now()), "Les bonnes cereales");
        Lot l = new Lot(1, "Mais", 12, "Correcto", c);
        Lot ll = new Lot(2, "Mais", 16, "Moyenno", c);

        this.lstLot.add(l);
        this.lstLot.add(ll);

        this.lstCommande.add(c);

        String lots = gson.toJson(this.lstLot);
        String postes = gson.toJson(this.lstPoste);
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
