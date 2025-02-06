import java.util.Random;

public class Pikachu extends Pokemon implements IEvolvibile, IAttaccoSpeciale {
    Random r = new Random();
    int vittorie = 0;
    boolean evoluto = false;

    public Pikachu() {
        super("Pikachu", "Elettro", 35, 25, 15, 35);
    }

    @Override
    public void eseguiMossaSPC(Pokemon avversario) {
        int danno = this.puntiAttacco * 2;
        if (danno < 0) {
            danno = 1;
        }
        avversario.subisciDanno(danno);
        System.out.println(nome + " usa attacco speciale su " + avversario.nome + " causando " + danno + " danni");
    }

    @Override
    public void evolvi() {
        if (vittorie >= 3 && !evoluto) {
            this.nome = "Raichu";
            this.puntiAttacco += 20;
            this.puntiDifesa += 10;
            this.SaluteMax += 30;
            puntiSalute = SaluteMax;
            System.out.println("Pikachu si è evoluto");
        }
    }

    @Override
    public void attaca(Pokemon avversario) {
        int ProbAttSpc = r.nextInt(100) + 1;
        if (ProbAttSpc < 40) {
            eseguiMossaSPC(avversario);
            return;
        }
        int danno = this.puntiAttacco - avversario.puntiDifesa;
        if (danno < 0) {
            danno = 1;
        }
        avversario.subisciDanno(danno);
        System.out.println(nome + " attacca " + avversario.nome + " causando " + danno + " danni");
    }

    @Override
    public void update() {
    }

}
