package edu.insightr.spellmonger;

public class Ritual extends Card {
    private String name;

    // TODO : don't use String as key, prefer enums

    public Ritual(String ritualName) {
        super(ritualName);
        switch(ritualName)
        {
            case "Curse":
                this.name = "Curse";
                break;
            case "Energy drain":
                this.name = "Energy drain";
                break;
            case "Blessing":
                this.name = "Blessing";
                break;
        }

    }

    @Override
    public String getName() {
        return this.name;
    }

    /*@Override
    public int getEnergy() {
        return this.energy;
    }*/

    public String toString() {
        String message = "";
        switch (name) {
            case "Curse":
                message = "Le rituel fait " + getDamage() + " points de dégat";
                break;
            case "Blessing":
                message = "Le rituel soigne" + getDamage() + " points de vie";
                break;
            case "Energy drain":
                message = "Le rituel vous donne" + getDamage() + " points de vie et enlève" + getDamage() + " points de vie à l'adversaire";
                break;
        }
        return message;
    }

    @Override
    public int getDamage() {
        int damage = 0;
        switch (this.name) {
            case "Curse":
                damage = 3;
                break;
            case "Blessing":
                damage = -3;
                break;
            case "Energy drain":
                damage = 2;
                break;
        }

        return damage;
    }

    @Override
    public int getEnergyCost(){
        int energy = 0;
        switch (this.name) {
            case "Curse":
                energy = 3;
                break;
            case "Blessing":
                energy = 3;
                break;
            case "Energy drain":
                energy = 2;
                break;
        }

        return energy;
    }
}
