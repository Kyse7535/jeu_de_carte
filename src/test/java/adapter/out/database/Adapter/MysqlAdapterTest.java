package adapter.out.database.Adapter;

import src.domain.functional.model.Compte;
import src.domain.functional.model.Heros;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import src.server.database.Adapter.MysqlAdapter;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class MysqlAdapterTest {

    @Mock
    MysqlAdapter database;

    @Test
    void save() {
        Compte given = new Compte("gesco");
        database.save(given);

        Mockito.when(database.load_compte("gesco")).thenReturn(given);
        Compte actual = database.load_compte("gesco");

        Assertions.assertThat(actual).isEqualTo(given);
    }

    @Test
    void load_compte() {
        Compte given = new Compte("gesco");
        database.save(given);

        Mockito.when(database.load_compte("gesco")).thenReturn(given);
        Compte actual = database.load_compte("gesco");

        Assertions.assertThat(actual).isEqualTo(given);


    }

    @Test
    void update() {
        Compte given = new Compte("gesco");
        Heros heros = Heros.newCommunTank("123");
        given.getDeck().ajouteCarte(heros);
        database.save(given);
        Mockito.when(database.load_compte("gesco")).thenReturn(given);
        Compte actual = database.load_compte("gesco");

        Assertions.assertThat(actual).isEqualTo(given);

        Heros heros2 = Heros.newCommunTank("124");
        given.getDeck().ajouteCarte(heros2);
        database.update(given);

        actual = database.load_compte("gesco");

        org.junit.jupiter.api.Assertions.assertEquals(actual,given);


    }

    @Test
    void findAllPlayers() {
        Compte compte1 = new Compte("gesco");
        Compte compte2 = new Compte("gesco2");
        List<Compte> comptes = new ArrayList<>();
        comptes.add(compte1);
        comptes.add(compte2);

        database.save(compte1); database.save(compte2);

        Mockito.when(database.findAllPlayers()).thenReturn(comptes);
        List<Compte> result = database.findAllPlayers();

        org.junit.jupiter.api.Assertions.assertEquals(result, comptes);
    }

    @Test
    void testSave() {
        Heros heros = Heros.newCommunMage("123");
        database.save(heros);

        Mockito.when(database.load_heros("123")).thenReturn(heros);
        Heros actual = database.load_heros("123");

        org.junit.jupiter.api.Assertions.assertEquals(actual, heros);
    }

    @Test
    void load_heros() {
        Heros heros = Heros.newCommunMage("123");
        database.save(heros);

        Mockito.when(database.load_heros("123")).thenReturn(heros);
        Heros actual = database.load_heros("123");

        org.junit.jupiter.api.Assertions.assertEquals(actual, heros);
    }

    @Test
    void findAllHeros() {
        Heros heros = Heros.newCommunMage("123");
        Heros heros2 = Heros.newLegendaryTank("124");
        List<Heros> list = new ArrayList<>();
        list.add(heros);
        list.add(heros2);

        Mockito.when(database.findAllHeros()).thenReturn(list);
        List<Heros> result = database.findAllHeros();

        org.junit.jupiter.api.Assertions.assertEquals(list,result);
    }
}