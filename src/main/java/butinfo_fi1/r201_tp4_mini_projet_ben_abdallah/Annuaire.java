package butinfo_fi1.r201_tp4_mini_projet_ben_abdallah;

import java.util.Iterator;

/**
 * Annuaire téléphonique permettant d'associer à une Personne une liste de numéros de téléphone.
 *
 * @see NumTel
 * @see Personne
 * @see ListeNumTel
 */

public interface Annuaire {
    
    /**
     * ajoute une nouvelle entrée dans l'annuaire. Si p n'existe pas: on crée une nouvelle
     * association (p,nums) et le booléen true est retourné ; sinon le booléen
     * /false est retourné et la méthode est sans effet.
     *
     * @param p la personne
     * @param nums sa liste de numéros
     * @return truesi l'entrée a été ajoutée, false si la personne
     *        <oce>p était déjà présente dans l'annuaire
     */
    public boolean ajouterEntree(Personne p, ListeNumTel_BEN_ABDALLAH nums) ;
    
    /**
     * ajoute un numéro à la fin de la liste des numéro d'une personne.
     * Si la personne n'existe pas on crée une nouvelle entrée pour cette personne avec
     * comme liste de numéro associée la liste constituée du numéro passé en paramêtre.
     *
     * @param p la personne
     * @param n le numéro à ajouter
     */
    public void ajouterNumeroFin(Personne p, NumTel n) ;
    
    /**
     * ajoute un numéro au début de la liste des numéro d'une personne.
     * Si la personne n'existe pas on crée une nouvelle entrée pour cette personne avec
     * comme liste de numéro associée la liste constituée du numéro passé en paramêtre.
     *
     * @param p la personne
     * @param n le numéro à ajouter
     */
    
    public void ajouterNumeroDebut(Personne p, NumTel n) ;
    
    /**
     * retourne le premier numéro d'une personne, si la personne n'est pas dans l'annuaire retourne null.
     *
     * @param p la personne dont on recherche le numéro
     * @return son numéro, null si p n'est pas présente dans l'annuaire.
     */
    public NumTel premierNumero(Personne p) ;
    
    /**
     * retourne les numéro  si la personne est absente retourne null
     * @param p
     * @return la liste des numéro de la personne si celle-ci est présente dans l'annuaire,
     *         null sinon.
     */
    public ListeNumTel numeros(Personne p);
    
    
    /**
     * renvoie un iterateur sur l'ensemble des personnes contenues dans l'annuaire
     * @return l'iterateur
     */
    public Iterator personnes();
    
    /**
     * affiche l'intégralité de l'annuaire, sous la forme d'une personne par ligne
     * suivie de ses numéro de téléphone.
     */
    public void afficher();
    
    /**
     * supprime une personne de l'annuaire. Sans effet si la persoone n'est pas présente
     * dans l'annuaire.
     * @param p la personne à retirer de l'annuaire.
     */
    public void supprimer(Personne p);
    
    
    /**
     * supprime un numéro donné pour une personne.
     * Si ce numéro est le seul numéro pour la  personne, la personne est retirée de l'annuaire.
     * Sans effet si la personne n'est pas présente dans l'annuaire.
     * @param p la personne pour laquelle un numéro doit être supprimé.
     * @param n le numéro a supprimer.
     */
    public void supprimer(Personne p, int n) ;
    
    
}// Annuaire
