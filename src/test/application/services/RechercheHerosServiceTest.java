package application.services;

import adapter.out.PersistanceAdapter;
import application.port.in.DTOs.CreationHerosCommand;
import application.port.in.DTOs.RechercheHerosCommand;
import domain.Caracteristiques;
import domain.Heros;
import domain.Rarete;
import domain.Specialite;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RechercheHerosServiceTest {

    @InjectMocks
    private RechercheHerosService rechercheHerosService;

    @InjectMocks
    private CreationHerosService creationHerosService;

    @Mock
    private PersistanceAdapter persistanceAdapter;

    @Test
    void recherche_heros_dispo() {

        //
        Heros heros = creationHerosService.create(new CreationHerosCommand(new Caracteristiques(Specialite.Tank, Rarete.Rare)));;

        // WHEN
        when(persistanceAdapter.load_heros(heros.getId())).thenReturn(heros);
        Heros heros_result = rechercheHerosService.recherche_heros_dispo(new RechercheHerosCommand(heros.getId()));

        // ASSERT
        verify(persistanceAdapter).load_heros(heros.getId());
    }
}
