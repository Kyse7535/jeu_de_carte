package domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Heros {
    @JsonProperty
    private String id;
    @JsonProperty
    private Caracteristiques caracteristiques;
    @JsonProperty
    private float niveau;
    @JsonProperty
    private float point_de_vie;
    @JsonProperty
    private float point_exp;
    @JsonProperty
    private float puissance;
    @JsonProperty
    private float armure;
    @JsonProperty
    private float puissance_supplementaire;
    @JsonIgnore
    private ArrayList<Combat> combat_history;

    public Heros(String id, Caracteristiques caracteristiques) {
        this.id = id;
       this.caracteristiques = caracteristiques;
        this.niveau = 1;
        this.combat_history = new ArrayList<>();
        if(caracteristiques.getSpecialite().equals(Specialite.Tank)) {
            if (caracteristiques.getRarete().equals(Rarete.Commun)) {
                point_de_vie = 1000 + (caracteristiques.getRarete().procentage/100*point_de_vie);
                puissance = 100 + (caracteristiques.getRarete().procentage/100*puissance);
                armure = 20 + (caracteristiques.getRarete().procentage/100*armure);
                puissance_supplementaire = 20 + (caracteristiques.getRarete().procentage/100*armure);
            }
            if (caracteristiques.getRarete().equals(Rarete.Rare)) {
                point_de_vie = 1000 + (caracteristiques.getRarete().procentage/100*point_de_vie);
                puissance = 100 + (caracteristiques.getRarete().procentage/100*puissance);
                armure = 20 + (caracteristiques.getRarete().procentage/100*armure);
                puissance_supplementaire = 20 + (caracteristiques.getRarete().procentage/100*armure);
            }
            if (caracteristiques.getRarete().equals(Rarete.Legandaire)) {
                point_de_vie = 1000 + (caracteristiques.getRarete().procentage/100*point_de_vie);
                puissance = 100 + (caracteristiques.getRarete().procentage/100*puissance);
                armure = 20 + (caracteristiques.getRarete().procentage/100*armure);
                puissance_supplementaire = 20 + (caracteristiques.getRarete().procentage/100*armure);
            }
        }
        if(caracteristiques.getSpecialite().equals(Specialite.Assassin)) {
            if (caracteristiques.getRarete().equals(Rarete.Commun)) {
                point_de_vie = 800 + (caracteristiques.getRarete().procentage/100*point_de_vie);
                puissance = 200 + (caracteristiques.getRarete().procentage/100*puissance);
                armure = 5 + (caracteristiques.getRarete().procentage/100*armure);
                puissance_supplementaire = 30 + (caracteristiques.getRarete().procentage/100*armure);
            }
            if (caracteristiques.getRarete().equals(Rarete.Rare)) {
                point_de_vie = 800 + (caracteristiques.getRarete().procentage/100*point_de_vie);
                puissance = 200 + (caracteristiques.getRarete().procentage/100*puissance);
                armure = 5 + (caracteristiques.getRarete().procentage/100*armure);
                puissance_supplementaire = 30 + (caracteristiques.getRarete().procentage/100*armure);
            }
            if (caracteristiques.getRarete().equals(Rarete.Legandaire)) {
                point_de_vie = 800 + (caracteristiques.getRarete().procentage/100*point_de_vie);
                puissance = 200 + (caracteristiques.getRarete().procentage/100*puissance);
                armure = 5 + (caracteristiques.getRarete().procentage/100*armure);
                puissance_supplementaire = 30 + (caracteristiques.getRarete().procentage/100*armure);
            }
        }
        if(caracteristiques.getSpecialite().equals(Specialite.Mage)) {
            if (caracteristiques.getRarete().equals(Rarete.Commun)) {
                point_de_vie = 700 + (caracteristiques.getRarete().procentage/100*point_de_vie);
                puissance = 150 + (caracteristiques.getRarete().procentage/100*puissance);
                armure = 10 + (caracteristiques.getRarete().procentage/100*armure);
                puissance_supplementaire = 25 + (caracteristiques.getRarete().procentage/100*armure);
            }
            if (caracteristiques.getRarete().equals(Rarete.Rare)) {
                point_de_vie = 700 + (caracteristiques.getRarete().procentage/100*point_de_vie);
                puissance = 150 + (caracteristiques.getRarete().procentage/100*puissance);
                armure = 10 + (caracteristiques.getRarete().procentage/100*armure);
                puissance_supplementaire = 25 + (caracteristiques.getRarete().procentage/100*armure);
            }
            if (caracteristiques.getRarete().equals(Rarete.Legandaire)) {
                point_de_vie = 700 + (caracteristiques.getRarete().procentage/100*point_de_vie);
                puissance = 150 + (caracteristiques.getRarete().procentage/100*puissance);
                armure = 10 + (caracteristiques.getRarete().procentage/100*armure);
                puissance_supplementaire = 25 + (caracteristiques.getRarete().procentage/100*armure);
            }
        }


    }

    public Heros() {}

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

    public Caracteristiques getCaracteristiques() { return caracteristiques;}

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
                ", caracteristiques=" + caracteristiques +
                ", niveau=" + niveau +
                ", point_de_vie=" + point_de_vie +
                ", point_exp=" + point_exp +
                ", puissance=" + puissance +
                ", armure=" + armure +
                ", puissance_supplementaire=" + puissance_supplementaire +
                '}';
    }
}
