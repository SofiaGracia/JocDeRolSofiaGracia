
package personatges;

import altres.Equip;
import altres.Poder;
import excepcions.AtacAMortException;
import java.util.ArrayList;
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
    private ArrayList<Poder> poders = new ArrayList();
    
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
        
        String poders = "";
        if(!this.poders.isEmpty()){
            for (Poder poder : this.poders) {
                poders += "\n"+poder.toString();
            }
        }
        return this.nom+" ["+(this.equip == null? "Sense equip" : this.equip.getNom())+"] ( "+
                this.getClass().getSimpleName().toUpperCase()+
                ", PA:"+this.getPuntsAtac()+" / PD:"+this.getPuntsDefensa()+" / PV:"+this.getVides()+" )"+
                (!this.poders.isEmpty()? poders: "");
    }

    protected void esColpejatAmb(int qpA) {
        System.out.println("");
        System.out.print(this.nom+" és colpejat amb "+qpA+" punts i es defén amb "+(this.puntsDefensa+this.sumaB("D"))+". Vides: "+this.vides);
        int ferida = (this.puntsDefensa+this.sumaB("D")) - qpA;
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
        atacat.esColpejatAmb(this.getPuntsAtac()+this.sumaB("A"));
        this.esColpejatAmb(atacat.getPuntsAtac()+atacat.sumaB("A"));
        System.out.println("");
        //DESPRÉS DE L'ATAC:
        mostrarConfrontacio(this, atacat);
    }
    public void mostrarConfrontacio(Jugador atacant, Jugador atacat){
        System.out.println("");
        System.out.println("Atacant: "+atacant.toString());
        System.out.println("Atacat: "+atacat.toString());
    }
    public int sumaB(String tipusBonus){//No fem ningún control, però tampoc arrepleguem res de teclat
        int Bonus = 0,BA = 0, BD = 0;
        if(!this.poders.isEmpty()){
            for (Poder poder : this.poders) {
                BA += poder.getBonusAtac();
                BD += poder.getBonusDefensa();
            }
        }
        switch(tipusBonus){
                case "A": Bonus = BA; break;
                case "D": Bonus = BD; break;
            }
        return Bonus;
    }
    @Override
    public boolean equals(Object obj) {
        final Jugador jug = (Jugador)obj;
        return this.nom.equals(jug.nom);
    }
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
    //Métodes poder
    public void posaPoder(Poder pod){
        if(this.poders.indexOf(pod) == -1){
            this.poders.add(pod);
        }else{
            System.out.println(this.nom+" ja té el poder "+pod);
        }
    }
    public void llevaPoder(Poder pod){
        if(this.poders.indexOf(pod) == -1){
            System.out.println(this.nom+" no té el poder "+pod);
        }else{
            this.poders.remove(pod);
        }
    }
}
