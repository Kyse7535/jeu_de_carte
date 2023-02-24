package adapter.out.database;

import javax.persistence.Enumerated;

public enum RareteData {

    Commun(0),
    Rare(10),
    Legandaire(20);


    private float procentage;

    public float getProcentage() {
        return procentage;
    }

    RareteData(float procentage) {
        this.procentage = procentage;
    }

}
