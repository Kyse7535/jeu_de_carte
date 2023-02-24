package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CombatTest {

    Heros attaquant = Heros.newCommunTank("123");
    Heros adveraire = Heros.newCommunTank("124");
    Heros adversaireMage = Heros.newCommunMage("125");
    Heros assassin = Heros.newCommunAssassin("126");
    Combat combat = new Combat(attaquant,adveraire);
    Combat combat2 = new Combat(attaquant,adversaireMage);
    Combat assassin_vs_tank = new Combat(assassin,adveraire);
    Combat mage_vs_assassin = new Combat(adversaireMage,assassin);
    Combat assassin_vs_mage = new Combat(assassin,adversaireMage);
    Combat mage_vs_tank = new Combat(adversaireMage,attaquant);
    Combat tank_vs_assassin = new Combat(attaquant,assassin);

    @Test
    public void un_contr_attaque_assassin_vs_tank() {
        tank_vs_assassin.unContreAttaque();
        Assertions.assertEquals(attaquant.getArmure(),0);
        Assertions.assertEquals(790, attaquant.getPointDeVie());
    }

    @Test
    public void un_contre_attaque_tank_vs_mage() {
        mage_vs_tank.unContreAttaque();
        Assertions.assertEquals(adversaireMage.getArmure(),0);
        Assertions.assertEquals(590, adversaireMage.getPointDeVie());
    }

    @Test
    public void un_contre_attaque_mage_vs_assassin() {
        assassin_vs_mage.unContreAttaque();
        Assertions.assertEquals(assassin.getArmure(),0);
        Assertions.assertEquals(630, assassin.getPointDeVie());
    }

    @Test
    public void unAttaque_mage_vs_assassin() {
        mage_vs_assassin.unAttaque();
        Assertions.assertEquals(assassin.getArmure(),0);
        Assertions.assertEquals(630, assassin.getPointDeVie());
    }

    @Test
    public void unAttaque_assassin_vs_tank() {
        assassin_vs_tank.unAttaque();
        Assertions.assertEquals(adveraire.getArmure(),0);
        Assertions.assertEquals(790, adveraire.getPointDeVie());
    }

    @Test
    public void unAttaque_tank_vs_mage() {
        combat2.unAttaque();
        Assertions.assertEquals(adversaireMage.getArmure(),0);
        Assertions.assertEquals(590, adversaireMage.getPointDeVie());
    }

    @Test
    public void unAttaque() {
        combat.unAttaque();
        Assertions.assertEquals(adveraire.getArmure(),0);
        Assertions.assertEquals(920, adveraire.getPointDeVie());
    }

    @Test
    public void un_contre_attaque() {
        combat.unContreAttaque();
        Assertions.assertEquals(attaquant.getArmure(),0);
        Assertions.assertEquals(attaquant.getPointDeVie(),920);
    }

    @Test
    public void attaque() {
        combat.attaque();
        Assertions.assertTrue(adveraire.getArmure()<=0);
        Assertions.assertTrue(adveraire.getPointDeVie()<=0);
    }

    @Test
    public void getGagnant() {
        combat.attaque();
        Assertions.assertEquals(adveraire.getPointDeVie(),-80);
        Assertions.assertEquals(combat.getGagnant(),attaquant);
    }

    @Test
    public void combat_history() {
        combat.attaque();
        combat.combatHistory();
        Assertions.assertTrue(!attaquant.getHistory().isEmpty());
    }
}
