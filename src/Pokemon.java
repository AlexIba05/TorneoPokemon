public abstract class Pokemon {
    protected String nome, tipo;
    protected int puntiSalute, puntiAttacco, puntiDifesa, SaluteMax;

    public Pokemon(String nome, String tipo, int puntiSalute, int puntiAttacco, int puntiDifesa, int SaluteMax) {
        this.nome = nome;
        this.tipo = tipo;
        this.puntiSalute = puntiSalute;
        this.puntiAttacco = puntiAttacco;
        this.puntiDifesa = puntiDifesa;
        this.SaluteMax = SaluteMax;
    }

    public abstract void attaca(Pokemon avversario);

    public void subisciDanno(int danno) {

        this.puntiSalute -= danno;

        if (this.puntiSalute < 0) {
            this.puntiSalute= 0;
        }
    }

    public void visualizzaStato() {

        System.out.println(nome + "(" +tipo + ")" + ":\n" + "Salute: " + puntiSalute + "\nAttacco: " + puntiAttacco + "\nDifesa: " + puntiDifesa);
    }  
}