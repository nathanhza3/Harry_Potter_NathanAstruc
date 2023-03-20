package com.isep.model;

public class Potion {
    private int healAmount;

    public Potion(int healAmount) {
        this.healAmount = 50;
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
