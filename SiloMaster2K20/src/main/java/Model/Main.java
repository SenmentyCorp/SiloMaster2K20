/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Engine.GestionEvenement;
import Engine.ArchivageJSON;
import Engine.Clock;
import Views.*;


/**
 *
 * @author Alex-PC
 */
public class Main {
    public static void main(String[] args) {
        
        Clock cl = new Clock();
        new Thread(cl).start();
       
       SiloMaster2K20 slm = new SiloMaster2K20(GestionEvenement.getInstance().getArchivage().getLstPoste());
       slm.setVisible(true);
    }
}


