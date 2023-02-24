package adapter.out.database;


import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Embeddable
public class CaracteristiquesData {

    @Enumerated(EnumType.STRING)
    private SpecialiteData specialite;
    @Enumerated(EnumType.STRING)
    private RareteData rarete;

    public CaracteristiquesData(SpecialiteData specialite, RareteData rarete) {
        this.specialite = specialite;
        this.rarete = rarete;
    }

    public CaracteristiquesData() {

    }

    public SpecialiteData getSpecialite() {
        return specialite;
    }

    public RareteData getRarete() {
        return rarete;
    }

    @Override
    public String toString() {
        return "CaracteristiquesData{" +
                "specialite=" + specialite +
                ", rarete=" + rarete +
                '}';
    }
}

