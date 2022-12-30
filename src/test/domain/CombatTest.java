package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CombatTest {

    Heros attaquant = new Heros("123",new Caracteristiques(Specialite.Tank,Rarete.Rare));
    Heros adveraire = new Heros("123",new Caracteristiques(Specialite.Tank,Rarete.Rare));
    Combat combat = new Combat(attaquant,adveraire);

    @Test
    public void un_attaque() {
        combat.un_attaque();
        Assertions.assertEquals(adveraire.getArmure(),0);
        Assertions.assertEquals(adveraire.getPoint_de_vie(),920);
    }

    @Test
    public void un_contre_attaque() {
        combat.un_contre_attaque();
        Assertions.assertEquals(attaquant.getArmure(),0);
        Assertions.assertEquals(attaquant.getPoint_de_vie(),920);
    }

    @Test
    public void attaque() {
        combat.attaque();
        Assertions.assertTrue(adveraire.getArmure()<=0);
        Assertions.assertTrue(adveraire.getPoint_de_vie()<=0);
    }

    @Test
    public void getGagnant() {
        combat.attaque();
        Assertions.assertEquals(combat.getGagnant(),attaquant);
    }

    @Test
    public void combat_history() {
        combat.attaque();
        combat.combat_history();
        Assertions.assertTrue(!attaquant.get_history().isEmpty());
    }
}