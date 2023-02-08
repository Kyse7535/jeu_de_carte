package domain;

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


    private String id;
    private Caracteristiques caracteristiques;
    private float niveau;
    private float pointDeVie;
    private float pointExp;
    private float puissance;
    private float armure;
    private float puissanceSupplementaire;
    private ArrayList<Combat> combatHistory;
    private boolean enVie;

    public Heros() {
    }

    public static Heros newCommunTank(String id) {
        return new Heros(id,new Caracteristiques(Specialite.Tank,Rarete.Commun),POINTS_VIE_TANK,POINTS_PUISSANCE_TANK,POINTS_ARMURE_TANK,POINTS_PUISSANCE_SUPPLEMENTAIRE_TANK);
    }

    public static Heros newRareTank(String id) {
        return new Heros(id,new Caracteristiques(Specialite.Tank,Rarete.Rare),(POINTS_VIE_TANK+Rarete.Rare.getProcentage()/100 * POINTS_VIE_TANK),
                (POINTS_PUISSANCE_TANK+Rarete.Rare.getProcentage()/100 * POINTS_PUISSANCE_TANK),
                (POINTS_ARMURE_TANK+Rarete.Rare.getProcentage()/100 * POINTS_ARMURE_TANK),
                (POINTS_PUISSANCE_SUPPLEMENTAIRE_TANK+Rarete.Rare.getProcentage()/100 * POINTS_PUISSANCE_SUPPLEMENTAIRE_TANK));
    }

    public static Heros newLegendaryTank(String id) {
        return new Heros(id,new Caracteristiques(Specialite.Tank,Rarete.Legandaire),(POINTS_VIE_TANK+Rarete.Legandaire.getProcentage()/100 * POINTS_VIE_TANK),
                (POINTS_PUISSANCE_TANK+Rarete.Legandaire.getProcentage()/100 * POINTS_PUISSANCE_TANK),
                (POINTS_ARMURE_TANK+Rarete.Legandaire.getProcentage()/100 * POINTS_ARMURE_TANK),
                (POINTS_PUISSANCE_SUPPLEMENTAIRE_TANK+Rarete.Legandaire.getProcentage()/100 * POINTS_PUISSANCE_SUPPLEMENTAIRE_TANK));
    }

    public static Heros newCommunAssassin(String id) {
        return new Heros(id,new Caracteristiques(Specialite.Assassin,Rarete.Commun),POINTS_VIE_ASSASSIN,POINTS_PUISSANCE_ASSASSIN,POINTS_ARMURE_ASSASSIN,POINTS_PUISSANCE_SUPPLEMENTAIRE_ASSASSIN);
    }

    public static Heros newRareAssassin(String id) {
        return new Heros(id,new Caracteristiques(Specialite.Assassin,Rarete.Rare),(POINTS_VIE_ASSASSIN+Rarete.Rare.getProcentage()/100 * POINTS_VIE_ASSASSIN),
                (POINTS_PUISSANCE_ASSASSIN+Rarete.Rare.getProcentage()/100 * POINTS_PUISSANCE_ASSASSIN),
                (POINTS_ARMURE_ASSASSIN+Rarete.Rare.getProcentage()/100 * POINTS_ARMURE_ASSASSIN),
                (POINTS_PUISSANCE_SUPPLEMENTAIRE_ASSASSIN+Rarete.Rare.getProcentage()/100 * POINTS_PUISSANCE_SUPPLEMENTAIRE_ASSASSIN));
    }

    public static Heros newLegendaryAssassin(String id) {
        return new Heros(id,new Caracteristiques(Specialite.Assassin,Rarete.Legandaire),(POINTS_VIE_ASSASSIN+Rarete.Legandaire.getProcentage()/100 * POINTS_VIE_ASSASSIN),
                (POINTS_PUISSANCE_ASSASSIN+Rarete.Legandaire.getProcentage()/100 * POINTS_PUISSANCE_ASSASSIN),
                (POINTS_ARMURE_ASSASSIN+Rarete.Legandaire.getProcentage()/100 * POINTS_ARMURE_ASSASSIN),
                (POINTS_PUISSANCE_SUPPLEMENTAIRE_ASSASSIN+Rarete.Legandaire.getProcentage()/100 * POINTS_PUISSANCE_SUPPLEMENTAIRE_ASSASSIN));
    }

    public static Heros newCommunMage(String id) {
        return new Heros(id,new Caracteristiques(Specialite.Mage,Rarete.Commun),POINTS_VIE_MAGE,POINTS_PUISSANCE_MAGE,POINTS_ARMURE_MAGE,POINTS_PUISSANCE_SUPPLEMENTAIRE_MAGE);
    }

    public static Heros newRareMage(String id) {
        return new Heros(id,new Caracteristiques(Specialite.Mage,Rarete.Rare),(POINTS_VIE_MAGE+Rarete.Rare.getProcentage()/100 * POINTS_VIE_MAGE),
                (POINTS_PUISSANCE_MAGE+Rarete.Rare.getProcentage()/100 * POINTS_PUISSANCE_MAGE),
                (POINTS_ARMURE_MAGE+Rarete.Rare.getProcentage()/100 * POINTS_ARMURE_MAGE),
                (POINTS_PUISSANCE_SUPPLEMENTAIRE_MAGE+Rarete.Rare.getProcentage()/100 * POINTS_PUISSANCE_SUPPLEMENTAIRE_MAGE));
    }

    public static Heros newLegendaryMage(String id) {
        return new Heros(id,new Caracteristiques(Specialite.Mage,Rarete.Legandaire),(POINTS_VIE_MAGE+Rarete.Legandaire.getProcentage()/100 * POINTS_VIE_MAGE),
                (POINTS_PUISSANCE_MAGE+Rarete.Legandaire.getProcentage()/100 * POINTS_PUISSANCE_MAGE),
                (POINTS_ARMURE_MAGE+Rarete.Legandaire.getProcentage()/100 * POINTS_ARMURE_MAGE),
                (POINTS_PUISSANCE_SUPPLEMENTAIRE_MAGE+Rarete.Legandaire.getProcentage()/100 * POINTS_PUISSANCE_SUPPLEMENTAIRE_MAGE));
    }





    public Heros(String id, Caracteristiques caracteristiques, float pointDeVie, float puissance, float armure, float puissanceSupplementaire) {
        this.id = id;
        this.caracteristiques = caracteristiques;
        this.puissance = puissance;
        this.pointDeVie = pointDeVie;
        this.armure = armure;
        this.puissanceSupplementaire = puissanceSupplementaire;
        this.niveau = 1;
        this.combatHistory = new ArrayList<>();
        this.enVie = true;
    }

    public Heros(String id, Caracteristiques caracteristiques, float niveau, float pointDeVie, float pointExp, float puissance, float armure, float puissanceSupplementaire, ArrayList<Combat> combatList, boolean enVie) {
        this.id = id;
        this.caracteristiques = caracteristiques;
        this.niveau = niveau;
        this.pointDeVie = pointDeVie;
        this.pointExp = pointExp;
        this.puissance = puissance;
        this.armure = armure;
        this.puissanceSupplementaire = puissanceSupplementaire;
        this.combatHistory = combatList;
        this.enVie = enVie;
    }

    public Heros(String id, Caracteristiques caracteristiques) {
        this.id = id;
        this.caracteristiques = caracteristiques;
        this.niveau = 1;
        this.combatHistory = new ArrayList<>();
        this.enVie = true;

    }

    public void gagnerUnCombat() {
        pointExp += 1;
        if (pointExp % 5 == 0) {
            this.niveau += 1;
            this.pointDeVie = (float) (this.pointDeVie + 0.1*this.pointDeVie);
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

    public float getPointDeVie() {
        return pointDeVie;
    }

    public void setPointDeVie(float pointDeVie) {
        this.pointDeVie = pointDeVie;
    }

    public float getPuissance() {
        return puissance;
    }

    public float getArmure() {
        return armure;
    }

    public void setArmure(float armure) {
        this.armure = armure;
    }

    public float getPuissanceSupplementaire() {
        return puissanceSupplementaire;
    }

    public Caracteristiques getCaracteristiques() { return caracteristiques;}

    public void combatHistory(Combat combat) {
        this.combatHistory.add(combat);
    }

    public ArrayList<Combat> getHistory() {
        return this.combatHistory;
    }

    public void setEnVie(boolean enVie) {
        this.enVie = enVie;
    }

    public boolean getEnVie() {
        return this.enVie;
    }

    public float getPointExp() {
        return this.pointExp;
    }

    @Override
    public String toString() {
        return "Heros{" +
                "id='" + id + '\'' +
                ", caracteristiques=" + caracteristiques +
                ", niveau=" + niveau +
                ", point_de_vie=" + pointDeVie +
                ", point_exp=" + pointExp +
                ", puissance=" + puissance +
                ", armure=" + armure +
                ", puissance_supplementaire=" + puissanceSupplementaire +
                '}';
    }
}
