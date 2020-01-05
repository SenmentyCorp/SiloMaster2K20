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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Lucas
 */
public class BoisseauTest {
    
    private static Boisseau boisseau;
    private static Lot l;
    private static Commande c;
    
    public BoisseauTest() {
    }
    
    @BeforeEach
    public static void setUp() {
        c = new Commande(1,null,null,"desc");
        l = new Lot(1,"Type","Qualite",c);
        
        boisseau = new Boisseau(1);
        boisseau.setLot(l);
                
    }
    
    @AfterEach
    public void tearDown() {
    }

    
    @Test
    public void testTraitement() {
        boisseau.traitement();
        assertEquals(l.isTraitementTermine(),true);
        assertEquals(c.isTraitementTermine(),true);
        assertEquals(boisseau.getLot(),null);
        assertEquals(boisseau.isPlein(),false);
    }
    
}
