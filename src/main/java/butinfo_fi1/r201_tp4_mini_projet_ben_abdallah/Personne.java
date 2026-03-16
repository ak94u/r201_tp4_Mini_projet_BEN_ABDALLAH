
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package butinfo_fi1.r201_tp4_mini_projet_ben_abdallah;

import java.util.HashSet;
/**
 *
 * @author but-info
 */
public class Personne {
    private String nom;
    private String prenom;
    private String civilite;
    
    public Personne(String nom, String prenom, String civilite){
        this.nom = nom;
        this.prenom = prenom;
        if (civilite == null){
           this.civilite = "Non renseignée";
        }else{
          this.civilite = civilite;  
        }
    }
    
    public Personne(String nom, String prenom){
        this(nom, prenom, "Non renseignée");
        
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public HashSet<String> getCivilite() {
        return civilite;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setCivilite(HashSet<String> civilite) {
        this.civilite = civilite;
    }
    
    
    
}
