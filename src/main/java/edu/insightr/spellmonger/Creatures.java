package edu.insightr.spellmonger;

public enum Creatures {
    EAGLE(1,1,1,"Flying","/CarteEagle.jpg"),
    WOLF(2,2,2,"None","/CarteWolf.jpg"),
    BEAR(3,3,3,"None","/CarteBear.jpg"),
    FOX(1,1,1,"None","/CarteFox.jpg");

    public int PV;
    public int energyCost;
    public int damage;
    public String capacity;
    public String picture;

    Creatures(int PV, int energyCost, int damage, String capacity, String picture) {
        this.PV = PV;
        this.energyCost = energyCost;
        this.damage = damage;
        this.capacity = capacity;
        this.picture = picture;
    }
}