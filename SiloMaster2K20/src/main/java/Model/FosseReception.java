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
public class FosseReception extends Poste {

    public FosseReception(int id, Poste suivant) {
        super(id,suivant);
    }

    @Override
    public void traitement() {
        this.getLot().setPoids((float)(Math.random()*150000 + 300000));
        
    }  

    @Override
    public void suivant(ArrayList<Poste> suivants) {
        
        
    }
}
