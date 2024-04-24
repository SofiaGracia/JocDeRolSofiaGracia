
package personatges;

import altres.Equip;
import altres.Poder;
import excepcions.AtacAMortException;
import java.util.ArrayList;
import java.util.Arrays;
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
        int conBA = 0, conBD = 0;
        if(this.poders.size() > 0){
            for (Poder poder : this.poders) {
                poders += "\t\n- "+poder.toString();
                conBA += poder.getBonusAtac();
                conBD += poder.getBonusDefensa();
            }
        }
        
        return this.nom+" ["+(this.equip == null? "Sense equip" : this.equip.getNom())+"] ( "+this.getClass().getSimpleName().toUpperCase()+", PA:"+
                this.getPuntsAtac()+" / PD:"+this.getPuntsDefensa()+
                " / PV:"+this.getVides()+" )"+
                (this.poders.size() > 0? poders+"\n>Total BA i BD: "+conBA+" / "+conBD: "");
    }

    protected void esColpejatAmb(int qpA) {
        System.out.print(this.nom+" és colpejat amb "+qpA+" punts i es defén amb "+(this.puntsDefensa+this.sumaB("D"))+". Vides: "+this.vides);
        int ferida = (this.puntsDefensa+this.sumaB("D")) - qpA;
        if(ferida < 0){
            this.vides = (this.vides + ferida) < 0 ? 0 : (this.vides + ferida);
            System.out.print("-"+(ferida < 0 ? -ferida : ferida)+" = "+this.vides);
        }
        System.out.println("");
    }
    public int sumaB(String tipusBonus){//Esta solució no és vàlida si canvie el format del toString
        int Bonus = 0;
        if(this.poders.size() > 0){
            String [] paraules = this.toString().split(" ");
            switch(tipusBonus){
                case "A": Bonus = Integer.parseInt(paraules[paraules.length-3]); break;
                case "D": Bonus = Integer.parseInt(paraules[paraules.length-1]); break;
                default: Bonus = 0;
            }
        }
        return Bonus;
    }
    public void ataca(Jugador atacat) throws AtacAMortException{
        //ABANS DE L'ATAC:
        mostrarConfrontacio(this, atacat);
        
        if(atacat.getVides() == 0){
            throw new AtacAMortException();
        }
        atacat.esColpejatAmb(this.getPuntsAtac()+this.sumaB("A"));
        this.esColpejatAmb(atacat.getPuntsAtac()+this.sumaB("A"));
        
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
