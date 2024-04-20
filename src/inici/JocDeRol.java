/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inici;

import excepcions.AtacAMortException;
import java.util.logging.Level;
import java.util.logging.Logger;
import personatges.Alien;
import personatges.Guerrer;
import personatges.Huma;
import personatges.Jugador;

/**
 *
 * @author sofia
 */
public class JocDeRol {
    public static void main(String[] args) {
        provaFase1();
        provaFase2();
        try {
            provaFase3();
        } catch (AtacAMortException ex) {
            System.out.println(ex.getMessage());
        }
    }
    static void provaFase1(){
//        System.out.println("Vaig a crear un Humà");
//        Jugador h = new Huma();
//        System.out.println("Vaig a crear un Guerrer");
//        Jugador g = new Guerrer();
//        System.out.println("Vaig a crear un Alien");
//        Jugador a = new Alien();
    }
    static void provaFase2(){
//        Jugador h2 = new Huma("Pep_Garcia", 13, 8, 39);
//        Jugador g2 = new Guerrer("Superpep", 27, 20, 32);
//        h2.ataca(g2);
    }
    static void provaFase3() throws AtacAMortException {
//        Jugador h2 = new Huma("Pep_Garcia", 13, 8, 105);
////        Jugador g2 = new Guerrer("Superpep", 27, 20, 32);
////        h2.ataca(g2);
//        System.out.println(h2.toString());
        
        Jugador a1 = new Alien("E.T.", 4, 20, 33);
        Jugador g1 = new Guerrer("Sofia", 10, 1, 3);
        System.out.println("INFO ALIEN: ");
        System.out.println(a1.toString());
        a1.ataca(g1);
        g1.ataca(a1);
        
        System.out.println("SEGONA PART:");
    }
}
