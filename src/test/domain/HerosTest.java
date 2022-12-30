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
}