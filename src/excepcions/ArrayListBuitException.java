
package excepcions;

/**
 *Esta excepció avisa de que l'ArrayList està buit.
 * Es llança a la clase Inici per a evitar que el programa aborte. És una alternativa a l'ús d'un if + isEmpty()
 * @author sofia
 */
public class ArrayListBuitException extends Exception{
    
    public ArrayListBuitException(String msg){
        System.out.println(msg);
    }
}
