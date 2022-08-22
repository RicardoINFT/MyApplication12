package com.example.myapplication;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class statsminion {

    private String nome;
    private int lvl;
    private int hp;
    private int dmg;
    private int dmgespecial;
    private int dmgultimate;
    private int mana;
    Random r = new Random();
    int ew = r.nextInt(18);
    public statsminion() {
        this.nome = "Npc";
        this.lvl = ew;
        this.hp = 423*ew/2;
        this.dmg = 42*ew/2-50;
        this.mana = 3;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = "Npc";
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getDmgespecial() {
        return dmgespecial;
    }

    public void setDmgespecial(int dmgespecial) {
        this.dmgespecial = dmgespecial;
    }

    public int getDmgultimate() {
        return dmgultimate;
    }

    public void setDmgultimate(int dmgultimate) {
        this.dmgultimate = dmgultimate;
    }
}