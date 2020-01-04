/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Engine.GestionEvenement;
import Engine.ArchivageJSON;


/**
 *
 * @author Alex-PC
 */
public class Main {
    public static void main(String[] args) {
        GestionEvenement.getInstance().creerCommande();   
        
        //System.out.println(GestionEvenement.getInstance().getArchivage().getLstCommande().get(0).toString());
        //System.out.println(GestionEvenement.getInstance().getArchivage().getLstCommande().get(0).getLot().toString());

        ArchivageJSON arch = new ArchivageJSON();
        //arch.writeFileJSON();
        arch.readFileJSON();
    }
}
