/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        List<Cellule> cellDispo = this.lstSuivant.stream()
                .filter(cell -> 
                    !cell.isPanne() && 
                    !cell.isPlein())
                .collect(Collectors.toList());
        
        if(cellDispo.size() != 0){
            Cellule cellAModifier = cellDispo.get(0);
            
            cellAModifier.setLot(this.getLot());
            cellAModifier.setPlein(true);
            
            this.setPlein(false);
            this.setLot(null);
        }
    }

}
