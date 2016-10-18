package edu.insightr.spellmonger;

public class Ritual extends Card {
    private String ritualName;
    private int energy;


    public Ritual(String ritualName) {
        super(ritualName);
        this.ritualName = ritualName;
    }

    public String getName() {
        return ritualName;
    }

    public int getEnergy() {
        return energy;
    }

    public String toString() {
        String message = "";
        switch (ritualName) {
            case "Curse":
                message = "Le rituel fait " + getDamage() + " points de dégat";
                break;
            case "Blessing":
                message = "Le rituel soigne" + getDamage() + " points de vie";
                break;
            case "Energy drain":
                message = "Le rituel vous donne" + this.energy + " points d'énergie et enlève" + this.energy + " points d'énergie à l'adversaire";
                break;
        }
        return message;
    }

    @Override
    public int getDamage() {
        int damage = 0;
        if (ritualName.equals("Curse"))
            damage = 3;
        if (ritualName.equals("Blessing"))
            damage = -3;
        if (ritualName.equals("Energy drain")) {
            damage = 2;
        }
        return damage;
    }
}
