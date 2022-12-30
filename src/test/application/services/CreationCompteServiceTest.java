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
    public void create() {
        CreationCompteCommand creationCompteCommand = new CreationCompteCommand("test");
        Compte compte = creationCompteService.create(creationCompteCommand);

        Assertions.assertEquals(compte.getPseudo(),"test");
    }
}