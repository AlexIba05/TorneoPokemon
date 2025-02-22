package com.github.alexIba05.torneopokemon.pokemon;

import com.github.alexIba05.torneopokemon.*;

import java.util.Random;

public class Charmender extends Pokemon implements IEvolvibile, IAttaccoSpeciale, IVolante {
    Random r = new Random();
    int vittorie = 2, turnoVolo = -1;
    boolean evoluto = false, volo = false;

    public Charmender() {
        super("Charmender", "fuoco", 30, 20, 15, 30);
    }

    @Override
    public void vola() {
        if (!nome.equalsIgnoreCase("Charmender") && !volo) {
            volo = true;
            turnoVolo = App.turno;
            System.out.println(nome + "sta volando e quindi non subirà alcun danno");
        }
    }

    @Override
    public void subisciDanno(int danno) {
        super.subisciDanno(volo ? 0 : danno);
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
            this.nome = "Charmeleon";
        }
    }

    @Override
    public int getVittorie() {
        return vittorie;
    }

    @Override
    public void attaca(Pokemon avversario) {
        if (volo) return;

        int ProbAttSpc = r.nextInt(100) + 1;
        if (ProbAttSpc < 40) {
            eseguiMossaSPC(avversario);
            return;
        }
        int ProbVoloSpc = r.nextInt(100) + 1;
        if (ProbVoloSpc < 20 && !nome.equalsIgnoreCase("Charmender")) {
            vola();
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
        if (App.turno > turnoVolo + 1 && volo) {
            volo = false;
            System.out.println(nome + " è sceso e riprende a combattere");
        }
    }

}
