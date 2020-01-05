/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lea
 */
public class Tremie extends Poste {

    public Tremie(int id, Poste suivant) {
        super(id,suivant);
    }
    
    public Tremie(int id)
    {
        super(id);
    }
    
    @Override
    public void traitement() {
        this.getLot().setPoids((float)((getLot().getPoids())*0.95));
        
    }  

    public void suivant(List<Cellule> cellules) {
        for(int i =0; i<cellules.size();i++)
        {
            if(cellules.get(i).isPlein() ==false && cellules.get(i).isPanne() == false)
            {
                cellules.get(i).setLot(this.getLot());
                cellules.get(i).setPlein(true);
                this.setPlein(false);
                this.setLot(null);
            }
        }
    }
}
