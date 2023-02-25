package adapter.out.database.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Table;


public enum RareteEntity {
    Commun(0),
    Rare(10),
    Legandaire(20);


    public float procentage;

    private RareteEntity(float procentage) {
        this.procentage = procentage;
    }
    RareteEntity() {}
}
