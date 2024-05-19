
package excepcions;

/**
 *Excepció per a avisar de que no es pot atacar a un jugador mort.
 * Llançada a la clase Inici; procediment jugar().
 * @author sofia
 */
public class AtacAMortException extends Exception{

    // Constructor passant-li el text de l’error com a paràmetre
    public AtacAMortException(String msg) {
        super(msg);
    }
    
    public AtacAMortException(){
        super("No es pot atacar a un mort");
    }
}
