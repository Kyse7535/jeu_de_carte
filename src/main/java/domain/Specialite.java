package domain;


import java.util.Random;

public enum Specialite {
    Tank,
    Assassin,
    Mage,

    Specialite() {};

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
