/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Lucas
 */
public class CapteurTest {
    
    private static Capteur c_0alarme, c_1alarme, c_presque_maxalarme, c_maxalarme;
    private static Alarme a1,a2,a3,a4;
    private static int max;
    
    public CapteurTest() {
    }
    
    @BeforeEach
    public static void setUp() {
        System.out.println("oui");
        max = 3;
        a1 = mock(Alarme.class);
        when(a1.getId()).thenReturn(1);
        a2 = mock(Alarme.class);
        a3 = mock(Alarme.class);
        a4 = mock(Alarme.class);
        
        c_0alarme = new Capteur(1, "Mesure", 1f, max);
        
        c_1alarme = new Capteur(2, "Mesure", 1f, max);
        c_1alarme.ajouterAlarme(a1);
        
        c_presque_maxalarme = new Capteur(3, "Mesure", 1f, max);
        c_presque_maxalarme.ajouterAlarme(a1);
        c_presque_maxalarme.ajouterAlarme(a2);
        
        c_maxalarme = new Capteur(4, "Mesure", 1f, max);
        c_maxalarme.ajouterAlarme(a1);
        c_maxalarme.ajouterAlarme(a2);
        c_maxalarme.ajouterAlarme(a3);
    }

    @Test
    public void testDeclencherAlarme() {
        //TODO
    }

    // ------
    
    @Test
    public void testAjouterAlarme_0Alarme() {
        // Ajout alarme pour liste vide
        c_0alarme.ajouterAlarme(a1);
        assertEquals(c_0alarme.getLstAlarme().size(),1);
    }
    
    @Test
    public void testAjouterAlarme_1Alarme() {
        // Ajout alarme quand deja 1 element
        c_1alarme.ajouterAlarme(a2);
        assertEquals(c_1alarme.getLstAlarme().size(),2);
    }
    
    @Test
    public void testAjouterAlarme_PresqueMaxAlarme() {
        // Ajout alarme quand presque plein
        c_presque_maxalarme.ajouterAlarme(a3);
        assertEquals(c_presque_maxalarme.getLstAlarme().size(),max);        
    }
    
    @Test
    public void testAjouterAlarme_MaxAlarme() {
        // Pas d'ajout d'alarme quand plein, ne depasse pas le max d'elements
        c_maxalarme.ajouterAlarme(a4);
        assertEquals(c_maxalarme.getLstAlarme().size(),max); 
    }

    // ------
    
    @Test
    public void testRetirerAlarme_int_VideAlarme() {
        // Retirer alarme quand vide
        c_0alarme.retirerAlarme(1);
        assertEquals(c_0alarme.getLstAlarme().size(),0);
    }
    
    @Test
    public void testRetirerAlarme_int_PresqueVideAlarme() {
        // Retirer alarme quand presque vide
        c_1alarme.retirerAlarme(1);
        assertEquals(c_1alarme.getLstAlarme().size(),0);
    }
    
    @Test
    public void testRetirerAlarme_int_PresqueMaxAlarme() {
        // Retirer alarme quand presque plein
        c_presque_maxalarme.retirerAlarme(1);
        assertEquals(c_presque_maxalarme.getLstAlarme().size(),1);
    }
    
    @Test
    public void testRetirerAlarme_int_MaxAlarme() {
        // Retirer alarme quand plein
        c_maxalarme.retirerAlarme(1);
        assertEquals(c_maxalarme.getLstAlarme().size(),max-1);
    }
    
    @Test
    public void testRetirerAlarme_int_AucuneAlarmeTrouvee() {
        // Retirer une alarme pas présente
        int size = c_presque_maxalarme.getLstAlarme().size();
        c_presque_maxalarme.retirerAlarme(10);
        assertEquals(c_presque_maxalarme.getLstAlarme().size(),size);
    }

    // ------
    
    @Test
    public void testRetirerAlarme_Alarme_VideAlarme() {
        // Retirer alarme quand vide
        c_0alarme.retirerAlarme(a1);
        assertEquals(c_0alarme.getLstAlarme().size(),0);
    }
    
    @Test
    public void testRetirerAlarme_Alarme_PresqueVideAlarme() {
        // Retirer alarme quand presque vide
        c_1alarme.retirerAlarme(a1);
        assertEquals(c_1alarme.getLstAlarme().size(),0);
    }
    
    @Test
    public void testRetirerAlarme_Alarme_PresqueMaxAlarme() {
        // Retirer alarme quand presque plein
        c_presque_maxalarme.retirerAlarme(a2);
        assertEquals(c_presque_maxalarme.getLstAlarme().size(),1);
    }
    
    @Test
    public void testRetirerAlarme_Alarme_MaxAlarme() {
        // Retirer alarme quand plein
        c_maxalarme.retirerAlarme(a3);
        assertEquals(c_maxalarme.getLstAlarme().size(),max-1);
    }
    
    @Test
    public void testRetirerAlarme_Alarme_AucuneAlarmeTrouvee() {
        // Retirer une alarme pas présente
        int size = c_presque_maxalarme.getLstAlarme().size();
        c_presque_maxalarme.retirerAlarme(a3);
        assertEquals(c_presque_maxalarme.getLstAlarme().size(),size);
    }

    // ------
    
    @Test
    public void testChercherAlarme_AlarmeTrouvee() {
        // Recherche par id d'une alarme présente dans la liste
        assertEquals(c_1alarme.chercherAlarme(1),a1);
    }
    
    @Test
    public void testChercherAlarme_AucuneAlarmeTrouvee() {
        // Recherche par id d'une alarme non-présente dans la liste
        assertEquals(c_1alarme.chercherAlarme(10),null);
    }
    
}
