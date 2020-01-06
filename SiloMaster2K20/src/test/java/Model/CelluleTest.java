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
public class CelluleTest {
    
    private static Cellule cell_vide, cell_panne, cell_plein, cell_ok;
    private static ArrayList<Boisseau> listeBo_vide, listeBo_panne, listeBo_plein, listeBo_ok;
    private static Boisseau bo_panne, bo_plein, bo_ok;
    private static Lot lot;
    private static Commande c;
    
    public CelluleTest() {
    }

    @BeforeEach
    public static void setUp() {
        c = new Commande(1,null,null,"desc");
        lot = new Lot(1,"Type","Qualite",c);
        
        bo_panne = mock(Boisseau.class);
        when(bo_panne.isPanne()).thenReturn(true);
        when(bo_panne.isPlein()).thenReturn(false);
        
        bo_plein = mock(Boisseau.class);
        when(bo_plein.isPlein()).thenReturn(true);
        when(bo_plein.isPanne()).thenReturn(false);
        
        bo_ok = new Boisseau(1);
        
        cell_vide = new Cellule(1);
        listeBo_vide = new ArrayList<Boisseau>();
        cell_vide.setSuivant(listeBo_vide);
        cell_vide.setLot(lot);
         
        cell_panne = new Cellule(2);
        listeBo_panne = new ArrayList<Boisseau>();
        listeBo_panne.add(bo_panne);
        listeBo_panne.add(bo_panne);
        listeBo_panne.add(bo_panne);
        cell_panne.setSuivant(listeBo_panne);
        cell_panne.setLot(lot);
        
        cell_plein = new Cellule(3);
        listeBo_plein = new ArrayList<Boisseau>();
        listeBo_plein.add(bo_plein);
        listeBo_plein.add(bo_plein);
        listeBo_plein.add(bo_plein);
        cell_plein.setSuivant(listeBo_plein);
        cell_plein.setLot(lot);
        
        cell_ok = new Cellule(4);
        listeBo_ok = new ArrayList<Boisseau>();
        listeBo_ok.add(bo_panne);
        listeBo_ok.add(bo_plein);
        listeBo_ok.add(bo_ok);
        cell_ok.setSuivant(listeBo_ok);
        cell_ok.setLot(lot);
    }
    
    @AfterEach
    public static void tearDown() {
        
    }

    @Test
    public void testTraitement() {
        
    }

    @Test
    public void testSuivant_vide() {
        // Traitement quand suivant vide, cellule ne se vide pas
        cell_vide.suivant();
        assertEquals(cell_vide.isPlein(),true);
        assertEquals(cell_vide.getLot(),lot);
    }
    
    @Test
    public void testSuivant_panne() {
        // Traitement quand suivants en panne, cellule ne se vide pas
        cell_panne.suivant();
        assertEquals(cell_panne.isPlein(),true);
        assertEquals(cell_panne.getLot(),lot);
    }
    
    @Test
    public void testSuivant_plein() {
        // Traitement quand suivants pleins, cellule ne se vide pas
        cell_plein.suivant();
        assertEquals(cell_plein.isPlein(),true);
        assertEquals(cell_plein.getLot(),lot);
    }
    
    @Test
    public void testSuivant_ok() {
        // Traitement quand suivant dispo, cellule se vide, boisseau est traite
        cell_ok.suivant();
        
        // Traitement boisseau
        assertEquals(lot.isTraitementTermine(),true);
        assertEquals(c.isTraitementTermine(),true);
        
        assertEquals(cell_ok.isPlein(),false);
        assertEquals(cell_ok.getLot(),null);
    }

    
}
