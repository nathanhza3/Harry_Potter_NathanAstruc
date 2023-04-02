package com.isep.model;

public enum House {
    GRYFFINDOR,
    HUFFLEPUFF{
        @Override
        public Potion adaptPotion(Potion potion, Wizard wizard) {
            potion.setHealAmount(wizard.getMaxHp()/2);
            return potion;
        }
    },
    RAVENCLAW,
    SLYTHERIN;

    public Potion adaptPotion(Potion potion, Wizard wizard){
        potion.setHealAmount(wizard.getMaxHp()/3);
        return potion;
    }
}
