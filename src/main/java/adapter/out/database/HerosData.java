package adapter.out.database;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class HerosData {


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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Embedded
    private CaracteristiquesData caracteristiques;
    private float niveau;
    private float pointDeVie;
    private float pointExp;
    private float puissance;
    private float armure;
    private float puissanceSupplementaire;

    @OneToMany(mappedBy = "attaquant")
    private List<CombatData> combatHistory;

    @OneToMany(mappedBy = "adversaire")
    private List<CombatData> combatHistory2;

    public List<CombatData> getCombatHistory2() {
        return combatHistory2;
    }

    public void setCombatHistory2(List<CombatData> combatHistory2) {
        this.combatHistory2 = combatHistory2;
    }

    public List<CombatData> getCombatHistory() {
        return combatHistory;
    }

    public void setCombatHistory(ArrayList<CombatData> combatHistory) {
        this.combatHistory = combatHistory;
    }

    private boolean enVie;

    public HerosData() {
    }

    public static HerosData newCommunTank(String id) {
        return new HerosData(id,new CaracteristiquesData(SpecialiteData.Tank, RareteData.Commun),POINTS_VIE_TANK,POINTS_PUISSANCE_TANK,POINTS_ARMURE_TANK,POINTS_PUISSANCE_SUPPLEMENTAIRE_TANK);
    }

    public static HerosData newRareTank(String id) {
        return new HerosData(id,new CaracteristiquesData(SpecialiteData.Tank,RareteData.Rare),(POINTS_VIE_TANK+RareteData.Rare.getProcentage()/100 * POINTS_VIE_TANK),
                (POINTS_PUISSANCE_TANK+RareteData.Rare.getProcentage()/100 * POINTS_PUISSANCE_TANK),
                (POINTS_ARMURE_TANK+RareteData.Rare.getProcentage()/100 * POINTS_ARMURE_TANK),
                (POINTS_PUISSANCE_SUPPLEMENTAIRE_TANK+RareteData.Rare.getProcentage()/100 * POINTS_PUISSANCE_SUPPLEMENTAIRE_TANK));
    }

    public static HerosData newLegendaryTank(String id) {
        return new HerosData(id,new CaracteristiquesData(SpecialiteData.Tank,RareteData.Legandaire),(POINTS_VIE_TANK+RareteData.Legandaire.getProcentage()/100 * POINTS_VIE_TANK),
                (POINTS_PUISSANCE_TANK+RareteData.Legandaire.getProcentage()/100 * POINTS_PUISSANCE_TANK),
                (POINTS_ARMURE_TANK+RareteData.Legandaire.getProcentage()/100 * POINTS_ARMURE_TANK),
                (POINTS_PUISSANCE_SUPPLEMENTAIRE_TANK+RareteData.Legandaire.getProcentage()/100 * POINTS_PUISSANCE_SUPPLEMENTAIRE_TANK));
    }

    public static HerosData newCommunAssassin(String id) {
        return new HerosData(id,new CaracteristiquesData(SpecialiteData.Assassin,RareteData.Commun),POINTS_VIE_ASSASSIN,POINTS_PUISSANCE_ASSASSIN,POINTS_ARMURE_ASSASSIN,POINTS_PUISSANCE_SUPPLEMENTAIRE_ASSASSIN);
    }

    public static HerosData newRareAssassin(String id) {
        return new HerosData(id,new CaracteristiquesData(SpecialiteData.Assassin,RareteData.Rare),(POINTS_VIE_ASSASSIN+RareteData.Rare.getProcentage()/100 * POINTS_VIE_ASSASSIN),
                (POINTS_PUISSANCE_ASSASSIN+RareteData.Rare.getProcentage()/100 * POINTS_PUISSANCE_ASSASSIN),
                (POINTS_ARMURE_ASSASSIN+RareteData.Rare.getProcentage()/100 * POINTS_ARMURE_ASSASSIN),
                (POINTS_PUISSANCE_SUPPLEMENTAIRE_ASSASSIN+RareteData.Rare.getProcentage()/100 * POINTS_PUISSANCE_SUPPLEMENTAIRE_ASSASSIN));
    }

    public static HerosData newLegendaryAssassin(String id) {
        return new HerosData(id,new CaracteristiquesData(SpecialiteData.Assassin,RareteData.Legandaire),(POINTS_VIE_ASSASSIN+RareteData.Legandaire.getProcentage()/100 * POINTS_VIE_ASSASSIN),
                (POINTS_PUISSANCE_ASSASSIN+RareteData.Legandaire.getProcentage()/100 * POINTS_PUISSANCE_ASSASSIN),
                (POINTS_ARMURE_ASSASSIN+RareteData.Legandaire.getProcentage()/100 * POINTS_ARMURE_ASSASSIN),
                (POINTS_PUISSANCE_SUPPLEMENTAIRE_ASSASSIN+RareteData.Legandaire.getProcentage()/100 * POINTS_PUISSANCE_SUPPLEMENTAIRE_ASSASSIN));
    }

    public static HerosData newCommunMage(String id) {
        return new HerosData(id,new CaracteristiquesData(SpecialiteData.Mage,RareteData.Commun),POINTS_VIE_MAGE,POINTS_PUISSANCE_MAGE,POINTS_ARMURE_MAGE,POINTS_PUISSANCE_SUPPLEMENTAIRE_MAGE);
    }

    public static HerosData newRareMage(String id) {
        return new HerosData(id,new CaracteristiquesData(SpecialiteData.Mage,RareteData.Rare),(POINTS_VIE_MAGE+RareteData.Rare.getProcentage()/100 * POINTS_VIE_MAGE),
                (POINTS_PUISSANCE_MAGE+RareteData.Rare.getProcentage()/100 * POINTS_PUISSANCE_MAGE),
                (POINTS_ARMURE_MAGE+RareteData.Rare.getProcentage()/100 * POINTS_ARMURE_MAGE),
                (POINTS_PUISSANCE_SUPPLEMENTAIRE_MAGE+RareteData.Rare.getProcentage()/100 * POINTS_PUISSANCE_SUPPLEMENTAIRE_MAGE));
    }

    public static HerosData newLegendaryMage(String id) {
        return new HerosData(id,new CaracteristiquesData(SpecialiteData.Mage,RareteData.Legandaire),(POINTS_VIE_MAGE+RareteData.Legandaire.getProcentage()/100 * POINTS_VIE_MAGE),
                (POINTS_PUISSANCE_MAGE+RareteData.Legandaire.getProcentage()/100 * POINTS_PUISSANCE_MAGE),
                (POINTS_ARMURE_MAGE+RareteData.Legandaire.getProcentage()/100 * POINTS_ARMURE_MAGE),
                (POINTS_PUISSANCE_SUPPLEMENTAIRE_MAGE+RareteData.Legandaire.getProcentage()/100 * POINTS_PUISSANCE_SUPPLEMENTAIRE_MAGE));
    }





    public HerosData(String id, CaracteristiquesData caracteristiques, float pointDeVie, float puissance, float armure, float puissanceSupplementaire) {
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

    public HerosData(String id, CaracteristiquesData caracteristiques, float niveau, float pointDeVie, float pointExp, float puissance, float armure, float puissanceSupplementaire, ArrayList<CombatData> combatList, boolean enVie) {
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

    public HerosData(String id, CaracteristiquesData caracteristiques) {
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

    public CaracteristiquesData getCaracteristiques() {
        return caracteristiques;
    }

    public void setCaracteristiques(CaracteristiquesData caracteristiques) {
        this.caracteristiques = caracteristiques;
    }

    public float getPuissanceSupplementaire() {
        return puissanceSupplementaire;
    }

    public CaracteristiquesData getCaracteristiquesData() { return caracteristiques;}

    public void combatHistory(CombatData combat) {
        this.combatHistory.add(combat);
    }

    public List<CombatData> getHistory() {
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


