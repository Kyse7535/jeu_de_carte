package domain;

public class Heros {
    private String nom;
    private Specialite specialite;
    private int niveau;
    private int point_de_vie;
    private int point_exp;
    private Puissance puissance;
    private Armure armure;
    private int puissance_supplementaire;
    private Rarete rarete;

    private int point_experience_gagnes;

    public void gagnerUnCombat() {
        point_experience_gagnes += 1;
    }

    public void gagnerUnNiveau() {
        if (point_experience_gagnes % 5 == 0) {
            this.niveau += 1;

        }
    }
}
