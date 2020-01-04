/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;
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
public class CommandeTest {
    
    public CommandeTest() {
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
     * Test of getId method, of class Commande.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Commande instance = null;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getArrivee method, of class Commande.
     */
    @Test
    public void testGetArrivee() {
        System.out.println("getArrivee");
        Commande instance = null;
        Date expResult = null;
        Date result = instance.getArrivee();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDepart method, of class Commande.
     */
    @Test
    public void testGetDepart() {
        System.out.println("getDepart");
        Commande instance = null;
        Date expResult = null;
        Date result = instance.getDepart();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Commande.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Commande instance = null;
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLot method, of class Commande.
     */
    @Test
    public void testGetLot() {
        System.out.println("getLot");
        Commande instance = null;
        Lot expResult = null;
        Lot result = instance.getLot();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLot method, of class Commande.
     */
    @Test
    public void testSetLot() {
        System.out.println("setLot");
        Lot lot = null;
        Commande instance = null;
        instance.setLot(lot);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Commande.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Commande instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Commande.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Commande instance = null;
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
