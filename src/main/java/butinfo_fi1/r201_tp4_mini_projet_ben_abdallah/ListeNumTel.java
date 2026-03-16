import java.util.Iterator;

/**
 *
 * Représente une liste de numéros de téléphone.  
 * La liste contient au moins un numéro (pas de liste vide).
 * 
 * @see NumTel
 * @version
 */

public interface ListeNumTel {

  /**
   * ajoute un numéro à la fin de la liste, sans effet si le numéro est déjà 
   * présent dans la liste.
   * @param num le numéro à ajouter
   * @return true si le numéro a été ajouté, false si l'ajout
   *        n'a pas eu lieu car la liste contient déjà le numéro.
   */
  public boolean ajouterFin(NumTel num) ;

   /**
   * ajoute un numéro au début de la liste, sans effet si le numéro est déjà 
   * présent dans la liste.
   * @param num le numéro à ajouter
   * @return true si le numéro a été ajouté, false si l'ajout
   *        n'a pas eu lieu car la liste contient déjà le numéro.
   */
  public boolean ajouterDebut(NumTel num) ;
  
  
  /**
   * ajoute un numéro à une position donnée dans la liste, sans effet si le numéro est déjà 
   * présent dans la liste.
   * @param int index la position d'insertion dans la liste
   * @param num le numéro à ajouter
   * @return true si le numéro a été ajouté? false si l'ajout
   *        n'a pas eu lieu car la liste contient déjà le numéro.
   */
  public boolean ajouter(int index, NumTel num) ;

  /**
   * retourne le premier numéro de la liste (il existe forcément) 
   * @return le premier numero de la liste.
   */
  public NumTel premierNumero() ;
  
  /**
   * retourne le ième numéro de la liste, null si la liste contient
   * moins de i numéros. 
   * @param index la position du numéro à rechercher 
   * @return le numero de la liste à la position index.
   */
  public NumTel numero(int index ) ;
 
 /**
  * Teste la présence d'un numéro dans la liste.
  * @param num le numéro à rechercher.
  * @return true si la liste contient le objet Numtel dont le numéro est
  *         identique à num, false sinon
  */
  public boolean contientNumero(int num) ;

 /**
  * retourne le nombre de numéros de la liste (>=1).
  * @return nombre de numéros présents dans la liste.
  */
  public int nbNumeros() ;

  /**
   * Retourne dans une chaîne de caractères la séquence des numéros contenu dans
   * cette liste. Dans la chaîne résultat les numéros sont séparés par des virgules.
   * 
   * exemple:
   * 0476088634 (D), 0654789045 (P), 0476615277 (T)
   * 
   * @return la chaine contenant la séquence des numéros.
   */ 
  public String toString() ;

  /**
   * Renvoie un itérateur sur les numéros de téléphone contenus dans la liste.
   *
   * @return un iterateur permettant le parcours des numéros de la liste
   */
   public Iterator iterator() ;
   
  /**
   * Enlève un numéro de la liste, cette opération n'est possible que si la liste
   * contient au moins deux numéros (nbNumero()>1). Si la liste ne contient contient
   * qu'un seul numéro cette opération est sans effet. De même si le numéro spécifié 
   * n'est pas présent dans la liste.
   * Cette méthode retourne un booléen qui indique si cette liste de numéros de téléphone
   * a été affectée par l'opération de retrait.
   *
   * @param num le numero à enlever.
   * 
   * @return true si un NumTel dont le numéro est num a été retiré de la liste,
   *         false si la liste ne contient plus qu'un seul numéro ou si il n'y
   *         a pas dans la liste de NumTel de numéro num.
   */
  public boolean retirer(int num);
  
  
}// ListeNumTel

