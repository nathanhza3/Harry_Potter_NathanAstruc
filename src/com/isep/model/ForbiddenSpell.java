package com.isep.model;

public class ForbiddenSpell extends AbstractSpell {
    public ForbiddenSpell(String name, int damage, int manaCost, int accuracy) {
        super(name, damage, manaCost,accuracy);
    }
    public Spell Avada_Kedavra() {
        return new Spell("Avada Kedavra", 9999, 50,20);
    }
    public Spell Imperio() {
        return new Spell("Imperio ", 80, 50,60);
    }
    public Spell Curcio() {
        return new Spell("Curcio ", 50, 50,70);
    }

    public abstract void cast(Ennemy caster,Wizard target);



}
