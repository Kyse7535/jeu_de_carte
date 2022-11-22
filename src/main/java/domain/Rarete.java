package domain;

public enum Rarete {
    Commun(0),
    Rare(10),
    Legandaire(20);

    public final float procentage;

    private Rarete(float procentage) {
        this.procentage = procentage;
    }
}
