
package personatges;

/**
 *
 * @author sofia
 */
public class Guerrer extends Huma{

    public Guerrer(String nom, int pA, int pD, int pV) {
        super(nom, pA, pD, pV);
    }

    @Override
    protected void esColpejatAmb(int qpA) {
        super.esColpejatAmb((this.getPuntsDefensa()-qpA) < 5 ? 0 : qpA);
    }
}
