
package personatges;

/**
 *
 * @author sofia
 */
public class Huma extends Jugador{

    public Huma(String nom, int pA, int pD, int pV) {
        /**
         * Els jugadors de la clase humà sempre tindran com a màxim 100 vides inicials.
         * És contradictori perquè en la clase Jugadors hi ha una funció que deixa posar als jugadors fins a 200 punts de vida inicial,
         * però per a fer proves ràpides ha anat bé esta diferència, perquè la partida no es fa tan llarga.
         */
        super(nom, pA, pD, (pV > 100 ? 100 : pV));
    }
}
