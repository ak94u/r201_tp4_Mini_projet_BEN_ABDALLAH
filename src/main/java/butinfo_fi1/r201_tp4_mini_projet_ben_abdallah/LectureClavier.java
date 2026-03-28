
import java.io.*;

/**  
*
*   Cette classe a pour rôle de faciliter la lecture de données
*   à partir du clavier.
*   Elle definit une méthode de lecture pour les types de base 
*   les plus courramment utilisés (int, float, double, boolean, String).
*   
*   La lecture d'une valeur au clavier se fait en tapant celle-ci suivie
*   d'un retour chariot.
*   
*   En cas d'erreur de lecture (par exemple un caractère a été tapé
*   lors de la lecture d'un entier) un message d'erreur est affiché
*   sur la console et l'exécution du programme est interrompue.
*   
*   exemples d'utilisation de cette classe :
*   
*      System.out.print("entrez un entier : ");
*      System.out.flush();
*      int i = LectureClavier.lireEntier();
*      System.out.println("entier lu : " + i);
*
*      System.out.print("entrez une chaine :");
*      System.out.flush();
*      String s = LectureClavier.lireChaine();
*      System.out.println("chaine lue : " + s);
*
*      System.out.print("entrez une réel (float) : ");
*      System.out.flush();
*      float f = LectureClavier.lireFloat();
*      System.out.println("réel (float) lu : " + f);
*
*      System.out.print("entrez une réel (double) : ");
*      System.out.flush();
*      double d = LectureClavier.lireDouble();
*      System.out.println("réel (double) lu : " + d);
*      
*      System.out.print("entrez une réponse O/N : ");
*      System.out.flush();
*      boolean b = LectureClavier.lireOuiNon();
*      System.out.println("booleen lu : " + b);
*/


public class LectureClavier {

  private static BufferedReader stdin = new BufferedReader(
                                        new InputStreamReader(System.in));

  /** 
   * lecture au clavier d'un entier simple precision (int)
   * @return l'entier lu
   */
  public static int lireEntier() {
     
    try {
      return(Integer.parseInt(stdin.readLine())); 
    }
    catch (Exception e) {       
      erreurEntree(e,"entier");
      return 0;    // même si on passe jamais ici il faut un return !!
    } 
  }
   
  /** 
   * lecture au clavier d'une chaine de caractères 
   * @return la chaine lue
   */
  public static String lireChaine() {
    try {
      return(stdin.readLine()); 
    }
    catch (Exception e) {       
      erreurEntree(e,"chaine de caracteres");

      return null;
    } 
  }
    
  /** 
   * lecture au clavier d'un réel simple précision (float)
   * @return le float lu
   */
  public static float lireFloat() {
     
    try {
      return(Float.valueOf(stdin.readLine()).floatValue()); 
    }
    catch (Exception e) {       
      erreurEntree(e,"reel (float)");

      return (float) 0.0;
    } 
  }
    
  /** 
   * lecture au clavier d'un réel double précision (double)
   * le double lu
   */
  public static double lireDouble() { 
    try {
      return(Double.valueOf(stdin.readLine()).doubleValue()); 
    }
    catch (Exception e) {      
      erreurEntree(e,"reel (double)");
      return 0.0;
    } 
  }  
    
  /**  
   *  lecture au clavier d'une réponse de type oui/non. Si la valeur tapée est
   *  "o" ou "O" cette méthode renvoie true, sinon elle renvoie
   *  false.
   *  @return true si la chaine lue est "o" ou "O",
   *          false sinon
   */ 
  public static boolean lireOuiNon() { 
    String ch;
    ch = lireChaine();
    return (ch.equals("o") || ch.equals("O"));
  }   

  /**  
   *  lecture au clavier d'une réponse de type oui/non. Si la valeur tapée est
   *  "o" ou "O" cette méthode renvoie true, sinon elle renvoie
   *  false.
   *  @return true si la chaine lue est "o" ou "O",
   *          false sinon
   */ 
  public static char lireChar() { 
    String ch;
    ch = lireChaine();
    return ch.charAt(0);
  }   

  /**
   * en cas d'erreur lors d'une lecture, affiche sur la sortie standard
   * (System.out) un message indiquant le type de l'erreur ainsi que
   * la la pile des appels de méthodes ayant conduit à cette erreur.
   * @param e l'exception décrivant l'erreur.
   * @param message le message d'erreur à afficher.
   */
  private static void erreurEntree(Exception e, String message)
    {
      System.out.println("Erreur lecture " + message);
      System.out.println(e);
      e.printStackTrace();
      System.exit(1);
    }

} // LectureClavier
