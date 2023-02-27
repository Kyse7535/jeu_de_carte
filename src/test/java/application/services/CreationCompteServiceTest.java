package application.services;

import src.server.database.Adapter.MysqlAdapter;
import src.domain.functional.DTOs.CreationCompteCommand;
import src.domain.functional.model.Compte;
import src.domain.functional.service.CreationCompteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreationCompteServiceTest {

    @InjectMocks
    private CreationCompteService service;

    @Mock
    private MysqlAdapter persistanceAdapter;

    @Test
    void should_create() {
        Compte compte = service.create(new CreationCompteCommand("test"));
        Assertions.assertEquals(4, compte.getNombreJetons());
        Assertions.assertTrue(compte.getDeck().getListCartes().isEmpty());
        Assertions.assertEquals("test",compte.getPseudo());
    }

}
