/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package butinfo_fi1.r201_tp4_mini_projet_ben_abdallah;
import java.util.HashMap;
import java.util.Iterator;
/**
 *
 * @author but-info
 */
public class Annuaire_BEN_ABDALLAH implements Annuaire {

    public HashMap<Personne, ListeNumTel_BEN_ABDALLAH> getEntrees_annuaire() {
        return entrees_annuaire;
    }

    public void setEntrees_annuaire(HashMap<Personne, ListeNumTel_BEN_ABDALLAH> entrees_annuaire) {
        this.entrees_annuaire = entrees_annuaire;
    }

    private HashMap<Personne, ListeNumTel_BEN_ABDALLAH> entrees_annuaire;

    public Annuaire_BEN_ABDALLAH() {
        this.entrees_annuaire = new HashMap<>();
    }

    @Override
    public boolean ajouterEntree(Personne p, ListeNumTel_BEN_ABDALLAH nums) {
        if (this.entrees_annuaire.containsKey(p)) {
            System.out.println("Cette personne est deja presente");
            return false;
        }
        this.entrees_annuaire.put(p, nums);
        return true;
    }

    @Override
    public void ajouterNumeroFin(Personne p, NumTel n) {
        if (!this.entrees_annuaire.containsKey(p)) {
            ListeNumTel_BEN_ABDALLAH liste = new ListeNumTel_BEN_ABDALLAH(new NumTel("151171", "D"));
            liste.add(n);
            this.entrees_annuaire.put(p, liste);
        } else {
            this.entrees_annuaire.get(p).add(n);
        }
    }

    @Override
    public void ajouterNumeroDebut(Personne p, NumTel n) {
        if (!this.entrees_annuaire.containsKey(p)) {
            ListeNumTel_BEN_ABDALLAH liste = new ListeNumTel_BEN_ABDALLAH(new NumTel("151171", "D"));
            liste.ajouterDebut(n);
            this.entrees_annuaire.put(p, liste);
        } else {
            this.entrees_annuaire.get(p).ajouterDebut(n);
        }
    }

    @Override
    public NumTel premierNumero(Personne p) {
        if (!this.entrees_annuaire.containsKey(p)) {
            return null;
        }
        return this.entrees_annuaire.get(p).premierNumero();
    }

    @Override
    public ListeNumTel numeros(Personne p) {
        return this.entrees_annuaire.get(p); // retourne null si absent → parfait
    }

    @Override
    public void afficher() {
        for (HashMap.Entry<Personne, ListeNumTel_BEN_ABDALLAH> e : this.entrees_annuaire.entrySet()) {
            System.out.println(e.getKey() + " => " + e.getValue());
        }
    }

    @Override
    public void supprimer(Personne p) {
        this.entrees_annuaire.remove(p); // remove fait déjà tout
    }

    @Override
    public void supprimer(Personne p, int n) {
        if (!this.entrees_annuaire.containsKey(p)) {
            return;
        }

        ListeNumTel_BEN_ABDALLAH liste = this.entrees_annuaire.get(p);
        liste.retirer(n);

        if (liste.nbNumeros() == 0) {
            this.entrees_annuaire.remove(p);
        }
    }

    @Override
    public Iterator<Personne> personnes() {
        return this.entrees_annuaire.keySet().iterator();
    }
}
