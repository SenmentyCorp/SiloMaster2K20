/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Flavien
 */
public class Silo {

    private ArrayList<Cellule> cellules;

    public ArrayList<Cellule> getCellules() {
        return cellules;
    }
    public AC ac;
    public int volume;

    public Silo() {
        cellules = new ArrayList<Cellule>();
        for (int i = 0; i < 10; i++) {
            cellules.add(new Cellule(cellules.size() + 1));
        }
        for (Cellule c : cellules) {
            c.setLot(new Lot(1,"aaa","bbb",new Commande(2,new Date(),new Date(),"ccc")));
        }
        this.volume = Cellule.poidsMax * cellules.size();
        this.ac = new AC();
    }
}
