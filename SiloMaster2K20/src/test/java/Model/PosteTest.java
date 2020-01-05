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
import static org.mockito.Mockito.when;

/**
 *
 * @author Lucas
 */
public class PosteTest {
    
    private static PosteImpl poste_panne, poste_plein, poste1, poste_0capt, poste_1capt, poste_2capt, poste_temp, poste_hum, poste_suiv;
    private static Lot lot;
    private static Capteur capt1, capt2, capt3, capt4, capt5, capt6;
    
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
        
        capt1 = mock(Capteur.class);
        when(capt1.getId()).thenReturn(1);
        when(capt1.getTypeMesure()).thenReturn("Temperature");
        when(capt1.getValeur()).thenReturn(1f);
        
        capt2 = mock(Capteur.class);
        when(capt2.getId()).thenReturn(2);
        when(capt2.getTypeMesure()).thenReturn("Temperature");
        when(capt2.getValeur()).thenReturn(3f);
        
        capt3 = mock(Capteur.class);
        when(capt3.getId()).thenReturn(3);
        when(capt3.getTypeMesure()).thenReturn("Temperature");
        when(capt3.getValeur()).thenReturn(7f);
        
        capt4 = mock(Capteur.class);
        when(capt4.getId()).thenReturn(4);
        when(capt4.getTypeMesure()).thenReturn("Humidite");
        when(capt4.getValeur()).thenReturn(12f);
        
        capt5 = mock(Capteur.class);
        when(capt5.getId()).thenReturn(5);
        when(capt5.getTypeMesure()).thenReturn("Humidite");
        when(capt5.getValeur()).thenReturn(7f);
        
        capt6 = mock(Capteur.class);
        when(capt6.getId()).thenReturn(6);
        when(capt6.getTypeMesure()).thenReturn("Humidite");
        when(capt6.getValeur()).thenReturn(13f);
        
        poste_0capt = new PosteImpl(4);
        
        poste_1capt = new PosteImpl(5);
        poste_1capt.ajouterCapteur(capt1);
        
        poste_2capt = new PosteImpl(6);
        poste_2capt.ajouterCapteur(capt1);
        poste_2capt.ajouterCapteur(capt2);
        
        poste_temp = new PosteImpl(7);
        poste_temp.ajouterCapteur(capt1);
        poste_temp.ajouterCapteur(capt2);
        poste_temp.ajouterCapteur(capt3);
        
        poste_hum = new PosteImpl(8);
        poste_hum.ajouterCapteur(capt4);
        poste_hum.ajouterCapteur(capt5);
        poste_hum.ajouterCapteur(capt6);
        
        poste_suiv = new PosteImpl(9, poste1);
        poste_suiv.setLot(lot);
        
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
        Capteur c = mock(Capteur.class);
        when(c.getId()).thenReturn(10);
        poste_2capt.retirerCapteur(c);
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
    public void testGetTemperature() {
        // Temperature moyenne
        float moy = (1f + 3f + 7f) / 3f;
        assertEquals(poste_temp.getTemperature(),moy);
    }

    @Test
    public void testGetHumidite() {
        // Humidite moyenne
        float moy = (12f + 7f + 13f) / 3f;
        assertEquals(poste_hum.getHumidite(),moy);
    }
    
    @Test
    public void testSuivant() {
        poste_suiv.suivant();
        assertEquals(poste1.getLot(),lot);
        assertEquals(poste1.isPlein(),true);
        assertEquals(poste_suiv.getLot(),null);
        assertEquals(poste_suiv.isPlein(),false);
    }

    // Classe fille de Poste n'implementant aucune nouveaute
    // Permet uniquement d'instancier Poste pour les tests
    public static class PosteImpl extends Poste {

        public PosteImpl(int id) {
            super(id);
        }
        
        public PosteImpl(int id, Poste suiv) {
            super(id, suiv);
        }

        public void traitement() {
        }
        
    }
    
}
