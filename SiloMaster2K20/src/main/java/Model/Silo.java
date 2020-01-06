/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Engine.GestionEvenement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.stream.Collectors;

/**
 *
 * @author Flavien
 */
public class Silo{

    private ArrayList<Cellule> cellules;

    public ArrayList<Cellule> getCellules() {
        return cellules;
    }
    
    private AC ac;
    private int volume;

    public AC getAc() {
        return ac;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Silo() {
        List<Poste> postesCell = GestionEvenement.getInstance().getArchivage().getLstPoste().stream().filter(
                poste -> 
                poste instanceof Cellule).collect(Collectors.toList());
        
        cellules = new ArrayList(postesCell);
        
        this.volume = Cellule.poidsMax * cellules.size();
        this.ac = new AC();
    }
}
