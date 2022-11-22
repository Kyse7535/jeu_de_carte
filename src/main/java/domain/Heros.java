package domain;

import java.util.UUID;

public class Heros {
    private final String id;
    private final Specialite specialite;
    private final Rarete rarete;
    private float niveau;
    private float point_de_vie;
    private float point_exp;
    private float puissance;
    private float armure;
    private float puissance_supplementaire;

    public Heros(String id, Specialite specialite, Rarete rarete) {
        this.id = id;
        this.specialite = specialite;
        this.rarete = rarete;
        this.niveau = 1;
        if(specialite.equals(Specialite.Tank)) {
            if (rarete.equals(Rarete.Commun)) {
                point_de_vie = 1000 + (rarete.procentage/100*point_de_vie);
                puissance = 100 + (rarete.procentage/100*puissance);
                armure = 20 + (rarete.procentage/100*armure);
            }
            if (rarete.equals(Rarete.Rare)) {
                point_de_vie = 1000 + (rarete.procentage/100*point_de_vie);
                puissance = 100 + (rarete.procentage/100*puissance);
                armure = 20 + (rarete.procentage/100*armure);
            }
            if (rarete.equals(Rarete.Legandaire)) {
                point_de_vie = 1000 + (rarete.procentage/100*point_de_vie);
                puissance = 100 + (rarete.procentage/100*puissance);
                armure = 20 + (rarete.procentage/100*armure);
            }
        }

    }

    public void gagnerUnCombat() {
        point_exp += 1;
    }

    public void gagnerUnNiveau() {
        if (point_exp % 5 == 0) {
            this.niveau += 1;

        }
    }

    public float getNiveau() {
        return niveau;
    }

    public void setNiveau(float niveau) {
        this.niveau = niveau;
    }

    public float getPoint_de_vie() {
        return point_de_vie;
    }

    public void setPoint_de_vie(float point_de_vie) {
        this.point_de_vie = point_de_vie;
    }

    public float getPoint_exp() {
        return point_exp;
    }

    public void setPoint_exp(float point_exp) {
        this.point_exp = point_exp;
    }

    public float getPuissance() {
        return puissance;
    }

    public void setPuissance(float puissance) {
        this.puissance = puissance;
    }

    public float getArmure() {
        return armure;
    }

    public void setArmure(float armure) {
        this.armure = armure;
    }

    public float getPuissance_supplementaire() {
        return puissance_supplementaire;
    }

    public void setPuissance_supplementaire(float puissance_supplementaire) {
        this.puissance_supplementaire = puissance_supplementaire;
    }
}
