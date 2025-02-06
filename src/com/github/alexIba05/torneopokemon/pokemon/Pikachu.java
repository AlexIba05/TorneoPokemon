package com.github.alexIba05.torneopokemon.pokemon;

import java.util.Random;

public class Pikachu extends Pokemon implements IEvolvibile, IAttaccoSpeciale {
    Random r = new Random();
    int vittorie = 2;
    boolean evoluto = false;

    public Pikachu() {
        super("Pikachu", "Elettro", 20, 25, 10, 20);
    }

    @Override
    public void eseguiMossaSPC(Pokemon avversario) {
        int danno = this.puntiAttacco * 2;
        if (danno < 0) {
            danno = 1;
        }
        avversario.subisciDanno(danno);
        if (!avversario.isAlive()) vittorie++;
        System.out.println(nome + " usa attacco speciale su " + avversario.nome + " causando " + danno + " danni");
    }

    @Override
    public void evolvi() {
        if (vittorie >= 3 && !evoluto) {
            evoluto = true;
            this.puntiAttacco += 20;
            this.puntiDifesa += 10;
            this.SaluteMax += 30;
            puntiSalute = SaluteMax;
            System.out.println(nome + " si è evoluto");
            this.nome = "Raichu";
        }
    }

    @Override
    public int getVittorie() {
        return vittorie;
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
        if (!avversario.isAlive()) vittorie++;
        System.out.println(nome + " attacca " + avversario.nome + " causando " + danno + " danni");
    }

    @Override
    public void update() {
        if (!isAlive()) return;
        evolvi();
    }

}
