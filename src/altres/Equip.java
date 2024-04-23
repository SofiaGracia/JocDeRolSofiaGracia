/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package altres;

import java.util.ArrayList;
import java.util.Objects;
import personatges.Huma;
import personatges.Jugador;

/**
 *
 * @author sofia
 */
public class Equip {
    private String nom;
    ArrayList<Jugador> jugadors = new ArrayList();
    
    public Equip(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nomEquip) {
        this.nom = nomEquip;
    }
    
    public void posa(Jugador jNou){
        //El métode ha de posar eixe objecte en la llista de jugadors de l'equip.
        if(!this.jugadors.contains(jNou)){
            this.jugadors.add(jNou);
            jNou.setEquip(this);
        }else{
            System.out.println("Ja existeix el jugador");
        }
    }
    
    public void lleva(String nomJ){
        //Anem a crear un jugador amb eixe nom
        Jugador borrJug = new Jugador(nomJ,0,0,0);
        
        if(this.jugadors.contains(borrJug)){
            int posJ = this.jugadors.indexOf(borrJug);
            Jugador jugB = this.jugadors.get(posJ);
            this.jugadors.remove(jugB);
            jugB.setEquip(null);
        }
    }

    @Override
    public String toString() {
        
        String infoJ = "";
        for (Jugador jugador : jugadors) {
            infoJ += "\t-"+jugador.toString()+"\n";
        }
        return "Equip "+this.nom+":\n"+infoJ;
    }
}
