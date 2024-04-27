
package inici;

import Teclat.Teclat;
import excepcions.AtacAMortException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import personatges.Jugador;

/**
 *
 * @author sofia
 */
public class JocDeRolinici {
    public static void main(String[] args) {
        //Bucle amb menú inicial:
        boolean ixir = false;
        while(! ixir){
            int op = Teclat.lligOpcio(
                    "JOC DE ROL", 
                "Configuració", 
                "Jugar",
                "Eixir");
            switch(op){
                case 1: menuConfiguracio(); break;
                case 2: jugar(); break;
                case 0: ixir = true;
            }
        }
    }

    private static void menuConfiguracio() {
        boolean ixir = false;
        while(! ixir){
            int op = Teclat.lligOpcio(
                    "CONFIGURACIÓ", 
                "Jugadors", 
                "Equips",
                "Poders",
                "Eixir");
            switch(op){
                case 1: Jugadors.menu(); break;
                case 2: Equips.menu(); break;
                case 3: Poders.menu();break;
                case 0: ixir = true;
            }
        }
    }

    private static void jugar() {
        char op = Teclat.lligChar("Jugar: Automatitzat o Manual?", "A/M");
        switch(op){
            case 'A':
                //Bucle fins que només quede 1 viu.
                //Tria aleatòriament el jugador de la llista que atacarà
                while(contJugsVius(Jugadors.llista) > 0){
                    Jugador atacaNt = null;
                    do{
                        int aNtPos = ((int)(Math.random()*(Jugadors.llista.size()-1)));
                        atacaNt = Jugadors.llista.get(aNtPos);
                    }while(atacaNt.getVides() <= 0);
                    //Tria aleatòriament el jugador de la llista que serà atacat
                    Jugador atacat = null;
                    do{
                        int atPos = ((int)(Math.random()*(Jugadors.llista.size()-1)));
                        atacat = Jugadors.llista.get(atPos);
                    }while(atacat.equals(atacaNt) && atacat.getVides() <= 0);
                
                    try {
                        //Es farà l'atac invocant el mètode atacar().
                        atacaNt.ataca(atacat);
                    } catch (AtacAMortException ex) {
                        System.out.println("Error: Atac a mort");
                    }
                }
                break;
            case 'M':
                while(contJugsVius(Jugadors.llista) > 0){
                    for (int pos = 0; pos < Jugadors.llista.size(); pos++) {
                        Jugador atacaNt = Jugadors.llista.get(pos);
                        if(atacaNt.getVides() > 0){
                            System.out.println("Li toca jugar a "+atacaNt);
                            String nomJ = Teclat.lligString("A quin jugador ataques? ");
                            Jugador jugBus = new Jugador(nomJ,0,0,0);
                            int posJ = Jugadors.llista.indexOf(jugBus);
                            if(posJ != -1){
                                Jugador atacat = Jugadors.llista.get(posJ);
                                try {
                                    atacaNt.ataca(atacat);
                                } catch (AtacAMortException ex) {
                                    System.out.println("No es pot atacar a un jugador mort");
                                }
                            }else{
                                System.out.println("No existeix el jugador");
                            }
                        }
                    }
                }
                break;
        }
    }
    
    private static int contJugsVius(ArrayList<Jugador> llista){
        int conJug = 0;
        for (Jugador jugador : llista) {
            if(jugador.getVides()>0){conJug++;}
        }
        return conJug;
    }
}
