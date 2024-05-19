//Hi ha dos fitxers que tenem main: Inici i ProvesAmbFases

package inici;

import Teclat.Teclat;
import altres.Equip;
import excepcions.ArrayListBuitException;
import excepcions.AtacAMortException;
import excepcions.AtacarPropiEquipException;
import excepcions.AutoAtacException;
import excepcions.UnElementException;
import java.util.ArrayList;
import personatges.Jugador;

/**
 *
 * @author sofia
 */
public class Inici {
    public static void main(String[] args) {
        
        //Creació d'una quantitat de poders a l'inici del progama. I creació d'una llista de noms de jugadors aleatoris.
        JugadorsAleatoris.OmplirArrayListJugadors();
        JugadorsAleatoris.OmplirArrayListPoders();
        
        //Bucle amb menú inicial:
        int op = -1;
        while (op != 0) {
            op = Teclat.lligOpcio(
                    "JOC DE ROL",
                    "Configuració",
                    "Jugar");
            switch (op) {
                case 1:
                    menuConfiguracio();
                    break;
                case 2:
                    try {
                        try {
                            jugar();
                        } catch (AtacAMortException ex) {
                            System.out.println(ex.getMessage());
                        }
                    } catch (ArrayListBuitException | UnElementException ex) {
                        System.out.println(ex.getMessage());
                    }
            }
        }
    }
    
    private static void menuConfiguracio() {
        int op = -1;
        while (op != 0) {
            op = Teclat.lligOpcio(
                    "CONFIGURACIÓ",
                    "Jugadors",
                    "Equips",
                    "Poders",
                    "Crear jugadors aleatoris");
            switch (op) {
                case 1:
                    Jugadors.menu();
                    break;
                case 2:
                    Equips.menu();
                    break;
                case 3:
                    Poders.menu();
                    break;
                case 4:
                    JugadorsAleatoris.CrearJugadors();
                    
            }
        }
    }
    /**
     * Procediment jugar:
     * 1. Partida automàtica o manual
     * 2. Batalla individual o per equips
     * 
     * @throws AtacAMortException
     * @throws ArrayListBuitException
     * @throws UnElementException 
     */
    private static void jugar() throws AtacAMortException, ArrayListBuitException, UnElementException {
        if (Jugadors.llista.isEmpty()) {
            throw new ArrayListBuitException("La llista de jugadors està buida");
        }
        if (Jugadors.llista.size() == 1) {
            throw new UnElementException("Sols hi ha un jugador registrat");
        }
        char opPar = Teclat.lligChar("Jugar: Automatitzat o Manual?", "AM");
        char opBat = Teclat.lligChar("Partida individual o per equips?", "IE");

        if (opBat == 'E') {
            if (Equips.llista.isEmpty()) {
                throw new ArrayListBuitException("La llista d'equips està buida");
            }
            if (Equips.llista.size() < 2) {
                throw new UnElementException("Sols hi ha un equip registrat");
            }
        }

        if (opPar == 'A') {
            if (opBat == 'I') {

                do {
                    Jugador atacant = getJugRanViu(Jugadors.llista);
                    Jugador atacat;
                    do {
                        atacat = getJugRanViu(Jugadors.llista);
                    } while (atacat.equals(atacant));
                    atacant.ataca(atacat);

                } while (quanJugVius(Jugadors.llista) > 1);
                getJugadorGuanyador();
            } else {
                do {
                    Equip eAtacant = getEquRan();
                    Equip eAtacat;
                    do {
                        eAtacat = getEquRan();
                    } while (eAtacat.equals(eAtacant));
                    Jugador atacant = getJugRanViu(eAtacant.getJugadors());
                    Jugador atacat = getJugRanViu(eAtacat.getJugadors());
                    atacant.ataca(atacat);
                } while (quanEquVius(Equips.llista) > 1);
                getEquipGuanyador();
            }
        } else {
            if (opBat == 'I') {
                while (quanJugVius(Jugadors.llista) > 1) {
                    for (Jugador atacant : Jugadors.llista) {
                        try {
                            cridarAtacarManual(atacant, opBat);
                        } catch (AutoAtacException ex) {
                            System.out.println(ex.getMessage());

                        } catch (AtacarPropiEquipException ex) {
                            //Netbeans m'obliga a posar esta Excepció
                        }
                    }
                }
                getJugadorGuanyador();
            } else {
                while (quanEquVius(Equips.llista) > 1) {
                    String nomE = Teclat.lligString("Nom de l'equip atacant: ");
                    int posE = Equips.llista.indexOf(new Equip(nomE));
                    if (posE == -1) {
                        System.out.println("***No existeix l'equip***");
                    } else {
                        Equip eAtacant = Equips.llista.get(posE);
                        for (Jugador atacant : eAtacant.getJugadors()) {
                            try {
                                cridarAtacarManual(atacant, opBat);
                            } catch (AutoAtacException | AtacarPropiEquipException ex) {
                                System.out.println(ex.getMessage());
                            }
                        }
                    }
                }
                getEquipGuanyador();
            }

        }
    }
    /**
     * cridarAtacarManual s'ha creat per a no repetir codi en la opció de partida manual.
     * 
     * @param atacant
     * @param opBat
     * @throws AtacAMortException
     * @throws AutoAtacException
     * @throws AtacarPropiEquipException 
     */
    static public void cridarAtacarManual(Jugador atacant, char opBat) throws AtacAMortException, AutoAtacException, AtacarPropiEquipException{
        if (atacant.getVides() > 0) {
            System.out.println("Li toca jugar a " + atacant.getNom());
            String nomJ = Teclat.lligString("A quin jugador ataques? ");
            int posJ = Jugadors.llista.indexOf(new Jugador(nomJ, 0, 0, 0));
            if (posJ == -1) {
                System.out.println("***No existeix el jugador***");
            } else {
                Jugador atacat = Jugadors.llista.get(posJ);
                
                if(opBat == 'E' && atacant.getEquip().equals(atacat.getEquip())){
                    throw new AtacarPropiEquipException();
                }
                
                if(atacat.equals(atacant)){
                    throw new AutoAtacException();
                }
                
                try {
                    atacant.ataca(atacat);
                } catch (AtacAMortException e) {
                    System.out.println(e.getMessage());
                }
            }
        }else{
            System.out.println(atacant.getNom()+" està mort: No pot atacar.");
        }
    }
    
    static public Jugador getJugRanViu(ArrayList<Jugador> llista) {
        Jugador jugR = null;
        do {
            jugR = llista.get((int) (Math.random() * llista.size()));
        } while (jugR.getVides() == 0);
        return jugR;
    }

    static public int quanJugVius(ArrayList<Jugador> llista) {
        int contVius = 0;
        for (Jugador jugador : llista) {
            if (jugador.getVides() > 0) {
                contVius++;
            }
        }
        return contVius;
    }
    
    static public Equip getEquRan(){
        Equip eR = null;
        do{
            eR = Equips.llista.get((int) (Math.random() * Equips.llista.size()));
        }while(quanJugVius(eR.getJugadors()) == 0);
        return eR;
    }
    
    static public int quanEquVius(ArrayList<Equip> llista){
        int conEqV = 0;
        for (Equip equip : llista) {
            if(quanJugVius(equip.getJugadors()) > 0){
                conEqV++;
            }
        }
        return conEqV;
    }
    
    //Podria haver creat una altre ArrayList per a posar els jugadors morts en vegada de fer estes funcions:
    static public void getJugadorGuanyador() {
        for (Jugador jugador : Jugadors.llista) {
            if (jugador.getVides() > 0) {
                System.out.println("*** Ha guanyat: "+jugador.getNom()+" ***");
                break;
            }
        }
    }
    
    static public void getEquipGuanyador(){
        for (Equip equip : Equips.llista) {
            if(quanJugVius(equip.getJugadors()) > 0){
                System.out.println("*** Ha guanyat: "+equip.getNom()+" ***");
                break;
            }
        }
    }
}
