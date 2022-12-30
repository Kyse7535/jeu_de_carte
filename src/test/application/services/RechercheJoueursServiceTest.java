package application.services;

import adapter.out.PersistanceAdapter;
import application.port.in.DTOs.RechercheJoueursCommand;
import application.port.in.DTOs.RechercheUnJoueurCommand;
import domain.Compte;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RechercheJoueursServiceTest {

    @InjectMocks
    RechercheJoueursService rechercheJoueursService;

    @Mock
    PersistanceAdapter persistanceAdapter;

    @Test
    void recherche_liste_joueur() {
        //BEFORE
        Compte compte = new Compte("test");
        ArrayList<Compte> comptes = new ArrayList<>();
        comptes.add(compte);

        RechercheJoueursCommand rechercheUnJoueurCommand =  new RechercheJoueursCommand(persistanceAdapter);

        //WHEN
        when(persistanceAdapter.load_compte(compte.getPseudo())).thenReturn(compte);
        ArrayList<Compte> comptes_2 = rechercheJoueursService.recherche_liste_joueur(rechercheUnJoueurCommand);

        //THEN
        assertThat(comptes_2).contains(compte);
        verify(persistanceAdapter).load_compte(compte.getPseudo());
    }
}