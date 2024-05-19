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
        int op = -1;
        while(op != 0){
            op = Teclat.lligOpcio(
                    "EQUIPS", 
                "Crear", 
                "Consultar",
                "Eliminar");
            switch(op){
                case 1: crear(); break;
                case 2: consultar(); break;
                case 3: eliminar();
            }
        }
    }

    private static void crear() {
        String nomE = Teclat.lligString("Nom del nou equip: ");
        Equip nouE = new Equip(nomE);
        if(!llista.contains(nouE)){
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

        if (Teclat.lligBoolean("Els jugadors d'este equip quedaran sense equip. Continuar?")) {

            String nomE = Teclat.lligString("Nom de l'equip: ");
            Equip buscE = new Equip(nomE);

            if (llista.contains(buscE)) {
                Equip trobE = llista.get(llista.indexOf(buscE));
                int qJ = trobE.getJugadors().size() - 1;
                /*He gastat un while perquè:
                - La interfície iterator no em deixava gastar la funció lleva()  ---> ConcurrentModificationException
                - Amb fore/fori gastant el remove() ---> ConcurrentModificationException
                - Gastant fore/fori amb la funció lleva() ---> Modifica l'ArrayList de Jugadors al mateix temps que el recorre (No podia accedir bé a tots els jugadors).
                */
                while (qJ >= 0) {
                    trobE.lleva(trobE.getJugadors().get(qJ).getNom());
                    qJ--;
                }
                llista.remove(trobE);
            } else {
                System.out.println("No existix l'equip");
            }
        }
    }
}
