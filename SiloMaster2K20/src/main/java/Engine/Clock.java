/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import Model.Boisseau;
import Model.Cellule;
import Model.FosseReception;
import Model.PontBascule;
import Model.Tremie;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author PC
 */
public class Clock implements Runnable {
    public void run()
    {   
        List<Cellule> cellules = new ArrayList<Cellule>();
        
        
        cellules.add((Cellule) GestionEvenement.getInstance().creerPoste("Cellule", 1));
        cellules.add((Cellule) GestionEvenement.getInstance().creerPoste("Cellule", 2));
        cellules.add((Cellule) GestionEvenement.getInstance().creerPoste("Cellule", 3));
        cellules.add((Cellule) GestionEvenement.getInstance().creerPoste("Cellule", 4));
        cellules.add((Cellule) GestionEvenement.getInstance().creerPoste("Cellule", 5));
        cellules.add((Cellule) GestionEvenement.getInstance().creerPoste("Cellule", 6));
        cellules.add((Cellule) GestionEvenement.getInstance().creerPoste("Cellule", 7));
        cellules.add((Cellule) GestionEvenement.getInstance().creerPoste("Cellule", 8));
        cellules.add((Cellule) GestionEvenement.getInstance().creerPoste("Cellule", 9));
        cellules.add((Cellule) GestionEvenement.getInstance().creerPoste("Cellule", 10));
        
        List<Boisseau> Boisseaux = new ArrayList<Boisseau>();
        
        Boisseaux.add((Boisseau) GestionEvenement.getInstance().creerPoste("Boisseau", 1));
        Boisseaux.add((Boisseau) GestionEvenement.getInstance().creerPoste("Boisseau", 2));
        Boisseaux.add((Boisseau) GestionEvenement.getInstance().creerPoste("Boisseau", 3));
        
        List<FosseReception> FosseReceptions = new ArrayList<FosseReception>();
        
        FosseReceptions.add((FosseReception) GestionEvenement.getInstance().creerPoste("FosseReception", 1));
        FosseReceptions.add((FosseReception) GestionEvenement.getInstance().creerPoste("FosseReception", 2));
        
        List<Tremie> tremies = new ArrayList<Tremie>();
        
        tremies.add((Tremie) GestionEvenement.getInstance().creerPoste("Tremie", 1));
        tremies.add((Tremie) GestionEvenement.getInstance().creerPoste("Tremie", 2));
        
        PontBascule pb1 = (PontBascule) GestionEvenement.getInstance().creerPoste("PontBascule", 1);
        
        
        
        while (true)
        {
            double chanceNouveauLot =  Math.ceil(Math.random() * 10);
            if(chanceNouveauLot<=1)
            {
                
            }
        }
    }
}
