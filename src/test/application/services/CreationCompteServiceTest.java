package application.services;

import adapter.out.PersistanceAdapter;
import application.port.in.DTOs.CreationCompteCommand;
import domain.Compte;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CreationCompteServiceTest {


    @InjectMocks
    private CreationCompteService creationCompteService;


    @Test
    void create() {
        Compte compte = service.create(new CreationCompteCommand("test"));
        Assertions.assertEquals(4, compte.getNombre_jetons());
        Assertions.assertTrue(compte.getDeck().getListCartes().isEmpty());
        Assertions.assertEquals("test",compte.getPseudo());
    }
}
