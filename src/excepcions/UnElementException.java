
package excepcions;

/**
 *Excepció per a avisar de que sols hi ha un element registrat. 
 * Llançada a la clase Inici; procediment jugar().
 * Casos:
 *  - Es llança quan:
 *      > Batalla individual:
 *              + Sols hi ha un jugador registrat.
 *      > Batalla per equips:
 *              + Sols hi ha un equip registrat.
 * @author sofia
 */
public class UnElementException extends Exception{

    public UnElementException(String msg) {
        super(msg);
    }

    
}
