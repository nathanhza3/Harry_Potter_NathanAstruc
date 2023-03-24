package com.isep.model;

public class Potion {
    private int healAmount;

    public Potion(Wizard wizard) {
        int maxHp = wizard.getMaxHp();
        int HealAmount = maxHp ;
        if (wizard.getHouse() == House.Hufflepuff) {
            this.healAmount = HealAmount/2 ;  //50% de soin
        } else {
            this.healAmount = HealAmount/3;  //33% de soin
        }
    }


    public int getHealAmount() {
        return healAmount;
    }

    public void use(Wizard wizard) {
        int newHp = wizard.getHp() + healAmount;
        int maxHp = wizard.getMaxHp();
        if (newHp > maxHp) {
            newHp = maxHp;
        }
        wizard.setHp(newHp);
    }

}
