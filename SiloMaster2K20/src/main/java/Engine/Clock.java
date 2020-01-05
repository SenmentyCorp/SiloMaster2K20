/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import Model.Boisseau;
import Model.Cellule;
import Model.FosseReception;
import Model.PontBascule;
import Model.Tremie;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author PC
 */
public class Clock implements Runnable {
    public void run()
    {       
        GestionEvenement.getInstance().creerPostes();
    }
}
