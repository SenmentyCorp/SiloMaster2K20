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
public class FosseReceptionTest {
    
    private static FosseReception fr;
    private static Lot l;
    
    public FosseReceptionTest() {
    }
    
    @BeforeEach
    public static void setUp() {
        fr = new FosseReception(1,null);
        l = new Lot(1,"Type","Qualite",null);
        fr.setLot(l);
    }
    
    @AfterEach
    public static void tearDown() {
    }

    @Test
    public void testTraitement() {
        float poids = 100f;
        fr.getLot().setPoids(poids);
        fr.traitement();
        assertTrue(fr.getLot().getPoids()>=300);
        assertTrue(fr.getLot().getPoids()<=450);
    }
    
}
