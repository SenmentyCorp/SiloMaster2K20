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

    public void suivant(List<Boisseau> boisseaux) {
        for(int i =0; i<boisseaux.size();i++)
        {
            if(boisseaux.get(i).isPlein() ==false && boisseaux.get(i).isPanne() == false)
            {
                boisseaux.get(i).setLot(this.getLot());
                boisseaux.get(i).setPlein(true);
                this.setPlein(false);
                this.setLot(null);
            }
        }
    }
    
    @Override
    public void suivant() {
        setLot(null);

    }

    public Ventilation getVent() {
        return vent;
    }
}
