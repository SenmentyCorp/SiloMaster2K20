/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import Controllers.*;
import Model.Commande;
import Model.Lot;
import java.util.Date;

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
        
        Lot newLot = this.lotCtrl.creerLot(id, typeCereale, poids, qualite, c);
        
        this.archivage.getLstLot().add(newLot);
        
        return newLot;
    }
}
