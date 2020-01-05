/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Alex-PC
 */
public abstract class Poste {
    
    private int id;
    private boolean panne;
    private boolean plein;
    private ArrayList<Capteur> lstCapteur;
    private Lot lot; 
    private Poste suivant;
    

    public Poste(int id, Poste suivant) {
        this.id = id;
        this.panne = false;
        this.plein = false;
        this.lstCapteur = new ArrayList<>();
        this.suivant = suivant;
    }

    public Poste(int id) {
        this.id = id;
        this.panne = false;
        this.plein = false;
        this.lstCapteur = new ArrayList<>();
        this.suivant = null;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPanne() {
        return panne;
    }

    public void setPanne(boolean panne) {
        this.panne = panne;
    }

    public boolean isPlein() {
        return plein;
    }

    public void setPlein(boolean plein) {
        this.plein = plein;
    }

    public ArrayList<Capteur> getLstCapteur() {
        return lstCapteur;
    }

    public void setLstCapteur(ArrayList<Capteur> lstCapteur) {
        this.lstCapteur = lstCapteur;
    }

    public Lot getLot() {
        return lot;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }
    
    public void ajouterCapteur(Capteur c){
        this.lstCapteur.add(c);
    }
    
    public void retirerCapteur(int id){
        for(int i=0; i< lstCapteur.size();i++){
            if(this.lstCapteur.get(i).getId()==id){
                lstCapteur.remove(i);
            }
        }
    }
    
    public void retirerCapteur(Capteur c){
        if(lstCapteur.contains(c)){
            lstCapteur.remove(c);
        }    
    }
         
    public Capteur chercherCapteur(int id){
        for(int i=0; i< lstCapteur.size();i++){
            if(this.lstCapteur.get(i).getId()==id){
                return lstCapteur.get(i);
            }
        }
        return null;
    }
    
    public void suivant() {
        if(this.suivant.isPlein() ==false && this.suivant.isPanne())
        {
            this.suivant.setPlein(true);
            this.suivant.setPanne(true);
            this.suivant.setLot(this.getLot());
        }
    }
      
    
    public abstract void traitement();

    
}
