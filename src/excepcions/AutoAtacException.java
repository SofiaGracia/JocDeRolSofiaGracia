
package excepcions;

/**
 *Excepció per a avisar de que un jugador no es pot atacar a sí mateix.
 * Llançada a la clase Inici; procediment jugar().
 * @author sofia
 */
public class AutoAtacException extends Exception{

    public AutoAtacException() {
        super("No pots atacar-te a tu mateix");
    }
    
}
