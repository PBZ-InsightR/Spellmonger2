package edu.insightr.spellmonger;

public enum Rituals {
    CURSE(1,0,3,"/CarteCurse.jpg"),
    BLESSING(1,3,0,"/CarteBlessing.jpg"),
    ENERGYDRAIN(1,2,2,"/CarteEnergyDrain.jpg");

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
