package edu.insightr.spellmonger;

public class Ritual extends Card {

    private int gain;

    public Ritual(String ritualName) {
        super(ritualName);
        switch(ritualName)
        {
            case "Curse":
                this.name = "Curse";
                this.damage = 0;
                this.gain = 3;
                break;
            case "Energy drain":
                this.name = "Energy drain";
                this.damage = 3;
                this.gain = 0;
                break;
            case "Blessing":
                this.name = "Blessing";
                this.damage = 2;
                this.gain = 2;
                break;
        }
        this.energyCost = 1;
    }

    public int getGain() {
        return this.gain;
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
        switch (name) {
            case "Curse":
                message = "Le rituel fait " + getDamage() + " points de dégat";
                break;
            case "Blessing":
                message = "Le rituel soigne" + getDamage() + " points de vie";
                break;
            case "Energy drain":
                message = "Le rituel vous donne" + getGain() + " points de vie et enlève" + getDamage() + " points de vie à l'adversaire";
                break;
        }
        return message;
    }
}
