/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.Poste;
import Model.Boisseau;
import Model.Cellule;
import Model.FosseReception;
import Model.PontBascule;
import Model.Tremie;

/**
 *
 * @author PC
 */
public class PosteController {
    public PosteController(){
        
    }
    
    public Poste creerPoste(String type, int id)
    {
        Poste poste=null;
        if (type == "Boisseau")
        {
            poste = new Boisseau(id);
        }
        if (type == "Cellule")
        {
            poste = new Cellule(id);
        }
        if (type == "FosseReception")
        {
            poste = new FosseReception(id);
        }
        if (type == "PontBascule")
        {
            poste = new Boisseau(id);
        }
        if (type == "Tremie")
        {
            poste = new Boisseau(id);
        }
        return poste;
    }
            
}
