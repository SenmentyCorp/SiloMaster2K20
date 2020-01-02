/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Lea
 */
public class FosseReception extends Poste {

    public FosseReception(int id) {
        super(id);
    }

    @Override
    public void traitement() {
        this.getLot().setPoids((float)(Math.random()*150000 + 300000));
        
    }  

    @Override
    public void suivant() {
        
        
    }
}
