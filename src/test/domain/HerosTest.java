package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HerosTest {

    Heros attaquant = new Heros("123",new Caracteristiques(Specialite.Tank,Rarete.Commun));

    @Test
    void gagnerUnCombat() {
        attaquant.gagnerUnCombat();
        Assertions.assertEquals(attaquant.getPoint_exp(),1);
        attaquant.gagnerUnCombat();
        Assertions.assertEquals(attaquant.getPoint_exp(),2);
        attaquant.gagnerUnCombat();
        attaquant.gagnerUnCombat();
        attaquant.gagnerUnCombat();
        Assertions.assertEquals(attaquant.getNiveau(),2);
    }

    @Test
    void combat_history() {
        attaquant.combat_history(new Combat(attaquant,attaquant));
        Assertions.assertTrue(!attaquant.get_history().isEmpty());
    }
    
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

    @Test
    void newCommunTank() {
        Heros heros = Heros.newCommunTank("test");
        assertEquals(heros.getPoint_de_vie(),POINTS_VIE_TANK);
        assertEquals(heros.getPuissance(),POINTS_PUISSANCE_TANK);
        assertEquals(heros.getArmure(),POINTS_ARMURE_TANK);
        assertEquals(heros.getPuissance_supplementaire(),POINTS_PUISSANCE_SUPPLEMENTAIRE_TANK);
        assertEquals(heros.getCaracteristiques().getSpecialite(),Specialite.Tank);
        assertEquals(heros.getCaracteristiques().getRarete(),Rarete.Commun);
    }

    @Test
    void newRareTank() {
        Heros heros = Heros.newRareTank("test");
        assertEquals(heros.getPoint_de_vie(),POINTS_VIE_TANK+Rarete.Rare.procentage/100 * POINTS_VIE_TANK);
        assertEquals(heros.getPuissance(),POINTS_PUISSANCE_TANK+Rarete.Rare.procentage/100 * POINTS_PUISSANCE_TANK);
        assertEquals(heros.getArmure(),POINTS_ARMURE_TANK+Rarete.Rare.procentage/100 * POINTS_ARMURE_TANK);
        assertEquals(heros.getPuissance_supplementaire(),POINTS_PUISSANCE_SUPPLEMENTAIRE_TANK+Rarete.Rare.procentage/100 * POINTS_PUISSANCE_SUPPLEMENTAIRE_TANK);
        assertEquals(heros.getCaracteristiques().getSpecialite(),Specialite.Tank);
        assertEquals(heros.getCaracteristiques().getRarete(),Rarete.Rare);
    }

    @Test
    void newLegendaryTank() {
        Heros heros = Heros.newLegendaryTank("test");
        assertEquals(heros.getPoint_de_vie(),POINTS_VIE_TANK+Rarete.Legandaire.procentage/100 * POINTS_VIE_TANK);
        assertEquals(heros.getPuissance(),POINTS_PUISSANCE_TANK+Rarete.Legandaire.procentage/100 * POINTS_PUISSANCE_TANK);
        assertEquals(heros.getArmure(),POINTS_ARMURE_TANK+Rarete.Legandaire.procentage/100 * POINTS_ARMURE_TANK);
        assertEquals(heros.getPuissance_supplementaire(),POINTS_PUISSANCE_SUPPLEMENTAIRE_TANK+Rarete.Legandaire.procentage/100 * POINTS_PUISSANCE_SUPPLEMENTAIRE_TANK);
        assertEquals(heros.getCaracteristiques().getSpecialite(),Specialite.Tank);
        assertEquals(heros.getCaracteristiques().getRarete(),Rarete.Legandaire);
    }

    @Test
    void newCommunAssassin() {
        Heros heros = Heros.newCommunAssassin("test");
        assertEquals(heros.getPoint_de_vie(),POINTS_VIE_ASSASSIN);
        assertEquals(heros.getPuissance(),POINTS_PUISSANCE_ASSASSIN);
        assertEquals(heros.getArmure(),POINTS_ARMURE_ASSASSIN);
        assertEquals(heros.getPuissance_supplementaire(),POINTS_PUISSANCE_SUPPLEMENTAIRE_ASSASSIN);
        assertEquals(heros.getCaracteristiques().getSpecialite(),Specialite.Assassin);
        assertEquals(heros.getCaracteristiques().getRarete(),Rarete.Commun);
    }

    @Test
    void newRareAssassin() {
        Heros heros = Heros.newRareAssassin("test");
        assertEquals(heros.getPoint_de_vie(),POINTS_VIE_ASSASSIN+Rarete.Rare.procentage/100 * POINTS_VIE_ASSASSIN);
        assertEquals(heros.getPuissance(),POINTS_PUISSANCE_ASSASSIN+Rarete.Rare.procentage/100 * POINTS_PUISSANCE_ASSASSIN);
        assertEquals(heros.getArmure(),POINTS_ARMURE_ASSASSIN+Rarete.Rare.procentage/100 * POINTS_ARMURE_ASSASSIN);
        assertEquals(heros.getPuissance_supplementaire(),POINTS_PUISSANCE_SUPPLEMENTAIRE_ASSASSIN+Rarete.Rare.procentage/100 * POINTS_PUISSANCE_SUPPLEMENTAIRE_ASSASSIN);
        assertEquals(heros.getCaracteristiques().getSpecialite(),Specialite.Assassin);
        assertEquals(heros.getCaracteristiques().getRarete(),Rarete.Rare);
    }

    @Test
    void newLegendaryAssassin() {
        Heros heros = Heros.newLegendaryAssassin("test");
        assertEquals(heros.getPoint_de_vie(),POINTS_VIE_ASSASSIN+Rarete.Legandaire.procentage/100 * POINTS_VIE_ASSASSIN);
        assertEquals(heros.getPuissance(),POINTS_PUISSANCE_ASSASSIN+Rarete.Legandaire.procentage/100 * POINTS_PUISSANCE_ASSASSIN);
        assertEquals(heros.getArmure(),POINTS_ARMURE_ASSASSIN+Rarete.Legandaire.procentage/100 * POINTS_ARMURE_ASSASSIN);
        assertEquals(heros.getPuissance_supplementaire(),POINTS_PUISSANCE_SUPPLEMENTAIRE_ASSASSIN+Rarete.Legandaire.procentage/100 * POINTS_PUISSANCE_SUPPLEMENTAIRE_ASSASSIN);
        assertEquals(heros.getCaracteristiques().getSpecialite(),Specialite.Assassin);
        assertEquals(heros.getCaracteristiques().getRarete(),Rarete.Legandaire);
    }

    @Test
    void newCommunMage() {
        Heros heros = Heros.newCommunMage("test");
        assertEquals(heros.getPoint_de_vie(),POINTS_VIE_MAGE);
        assertEquals(heros.getPuissance(),POINTS_PUISSANCE_MAGE);
        assertEquals(heros.getArmure(),POINTS_ARMURE_MAGE);
        assertEquals(heros.getPuissance_supplementaire(),POINTS_PUISSANCE_SUPPLEMENTAIRE_MAGE);
        assertEquals(heros.getCaracteristiques().getSpecialite(),Specialite.Mage);
        assertEquals(heros.getCaracteristiques().getRarete(),Rarete.Commun);
    }

    @Test
    void newRareMage() {
        Heros heros = Heros.newRareMage("test");
        assertEquals(heros.getPoint_de_vie(),POINTS_VIE_MAGE+Rarete.Rare.procentage/100 * POINTS_VIE_MAGE);
        assertEquals(heros.getPuissance(),POINTS_PUISSANCE_MAGE+Rarete.Rare.procentage/100 * POINTS_PUISSANCE_MAGE);
        assertEquals(heros.getArmure(),POINTS_ARMURE_MAGE+Rarete.Rare.procentage/100 * POINTS_ARMURE_MAGE);
        assertEquals(heros.getPuissance_supplementaire(),POINTS_PUISSANCE_SUPPLEMENTAIRE_MAGE+Rarete.Rare.procentage/100 * POINTS_PUISSANCE_SUPPLEMENTAIRE_MAGE);
        assertEquals(heros.getCaracteristiques().getSpecialite(),Specialite.Mage);
        assertEquals(heros.getCaracteristiques().getRarete(),Rarete.Rare);
    }

    @Test
    void newLegendaryMage() {
        Heros heros = Heros.newLegendaryMage("test");
        assertEquals(heros.getPoint_de_vie(),POINTS_VIE_MAGE+Rarete.Legandaire.procentage/100 * POINTS_VIE_MAGE);
        assertEquals(heros.getPuissance(),POINTS_PUISSANCE_MAGE+Rarete.Legandaire.procentage/100 * POINTS_PUISSANCE_MAGE);
        assertEquals(heros.getArmure(),POINTS_ARMURE_MAGE+Rarete.Legandaire.procentage/100 * POINTS_ARMURE_MAGE);
        assertEquals(heros.getPuissance_supplementaire(),POINTS_PUISSANCE_SUPPLEMENTAIRE_MAGE+Rarete.Legandaire.procentage/100 * POINTS_PUISSANCE_SUPPLEMENTAIRE_MAGE);
        assertEquals(heros.getCaracteristiques().getSpecialite(),Specialite.Mage);
        assertEquals(heros.getCaracteristiques().getRarete(),Rarete.Rare);
    }
}
