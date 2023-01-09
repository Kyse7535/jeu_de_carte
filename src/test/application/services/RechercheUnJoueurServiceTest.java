package application.services;

import adapter.out.PersistanceAdapter;
import application.port.in.DTOs.CreationCompteCommand;
import application.port.in.DTOs.RechercheUnJoueurCommand;
import domain.Compte;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RechercheUnJoueurServiceTest {

    @InjectMocks
    private RechercheUnJoueurService rechercheUnJoueurService;

    @InjectMocks
    private CreationCompteService creationCompteService;

    @Mock
    private PersistanceAdapter persistanceAdapter;

    @Test
    void recherche_un_joueur() {
        Compte compte = new Compte("test");

        // WHEN
        when(persistanceAdapter.load_compte(compte.getPseudo())).thenReturn(compte);
        Compte compte_result = rechercheUnJoueurService.recherche_un_joueur(new RechercheUnJoueurCommand(compte.getPseudo()));

        // ASSERT
        Assertions.assertEquals("test",compte_result.getPseudo());
        Mockito.verify(persistanceAdapter).load_compte(compte.getPseudo());
    }
}
