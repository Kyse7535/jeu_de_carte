package application.services;

import src.server.database.Adapter.MysqlAdapter;
import src.domain.functional.DTOs.OuverturePackCommand;
import src.domain.functional.model.Compte;
import src.domain.functional.model.Pack;
import src.domain.functional.service.OuverturePackService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class OuverturePackServiceTest {

    @InjectMocks
    private OuverturePackService ouverturePackService;

    @Mock
    private MysqlAdapter persistanceAdapter;

    @Mock
    private Random random;

    @Test
    void ouvre_pack_argent() {
        OuverturePackCommand pack_diamant = new OuverturePackCommand(Pack.diamant,new Compte("123"));

        Assertions.assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> ouverturePackService.ouvrePack(pack_diamant));

    }
}
