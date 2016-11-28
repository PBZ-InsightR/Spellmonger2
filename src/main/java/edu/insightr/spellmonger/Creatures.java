package edu.insightr.spellmonger;

public enum Creatures {
    EAGLE(1,1,1,"Flying"),
    WOLF(2,2,2,"None"),
    BEAR(3,3,3,"None"),
    FOX(1,1,1,"None");

    public int PV;
    public int energyCost;
    public int damage;
    public String capacity;

    Creatures(int PV, int energyCost, int damage, String capacity) {
        this.PV = PV;
        this.energyCost = energyCost;
        this.damage = damage;
        this.capacity = capacity;
    }
}
