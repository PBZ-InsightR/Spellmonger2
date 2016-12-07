package edu.insightr.spellmonger;

public class Creature extends Card {
    private String capacity;
    private int PV;

    public Creature(Creatures init) {
        super(init.name(), init.energyCost, init.damage, init.urlPicture);
        this.capacity = init.capacity;
        this.PV = init.PV;
    }

    public int getPV() {
        return PV;
    }

    public String getCapacity() {
        return capacity;
    }

    public boolean isAlive() {
        boolean result = false;
        if (this.PV > 0) {
            result = true;
        }
        return result;
    }

    public String toString() {
        return "La créature " + this.getName() + "a" + this.PV + "point de vie" + "(capacité :" + this.capacity + ")" + " fait " + this.getDamage() + " points de dégats";
    }

    public void alterePV(int damage) {
        this.PV -= damage;
    }
}
