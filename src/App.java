import java.util.ArrayList;
import java.util.List;

public class App {
    public static int turno = 0;

    public static void main(String[] args) throws Exception {

        List<Pokemon> red = new ArrayList<>();
        List<Pokemon> blue = new ArrayList<>();

        red.add(new Pikachu());
        red.add(new Charmender());

        blue.add(new Pikachu());
        blue.add(new Onix());

        System.out.println("Comincia la battaglia!!!");
        System.out.println("Scendono in campo i nostri sfidanti: ");

        for (;;) {
            turno++;
            System.out.println("Inzio del turno: " + turno);

            Pokemon redp = getFirstAlive(red);
            Pokemon blup = getFirstAlive(blue);

            if (redp == null || blup == null) {
                if (redp == null) {
                    System.out.println("Ha vinto il blu");
                } else System.out.println("Ha vinto il rosso");

                break;
            }

            System.out.println("Turno Red");
            redp.attaca(blup);
            System.out.println("Turno Blue");
            if (blup.isAlive())
                blup.attaca(redp);
            else System.out.println("Salta turno, pokemon esausto. sceglierà il prossimo");

            System.out.println();
        }
    }

    public static Pokemon getFirstAlive(List<Pokemon> allenatore) {
        for (Pokemon pokemon : allenatore) {
            if (pokemon.isAlive()) return pokemon;
        }

        return null;
    }
}
