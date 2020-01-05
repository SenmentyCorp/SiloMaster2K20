/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import Controllers.*;
import Model.Boisseau;
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
        int id = 0;
        
        if(this.archivage.getLstCommande().size() == 0){
            id = 1;
        }else{
            id = this.archivage.getLstCommande().get(this.archivage.getLstCommande().size() - 1).getId() + 1;
        } 
        
        Date arrivee = new Date(System.currentTimeMillis());
        Date depart = null;
        String desc = "rien";
        
        Commande newCommande = this.commandeCtrl.creerCommande(id, arrivee, depart, desc); 
        newCommande.setLot(this.creerLot(newCommande));
        
        this.archivage.getLstCommande().add(newCommande);
    }
    
    private Lot creerLot(Commande c){
        
        int id = 0;
        
        if(this.archivage.getLstLot().size() == 0){
            id = 1;
        }else{
            id = this.archivage.getLstLot().get(this.archivage.getLstLot().size() - 1).getId() + 1;
        } 
  
        String typeCereale = "random";
        float poids = 10.0f;
        String qualite = "random";
        
        Lot newLot = this.lotCtrl.creerLot(id, typeCereale, qualite, c);
        
        this.archivage.getLstLot().add(newLot);
        
        return newLot;
    }
    
    public void creerPostes()
    {
        List<Boisseau> boisseaux = new ArrayList<Boisseau>(); 
        boisseaux.add(new Boisseau(1,null));
        boisseaux.add(new Boisseau(2,null));
        boisseaux.add(new Boisseau(3,null));
        
        List<Cellule> cellules = new ArrayList<Cellule>();
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
        
        Tremie tr1 = new Tremie(1);
        Tremie tr2 = new Tremie(2);
        
        FosseReception fr1 = new FosseReception(1,tr1);
        FosseReception fr2 = new FosseReception(2,tr2);
        
    }
    
}
