/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Engine.GestionEvenement;
import java.util.ArrayList;

/**
 *
 * @author Lea
 */
public class Boisseau extends Poste {

    public Boisseau(int id, Poste suivant) {
        super(id,suivant);
    }

    @Override
    public void traitement() {
        setChanged();
        notifyObservers();
    }  
        
        
    @Override
    public void suivant() {
        this.getLot().setTraitementTermine(true);
        this.getLot().getCommande().setTraitementTermine(true);
        this.setLot(null);
        this.setPlein(false);
        setChanged();
        notifyObservers();
        GestionEvenement.getInstance().getArchivage().writeFileJSON();
    }
}
