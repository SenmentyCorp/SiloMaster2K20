/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

/**
 *
 * @author Alex-PC
 */
public final class GestionEvenement {
    
    private static volatile GestionEvenement instance = null;
    private float horloge = .0f;
    
    /*
    Constructeur vide
    */
    public GestionEvenement() {
        
    }
    
    
    public final static GestionEvenement getInstance(){
        if (GestionEvenement.instance == null){
            synchronized(GestionEvenement.class){
                if (GestionEvenement.instance == null){
                    GestionEvenement.instance = new GestionEvenement();
                }
            }
        }
        return GestionEvenement.instance;
    }
    
    
}
