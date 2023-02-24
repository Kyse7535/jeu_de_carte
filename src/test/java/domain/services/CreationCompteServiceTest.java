package application.services;

import adapter.out.PersistanceAdapter;
import application.port.in.DTOs.CreationCompteCommand;
import domain.Compte;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreationCompteServiceTest {

    @InjectMocks
    private CreationCompteService service;

    @Mock
    private PersistanceAdapter persistanceAdapter;

    @Test
    void should_create() {
        Compte compte = service.create(new CreationCompteCommand("test"));
        Assertions.assertEquals(4, compte.getNombreJetons());
        Assertions.assertTrue(compte.getDeck().getListCartes().isEmpty());
        Assertions.assertEquals("test",compte.getPseudo());
    }
    @Test
    void should_not_create() {
        Compte compte = service.create(new CreationCompteCommand("test"));
        Mockito.when(persistanceAdapter.load_compte("test")).thenReturn(compte);
        org.assertj.core.api.Assertions.assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> service.create(new CreationCompteCommand("test")));
    }

}