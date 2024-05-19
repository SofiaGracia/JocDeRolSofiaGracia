
package excepcions;

/**
 *Excepció per a avisar de que no es pot atacar als jugadors del mateix equip.
 * Llançada a la clase Inici; procediment jugar().
 * @author sofia
 */
public class AtacarPropiEquipException extends Exception{

    public AtacarPropiEquipException() {
        super("No pots atacar al teu propi equip");
    }
}
