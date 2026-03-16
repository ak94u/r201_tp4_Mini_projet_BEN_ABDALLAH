
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package butinfo_fi1.r201_tp4_mini_projet_ben_abdallah;
/**
 *
 * @author but-info
 */
public class Personne implements Comparable<Personne> {
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

    public String getCivilite() {
        return civilite;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }
    
    @Override
    public String toString(){
        nom = getNom();
        prenom = getPrenom();
        civilite = getCivilite();
        return "[Prenom = " + prenom + "," + "Nom = " + nom + "," + "Civilité = " + civilite + " ]"; 
    }

    @Override
    public int compareTo(Personne p2) {
        int cmpNom = this.nom.compareTo(p2.nom);
        if (cmpNom != 0) return cmpNom;
        
        int cmpPrenom = this.prenom.compareTo(p2.prenom);
        if (cmpPrenom != 0) return cmpPrenom;
        
        return this.civilite.compareTo(p2.civilite);
    }
    
    
}
