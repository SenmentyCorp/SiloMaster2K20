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
public class Cellule extends Poste {

    public Cellule(int id) {
        super(id);
    }

    @Override
    public void traitement() {
        
        
    }  

    @Override
    public void suivant() {
        setLot(null);
        
    }
    
}