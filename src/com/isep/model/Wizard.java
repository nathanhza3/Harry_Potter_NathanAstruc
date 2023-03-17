package com.isep.model;
import java.util.Random;

public class Wizard extends Character {
    private String name;
    private String gender;
    private Wand wand;
    private House house;
    private Pet pet;
    private Potion potions;
    private AbstractSpell knownSpells;
    private int maxHp;
    private int hp;
    private int xp;
    private int level;
    private int spellPower;
    private int maxSpellPower;

    public Wizard(String name, int maxHp, int spellPower) {
        this.wand = wand;
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.xp = 0;
        this.level = 1;
        this.spellPower = spellPower;
        this.maxSpellPower = spellPower;
        }

        public String getName() {
            return name;
        }

        public int getMaxHp() {
            return maxHp;
        }

        public int getHp() {
            return hp;
        }

        public int getXp() {
            return xp;
        }

        public int getLevel() {
            return level;
        }

        public int getSpellPower() {
            return spellPower;
        }

        public int getMaxSpellPower() {
            return maxSpellPower;
        }

        public void castSpell(Wizard enemyWizard) {
            Random random = new Random();
            int damage = random.nextInt(spellPower) + 1;
            enemyWizard.takeDamage(damage);
            spellPower -= damage;
            if (spellPower < 0) {
                spellPower = 0;
            }
        }
        public void setHp(int hp) {
            this.hp = hp;
        }


        public void takeDamage(int damage) {
            hp -= damage;
            if (hp < 0) {
                hp = 0;
            }
        }

        public boolean isDead() {
            return hp == 0;
        }

        public void gainXp(int xp) {
            this.xp += xp;
            if (this.xp >= 10 + (level-1) * 3) {
                levelUp();
            }
        }

        private void levelUp() {
            level++;
            maxHp += 10;
            hp = maxHp;
            System.out.println(name + " is now level " + level + "!");
        }
    }