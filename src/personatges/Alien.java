
package personatges;

import excepcions.AtacAMortException;

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
        if (this.getVides() > 20) {
            this.setPuntsAtac(this.getPuntsAtac() + 3);
            this.setPuntsDefensa(this.getPuntsDefensa() - 3 < 0 ? 0 : this.getPuntsDefensa() - 3);
//            System.out.println("Alien Embogit: "+this.getNom());//Ho deixat comentat perquè m'ajuda a saber si el procediment funciona
        }
        try {
            super.ataca(atacat);
        } catch (AtacAMortException ex) {
            ex.getMessage();
        }
    }
}
