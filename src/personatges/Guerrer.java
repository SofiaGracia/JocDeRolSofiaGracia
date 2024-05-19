
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
        System.out.print("\n"+this.getNom()+" és colpejat amb "+qpA+" punts i es defén amb "+(this.getPuntsDefensa()+this.sumaB("D"))+". Vides: "+this.getVides());
        int ferida = (this.getPuntsDefensa()+this.sumaB("D")) - qpA;
        if(ferida < -5){
            this.setVides((this.getVides() + ferida) < 0? 0 :(this.getVides() + ferida));
            System.out.print("-"+(ferida < 0 ? -ferida : ferida)+" = "+this.getVides()+"\n");
        }
    }
}
