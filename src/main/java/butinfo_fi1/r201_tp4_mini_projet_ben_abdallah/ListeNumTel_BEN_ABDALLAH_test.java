/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package butinfo_fi1.r201_tp4_mini_projet_ben_abdallah;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
/**
 *
 * @author but-info
 */
public class ListeNumTel_BEN_ABDALLAH_test {
    private ListeNumTel_BEN_ABDALLAH liste;
    private NumTel nPro; 
    private NumTel nPerso;
   
    
    @BeforeEach
    public void setUp(){
        //Initialisation avec quelques numéros de test
        //On suppose que NumTel a un constructeur NumTel(String num)
        nPro = new NumTel("0140404040","T");
        nPerso = new NumTel("0602020204", "P");
        liste = new ListeNumTel_BEN_ABDALLAH(new ArrayList<>()); 
    }
    
    @Test
    public void testAjouterTypesValides(){
        assertTrue(liste.ajouterFin(nPro));
        assertTrue(liste.ajouterFin(nPerso));
        assertEquals(2 , liste.nbNumeros());
        
        //Vérification des types stockés
        assertEquals("T", liste.numero(0).getType());
        assertEquals("P", liste.numero(1).getType());
    }
    
    @Test
    public void testTypeInconnu(){
        //Test avec un type qui n'existe pas (ex: 'Z')
        NumTel nInconnu = new NumTel("0999999999", "Z");
        
        //Si tu as impléménté la vérification dans le constructeur :
        //assertEquals("?", Inconnu.getType());
        assertTrue(liste.ajouterFin(nInconnu));
    }
    
    @Test
    public void testDoublonMemeNumeroMemeType(){
        liste.ajouterFin(nPro);
        //On recrée le même numéro
        NumTel copie = new NumTel("014040404040", "T");
        
        assertFalse(liste.ajouterFin(copie), "Un numero identique avec le meme type ne doit pas etre ajoute");
    } 
    
    @Test
    public void testMemeNumeroTypeDifferent(){
        liste.ajouterFin(nPro);// 0140404040 en 'T'
        
        //Est-ce qu'on a le droit d'avoir le même numéro s'il change de type ?
        //Selon ton equals actuel (qui compare num ET type), ce sera considéré comme DIFFÉRENT.
        NumTel memeNumAutreType = new NumTel("0140404040", "D");
        
        assertTrue(liste.ajouterFin(memeNumAutreType), "Si le type change, equals les voit comme differents");
    }
    
    @Test
    public void testToStringFormat(){
        liste.ajouterFin(nPro);
        //Vérifie que l'affichage ressemble à : 0140404040(T)
        String attendu = "0140404040(T)";
        assertEquals(attendu, nPro.toString());
    }
    
}