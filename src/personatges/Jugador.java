
package personatges;

import altres.Equip;
import excepcions.AtacAMortException;
import java.util.Objects;

/**
 *
 * @author sofia
 */
public class Jugador {
    
    private String nom;
    private int puntsAtac;
    private int puntsDefensa;
    private int vides;
    private Equip equip;
    
    //Constructor
    public Jugador(String nom, int pA, int pD, int pV) {
        this.nom = nom;
        this.puntsAtac = pA;
        this.puntsDefensa = pD;
        this.vides = pV;
    }
    
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

    @Override
    public String toString() {
        return this.nom+" ["+(this.equip == null? "Sense equip" : this.equip.getNom())+"] ( "+this.getClass().getSimpleName().toUpperCase()+", PA:"+
                this.getPuntsAtac()+" / PD:"+this.getPuntsDefensa()+
                " / PV:"+this.getVides()+" )";
    }

    protected void esColpejatAmb(int qpA) {
        
        System.out.println("");
        System.out.print(this.nom+" és colpejat amb "+qpA+" punts i es defén amb "+this.puntsDefensa+". Vides: "+this.vides);
        int ferida = this.puntsDefensa - qpA;
        if(ferida < 0){
            this.vides = (this.vides + ferida) < 0 ? 0 : (this.vides + ferida);
            System.out.print("-"+(ferida < 0 ? -ferida : ferida)+" = "+this.vides);
        }
    }
    public void ataca(Jugador atacat) throws AtacAMortException{
        //ABANS DE L'ATAC:
        mostrarConfrontacio(this, atacat);
        
        if(atacat.getVides() == 0){
            throw new AtacAMortException();
        }
        atacat.esColpejatAmb(this.getPuntsAtac());
        this.esColpejatAmb(atacat.getPuntsAtac());
        
        System.out.println("");
        //DESPRÉS DE L'ATAC:
        mostrarConfrontacio(this, atacat);
    }
    //Funció per a no repetir codi
    public void mostrarConfrontacio(Jugador atacant, Jugador atacat){
        System.out.println("");
        System.out.println("Atacant: "+atacant.toString());
        System.out.println("Atacat: "+atacat.toString());
    }
    
    @Override
    public boolean equals(Object obj) {
        final Jugador jug = (Jugador)obj;
        return this.nom.equals(jug.nom);
    }

//    public boolean equals(Jugador jug) {
//        return this.nom.equals(jug.nom);
//    }

    public Equip getEquip() {
        return equip;
    }

    public void setEquip(Equip equip) {
        
        if(equip != null && this.equip == null){
            //posar
            this.equip = equip;
            equip.posa(this);
        }else if(equip == null && this.equip != null){
            //llevar
            this.equip.lleva(this.nom);
            this.equip = null;
        }
    }
    
}
