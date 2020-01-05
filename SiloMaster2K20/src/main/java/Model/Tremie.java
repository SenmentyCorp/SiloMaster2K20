/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Lea
 */
public class Tremie extends Poste {

    public Tremie(int id) {
        super(id);
    }

    @Override
    public void traitement() {
        this.getLot().setPoids((float)((getLot().getPoids())*0.95));
        
    }  

    @Override
    public void suivant(ArrayList<Poste> suivants) {
        
        
    }
}
