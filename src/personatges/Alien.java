
package personatges;

import excepcions.AtacAMortException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sofia
 */
public class Alien extends Jugador{
    
    public Alien(String nom, int pA, int pD, int pV) {
        super(nom, pA, pD, pV);
    }

    @Override
    public void ataca(Jugador atacat) {
        if ((this.getVides() > 20) && atacat.getVides() > 0) {
            this.setPuntsAtac(this.getPuntsAtac() + 3);
            this.setPuntsDefensa(this.getPuntsDefensa() - 3 < 0 ? 0 : this.getPuntsDefensa() - 3);
            System.out.println("Alien embogit");
        }
        try {
            super.ataca(atacat);
        } catch (AtacAMortException ex) {
            ex.getMessage();
        }
    }
}
