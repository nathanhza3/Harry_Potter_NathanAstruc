package com.isep.model;

public class Potion {
    private int healAmount;

    public Potion(int healAmount) {
        this.healAmount = healAmount;
    }

    public int getHealAmount() {
        return healAmount;
    }

    public void use(Wizard wizard) {
        int newHp = wizard.getHp() + healAmount;
        if (House.HUFFLEPUFF == wizard.getHouse()) {
            this.healAmount = wizard.getMaxHp()/2 ;  //50% de soin
        } else {
            this.healAmount = wizard.getMaxHp()/3;  //33% de soin
        }
        int maxHp = wizard.getMaxHp();
        if (newHp > maxHp) {
            newHp = maxHp;
        }
        wizard.setHp(newHp);
    }

}
