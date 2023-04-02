package com.isep.model;

public class Spell extends AbstractSpell{
    public Spell(String name, int damage,  int accuracy) {
        super(name, damage, accuracy);
    }
    /*
    public Spell Wingardium_leviosa() {
        return new Spell("Wingardium Leviosa", 0,80);
    }

    public Spell Accio() {
        return new Spell("Accio", 5, 80);
    }
    public Spell Sectumsempra() {
        return new Spell("Sectumsempra", 30, 80);
    }
    public Spell Expelliarmus() {
        return new Spell("Expelliarmus", 30, 80);
    }
    public Spell Bombarda() {
        return new Spell("Bombarda", 50, 80);
    }

    public Spell Doloris() {
        return new Spell("Doloris", 70, 80);
    }
*/




    public void cast(Wizard caster, Ennemy target) {
        //caster.reduceMana(getManaCost());   //encore à faire la methode qui reduit le mana //enfaite j'utilise plus le mana
        target.reduceHealth(getDamage()); //faire la méthode qui reduit la santé de la cible
        }
}

