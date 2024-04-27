/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inici;

import altres.Equip;
import altres.Poder;
import excepcions.AtacAMortException;
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
        provaFase4();
        provaFase5();
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
        
//        Jugador a1 = new Alien("E.T.", 4, 20, 33);
//        Jugador g1 = new Guerrer("Sofia", 0, 1, 0);
//        
//        try{
//            a1.ataca(g1);
//        }catch(AtacAMortException e){
//            System.out.println(e.getMessage());
//        }
//        
//        try{
//            g1.ataca(a1);
//        }catch(AtacAMortException e){
//            System.out.println(e.getMessage());
//        }
//        System.out.println(a1.toString());
    }
    static void provaFase4(){
//        Jugador h1 = new Huma("Pep_Garcia", 13, 8, 105);
//        Jugador a1 = new Alien("E.T.", 4, 20, 33);
//        Jugador g1 = new Guerrer("Sofia", 0, 1, 0);
//        
//        Equip e1 = new Equip("SuecaUnited");
//        
//        //Provem a posar a h1
//        e1.posa(h1);
//        
//        e1.posa(g1);
//        e1.posa(a1);
//        e1.posa(h1);
    }
    static void provaFase5(){
        Jugador h1 = new Huma("HumaSofia", 13, 8, 105);
        Jugador a1 = new Alien("AlienSofia", 4, 20, 33);
        Jugador g1 = new Guerrer("GuerrerSofia", 10, 1, 11);
        
        Jugador h2 = new Huma("HumaRoser", 13, 8, 105);
        Jugador a2 = new Alien("AlienRoser", 4, 20, 33);
        Jugador g2 = new Guerrer("GuerrerRoser", 10, 1, 11);
        Equip e1 = new Equip("SofiaUnited");Equip e2 = new Equip("RoserUnited");
        e1.posa(h1);e1.posa(a1);e1.posa(g1);
        e2.posa(h2);e2.posa(a2);e2.posa(g2);
        e1.posa(h1);
                
        Poder aire = new Poder("Aire",10,1);
        Poder terra = new Poder("Terra",5,11);
        
        h1.posaPoder(aire);
        
        h2.posaPoder(aire);
        h2.posaPoder(terra);
        System.out.println("");
        System.out.println("EQUIP SOFIA");
        System.out.println(e1.toString());
        System.out.println("");
        System.out.println("EQUIP ROSER");
        System.out.println(e2.toString());
        System.out.println("");
        System.out.println(h1.toString());
        System.out.println(a1.toString());
        
        try{
            h1.ataca(h2);
        }catch(AtacAMortException e){
            System.out.println(e.getMessage());
        }
        try{
            a1.ataca(h2);
        }catch(AtacAMortException e){
            System.out.println(e.getMessage());
        }
    }
}
