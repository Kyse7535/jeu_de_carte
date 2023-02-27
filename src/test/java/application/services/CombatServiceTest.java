package application.services;


import src.server.database.Adapter.MysqlAdapter;
import src.domain.functional.DTOs.CombatCommand;
import src.domain.functional.model.Combat;
import src.domain.functional.model.Heros;
import src.domain.functional.service.CombatService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CombatServiceTest {

    @InjectMocks
    CombatService service;

    @Mock
    private MysqlAdapter persistanceAdapter;

    @Test
    public void attack() {
        CombatCommand combatCommand = new CombatCommand(new Combat(Heros.newCommunTank("123"),Heros.newCommunTank("124")));

        Combat combat = service.attack(combatCommand);
        Assertions.assertEquals(combat.getAdversaire().getPointDeVie(),-80);

        org.assertj.core.api.Assertions.assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> service.attack(combatCommand));

    }
}
