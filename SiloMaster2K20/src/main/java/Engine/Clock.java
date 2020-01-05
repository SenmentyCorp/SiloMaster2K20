/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import Model.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;


/**
 *
 * @author PC
 */
public class Clock implements Runnable {
    
    public void run(){       
       
        GestionEvenement.getInstance().creerPostes();
        
        while(true){
        
            GestionEvenement.getInstance().creerCommande();
            List<Poste> po = GestionEvenement.getInstance().getArchivage().getLstPoste().stream().filter(
                                        poste ->
                                        poste.isPanne() == false 
                                        && poste.isPlein() == true
                                ).collect(Collectors.toList());
            
            Collections.shuffle(po);
            po.get(0).suivant();
            
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
