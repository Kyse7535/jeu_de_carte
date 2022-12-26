package domain;

import java.util.ArrayList;

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
    private ArrayList<Combat> combat_history;

    public Heros(String id, Specialite specialite, Rarete rarete) {
        this.id = id;
        this.specialite = specialite;
        this.rarete = rarete;
        this.niveau = 1;
        this.combat_history = new ArrayList<>();
        if(specialite.equals(Specialite.Tank)) {
            if (rarete.equals(Rarete.Commun)) {
                point_de_vie = 1000 + (rarete.procentage/100*point_de_vie);
                puissance = 100 + (rarete.procentage/100*puissance);
                armure = 20 + (rarete.procentage/100*armure);
                puissance_supplementaire = 20 + (rarete.procentage/100*armure);
            }
            if (rarete.equals(Rarete.Rare)) {
                point_de_vie = 1000 + (rarete.procentage/100*point_de_vie);
                puissance = 100 + (rarete.procentage/100*puissance);
                armure = 20 + (rarete.procentage/100*armure);
                puissance_supplementaire = 20 + (rarete.procentage/100*armure);
            }
            if (rarete.equals(Rarete.Legandaire)) {
                point_de_vie = 1000 + (rarete.procentage/100*point_de_vie);
                puissance = 100 + (rarete.procentage/100*puissance);
                armure = 20 + (rarete.procentage/100*armure);
                puissance_supplementaire = 20 + (rarete.procentage/100*armure);
            }
        }
        if(specialite.equals(Specialite.Assassin)) {
            if (rarete.equals(Rarete.Commun)) {
                point_de_vie = 800 + (rarete.procentage/100*point_de_vie);
                puissance = 200 + (rarete.procentage/100*puissance);
                armure = 5 + (rarete.procentage/100*armure);
                puissance_supplementaire = 30 + (rarete.procentage/100*armure);
            }
            if (rarete.equals(Rarete.Rare)) {
                point_de_vie = 800 + (rarete.procentage/100*point_de_vie);
                puissance = 200 + (rarete.procentage/100*puissance);
                armure = 5 + (rarete.procentage/100*armure);
                puissance_supplementaire = 30 + (rarete.procentage/100*armure);
            }
            if (rarete.equals(Rarete.Legandaire)) {
                point_de_vie = 800 + (rarete.procentage/100*point_de_vie);
                puissance = 200 + (rarete.procentage/100*puissance);
                armure = 5 + (rarete.procentage/100*armure);
                puissance_supplementaire = 30 + (rarete.procentage/100*armure);
            }
        }
        if(specialite.equals(Specialite.Mage)) {
            if (rarete.equals(Rarete.Commun)) {
                point_de_vie = 700 + (rarete.procentage/100*point_de_vie);
                puissance = 150 + (rarete.procentage/100*puissance);
                armure = 10 + (rarete.procentage/100*armure);
                puissance_supplementaire = 25 + (rarete.procentage/100*armure);
            }
            if (rarete.equals(Rarete.Rare)) {
                point_de_vie = 700 + (rarete.procentage/100*point_de_vie);
                puissance = 150 + (rarete.procentage/100*puissance);
                armure = 10 + (rarete.procentage/100*armure);
                puissance_supplementaire = 25 + (rarete.procentage/100*armure);
            }
            if (rarete.equals(Rarete.Legandaire)) {
                point_de_vie = 700 + (rarete.procentage/100*point_de_vie);
                puissance = 150 + (rarete.procentage/100*puissance);
                armure = 10 + (rarete.procentage/100*armure);
                puissance_supplementaire = 25 + (rarete.procentage/100*armure);
            }
        }


    }

    public void gagnerUnCombat() {
        point_exp += 1;
        if (point_exp % 5 == 0) {
            this.niveau += 1;
            this.point_de_vie = (float) (this.point_de_vie + 0.1*this.point_de_vie);
            this.puissance = (float) (this.puissance + 0.1*this.puissance);
            this.armure = (float) (this.armure + 0.1*this.armure);
        }
    }

    public String getId() {
        return id;
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

    public Specialite getSpecialite() { return specialite;}

    public void combat_history(Combat combat) {
        this.combat_history.add(combat);
    }
    public ArrayList<Combat> get_history() {
        return this.combat_history;
    }

    @Override
    public String toString() {
        return "Heros{" +
                "id='" + id + '\'' +
                ", specialite=" + specialite +
                ", rarete=" + rarete +
                ", niveau=" + niveau +
                ", point_de_vie=" + point_de_vie +
                ", point_exp=" + point_exp +
                ", puissance=" + puissance +
                ", armure=" + armure +
                ", puissance_supplementaire=" + puissance_supplementaire +
                '}';
    }
}
