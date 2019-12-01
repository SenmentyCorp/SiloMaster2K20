/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Alex-PC
 */
public class Lot {
    
    private int id;
    private String TypeCereale;
    private float poids;
    private String qualite;
    private Commande commande;
    private Poste poste;

    public int getId() {
        return id;
    }

    public String getTypeCereale() {
        return TypeCereale;
    }

    public float getPoids() {
        return poids;
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
    }
    
    /*
    Constucteur avec Poste
    */
    public Lot(int id, String TypeCereale, float poids, String qualite, Commande commande, Poste poste) {
        this.id = id;
        this.TypeCereale = TypeCereale;
        this.poids = poids;
        this.qualite = qualite;
        this.commande = commande;
        this.poste = poste;
    }

    /*
    Constucteur sans Poste
    */
    public Lot(int id, String TypeCereale, float poids, String qualite, Commande commande) {
        this.id = id;
        this.TypeCereale = TypeCereale;
        this.poids = poids;
        this.qualite = qualite;
        this.commande = commande;
    }
    
    
    
    
}
