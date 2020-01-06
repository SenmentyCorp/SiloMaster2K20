/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import Model.*;
import Views.SiloMaster2K20;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
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
        
        SiloMaster2K20 slm = new SiloMaster2K20(GestionEvenement.getInstance().getArchivage().getLstPoste());
        slm.setVisible(true);
       
        Random rand = new Random();
        
        while(true){
        
            GestionEvenement.getInstance().creerCommande();
            List<Poste> po = GestionEvenement.getInstance().getArchivage().getLstPoste().stream().filter(
                                        poste ->
                                        poste.isPanne() == false 
                                        && poste.isPlein() == true
                                ).collect(Collectors.toList());
            
            if(po.size() != 0){
                Collections.shuffle(po);
                po.get(0).suivant();
            }
            
            if(rand.nextInt(100) < 3){
                
                po = GestionEvenement.getInstance().getArchivage().getLstPoste().stream().filter(
                                poste ->
                                poste.isPanne() == false 
                                && poste.isPlein() == true
                        ).collect(Collectors.toList());
                
                if(po.size() != 0){
                    Collections.shuffle(po);
                    po.get(0).setPanne(true);
                }
            }
            if(rand.nextInt(100) < 35){
               slm.getSilo().getAc().setHumiExt(slm.getSilo().getAc().humiExt+rand.nextInt(20)-10);
               slm.getSilo().getAc().setTemperatureExt(slm.getSilo().getAc().temperatureExt+rand.nextInt(12)-5);
            }
            
            
            List<Poste> cells = GestionEvenement.getInstance().getArchivage().getLstPoste().stream().filter(
                                poste ->
                                poste instanceof Cellule
                                && poste.isPlein() == true
                        ).collect(Collectors.toList());
            
            for(Poste c : cells){
                Cellule cell = (Cellule)c;
                float x = Math.abs(15-cell.getTemperature());
                cell.getVent().setPuissance((int)x*5);
                cell.getLstCapteur().stream().filter(
                                capt ->
                                capt.getTypeMesure() == "Temperature"
                ).forEach(capt -> capt.setValeur(capt.getValeur()*x));
            }
            
            try {
                Thread.sleep(1200);
            } catch (InterruptedException ex) {
                Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
