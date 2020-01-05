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
    
    private ArrayList<Cellule> lstSuivant = new ArrayList<Cellule>();

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

    public void setSuivant(ArrayList<Cellule> _lstSuivant){
        this.lstSuivant = _lstSuivant;
    }

    @Override
    public void suivant() {
        boolean trouve = false;
        for(int i=0; i<this.lstSuivant.size();i++)
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

}
