/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Lucas
 */
public class VentilationTest {
    
    private static Ventilation v;
    
    public VentilationTest() {
    }

    @BeforeEach
    public static void setUp() {
        v = new Ventilation();
    }
    
    @AfterEach
    public static void tearDown() {
    }

    @Test
    public void testSetPuissance() {
        // Puissance correcte
        v.setPuissance(50);
        assertEquals(v.getPuissance(),50);
    }
    
    @Test
    public void testSetPuissance_MauvaiseValeur() {
        // Quand puissance pas entre 0 et 100
        v.setPuissance(101);
        assertFalse(v.getPuissance()==101);
        assertEquals(v.getPuissance(),0);
    }
    
}
