/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Observable;

/**
 *
 * @author Alex-PC
 */
public class Lot extends Observable{
    
    private int id;
    private String TypeCereale;
    private float poids;
    private String qualite;
    private Commande commande;
    private Poste poste;
    private boolean traitementTermine;

    public boolean isTraitementTermine() {
        return traitementTermine;
    }

    public void setTraitementTermine(boolean traitementTermine) {
        this.traitementTermine = traitementTermine;
    }

    public int getId() {
        return id;
    }

    public String getTypeCereale() {
        return TypeCereale;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
        setChanged();
        notifyObservers();
    }

    public String getQualite() {
        return qualite;
    }

    public Commande getCommande() {
        return commande;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
        setChanged();
        notifyObservers();
    }
    
    /*
    Constucteur avec Poste
    */
    public Lot(int id, String TypeCereale, String qualite, Commande commande, Poste poste) {
        this.id = id;
        this.TypeCereale = TypeCereale;
        this.qualite = qualite;
        this.commande = commande;
        this.poste = poste;
        this.traitementTermine = false;
    }

    /*
    Constucteur sans Poste
    */
    public Lot(int id, String TypeCereale, String qualite, Commande commande) {
        this.id = id;
        this.TypeCereale = TypeCereale;
        this.qualite = qualite;
        this.commande = commande;
        this.traitementTermine = false;
    }

    @Override
    public String toString() {
        return " ID : " +this.id + "\n TYPE: " + this.TypeCereale + "\n POIDS: " + this.poids + "\n QUALITE: " + this.qualite; 
    }
    
    @Override
    public boolean equals(Object o){
        if(o.getClass() == Lot.class){
            Lot test = (Lot)(o);
            
            return test.getId()==this.id;
        }else{
            return false;
        }
    }
    
}
