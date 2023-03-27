package com.isep.model;

public class ForbiddenSpell extends AbstractSpell {
    public ForbiddenSpell(String name, int damage, int accuracy) {
        super(name, damage, accuracy);
    }
    public Spell Avada_Kedavra() {
        return new Spell("Avada Kedavra", 9999,20);
    }
    public Spell Imperio() {
        return new Spell("Imperio ", 80, 60);
    }
    public Spell Curcio() {

        return new Spell("Curcio ", 50, 70);
    }


    public  void cast(Wizard caster,  Ennemy target){

    }



}
