package com.isep.model;

public class Potion {
        private int healAmount;

    public Potion(Wizard wizard) {
        if (House.HUFFLEPUFF == wizard.getHouse()) {
            this.healAmount = wizard.getMaxHp()/2 ;  //50% de soin
        } else {
            this.healAmount = wizard.getMaxHp()/3;  //33% de soin
        }
        wizard.addPotion(wizard.getHouse().adaptPotion(this, wizard));

    }


    public int getHealAmount() {
        return healAmount;
    }

    public void use(Wizard wizard) {
        if (House.HUFFLEPUFF == wizard.getHouse()) {
            this.healAmount = wizard.getMaxHp()/2 ;  //50% de soin
        } else {
            this.healAmount = wizard.getMaxHp()/3;  //33% de soin
        }
        int newHp = wizard.getHp() + healAmount;
        int maxHp = wizard.getMaxHp();
        if (newHp > maxHp) {
            newHp = maxHp;
        }
        wizard.setHp(newHp);
    }

    public void setHealAmount(int healAmount) {
        this.healAmount = healAmount;
    }
}
