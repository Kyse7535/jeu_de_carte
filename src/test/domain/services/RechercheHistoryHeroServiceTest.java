package application.services;

import adapter.out.PersistanceAdapter;
import application.port.in.DTOs.RechercheHistoryHeroCommand;
import domain.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class
)
class RechercheHistoryHeroServiceTest {

    @InjectMocks
    RechercheHistoryHeroService rechercheHistoryHeroService;

    @Mock
    PersistanceAdapter persistanceAdapter;

    @Test
    void combat_history() {
        Heros heros = new Heros("123",new Caracteristiques(Specialite.Tank, Rarete.Commun));
        RechercheHistoryHeroCommand rechercheHistoryHeroCommand = new RechercheHistoryHeroCommand("123");

        Mockito.when(persistanceAdapter.load_heros("123")).thenReturn(heros);
        List<Combat> heros_combat_history = rechercheHistoryHeroService.combatHistory(rechercheHistoryHeroCommand);

        assertTrue(heros_combat_history.isEmpty());
        Mockito.verify(persistanceAdapter).load_heros("123");
        Mockito.verifyNoMoreInteractions(persistanceAdapter);
    }
}