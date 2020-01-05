/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Lea
 */
public class Cellule extends Poste {
    
    private ArrayList<Boisseau> lstSuivant = new ArrayList<Boisseau>();
    public static final int poidsMax = 500;
    private Ventilation vent;

    public Cellule(int id, Poste suivant) {
        super(id,suivant);
    }
    
    public Cellule(int id) {
        super(id);
        this.vent=new Ventilation();
    }

    @Override
    public void traitement() {

    }
    
    public void setSuivant(ArrayList<Boisseau> _lstSuivant){
        this.lstSuivant = _lstSuivant;
    }

    @Override
    public void suivant() {
        boolean trouve = false;
        for(int i =0; i<lstSuivant.size();i++)
        {
            if(lstSuivant.get(i).isPlein() == false && lstSuivant.get(i).isPanne() == false && trouve == false)
            {
                trouve = true;
                lstSuivant.get(i).setLot(this.getLot());
                lstSuivant.get(i).setPlein(true);
                this.setPlein(false);
                this.setLot(null);
            }
        }
    }

    public Ventilation getVent() {
        return vent;
    }
}
