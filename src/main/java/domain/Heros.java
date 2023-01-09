package domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;



public class Heros {

    private static final float POINTS_VIE_TANK = 1000;
    private static final float POINTS_PUISSANCE_TANK = 100;
    private static final float POINTS_ARMURE_TANK = 20;
    private static final float POINTS_PUISSANCE_SUPPLEMENTAIRE_TANK = 20;

    private static final float POINTS_VIE_ASSASSIN = 800;
    private static final float POINTS_PUISSANCE_ASSASSIN = 200;
    private static final float POINTS_ARMURE_ASSASSIN= 5;
    private static final float POINTS_PUISSANCE_SUPPLEMENTAIRE_ASSASSIN = 30;

    private static final float POINTS_VIE_MAGE = 700;
    private static final float POINTS_PUISSANCE_MAGE = 150;
    private static final float POINTS_ARMURE_MAGE= 10;
    private static final float POINTS_PUISSANCE_SUPPLEMENTAIRE_MAGE= 25;

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

    public static Heros newCommunTank(String id) {
        return new Heros(id,new Caracteristiques(Specialite.Tank,Rarete.Commun),POINTS_VIE_TANK,POINTS_PUISSANCE_TANK,POINTS_ARMURE_TANK,POINTS_PUISSANCE_SUPPLEMENTAIRE_TANK);
    }

    public static Heros newRareTank(String id) {
        return new Heros(id,new Caracteristiques(Specialite.Tank,Rarete.Rare),(POINTS_VIE_TANK+Rarete.Rare.procentage/100 * POINTS_VIE_TANK),
                (POINTS_PUISSANCE_TANK+Rarete.Rare.procentage/100 * POINTS_PUISSANCE_TANK),
                (POINTS_ARMURE_TANK+Rarete.Rare.procentage/100 * POINTS_ARMURE_TANK),
                (POINTS_PUISSANCE_SUPPLEMENTAIRE_TANK+Rarete.Rare.procentage/100 * POINTS_PUISSANCE_SUPPLEMENTAIRE_TANK));
    }

    public static Heros newLegendaryTank(String id) {
        return new Heros(id,new Caracteristiques(Specialite.Tank,Rarete.Legandaire),(POINTS_VIE_TANK+Rarete.Legandaire.procentage/100 * POINTS_VIE_TANK),
                (POINTS_PUISSANCE_TANK+Rarete.Legandaire.procentage/100 * POINTS_PUISSANCE_TANK),
                (POINTS_ARMURE_TANK+Rarete.Legandaire.procentage/100 * POINTS_ARMURE_TANK),
                (POINTS_PUISSANCE_SUPPLEMENTAIRE_TANK+Rarete.Legandaire.procentage/100 * POINTS_PUISSANCE_SUPPLEMENTAIRE_TANK));
    }

    public static Heros newCommunAssassin(String id) {
        return new Heros(id,new Caracteristiques(Specialite.Assassin,Rarete.Commun),POINTS_VIE_ASSASSIN,POINTS_PUISSANCE_ASSASSIN,POINTS_ARMURE_ASSASSIN,POINTS_PUISSANCE_SUPPLEMENTAIRE_ASSASSIN);
    }

    public static Heros newRareAssassin(String id) {
        return new Heros(id,new Caracteristiques(Specialite.Assassin,Rarete.Rare),(POINTS_VIE_ASSASSIN+Rarete.Rare.procentage/100 * POINTS_VIE_ASSASSIN),
                (POINTS_PUISSANCE_ASSASSIN+Rarete.Rare.procentage/100 * POINTS_PUISSANCE_ASSASSIN),
                (POINTS_ARMURE_ASSASSIN+Rarete.Rare.procentage/100 * POINTS_ARMURE_ASSASSIN),
                (POINTS_PUISSANCE_SUPPLEMENTAIRE_ASSASSIN+Rarete.Rare.procentage/100 * POINTS_PUISSANCE_SUPPLEMENTAIRE_ASSASSIN));
    }

    public static Heros newLegendaryAssassin(String id) {
        return new Heros(id,new Caracteristiques(Specialite.Assassin,Rarete.Legandaire),(POINTS_VIE_ASSASSIN+Rarete.Legandaire.procentage/100 * POINTS_VIE_ASSASSIN),
                (POINTS_PUISSANCE_ASSASSIN+Rarete.Legandaire.procentage/100 * POINTS_PUISSANCE_ASSASSIN),
                (POINTS_ARMURE_ASSASSIN+Rarete.Legandaire.procentage/100 * POINTS_ARMURE_ASSASSIN),
                (POINTS_PUISSANCE_SUPPLEMENTAIRE_ASSASSIN+Rarete.Legandaire.procentage/100 * POINTS_PUISSANCE_SUPPLEMENTAIRE_ASSASSIN));
    }

    public static Heros newCommunMage(String id) {
        return new Heros(id,new Caracteristiques(Specialite.Mage,Rarete.Commun),POINTS_VIE_MAGE,POINTS_PUISSANCE_MAGE,POINTS_ARMURE_MAGE,POINTS_PUISSANCE_SUPPLEMENTAIRE_MAGE);
    }

    public static Heros newRareMage(String id) {
        return new Heros(id,new Caracteristiques(Specialite.Mage,Rarete.Rare),(POINTS_VIE_MAGE+Rarete.Rare.procentage/100 * POINTS_VIE_MAGE),
                (POINTS_PUISSANCE_MAGE+Rarete.Rare.procentage/100 * POINTS_PUISSANCE_MAGE),
                (POINTS_ARMURE_MAGE+Rarete.Rare.procentage/100 * POINTS_ARMURE_MAGE),
                (POINTS_PUISSANCE_SUPPLEMENTAIRE_MAGE+Rarete.Rare.procentage/100 * POINTS_PUISSANCE_SUPPLEMENTAIRE_MAGE));
    }

    public static Heros newLegendaryMage(String id) {
        return new Heros(id,new Caracteristiques(Specialite.Mage,Rarete.Legandaire),(POINTS_VIE_MAGE+Rarete.Legandaire.procentage/100 * POINTS_VIE_MAGE),
                (POINTS_PUISSANCE_MAGE+Rarete.Legandaire.procentage/100 * POINTS_PUISSANCE_MAGE),
                (POINTS_ARMURE_MAGE+Rarete.Legandaire.procentage/100 * POINTS_ARMURE_MAGE),
                (POINTS_PUISSANCE_SUPPLEMENTAIRE_MAGE+Rarete.Legandaire.procentage/100 * POINTS_PUISSANCE_SUPPLEMENTAIRE_MAGE));
    }





    public Heros(String id, Caracteristiques caracteristiques, float point_de_vie, float puissance, float armure, float puissance_supplementaire) {
        this.id = id;
        this.caracteristiques = caracteristiques;
        this.puissance = puissance;
        this.point_de_vie = point_de_vie;
        this.armure = armure;
        this.puissance_supplementaire = puissance_supplementaire;
    }


    public Heros(String id, Caracteristiques caracteristiques) {
        this.id = id;
        this.caracteristiques = caracteristiques;
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
