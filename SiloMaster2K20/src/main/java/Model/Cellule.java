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

    public Cellule(int id, Poste suivant) {
        super(id,suivant);
    }
    
    public Cellule(int id)
    {
        super(id);
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
                this.setPlein(false);
                this.setLot(null);
            }
        }
    }
    
}
