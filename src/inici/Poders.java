
package inici;

import Teclat.Teclat;
import altres.Poder;
import java.util.ArrayList;

/**
 *
 * @author sofia
 */
public class Poders {
    static ArrayList<Poder> llista = new ArrayList();

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
        String nomP = Teclat.lligString("Nom del poder: ");
        Poder nouP = new Poder(nomP,0,0);
        if(!llista.contains(nouP)){
            int baP = Teclat.lligInt("Bonus d'atac del poder: ",0,100);
            int bdP = 100 - baP;
            llista.add(new Poder(nomP,baP,bdP));
        }else{
            System.out.println("Ja existeix");
        }
    }

    private static void consultar() {
        System.out.println("LLISTA DE PODERS");
        for (Poder poder : llista) {
            System.out.println(poder);
        }
    }

    private static void eliminar() {
        String nomP = Teclat.lligString("Nom del poder: ");
        Poder buscP = new Poder(nomP,0,0);
        if(llista.contains(buscP)){
            llista.remove(llista.get(llista.indexOf(buscP)));
        }else{
            System.out.println("Ja existeix");
        }
    }
}
