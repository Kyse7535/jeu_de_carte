package application.services;

import adapter.out.PersistanceAdapter;
import application.port.in.DTOs.OuverturePackCommand;
import domain.Compte;
import domain.Pack;
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
    private PersistanceAdapter persistanceAdapter;

    @Mock
    private Random random;

    @Test
    void ouvre_pack_argent() {
        OuverturePackCommand pack_diamant = new OuverturePackCommand(Pack.diamant,new Compte("123"));

        Assertions.assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> ouverturePackService.ouvrePack(pack_diamant));

    }
}