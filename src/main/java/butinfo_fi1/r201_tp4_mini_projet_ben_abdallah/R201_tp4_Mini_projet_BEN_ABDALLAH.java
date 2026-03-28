/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package butinfo_fi1.r201_tp4_mini_projet_ben_abdallah;

/**
 *
 * @author but-info
 */
public class R201_tp4_Mini_projet_BEN_ABDALLAH {

    public static void main(String[] args) {
        Annuaire an = new Annuaire_BEN_ABDALLAH();// Instancie un annuaire vide
        
        //Ajoute des personnes à l'annuaire
        Personne p1 = new Personne("Durand", "Sophie", "Femme");
        an.ajouterEntree(p1, new ListeNumTel_BEN_ABDALLAH(new NumTel("151171", "D")));
        an.ajouterEntree(new Personne("DUPONT", "Luc", "Homme trans"), new ListeNumTel_BEN_ABDALLAH(new NumTel("151170", "P")));
        an.ajouterEntree(new Personne("LESTIN", "Louis", "Homme"), new ListeNumTel_BEN_ABDALLAH(new NumTel("146761", "P")));
        an.ajouterEntree(new Personne("CARUETTE", "Carla"), new ListeNumTel_BEN_ABDALLAH(new NumTel("140361", "P")));
        
        //imprime l'annuaire
        System.out.println("-------------------------------------------");
        System.out.println(an);
        System.out.println("-------------------------------------------");
        
        //Recherche les numéros de Sophie DURAND
        System.out.println("numeros de " + p1);
        System.out.println(an.numeros(p1));
        
        // Recherche les numéros de Luc DUPONT
        Personne p2 = new Personne("DUPONT", "Luc", "Homme trans");
        System.out.println("numeros de " + p2);
        System.out.println(an.numeros(p2));
    }
    
}
