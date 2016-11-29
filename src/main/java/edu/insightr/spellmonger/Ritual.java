package edu.insightr.spellmonger;

public class Ritual extends Card {
    private int gain;

    public Ritual(Rituals init) {
        super(init.name(),init.energyCost,init.damage,init.urlPicture);
        this.gain = init.gain;
    }

    public String toString() {
        String message = "";
        switch (this.getName()) {
            case "CURSE":
                message = "Le rituel fait " + getDamage() + " points de dégat";
                break;
            case "BLESSING":
                message = "Le rituel soigne" + getDamage() + " points de vie";
                break;
            case "ENERGYDRAIN":
                message = "Le rituel vous donne" + getDamage() + " points de vie et enlève" + getDamage() + " points de vie à l'adversaire";
                break;
        }
        return message;
    }
}
