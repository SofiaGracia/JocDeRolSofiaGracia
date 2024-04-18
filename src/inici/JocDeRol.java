/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inici;

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
        Jugador h2 = new Huma("Pep_Garcia", 13, 8, 39);
        Jugador g2 = new Guerrer("Superpep", 27, 20, 32);
        
//        System.out.println("DADES PEP");
//        System.out.println(h2.toString());
//        
//        System.out.println("DADES SUPERPEP");
//        System.out.println(g2.toString());
        
        
        h2.ataca(g2);
    }
}
