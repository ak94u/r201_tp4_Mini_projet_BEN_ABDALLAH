/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package butinfo_fi1.r201_tp4_mini_projet_ben_abdallah;
import java.util.HashMap;
/**
 *
 * @author but-info
 */
public class Annuaire_BEN_ABDALLAH implements Annuaire {
    private HashMap<Personne, ListeNumTel_BEN_ABDALLAH> Contact;
    
    public Annuaire_BEN_ABDALLAH(){
        this.Contact = new HashMap<>();
    }
    
    @Override
    public boolean ajouterEntree(Personne p, ListeNumTel_BEN_ABDALLAH nums) { 
        if(getContact().containsKey(p)){
            System.out.println("Cette personne est deja presente");
            return false;// personne déjà présente
        }
        getContact().put(p, nums);
        return true;
    }

    @Override
    public void ajouterNumeroFin(Personne p, NumTel n) {
        if(!getContact().containsKey(p)){ 
            ListeNumTel_BEN_ABDALLAH liste = new ListeNumTel_BEN_ABDALLAH();
            liste.add(n);
            getContact().put(p, liste);
        }else{
            getContact().get(p).add(n);
        }
        
    }

    @Override
    public void ajouterNumeroDebut(Personne p, NumTel n) {
        if(!getContact().containsKey(p)){
            ListeNumTel_BEN_ABDALLAH liste = new ListeNumTel_BEN_ABDALLAH();
            liste.ajouterDebut(n);
            getContact().put(p, liste);        
        }else{
            getContact().get(p).ajouterDebut(n);
        }
    }

    @Override
    public NumTel premierNumero(Personne p) {
        if(!this.Contact.containsKey(p)){
            return null;
        }
        ListeNumTel_BEN_ABDALLAH liste = this.Contact.get(p);
        if(liste.estVide()){
            return null;
        }
        
        return liste.premierNumero();
    }

    public HashMap<Personne, ListeNumTel_BEN_ABDALLAH> getContact(){
        return this.Contact;
    }

    @Override
    public ListeNumTel numeros(Personne p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void afficher() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void supprimer(Personne p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void supprimer(Personne p, int n) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
