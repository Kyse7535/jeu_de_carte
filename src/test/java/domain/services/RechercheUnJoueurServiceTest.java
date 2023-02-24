package application.services;

import adapter.out.PersistanceAdapter;
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
    void recherche_un_joueur_vrai() {
        Compte compte = new Compte("test");

        // WHEN

        when(persistanceAdapter.load_compte(compte.getPseudo())).thenReturn(compte);
        Compte compte_result = rechercheUnJoueurService.rechercheUnJoueur(new RechercheUnJoueurCommand(compte.getPseudo()));

        // ASSERT
        Assertions.assertEquals("test",compte_result.getPseudo());
        Mockito.verify(persistanceAdapter).load_compte(compte.getPseudo());
    }

    @Test
    void recherche_un_joueur_faux() {
        when(persistanceAdapter.load_compte("test")).thenReturn(null);
        Assertions.assertThrows(RuntimeException.class, () -> rechercheUnJoueurService.rechercheUnJoueur(new RechercheUnJoueurCommand("test")));
    }
}