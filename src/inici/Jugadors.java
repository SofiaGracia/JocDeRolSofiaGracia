
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
        boolean ixir = false;
        while(! ixir){
            int op = Teclat.lligOpcio(
                    "JUGADORS", 
                "Crear", 
                "Consultar",
                "Eliminar",
                "Assignar a equip",
                "Llevar d'equip",
                "Assignar poder",
                "Eixir");
            switch(op){
                case 1: crear(); break;
                case 2: consultar(); break;
                case 3: eliminar();break;
                case 4: assignarEquip();break;
                case 5: llevarEquip();break;
                case 6: assignarPoder();break;
                case 0: ixir = true;
            }
        }
    }

    private static void crear() {
        //Tipus de jugador
        char tipusJ = Teclat.lligChar("Tipus de jugador", "HGA");
        //Nom del jugador
        String nomJ = Teclat.lligString("Nom del jugador: ");
        //Els punts d'atac
        int pA = Teclat.lligInt("Punts d'atac del jugador", 1, 100);
        //Punts de defensa
        int pD = 100 - pA;
        //Comprovar i posar el jugador
        Jugador nouJ = null;
        switch(tipusJ){
            case 'H': nouJ = new Huma(nomJ, pA, pD, videsInicials);break;
            case 'G': nouJ = new Guerrer(nomJ, pA, pD, videsInicials);break;
            case 'A': nouJ = new Alien(nomJ, pA, pD, videsInicials);break;
        }
        if(!llista.contains(nouJ)){llista.add(nouJ);}
    }

    private static void consultar() {
        System.out.println("LLISTA DELS JUGADORS DE LA PARTIDA:");
        for (Jugador jugador : llista) {
            System.out.println(jugador);
        }
    }

    private static void eliminar() {
        String nomJ = Teclat.lligString("Nom del jugador a borrar: ");
        Jugador borrJ = new Jugador(nomJ,0,0,0);
        System.out.println(llista.remove(borrJ)?"S'ha borrat el jugador":"No existeix el jugador");
    }

    private static void assignarEquip() {
        String nomJ = Teclat.lligString("Nom del jugador: ");
        Jugador buscJ = new Jugador(nomJ,0,0,0);
        if(llista.contains(buscJ)){
            Jugador trobJ = llista.get(llista.indexOf(buscJ));
            String nomE = Teclat.lligString("Nom de l'equip: ");
            Equip buscE = new Equip(nomE);
            if(Equips.llista.contains(buscE)){
                buscE.posa(trobJ);
            }
        }else{
            System.out.println("El jugador no existeix");
        }
    }

    private static void llevarEquip() {
        String nomJ = Teclat.lligString("Nom del jugador: ");
        Jugador buscJ = new Jugador(nomJ,0,0,0);
        if(llista.contains(buscJ)){
            Jugador trobJ = llista.get(llista.indexOf(buscJ));
            String nomE = Teclat.lligString("Nom de l'equip: ");
            Equip buscE = new Equip(nomE);
            Equip trobE = Equips.llista.get(Equips.llista.indexOf(nomE));
            if(trobE.getNom().equals(trobJ.getEquip().getNom())){
                trobE.lleva(nomJ);
            }
        }else{
            System.out.println("El jugador no existeix");
        }
    }
    
    private static void assignarPoder() {
        String nomJ = Teclat.lligString("Nom del jugador: ");
        Jugador buscJ = new Jugador(nomJ,0,0,0);
        if(llista.contains(buscJ)){
            Jugador trobJ = llista.get(llista.indexOf(buscJ));
            String nomP = Teclat.lligString("Nom del poder: ");
            int baP = Teclat.lligInt("Bonus d'atac del poder: ",0,100);
            int bdP = 100 - baP;
            trobJ.posaPoder(new Poder(nomP, baP, bdP));
        }else{
            System.out.println("El jugador no existeix");
        }
    }
}
