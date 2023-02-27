package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import src.domain.functional.model.*;

class DeckTest {

    @Test
    void ajouteCarte() {
        Deck deck = new Deck();
        deck.ajouteCarte(new Heros("123",new Caracteristiques(Specialite.Tank, Rarete.Commun)));
        Assertions.assertTrue(!deck.getListCartes().isEmpty());
    }
}