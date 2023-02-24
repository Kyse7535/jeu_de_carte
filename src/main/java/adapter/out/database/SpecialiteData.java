package adapter.out.database;

import domain.Specialite;

import java.util.Random;

public enum SpecialiteData {
    Tank,
    Assassin,
    Mage,

    SpecialiteData() {};

    public String getSpecialite() {
        return this.name();
    }

    public static Specialite random() {
        Random r = new Random();
        int probability = r.nextInt(3);

        if(probability < 1) {
            return Specialite.Tank;
        }
        else if (probability < 2) {
            return Specialite.Assassin;
        }
        else {
            return Specialite.Mage;
        }
    }
}
