/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Engine.GestionEvenement;
import Model.Commande;
import java.util.Date;

/**
 *
 * @author Alex-PC
 */
public class CommandeController {

    /*
    Constructeur vide
    */
    public CommandeController() {
    }

    public Commande creerCommande(int id, Date arrivee, Date depart, String description){  
        return new Commande(id, arrivee, depart, description);
    }    
}
