package application.services;

import src.server.database.Adapter.MysqlAdapter;
import src.domain.functional.DTOs.CreationCompteCommand;
import src.domain.functional.model.Compte;
import src.domain.functional.service.CreationCompteService;
import src.domain.functional.service.RechercheJoueursService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RechercheJoueursServiceTest {

    @InjectMocks
    private RechercheJoueursService rechercheJoueursService;

    @InjectMocks
    private CreationCompteService creationCompteService;

    @Mock
    private MysqlAdapter persistanceAdapter;


    @Test
    void recherche_liste_joueur() {
        Compte compte = creationCompteService.create(new CreationCompteCommand("test"));
        ArrayList<Compte> list = new ArrayList<>();
        list.add(compte);

        // WHEN
        when(persistanceAdapter.findAllPlayers()).thenReturn(list);
        List<Compte> comptes_result = rechercheJoueursService.rechercheListeJoueur();

        // ASSERT
        Assertions.assertTrue(comptes_result.contains(compte));
        verify(persistanceAdapter).findAllPlayers();
    }
}
