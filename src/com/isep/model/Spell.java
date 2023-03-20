package com.isep.model;

public class Spell extends AbstractSpell{
    public Spell(String name, int damage, int manaCost, int accuracy) {
        super(name, damage, manaCost, accuracy);

    }
    public Spell Wingardium_leviosa() {
        return new Spell("Wingardium Leviosa", 0, 10,80);
    }
    public Spell Expectro_Patronum() {
        return new Spell("Expectro Patronum", 0, 10,90);
    }
    public Spell Accio() {
        return new Spell("Accio", 5, 10,80);
    }
    public Spell Sectumsempra() {
        return new Spell("Sectumsempra", 30, 10,80);
    }
    public Spell Expelliarmus() {
        return new Spell("Expelliarmus", 30, 10,80);
    }
    public Spell Bombarda() {
        return new Spell("Bombarda", 50, 30,80);
    }

    public Spell Doloris() {
        return new Spell("Doloris", 70, 40,80);
    }





    public void cast(Wizard caster, Ennemy target) {

        if (caster.getMana() >= getManaCost()) {
            caster.reduceMana(getManaCost());
            target.reduceHealth(getDamage());
        }
    }


    public abstract void cast(Wizard caster,  Ennemy target);

}
