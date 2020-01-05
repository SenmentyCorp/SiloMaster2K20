/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;


/**
 *
 * @author PC
 */
public class PontBascule extends Poste{
    public PontBascule(int id, Poste suivant) {
        super(id,suivant);
    }

    @Override
    public void traitement() {
        float poid= (float) (1+Math.ceil(Math.random() * 10));
        this.getLot().setPoids(poid);
    }  

    @Override
    public void suivant(ArrayList<Poste> suivants) {
        
        
    }
    
}
