package com.example.myapplication;

public class Statstokoe {

    private String nome;
    private int lvl;
    private int hp;
    private int dmg;
    private int dmgespecial;
    private int dmgultimate;
    private int mana;
    private int gold;

    public Statstokoe() {
        this.nome = "Taokaka";
        this.lvl = 10;
        this.hp = 400*getLvl();
        this.dmg = 240;
        this.gold = 0;
        this.mana = 317;
        this.dmgespecial = 120;
        this.dmgultimate = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = "Pantheon";
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
    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
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
