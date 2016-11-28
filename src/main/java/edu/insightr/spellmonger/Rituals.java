package edu.insightr.spellmonger;

public enum Rituals {
    CURSE(1,0,3),
    BLESSING(1,3,0),
    ENERGYDRAIN(1,2,2);

    public int energyCost;
    public int damage;
    public int gain;

    Rituals (int energyCost, int damage, int gain) {
        this.energyCost = energyCost;
        this.damage = damage;
        this.gain = gain;
    }
}
