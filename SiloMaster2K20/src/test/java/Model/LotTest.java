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
public class LotTest {
    
    public LotTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Lot.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Lot instance = null;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTypeCereale method, of class Lot.
     */
    @Test
    public void testGetTypeCereale() {
        System.out.println("getTypeCereale");
        Lot instance = null;
        String expResult = "";
        String result = instance.getTypeCereale();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPoids method, of class Lot.
     */
    @Test
    public void testGetPoids() {
        System.out.println("getPoids");
        Lot instance = null;
        float expResult = 0.0F;
        float result = instance.getPoids();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQualite method, of class Lot.
     */
    @Test
    public void testGetQualite() {
        System.out.println("getQualite");
        Lot instance = null;
        String expResult = "";
        String result = instance.getQualite();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCommande method, of class Lot.
     */
    @Test
    public void testGetCommande() {
        System.out.println("getCommande");
        Lot instance = null;
        Commande expResult = null;
        Commande result = instance.getCommande();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPoste method, of class Lot.
     */
    @Test
    public void testGetPoste() {
        System.out.println("getPoste");
        Lot instance = null;
        Poste expResult = null;
        Poste result = instance.getPoste();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPoste method, of class Lot.
     */
    @Test
    public void testSetPoste() {
        System.out.println("setPoste");
        Poste poste = null;
        Lot instance = null;
        instance.setPoste(poste);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Lot.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Lot instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Lot.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Lot instance = null;
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
