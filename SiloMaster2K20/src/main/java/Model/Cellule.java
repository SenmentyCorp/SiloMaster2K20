/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
        setChanged();
        notifyObservers();
    }
    
    public void setSuivant(ArrayList<Boisseau> _lstSuivant){
        this.lstSuivant = _lstSuivant;
    }

    @Override
    public void suivant() {
        List<Boisseau> boDispo = this.lstSuivant.stream()
                .filter(boisseau -> 
                    !boisseau.isPanne() && 
                    !boisseau.isPlein())
                .collect(Collectors.toList());
        
        if(boDispo.size() != 0){
            Boisseau boAModifier = boDispo.get(0);
            
            boAModifier.setLot(this.getLot());
            boAModifier.setPlein(true);
            
            this.setPlein(false);
            this.setLot(null);
            boAModifier.traitement();
        }  
    }

    public Ventilation getVent() {
        return vent;
    }
}
