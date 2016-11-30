package edu.insightr.spellmonger;

public enum Rituals {
    CURSE(1,0,3,"/carte.jpg"),
    BLESSING(1,3,0,"/carte.jpg"),
    ENERGYDRAIN(1,2,2,"/carte.jpg");

    public int energyCost;
    public int damage;
    public int gain;
    public String urlPicture;

    Rituals (int energyCost, int damage, int gain, String urlPicture) {
        this.energyCost = energyCost;
        this.damage = damage;
        this.gain = gain;
        this.urlPicture = urlPicture;
    }
}
