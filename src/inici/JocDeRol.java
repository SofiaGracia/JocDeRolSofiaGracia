/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inici;

import personatges.Alien;
import personatges.Guerrer;
import personatges.Huma;

/**
 *
 * @author sofia
 */
public class JocDeRol {
    public static void main(String[] args) {
        provaFase1();
    }
    static void provaFase1(){
        System.out.println("Vaig a crear un Humà");
        new Huma();
        System.out.println("Vaig a crear un Guerrer");
        new Guerrer();
        System.out.println("Vaig a crear un Alien");
        new Alien();
    }
}
