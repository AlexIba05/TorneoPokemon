public class Charmender extends Pokemon implements IEvolvibile, IAttaccoSpeciale, IVolante {

    int vittorie= 0;
    boolean evoluto= false, volo=false;

    public Charmender() {
            super("Charmender", "fuoco", 30, 20, 15, 30);
            //TODO Auto-generated constructor stub
        }
    
        @Override
    public void vola() {
        if(!nome.equalsIgnoreCase("Charmender")) {
            volo = true;
            System.out.println(nome + "sta volando e quindi non subirà alcun danno");
        }
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
        int danno = this.puntiAttacco - avversario.puntiDifesa;
       if(danno < 0) {danno = 1;}
       avversario.subisciDanno(danno);
       System.out.println(nome + " attacca " + avversario.nome + " causando " + danno + " danni");
    }

}
