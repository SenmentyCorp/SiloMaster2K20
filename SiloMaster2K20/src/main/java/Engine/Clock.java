/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import Model.*;
import Views.SiloMaster2K20;
import java.text.DecimalFormat;
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

    public void run() {

        GestionEvenement.getInstance().creerPostes();

        SiloMaster2K20 slm = new SiloMaster2K20(GestionEvenement.getInstance().getArchivage().getLstPoste());
        slm.setVisible(true);

        Random rand = new Random();

        while (true) {

            GestionEvenement.getInstance().creerCommande();
            List<Poste> po = GestionEvenement.getInstance().getArchivage().getLstPoste().stream().filter(
                    poste
                    -> poste.isPanne() == false
                    && poste.isPlein() == true
            ).collect(Collectors.toList());

            if (po.size() != 0) {
                Collections.shuffle(po);
                po.get(0).suivant();
            }

            if (rand.nextInt(100) < 3) {

                po = GestionEvenement.getInstance().getArchivage().getLstPoste().stream().filter(
                        poste
                        -> poste.isPanne() == false
                        && poste.isPlein() == true
                ).collect(Collectors.toList());

                if (po.size() != 0) {
                    Collections.shuffle(po);
                    po.get(0).setPanne(true);
                }
            }
            if (rand.nextInt(100) < 30) {
                float temp = slm.getSilo().getAc().humiExt;
                float sign = (Math.random() < 1) ? 1 : -1;
                if (temp > 5 && temp < 95) {
                    temp += rand.nextFloat() * sign * AC.inertie;
                } else {
                    if (temp <= 5) {
                        temp += rand.nextFloat() * 1.0 * AC.inertie;
                    }
                    if (temp >= 95) {
                        temp += rand.nextFloat() * -1.0 * AC.inertie;
                    }
                }

                slm.getSilo().getAc().setHumiExt(temp);

                float temp2 = slm.getSilo().getAc().temperatureExt;
                float sign2 = (Math.random() < 0.5) ? 1 : -1;
                temp2 += rand.nextFloat() * sign2 * AC.inertie;
                slm.getSilo().getAc().setTemperatureExt(temp2);
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
