/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import Model.*;
import java.util.ArrayList;

/**
 *
 * @author Alex-PC
 */
public class ArchivageJSON {
    
    private ArrayList<Commande> lstCommande;
    private ArrayList<Lot> lstLot;
    private ArrayList<Poste> lstPoste;    

    public ArrayList<Commande> getLstCommande() {
        return lstCommande;
    }

    public ArrayList<Lot> getLstLot() {
        return lstLot;
    }

    public ArrayList<Poste> getLstPoste() {
        return lstPoste;
    }

    public ArchivageJSON() {
        this.lstCommande = new ArrayList<Commande>();
        this.lstLot = new ArrayList<Lot>();
        this.lstPoste = new ArrayList<Poste>();
    }
    
    public void readFileJSON(){
         throw new UnsupportedOperationException("Not implemented yet");
    }
    
    public void writeFileJSON(){
        throw new UnsupportedOperationException("Not implemented yet");
    }

}
