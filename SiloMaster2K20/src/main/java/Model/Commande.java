/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Alex-PC
 */
public class Commande {
    
    private int id;
    private Date arrivee;
    private Date depart;
    private String description;
    private Lot lot;
    private boolean traitementTermine;

    public boolean isTraitementTermine() {
        return traitementTermine;
    }

    public void setTraitementTermine(boolean estTraite) {
        this.traitementTermine = estTraite;
    }
    

    public int getId() {
        return id;
    }

    public Date getArrivee() {
        return arrivee;
    }

    public Date getDepart() {
        return depart;
    }

    public String getDescription() {
        return description;
    }

    public Lot getLot() {
        return lot;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }
    
    /*
    Constructeur avec Lot en paramètre
    */
    public Commande(int id, Date arrivee, Date depart, String description, Lot lot) {
        this.id = id;
        this.arrivee = arrivee;
        this.depart = depart;
        this.description = description;
        this.lot = lot;
        this.traitementTermine = false;
    } 

    /*
    Constructeur sans Lot en paramètre
    */
    public Commande(int id, Date arrivee, Date depart, String description) {
        this.id = id;
        this.arrivee = arrivee;
        this.depart = depart;
        this.description = description;
        this.traitementTermine = false;
    }
    
    @Override
    public String toString() {
        return " ID : " +this.id + "\n ARRIVEE: " + this.arrivee + "\n DEPART: " + this.depart + "\n DESCRIPTION: " + this.description; 
    }
    
    @Override
    public boolean equals(Object o){
        if(o.getClass() == Commande.class){
            Commande test = (Commande)(o);
            
            return test.getId()==this.id;
        }else{
            return false;
        }
    }
}
