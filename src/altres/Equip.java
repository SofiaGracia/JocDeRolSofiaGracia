
package altres;

import java.util.ArrayList;
import personatges.Jugador;

/**
 *
 * @author sofia
 */
public class Equip {
    private String nom;
    ArrayList<Jugador> jugadors = new ArrayList();

    public String getNom() {
        return nom;
    }

    public void setNom(String nomEquip) {
        this.nom = nomEquip;
    }

    public Equip(String nom) {
        this.nom = nom;
    }
    
    public void posa(Jugador nouJ){
        
        if(nouJ.getEquip() == null &&(!this.jugadors.contains(nouJ))){
            this.jugadors.add(nouJ);
            nouJ.setEquip(this);
        }else if((nouJ.getEquip() != null)&&(!this.jugadors.contains(nouJ))){
            System.out.println("El jugador "+nouJ.getNom()+" ja està a "+nouJ.getEquip().getNom());
        }
    }
    
    public void lleva(String nomJ){
        
        int posJ = this.jugadors.indexOf(new Jugador(nomJ,0,0,0));
        if(posJ != -1){
            Jugador trobJ = this.jugadors.get(posJ);
            this.jugadors.remove(trobJ);
            trobJ.setEquip(null);
        }
    }

    @Override
    public String toString() {
        
        String infoJ = "";
        for (Jugador jugador : jugadors) {
            infoJ += "\t-"+jugador+"\n";
        }
        return "Equip "+this.nom+":\n"+infoJ;
    }

    @Override
    public boolean equals(Object obj) {
        final Equip eq = (Equip) obj;
        return this.nom.equals(eq.nom);
    }

    public ArrayList<Jugador> getJugadors() {//També haguerem pogut fer l'ArrayList d'Equip public
        return jugadors;
    }
}
