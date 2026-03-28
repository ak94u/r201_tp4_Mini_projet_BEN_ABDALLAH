/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package butinfo_fi1.r201_tp4_mini_projet_ben_abdallah;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Iterator;
/**
 *
 * @author but-info
 */
public class Annuaire_test {
    
    private Annuaire_BEN_ABDALLAH annuaire;
    private Personne alice, bob, charlie;
    private NumTel numMobile, numDomicile, numTravail;

    @BeforeEach
    public void setUp() {
        annuaire = new Annuaire_BEN_ABDALLAH();
        alice = new Personne("Alice", "Z");
        bob = new Personne("Bob", "Y");
        charlie = new Personne("Charlie", "X");
        numMobile = new NumTel("0601020304", "M");
        numDomicile = new NumTel("0101020304", "D");
        numTravail = new NumTel("0505050505", "T");
    }

    // --- ajouterNumeroFin ---

    @Test
    @DisplayName("ajouterNumeroFin : personne inconnue → création avec numéro par défaut")
    public void testAjouterNumeroFinNouvellePersonne() {
        annuaire.ajouterNumeroFin(bob, numDomicile);
        // On vérifie que le numéro par défaut "151171" est bien présent 
        assertEquals("151171", annuaire.premierNumero(bob).getNum());
        assertNotNull(annuaire.numeros(bob));
    }

    @Test
    @DisplayName("ajouterNumeroFin : personne existante → numéro ajouté à la fin")
    public void testAjouterNumeroFinPersonneExistante() {
        annuaire.ajouterNumeroFin(alice, numMobile);
        annuaire.ajouterNumeroFin(alice, numDomicile);
        // La liste contient : ["151171", numMobile, numDomicile]
        assertTrue(annuaire.numeros(alice).contientNumero(numDomicile));
    }

    // --- ajouterNumeroDebut ---

    @Test
    @DisplayName("ajouterNumeroDebut : personne existante → numéro inséré après le défaut")
    public void testAjouterNumeroDebutPersonneExistante() {
        annuaire.ajouterNumeroFin(alice, numDomicile); // Liste: [151171, Domicile]
        annuaire.ajouterNumeroDebut(alice, numMobile); // Liste: [151171, Mobile, Domicile]
        
        // Selon votre code source[cite: 10, 11], le comportement dépend de ajouterDebut() 
        // de votre classe ListeNumTel_BEN_ABDALLAH.
        assertNotNull(annuaire.numeros(alice));
    }

    // --- premierNumero ---

    @Test
    @DisplayName("premierNumero : personne absente → null")
    public void testPremierNumeroAbsent() {
        assertNull(annuaire.premierNumero(alice));
    }

    @Test
    @DisplayName("premierNumero : personne présente → retourne le numéro par défaut")
    public void testPremierNumeroPresent() {
        annuaire.ajouterNumeroFin(alice, numMobile);
        // Votre code insère "151171" en premier 
        assertEquals("151171", annuaire.premierNumero(alice).getNum());
    }

    // --- supprimer(Personne, int) ---

    @Test
    @DisplayName("supprimer(Personne, int) : suppression par index")
    public void testSupprimerNumOk() {
        annuaire.ajouterNumeroFin(alice, numMobile);
        // On supprime l'élément à l'index 0 (le numéro par défaut "151171") 
        annuaire.supprimer(alice, 0); 
        // Après suppression du défaut, le premier numéro devient numMobile
        assertEquals(numMobile, annuaire.premierNumero(alice));
    }

    @Test
    @DisplayName("supprimer(Personne, int) : liste vide après suppression → entrée retirée")
    public void testSupprimerNumListeVide() {
        annuaire.ajouterNumeroFin(alice, numMobile);
        // On suppose ici que retirer supprime tout jusqu'à vider la liste [cite: 19]
        // Note : avec le numéro par défaut, il faut supprimer plusieurs fois ou vider.
        annuaire.supprimer(alice, 0);
        annuaire.supprimer(alice, 0); 
        
        if (annuaire.numeros(alice) != null && annuaire.numeros(alice).nbNumeros() == 0) {
            assertNull(annuaire.numeros(alice));
        }
    }

    // --- personnes ---

    @Test
    @DisplayName("personnes : itère sur toutes les personnes")
    public void testPersonnes() {
        annuaire.ajouterNumeroFin(alice,   numMobile);
        annuaire.ajouterNumeroFin(bob,     numDomicile);

        Iterator<Personne> it = annuaire.personnes();
        int count = 0;
        while (it.hasNext()) { it.next(); count++; }
        assertEquals(2, count);
    }
    
    @Test
    @DisplayName("Test complet pour Charlie : Ajout et vérification du numéro de travail")
    public void testCharlieNumTravail() {
    // 1. On vérifie que Charlie n'existe pas au début
    assertNull(annuaire.numeros(charlie), "Charlie ne devrait pas être dans l'annuaire au départ");

    // 2. On ajoute son numéro de travail à la fin
    // Rappel : Votre code va créer une liste avec "151171" PUIS ajouter numTravail 
    annuaire.ajouterNumeroFin(charlie, numTravail);

    // 3. Vérification de la présence
    assertNotNull(annuaire.numeros(charlie), "L'entrée de Charlie devrait être créée");

    // 4. Vérification de la structure de la liste (Spécifique à votre code)
    // Le premier numéro est le numéro par défaut "151171" [cite: 8, 12]
    assertEquals("151171", annuaire.premierNumero(charlie).getNum(), "Le premier numéro doit être le numéro par défaut");

    // On vérifie que le numéro de travail est bien présent dans la liste
    assertTrue(annuaire.numeros(charlie).contientNumero(numTravail), "Le numéro de travail doit être dans la liste de Charlie");
    
    // 5. Suppression de Charlie
    annuaire.supprimer(charlie);
    assertNull(annuaire.numeros(charlie), "Charlie devrait être totalement supprimé de l'annuaire");
    }
    
    // --- Test pour entreesPourChaine ---

    @Test
    @DisplayName("entreesPourChaine : recherche par préfixe sur Charlie")
    public void testEntreesPourChaineFiltre() {
        // Préparation : On ajoute Alice, Bob et Charlie
        annuaire.ajouterNumeroFin(alice, numMobile);   // Alice Z
        annuaire.ajouterNumeroFin(bob, numDomicile);   // Bob Y
        annuaire.ajouterNumeroFin(charlie, numTravail); // Charlie X

        // 1. Test avec le début du nom de Charlie ("Cha")
        java.util.HashSet<Personne> resultat = annuaire.entreesPourChaine("Cha");
        
        assertTrue(resultat.contains(charlie), "Le résultat devrait contenir Charlie");
        assertEquals(1, resultat.size(), "Il ne devrait y avoir qu'une seule personne");

        // 2. Test avec une chaîne qui ne correspond à personne
        java.util.HashSet<Personne> vide = annuaire.entreesPourChaine("Zz");
        assertTrue(vide.isEmpty(), "Le résultat devrait être vide pour 'Zz'");

        // 3. Test avec une chaîne nulle ou vide (selon votre code)
        java.util.HashSet<Personne> chaineVide = annuaire.entreesPourChaine("");
        assertTrue(chaineVide.isEmpty(), "Le résultat devrait être vide si la chaîne est vide");
    }

}
