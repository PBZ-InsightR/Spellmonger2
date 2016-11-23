package edu.insightr.spellmonger;

import java.util.Random;

public class Enchantment extends Card {
    private int energy;

    public Enchantment(String enchantmentName) {
        super(enchantmentName);
        switch(enchantmentName) {
            case "Vault overclocking":
                this.energyCost = 3;
                this.damage = 0;
                this.energy = 1;
                break;
        }
    }

    public boolean vaultOverburn() {
        int nbRand;
        Random rand = new Random();
        nbRand = rand.nextInt(3);
        if(nbRand==0) return true;
        return false;
    }

    public int getEnergy() {
        return energy;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }

    @Override
    public int getEnergyCost() {
        return this.energyCost;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public String toString() {
        String message = "";
        switch (this.name) {
            case "Vault overclocking":
                if(vaultOverburn()==true) message = "Vault overburn and is empty";
                else message = "L'enchantement donne " + getEnergy() + " points d'énergie";
                break;
        }
        return message;
    }
}
