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
    

    public Poste(int id) {
        this.id = id;
        this.panne = false;
        this.plein = false;
        this.lstCapteur = new ArrayList<>();
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
    
    public void suivant(ArrayList<Poste> suivants) {
        boolean libre = false;
        while(libre==false)
        {
            int i=0;
            while(i<suivants.size() && libre==false)
            {
                if(suivants.get(i).isPlein()==false && suivants.get(i).isPanne() == false)
                {
                    suivants.get(i).setLot(this.getLot());
                    this.setLot(null);
                    this.setPlein(false);
                    libre = true;
                }
            }
        }
    }
      
    
    public abstract void traitement();

    
}
