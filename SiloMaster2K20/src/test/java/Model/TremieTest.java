/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Lucas
 */
public class TremieTest {
    
    private static Tremie tr_vide, tr_panne, tr_plein, tr_ok, tr_poids;
    private static ArrayList<Cellule> listeCell_vide, listeCell_panne, listeCell_plein, listeCell_ok;
    private static Cellule cell_panne, cell_plein, cell_ok;
    private static Lot lot, lot_poids;
    
    public TremieTest() {
    }
    
    @BeforeEach
    public static void setUp() {
        lot = mock(Lot.class);
        
        cell_panne = mock(Cellule.class);
        when(cell_panne.isPanne()).thenReturn(true);
        when(cell_panne.isPlein()).thenReturn(false);
        
        cell_plein = mock(Cellule.class);
        when(cell_plein.isPlein()).thenReturn(true);
        when(cell_plein.isPanne()).thenReturn(false);
        
        cell_ok = new Cellule(1);
        
        
        tr_vide = new Tremie(1);
        listeCell_vide = new ArrayList<Cellule>();
        tr_vide.setSuivant(listeCell_vide);
        tr_vide.setLot(lot);
         
        tr_panne = new Tremie(2);
        listeCell_panne = new ArrayList<Cellule>();
        listeCell_panne.add(cell_panne);
        listeCell_panne.add(cell_panne);
        listeCell_panne.add(cell_panne);
        tr_panne.setSuivant(listeCell_panne);
        tr_panne.setLot(lot);
        
        tr_plein = new Tremie(3);
        listeCell_plein = new ArrayList<Cellule>();
        listeCell_plein.add(cell_panne);
        listeCell_plein.add(cell_panne);
        listeCell_plein.add(cell_panne);
        tr_plein.setSuivant(listeCell_plein);
        tr_plein.setLot(lot);
        
        tr_ok = new Tremie(4);
        listeCell_ok = new ArrayList<Cellule>();
        listeCell_ok.add(cell_panne);
        listeCell_ok.add(cell_plein);
        listeCell_ok.add(cell_ok);
        tr_ok.setSuivant(listeCell_ok);
        tr_ok.setLot(lot);
        
        lot_poids = new Lot(1,"Type","Qualite",null);
        tr_poids = new Tremie(5);
        tr_poids.setLot(lot_poids);
    }
    
    @AfterEach
    public static void tearDown() {
    }

    @Test
    public void testTraitement() {
        // Traitement, reduction du poids du lot
        float poids = 100f;
        tr_poids.getLot().setPoids(poids);
        tr_poids.traitement();
        assertEquals(tr_poids.getLot().getPoids(),poids*0.95f);
        
    }
    
    @Test
    public void testSuivant_vide() {
        // Traitement quand suivant vide, tremie ne se vide pas
        tr_vide.suivant();
        assertEquals(tr_vide.isPlein(),true);
        assertEquals(tr_vide.getLot(),lot);
    }
    
    @Test
    public void testSuivant_panne() {
        // Traitement quand suivants en panne, tremie ne se vide pas
        tr_panne.suivant();
        assertEquals(tr_panne.isPlein(),true);
        assertEquals(tr_panne.getLot(),lot);
    }
    
    @Test
    public void testSuivant_plein() {
        // Traitement quand suivants pleins, tremie ne se vide pas
        tr_plein.suivant();
        assertEquals(tr_plein.isPlein(),true);
        assertEquals(tr_plein.getLot(),lot);
    }
    
    @Test
    public void testSuivant_ok() {
        // Traitement quand suivant dispo, tremie se vide, cellule se remplit
        tr_ok.suivant();
        assertEquals(cell_ok.getLot(),lot);
        assertEquals(cell_ok.isPlein(),true);
        assertEquals(tr_ok.isPlein(),false);
        assertEquals(tr_ok.getLot(),null);
    }
    
}
