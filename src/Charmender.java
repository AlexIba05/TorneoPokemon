import java.util.Random;

public class Charmender extends Pokemon implements IEvolvibile, IAttaccoSpeciale, IVolante {
    Random r= new Random();
    int vittorie= 0, turnoVolo= -1;
    boolean evoluto= false, volo=false;

    public Charmender() {
            super("Charmender", "fuoco", 30, 20, 15, 30);
        }
    
        @Override
    public void vola() {
        if(!nome.equalsIgnoreCase("Charmender") && !volo) {
            volo = true;
            turnoVolo = App.turno;
            System.out.println(nome + "sta volando e quindi non subirà alcun danno");
        }
    }

    @Override
    public void subisciDanno(int danno) {
        if (volo) {
           super.subisciDanno(0);
        }
        else subisciDanno(danno);
    }

    @Override
    public void eseguiMossaSPC(Pokemon avversario) {
        int danno = this.puntiAttacco * 2;
        if(danno < 0) {danno = 1;}
        avversario.subisciDanno(danno);
        System.out.println(nome + "usa attacco speciale su " + avversario.nome + " causando " + danno + " danni");
    }

    @Override
    public void evolvi() {
       if (vittorie >= 3 && !evoluto) {
        this.nome = "Charmeleon";
        this.puntiAttacco += 20;
        this.puntiDifesa += 10;
        this.SaluteMax += 30;
        puntiSalute = SaluteMax;
        System.out.println("Charmender  si è evoluto");
       } 
    }

    @Override
    public void attaca(Pokemon avversario) {
        if (volo) return;
        int ProbAttSpc = r.nextInt(100)+1;
        if (ProbAttSpc < 40) {eseguiMossaSPC(avversario); return;}
        int ProbVoloSpc = r.nextInt(100)+1;
        if (ProbVoloSpc < 20) {vola(); return;}
        int danno = this.puntiAttacco - avversario.puntiDifesa;
       if(danno < 0) {danno = 1;}
       avversario.subisciDanno(danno);
       System.out.println(nome + " attacca " + avversario.nome + " causando " + danno + " danni");
    }

    @Override
    public void update() {
        if (App.turno > turnoVolo+1) {
            volo = false;
            System.out.println(nome + " è sceso e riprende a combattere");
        }
    }

}
