package inici;

import Teclat.Teclat;
import altres.Equip;
import java.util.ArrayList;

/**
 *
 * @author sofia
 */
public class Equips {
    static ArrayList<Equip> llista = new ArrayList();

    static void menu() {
        boolean ixir = false;
        while(! ixir){
            int op = Teclat.lligOpcio(
                    "EQUIPS", 
                "Crear", 
                "Consultar",
                "Eliminar",
                "Eixir");
            switch(op){
                case 1: crear(); break;
                case 2: consultar(); break;
                case 3: eliminar();break;
                case 0: ixir = true;
            }
        }
    }

    private static void crear() {
        String nomNouE = Teclat.lligString("Nom del nou equip: ");
        Equip nouE = new Equip(nomNouE);
        if(!llista.contains(nouE)){//Modifiquem l'equals d'equip
            llista.add(nouE);
        }
    }

    private static void consultar() {
        System.out.println("LLISTA DELS EQUIPS");
        for (Equip equip : llista) {
            System.out.println(equip);
        }
    }

    private static void eliminar() {
        String nomNouE = Teclat.lligString("Nom de l'equip: ");
        Equip buscE = new Equip(nomNouE);
        System.out.println(llista.remove(buscE)?"S'ha borrat l'equip":"No existeix l'equip");
    }
}
