package edu.insightr.spellmonger;

public enum Creatures {
    EAGLE(1, 1, 1, "Flying", "/CarteEagle.jpg"),
    WOLF(2, 2, 2, "None", "/CarteWolf.jpg"),
    BEAR(3, 3, 3, "None", "/CarteBear.jpg"),
    FOX(1, 1, 1, "None", "/CarteFox.jpg");

    public int PV;
    public int energyCost;
    public int damage;
    public String capacity;
    public String urlPicture;
    public String type;

    Creatures(int PV, int energyCost, int damage, String capacity, String urlPicture) {
        this.PV = PV;
        this.energyCost = energyCost;
        this.damage = damage;
        this.capacity = capacity;
        this.urlPicture = urlPicture;
        this.type="Creature";
    }
}