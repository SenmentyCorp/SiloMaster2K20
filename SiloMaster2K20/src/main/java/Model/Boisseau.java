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

    public Boisseau(int id) {
        super(id);
    }

    @Override
    public void traitement() {
        this.getLot().setTraitementTermine(true);
        this.getLot().getCommande().setTraitementTermine(true);
        this.setLot(null);
        this.setPlein(false);
    }  
}
