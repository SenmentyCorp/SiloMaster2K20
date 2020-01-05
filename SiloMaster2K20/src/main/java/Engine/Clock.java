/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import Model.Boisseau;
import Model.Cellule;
import Model.FosseReception;
import Model.Tremie;


/**
 *
 * @author PC
 */
public class Clock implements Runnable {
    public void run()
    {
        GestionEvenement ge = new GestionEvenement();
        
        Cellule c1 = (Cellule) ge.creerPoste("Cellule", 1);
        Cellule c2 = (Cellule) ge.creerPoste("Cellule", 2);
        Cellule c3 = (Cellule) ge.creerPoste("Cellule", 3);
        Cellule c4 = (Cellule) ge.creerPoste("Cellule", 4);
        Cellule c5 = (Cellule) ge.creerPoste("Cellule", 5);
        Cellule c6 = (Cellule) ge.creerPoste("Cellule", 6);
        Cellule c7 = (Cellule) ge.creerPoste("Cellule", 7);
        Cellule c8 = (Cellule) ge.creerPoste("Cellule", 8);
        Cellule c9 = (Cellule) ge.creerPoste("Cellule", 9);
        Cellule c10 = (Cellule) ge.creerPoste("Cellule", 10);
        
        Boisseau bo1 = (Boisseau) ge.creerPoste("Boisseau", 1);
        Boisseau bo2 = (Boisseau) ge.creerPoste("Boisseau", 2);
        Boisseau bo3 = (Boisseau) ge.creerPoste("Boisseau", 3);
        
        FosseReception fr1 = (FosseReception) ge.creerPoste("FosseReception", 1);
        FosseReception fr2 = (FosseReception) ge.creerPoste("FosseReception", 2);
        
        Tremie tr1 = (Tremie) ge.creerPoste("Tremie", 1);
        Tremie tr2= (Tremie) ge.creerPoste("Tremie", 2);
        /*
        
        Tremie tr1 = new Tremie(1);
        Tremie tr2 = new Tremie(2);
        
        PontBascule pb1 = new PontBascule(1);*/
        
        while (true)
        {
            
        }
    }
}
