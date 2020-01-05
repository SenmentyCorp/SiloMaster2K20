/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

/**
 *
 * @author Lucas
 */
public class PosteTest {
    
    private static PosteImpl poste_panne, poste_plein, poste1, poste_0capt, poste_1capt, poste_2capt;
    private static Lot lot;
    private static Capteur capt1, capt2, capt3;
    
    public PosteTest() {
    }
    
    @BeforeEach
    public static void setUp() {
        lot = mock(Lot.class);
        
        poste_panne = new PosteImpl(1);
        poste_panne.setPanne(true);
        
        poste_plein = new PosteImpl(2);
        poste_plein.setLot(lot);
        
        poste1 = new PosteImpl(3);
        
        capt1 = new Capteur(1,"Mesure",1f,10);
        capt2 = new Capteur(2,"Mesure",1f,10);
        capt3 = new Capteur(3,"Mesure",1f,10);
        
        poste_0capt = new PosteImpl(4);
        
        poste_1capt = new PosteImpl(5);
        poste_1capt.ajouterCapteur(capt1);
        
        poste_2capt = new PosteImpl(6);
        poste_2capt.ajouterCapteur(capt1);
        poste_2capt.ajouterCapteur(capt2);
    }
    
    @AfterEach
    public void tearDown() {
    }

    // -----
    
    @Test
    public void testIsPanne() {
        // Verifie que le poste en panne a bien son booleen de panne true
        assertEquals(poste_panne.isPanne(),true);
    }

    @Test
    public void testIsPlein() {
        // Verifie que le poste plein a bien son booleen plein true
        assertEquals(poste_plein.isPlein(),true);
    }
    
    @Test
    public void testSetLot() {
        // Verifie qu'un lot est bien affecte et que le booleen plein devient true
        poste1.setLot(lot);
        assertEquals(poste1.getLot(),lot);
        assertEquals(poste1.isPlein(),true);
    }

    // -----
    
    @Test
    public void testAjouterCapteur_0capteur() {
        // Ajout capteur pour liste vide
        poste_0capt.ajouterCapteur(capt1);
        assertEquals(poste_0capt.getLstCapteur().size(),1);
    }

    @Test
    public void testAjouterCapteur_1capteur() {
        // Ajout capteur quand deja 1 capteur
        poste_1capt.ajouterCapteur(capt2);
        assertEquals(poste_1capt.getLstCapteur().size(),2);
    }
    
    @Test
    public void testAjouterCapteur_2capteurs() {
        // Ajout capteur quand deja plusieurs capteurs
        poste_2capt.ajouterCapteur(capt3);
        assertEquals(poste_2capt.getLstCapteur().size(),3);
    }
    
    // -----
    
    @Test
    public void testRetirerCapteur_int_0capteur() {
        // Retire capteur pour liste vide
        poste_0capt.retirerCapteur(1);
        assertEquals(poste_0capt.getLstCapteur().size(),0);
    }
    
    @Test
    public void testRetirerCapteur_int_1capteur() {
        // Retire capteur quand 1 capteur
        poste_1capt.retirerCapteur(1);
        assertEquals(poste_1capt.getLstCapteur().size(),0);
    }
    
    @Test
    public void testRetirerCapteur_int_2capteurs() {
        // Retire capteur quand plusieurs capteurs
        poste_2capt.retirerCapteur(1);
        assertEquals(poste_2capt.getLstCapteur().size(),1);
    }
    
    @Test
    public void testRetirerCapteur_int_AucunCapteurTrouve() {
        // Retire un capteur pas present
        poste_2capt.retirerCapteur(10);
        assertEquals(poste_2capt.getLstCapteur().size(),2);
    }

    // -----
    
    @Test
    public void testRetirerCapteur_Capteur_0capteur() {
        // Retire capteur pour liste vide
        poste_0capt.retirerCapteur(capt1);
        assertEquals(poste_0capt.getLstCapteur().size(),0);
    }
    
    @Test
    public void testRetirerCapteur_Capteur_1capteur() {
        // Retire capteur quand 1 capteur
        poste_1capt.retirerCapteur(capt1);
        assertEquals(poste_1capt.getLstCapteur().size(),0);
    }
    
    @Test
    public void testRetirerCapteur_Capteur_2capteurs() {
        // Retire capteur quand plusieurs capteurs
        poste_2capt.retirerCapteur(capt2);
        assertEquals(poste_2capt.getLstCapteur().size(),1);
    }
    
    @Test
    public void testRetirerCapteur_Capteur_AucunCapteurTrouve() {
        // Retire un capteur pas present
        poste_2capt.retirerCapteur(new Capteur(10,"Mesure",1f,10));
        assertEquals(poste_2capt.getLstCapteur().size(),2);
    }

    // -----
    
    @Test
    public void testChercherCapteur_CapteurTrouve() {
        // Cherche capteur present
        assertEquals(poste_2capt.chercherCapteur(1),capt1);
    }
    
    @Test
    public void testChercherCapteur_AucunCapteurTrouve() {
        // Cherche capteur non-present
        assertEquals(poste_2capt.chercherCapteur(10),null);
    }

    @Test
    public void testTraitement() {
        
    }

    @Test
    public void testSuivant() {
        
    }

    public static class PosteImpl extends Poste {

        public PosteImpl(int id) {
            super(id);
        }

        public void traitement() {
        }

        public void suivant() {
        }
    }
    
}
