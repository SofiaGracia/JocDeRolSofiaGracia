
package inici;

import Teclat.Teclat;
import altres.Equip;
import altres.Poder;
import java.util.ArrayList;
import personatges.Alien;
import personatges.Guerrer;
import personatges.Huma;
import personatges.Jugador;

/**
 *
 * @author sofia
 */
public class Jugadors {
    static ArrayList<Jugador> llista = new ArrayList();
    static int videsInicials = 200;
    
    static void menu() {
        int op = -1;
        while(op != 0){
            op = Teclat.lligOpcio(
                    "JUGADORS", 
                "Crear", 
                "Consultar",
                "Eliminar",
                "Assignar a equip",
                "Llevar d'equip",
                "Assignar poder",
                "Modificar vides inicials");
            switch(op){
                case 1: crear(); break;
                case 2: consultar(); break;
                case 3: eliminar();break;
                case 4: assignarEquip();break;
                case 5: llevarEquip();break;
                case 6: assignarPoder(); break;
                case 7: modificarVidesInicials();
            }
        }
    }

    private static void crear() {
        char tipusJ = Teclat.lligChar("Tipus de jugador", "HGA");
        String nomJ = Teclat.lligString("Nom del jugador: ");
        int pA = Teclat.lligInt("Punts d'atac del jugador", 1, 100);
        int pD = 100 - pA;
        Jugador nouJ = null;
        switch(tipusJ){
            case 'H': nouJ = new Huma(nomJ, pA, pD, videsInicials);break;
            case 'G': nouJ = new Guerrer(nomJ, pA, pD, videsInicials);break;
            case 'A': nouJ = new Alien(nomJ, pA, pD, videsInicials);
        }
        if (!llista.contains(nouJ)) {
            llista.add(nouJ);
        } else {
            System.out.println("El jugador " + nomJ + " ja existix");
        }
    }

    private static void consultar() {
        System.out.println("LLISTA DELS JUGADORS DE LA PARTIDA:");
        for (Jugador jugador : llista) {
            System.out.println("\n"+jugador);
        }
    }

    private static void eliminar() {
        String nomJ = Teclat.lligString("Nom del jugador a borrar: ");
        Jugador borrJ = new Jugador(nomJ,0,0,0);
        System.out.println(llista.remove(borrJ)?"S'ha borrat el jugador":"No existeix el jugador");
    }

    private static void assignarEquip() {
        Jugador busJ = buscarJugador();
        if(busJ != null){
            Equip busE = buscarEquip();
            if(busE != null){
                busE.posa(busJ);
            }else{
                System.out.println("L'equip no existix");
            }
        }else{
            System.out.println("El jugador no existix");
        }
    }

    private static void llevarEquip() {
        Jugador busJ = buscarJugador();
        if (busJ != null) {
            Equip busE = buscarEquip();
            if (busE != null) {
                if (busE.getNom().equals(busJ.getEquip().getNom())) {
                    busE.lleva(busJ.getNom());
                } else {
                    System.out.println("El jugador no pertany a este equip");
                }
            } else {
                System.out.println("L'equip no existix");
            }
        } else {
            System.out.println("El jugador no existix");
        }
    }
    
    private static void assignarPoder() {
        Jugador busJ = buscarJugador();
        if(busJ != null){
            String nomP = Teclat.lligString("Nom del poder: ");
            int posP = Poders.llista.indexOf(new Poder(nomP,0,0));
            if(posP != -1){
                busJ.posaPoder(Poders.llista.get(posP));
            }else{
                System.out.println("El poder no existix "+nomP);
            }
        }else{
            System.out.println("El jugador no existix");
        }
    }
    
    private static Jugador buscarJugador(){
        String nomJ = Teclat.lligString("Nom del jugador: ");
        Jugador buscJ = new Jugador(nomJ,0,0,0);
        return llista.contains(buscJ)? llista.get(llista.indexOf(buscJ)) : null;
    }
    
    private static Equip buscarEquip(){
        String nomE = Teclat.lligString("Nom de l'equip: ");
        Equip buscE = new Equip(nomE);
        return Equips.llista.contains(buscE)? Equips.llista.get(Equips.llista.indexOf(buscE)) : null;
    }
    
    /**
     * Posa i modifica les vides inicials dels jugadors.
     * Hi ha que comentar que els jugadors de la clase Humà sempre tindrán 100 punts com a vides inicials.
     */
    private static void modificarVidesInicials() {
        videsInicials = Teclat.lligInt("Indica vides inicials dels jugadors (Valor actual: "+videsInicials+")", 1, 200);
        
        //Gaste un fore per a canviar les videsInicials dels jugadors que ja estan registrats
        for (Jugador jugador : llista) {
            jugador.setVides(videsInicials);
        }
    }
}
