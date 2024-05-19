package inici;

import Teclat.Teclat;
import altres.Poder;
import static inici.Jugadors.videsInicials;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import personatges.Alien;
import personatges.Guerrer;
import personatges.Huma;
import personatges.Jugador;

/**
 *Creació de jugadors aleatoris sense equip
 * per a facilitar fer proves amb la resta del programa
 * @author sofia
 */
public class JugadorsAleatoris {

    static String[] nomJugadors = {"Xavi", "Teresa", "Roser", "Pau", "Amparo", "Dani", "Alex", "Adri", "Joel", "Carles"};
    static ArrayList<String> nomJugs = new ArrayList();
    
    static char[] tipusJug = {'H', 'A', 'G'};
    
    static void OmplirArrayListJugadors() {
        nomJugs.addAll(Arrays.asList(nomJugadors));//Esta sintaxi me l'ha dita Netbeans
    }
    
    static void OmplirArrayListPoders(){//Com és per a fer proves ompliré l'ArrayList manualment
        Poders.llista.add(new Poder("Marejar",34,66));
        Poders.llista.add(new Poder("Caure",11,89));
        Poders.llista.add(new Poder("Volar",67,33));
    }

    static void CrearJugadors() {

        int qJ = Teclat.lligInt("Quantitat de jugadors a crear: ", 1, nomJugs.size());

        if (!nomJugs.isEmpty()) {
            for (int i = 0; i < qJ; i++) {

                Jugador nouJ = null;

                //Importem la clase random
                Random random = new Random();

                //Obtenim el nom
                int posNomRanJug = random.nextInt(nomJugs.size());
                String nomJ = nomJugs.get(posNomRanJug);

                //Punts d'Atac i de Defensa
                int pA = random.nextInt(1, 100);
                int pD = 100 - pA;

                //Triar tipus de jugador
                int posTipusJug = random.nextInt(tipusJug.length);

                switch (tipusJug[posTipusJug]) {
                    case 'H':
                        nouJ = new Huma(nomJ, pA, pD, videsInicials);
                        break;
                    case 'G':
                        nouJ = new Guerrer(nomJ, pA, pD, videsInicials);
                        break;
                    case 'A':
                        nouJ = new Alien(nomJ, pA, pD, videsInicials);
                }

                //Afegim el jugador a la llista de jugadors
                Jugadors.llista.add(nouJ);
                
                //Posibilitat de que el jugador tinga poder:
                int pos = random.nextInt(2);
                if(pos == 1){
                    
                    Poder p = Poders.llista.get(random.nextInt(Poders.llista.size()));

                    nouJ.posaPoder(p);//No entenc perquè me dona Deferencing null pointer
                }

                //Remove del nom del jugador de la llista de noms de jugadors aleatoris
                nomJugs.remove(nomJ);
            }
        }else{
            System.out.println("**La llista de jugadors aleatoris està buida***");
        }
    }
}