/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
/**
 *
 * @author Alex-PC
 */
public abstract class Poste {
    
    private int id;
    private boolean panne;
    private boolean plein;
    private ArrayList<Capteur> lstCapteur;

    public Poste(int id) {
        this.id = id;
        this.panne = false;
        this.plein = false;
        this.lstCapteur = new ArrayList<>();
    }
    
    
}
