/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
        
        if(jNou.getEquip() == null &&(!this.jugadors.contains(jNou))){
            this.jugadors.add(jNou);
            jNou.setEquip(this);
        }else if((jNou.getEquip() != null)&&(!this.jugadors.contains(jNou))){
            System.out.println("El jugador "+jNou.getNom()+" ja està a "+jNou.getEquip().getNom());
        }
    }
    
    public void lleva(String nomJ){
        
        Jugador borrJug = new Jugador(nomJ,0,0,0);
        if(this.jugadors.remove(borrJug)){
            borrJug.setEquip(null);
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

    @Override
    public boolean equals(Object obj) {
        final Equip eq = (Equip) obj;
        return this.nom.equals(eq.nom);
    }
}
