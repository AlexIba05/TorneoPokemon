import java.util.ArrayList;
import java.util.List;

public class App {
    public static int turno= 0;
    public static void main(String[] args) throws Exception {
      
        List<Pokemon> Red = new ArrayList<>();
        List<Pokemon> Blue = new ArrayList<>();

        Red.add(new Pikachu());
        Red.add(new Charmender());

        Blue.add(new Pikachu());
        Blue.add(new Onix());

        System.out.println("Comincia la battaglia!!!");
        System.out.println("Scendono in campo i nostri sfidanti: " );

        while(continua(Red, Blue)) {
            turno++;
            System.out.println("Inzio del turno: " + turno);
            System.out.println("");

        }



    }

    public static boolean continua(List<Pokemon> Red, List<Pokemon> Blue) {
        boolean Alldie= true;
       for (Pokemon r : Red) {
            if (r.IsAlive()) {
                Alldie= false;
                break;
            }
       }
       boolean Alldie2= true;
       for (Pokemon b : Blue) {
        if (b.IsAlive()) {
            Alldie2= false;
            break;
        }
   }
        return !(Alldie || Alldie2);
    }
}
