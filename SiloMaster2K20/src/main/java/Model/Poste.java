/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Alex-PC
 */
public abstract class Poste {
    
    private int id;
    private boolean panne;
    private boolean plein;

    public Poste(int id) {
        this.id = id;
        this.panne = false;
        this.plein = false;
    }
    
    
}
