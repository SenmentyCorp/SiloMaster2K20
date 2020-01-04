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
public class AlarmeTest {
    
    public AlarmeTest() {
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
     * Test of getId method, of class Alarme.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Alarme instance = null;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Alarme.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Alarme instance = null;
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class Alarme.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Alarme instance = null;
        Date expResult = null;
        Date result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDate method, of class Alarme.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        Date date = null;
        Alarme instance = null;
        instance.setDate(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTypeAlarme method, of class Alarme.
     */
    @Test
    public void testGetTypeAlarme() {
        System.out.println("getTypeAlarme");
        Alarme instance = null;
        String expResult = "";
        String result = instance.getTypeAlarme();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTypeAlarme method, of class Alarme.
     */
    @Test
    public void testSetTypeAlarme() {
        System.out.println("setTypeAlarme");
        String TypeAlarme = "";
        Alarme instance = null;
        instance.setTypeAlarme(TypeAlarme);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Alarme.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Alarme instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Alarme.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Alarme instance = null;
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
