package domain;

public class Caracteristiques {

    private Specialite specialite;
    private Rarete rarete;

    public Caracteristiques(Specialite specialite, Rarete rarete) {
        this.specialite = specialite;
        this.rarete = rarete;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public Rarete getRarete() {
        return rarete;
    }

    @Override
    public String toString() {
        return "Caracteristiques{" +
                "specialite=" + specialite +
                ", rarete=" + rarete +
                '}';
    }
}
