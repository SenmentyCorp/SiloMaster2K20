/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import Controllers.*;
import Model.Boisseau;
import Model.Capteur;
import Model.Cellule;
import Model.Commande;
import Model.FosseReception;
import Model.Lot;
import Model.Poste;
import Model.Tremie;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


/**
 *
 * @author Alex-PC
 */
public final class GestionEvenement {
    
    private static volatile GestionEvenement instance = null;
    private float horloge = .0f;
    
    private ArchivageJSON archivage;
    private CommandeController commandeCtrl;
    private LotController lotCtrl;
    private PosteController posteCtrl;

    public ArchivageJSON getArchivage() {
        return archivage;
    }
    
    
    /*
    Constructeur
    */
    public GestionEvenement() {
        archivage = new ArchivageJSON();
        commandeCtrl = new CommandeController();
        lotCtrl = new LotController();
        posteCtrl = new PosteController();
    }
    
    public final static GestionEvenement getInstance(){
        if (GestionEvenement.instance == null){
            synchronized(GestionEvenement.class){
                if (GestionEvenement.instance == null){
                    GestionEvenement.instance = new GestionEvenement();
                }
            }
        }
        return GestionEvenement.instance;
    }
    
    public void creerCommande(){
        List<Poste> fossesLibres = this.archivage.getLstPoste().stream().filter(
                poste -> 
                poste instanceof FosseReception
                && poste.isPanne() == false 
                && poste.isPlein() == false
        ).collect(Collectors.toList());
        
        if(fossesLibres.size() != 0){
            
            int id = 0;

            if(this.archivage.getLstCommande().size() == 0){
                id = 1;
            }else{
                id = this.archivage.getLstCommande().get(this.archivage.getLstCommande().size() - 1).getId() + 1;
            } 

            Date arrivee = new Date(System.currentTimeMillis());
            Date depart = null;
            String desc = "";

            Commande newCommande = this.commandeCtrl.creerCommande(id, arrivee, depart, desc); 
            Lot newLot = (this.creerLot(newCommande, fossesLibres.get(0)));

            this.archivage.getLstCommande().add(newCommande);
            this.archivage.getLstLot().add(newLot);
            this.archivage.writeFileJSON();
        }   
    }
    
    private Lot creerLot(Commande c, Poste p){
        
        int id = 0;
        
        if(this.archivage.getLstLot().size() == 0){
            id = 1;
        }else{
            id = this.archivage.getLstLot().get(this.archivage.getLstLot().size() - 1).getId() + 1;
        } 
        
        String typeCereale = "";
        String qualite = "";
        
        Random rand = new Random();
        int valeur = rand.nextInt(5);
        
        switch(valeur){
            case 0:
                typeCereale = "Orge";
            break;
            case 1:
                typeCereale = "Malt";
            break;
            case 2:
                typeCereale = "Blé";
            break;
            case 3:
                typeCereale = "Maïs";
            break;
            case 4:
                typeCereale = "Houblon";
            break;
        }
        
        valeur = rand.nextInt(2);
        
        switch(valeur){
            case 0:
                qualite = "Moyen";
            break;
            case 1:
                qualite = "Bon";
            break;
            case 2:
                qualite = "Très bon";
            break;
        }
        
        Lot newLot = this.lotCtrl.creerLot(id, typeCereale, qualite, c);
        
        this.archivage.getLstLot().add(newLot);
        p.setLot(newLot);
        p.traitement();
        
        return newLot;
    }
    
    public void creerPostes()
    {
        this.archivage.readFileJSON();
        
        ArrayList<Boisseau> boisseaux = new ArrayList<Boisseau>(); 
        boisseaux.add(new Boisseau(1));
        boisseaux.add(new Boisseau(2));
        boisseaux.add(new Boisseau(3));
        
        ArrayList<Cellule> cellules = new ArrayList<Cellule>();
        cellules.add(new Cellule(1));
        cellules.add(new Cellule(2));
        cellules.add(new Cellule(3));
        cellules.add(new Cellule(4));
        cellules.add(new Cellule(5));
        cellules.add(new Cellule(6));
        cellules.add(new Cellule(7));
        cellules.add(new Cellule(8));
        cellules.add(new Cellule(9));
        cellules.add(new Cellule(10));
        
        for(Cellule c : cellules){
            c.setSuivant(boisseaux);
            c.ajouterCapteur(new Capteur(c.getId(),"Temperature",10));
            c.chercherCapteur(c.getId()).genererValeur("Temperature");
            c.ajouterCapteur(new Capteur(c.getId()+10,"Humidite",10));
            c.chercherCapteur(c.getId()+10).genererValeur("Humidite");
            this.archivage.getLstPoste().add(c);
        }
        
        for(Boisseau b : boisseaux){
            this.archivage.getLstPoste().add(b);
        }
        
        Tremie tr1 = new Tremie(1);
        Tremie tr2 = new Tremie(2);
        
        tr1.setSuivant(cellules);
        tr2.setSuivant(cellules);
        
        this.archivage.getLstPoste().add(tr1);
        this.archivage.getLstPoste().add(tr2);
        
        FosseReception fr1 = new FosseReception(1,tr1);
        FosseReception fr2 = new FosseReception(2,tr2);
        
        this.archivage.getLstPoste().add(fr1);
        this.archivage.getLstPoste().add(fr2);
        
    }
    
}
