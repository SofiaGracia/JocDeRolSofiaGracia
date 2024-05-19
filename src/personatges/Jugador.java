
package personatges;

import altres.Equip;
import altres.Poder;
import excepcions.AtacAMortException;
import java.util.ArrayList;

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
    private final ArrayList<Poder> poders = new ArrayList();
    
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
    
    //L'he posada pública per a que siga accesible per a modificarVidesIncials() en la clase Jugadors.
    public void setVides(int vides) {
        this.vides = vides;
    }

    @Override
    public String toString() {
        
        String qPoders = "";
        for (Poder poder : this.poders) {
            qPoders += "\n\t"+poder.toString();
        }
        return this.nom+" ["+(this.equip == null? "Sense equip" : this.equip.getNom())+"] ( "+
                this.getClass().getSimpleName().toUpperCase()+
                ", PA:"+this.getPuntsAtac()+" / PD:"+this.getPuntsDefensa()+" / PV:"+this.getVides()+" )"+qPoders;//No mostrarà res si el jugador no té poders
    }
    
    protected void esColpejatAmb(int qpA) {
        System.out.print("\n"+this.nom+" és colpejat amb "+qpA+" punts i es defén amb "+(this.puntsDefensa+this.sumaB("D"))+". Vides: "+this.vides);
        int ferida = (this.puntsDefensa+this.sumaB("D")) - qpA;
        if(ferida < 0){
            this.vides = (this.vides + ferida) < 0 ? 0 : (this.vides + ferida);
            
            System.out.print("-"+(ferida < 0 ? -ferida : ferida)+" = "+this.vides+"\n");//Si no li lleva vides no mostrem la resta
        }
    }
    
    public void ataca(Jugador atacat) throws AtacAMortException{
        System.out.println("\nABANS DE L'ATAC:");
        mostrarConfrontacio(this, atacat);
        if(atacat.getVides() == 0){
            throw new AtacAMortException();
        }
        atacat.esColpejatAmb(this.getPuntsAtac()+this.sumaB("A"));
        this.esColpejatAmb(atacat.getPuntsAtac()+atacat.sumaB("A"));
        System.out.println("\n\nDESPRÉS DE L'ATAC:");
        mostrarConfrontacio(this, atacat);
    }
    
    private void mostrarConfrontacio(Jugador atacant, Jugador atacat){
        System.out.println("Atacant: "+atacant.toString());
        System.out.println("Atacat: "+atacat.toString());
    }
    
    /**
     * Funció que suma la quantitat de punts dels Bonus dels Poders que té un jugador segons el tipus de Bonus
     * @param tipusBonus
     * @return Suma del punts del tipus de Bonus que hem indicat
     */
    protected int sumaB(String tipusBonus){//No fem cap control, però tampoc arrepleguem res de teclat. L'he deixat en protected per a que puga accedir Guerrer.
        int BA = 0, BD = 0;
        for (Poder poder : this.poders) {
            BA += poder.getBonusAtac();
            BD += poder.getBonusDefensa();
        }
        return tipusBonus.equals("A")? BA: BD;
    }
    
    @Override
    public boolean equals(Object obj) {
        final Jugador jug = (Jugador)obj;
        return this.nom.equals(jug.nom);
    }
    
    //Procediments Equip
    public Equip getEquip() {
        return equip;
    }
    
    public void setEquip(Equip equip) {
        if(this.equip == null && equip != null){
            //posar
            this.equip = equip;
            this.equip.posa(this);
        }else if(equip == null && this.equip != null){
            //llevar
            this.equip.lleva(this.nom);
            this.equip = null;
        }
    }
    
    //Procediments Poder
    public void posaPoder(Poder pod){
        if(this.poders.indexOf(pod) == -1){
            this.poders.add(pod);
        }else{
            System.out.println(this.nom+" ja té el poder "+pod.getNom());
        }
    }
    
    public void llevaPoder(Poder pod){
        if(this.poders.indexOf(pod) == -1){
            System.out.println(this.nom+" no té el poder "+pod.getNom());
        }else{
            this.poders.remove(pod);
        }
    }
}
