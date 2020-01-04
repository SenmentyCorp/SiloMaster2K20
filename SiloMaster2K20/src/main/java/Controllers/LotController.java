/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Engine.GestionEvenement;
import Model.Commande;
import Model.Lot;

/**
 *
 * @author Alex-PC
 */
public class LotController {
    
    /*
    Constructeur vide
    */

    public LotController(){
        
    }
    
    public Lot creerLot(int id, String typeCereale, String qualite, Commande c){
        return new Lot(id, typeCereale, qualite, c);
    }
   
}
