import java.util.Random;

public class Onix extends Pokemon implements ICorazzato, IAttaccoSpeciale{
    Random r= new Random();
    int AttCorazzato, DifCorazzato;
    boolean corazzato=false;
    
    public Onix() {
            super("Onix", "Roccia", 40, 15, 30, 40);
        }

    @Override
    public void eseguiMossaSPC(Pokemon avversario) {
        int danno = this.puntiAttacco * 2;
        if(danno < 0) {danno = 1;}
        avversario.subisciDanno(danno);
        System.out.println(nome + "usa attacco speciale su " + avversario.nome + " causando " + danno + " danni");
    }

    @Override
    public void corazzato() {
       if(!corazzato) {
        corazzato= true;
        AttCorazzato = puntiAttacco;
        DifCorazzato = puntiDifesa;
        puntiAttacco = 10;
        puntiDifesa = 50;
        System.out.println(nome + "si è refforzato e la sua difesa aumenta, attacco diminuito");
       }
    }

    @Override
    public void attaca(Pokemon avversario) {
        int danno;
        int ProbAttSpc = r.nextInt(100)+1;
        if (ProbAttSpc < 40) {eseguiMossaSPC(avversario); return;}
        danno = this.puntiAttacco - avversario.puntiDifesa;
       if(danno < 0) {danno = 1;}
       avversario.subisciDanno(danno);
       System.out.println(nome + " attacca " + avversario.nome + " causando " + danno + " danni");
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

}
