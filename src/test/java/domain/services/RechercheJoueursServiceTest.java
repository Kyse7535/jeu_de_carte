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

import java.util.ArrayList;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RechercheJoueursServiceTest {

    @InjectMocks
    private RechercheJoueursService rechercheJoueursService;

    @InjectMocks
    private CreationCompteService creationCompteService;

    @Mock
    private PersistanceAdapter persistanceAdapter;


    @Test
    void recherche_liste_joueur() {
        Compte compte = creationCompteService.create(new CreationCompteCommand("test"));
        ArrayList<Compte> list = new ArrayList<>();
        list.add(compte);

        // WHEN
        when(persistanceAdapter.findAllPlayers()).thenReturn(list);
        ArrayList<Compte> comptes_result = rechercheJoueursService.rechercheListeJoueur();

        // ASSERT
        Assertions.assertTrue(comptes_result.contains(compte));
        verify(persistanceAdapter).findAllPlayers();
    }
}