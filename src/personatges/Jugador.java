
package personatges;

/**
 *
 * @author sofia
 */
public class Jugador {
    
    private String nom;
    private int puntsAtac;
    private int puntsDefensa;
    private int vides;
    
    public String getNom() {
        return nom;
    }

    protected void setNom(String nom) {
        this.nom = nom;
    }

    public int getPuntsAtac() {
        return puntsAtac;
    }

    protected void setPuntsAtac(int puntsAtac) {
        this.puntsAtac = puntsAtac;
    }

    public int getPuntsDefensa() {
        return puntsDefensa;
    }

    protected void setPuntsDefensa(int puntsDefensa) {
        this.puntsDefensa = puntsDefensa;
    }

    public int getVides() {
        return vides;
    }

    protected void setVides(int vides) {
        this.vides = vides;
    }
    
    //Constructor
    public Jugador(String nom, int pA, int pD, int pV) {
        this.nom = nom;
        this.puntsAtac = pA;
        this.puntsDefensa = pD;
        this.vides = pV;
    }

    @Override
    public String toString() {
        return this.nom+" ( "+this.getClass().getSimpleName().toUpperCase()+", PA:"+
                this.getPuntsAtac()+" / PD:"+this.getPuntsDefensa()+
                " / PV:"+this.getVides()+" )";
    }

    protected void esColpejatAmb(int qpA) {
        
        System.out.println("");
        System.out.print(this.nom+" és colpejat amb "+qpA+" punts i es defén amb "+this.puntsDefensa+". Vides: "+this.vides);
        int qVmenys = this.puntsDefensa - qpA;
        if(qVmenys < 0){
            int qVres = this.vides + qVmenys;
            this.vides = qVres < 0 ? 0 : qVres;
            System.out.print("-"+(qVmenys < 0 ? -qVmenys : qVmenys)+" = "+this.vides);
        }
    }
    public void ataca(Jugador atacat){
        //ABANS DE L'ATAC:
        mostrarConfrontacio(this, atacat);
        //Jugador atacant = this;
        atacat.esColpejatAmb(this.getPuntsAtac());
        this.esColpejatAmb(atacat.getPuntsAtac());
        System.out.println("");
        //DESPRÉS DE L'ATAC:
        mostrarConfrontacio(atacat, this);
    }
    //Funció per a no repetir codi
    public void mostrarConfrontacio(Jugador atacant, Jugador atacat){
        System.out.println("");
        System.out.println("Atacant: "+atacant.toString());
        System.out.println("Atacat: "+atacat.toString());
    }
}
