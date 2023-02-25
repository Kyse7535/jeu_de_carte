package domain.services;


import adapter.out.database.Adapter.MysqlAdapter;
import application.port.in.DTOs.CreationHerosCommand;
import application.port.in.DTOs.RechercheUnHerosCommand;
import application.services.CreationHerosService;
import application.services.RechercheUnHerosService;
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
    private RechercheUnHerosService rechercheHerosService;

    @InjectMocks
    private CreationHerosService creationHerosService;

    @Mock
    private MysqlAdapter persistanceAdapter;

    @Test
    void recherche_heros_dispo() {

        //
        Heros heros = creationHerosService.create(new CreationHerosCommand(new Caracteristiques(Specialite.Tank, Rarete.Rare)));;

        // WHEN
        when(persistanceAdapter.load_heros(heros.getId())).thenReturn(heros);
        Heros heros_result = rechercheHerosService.rechercheHerosDispo(new RechercheUnHerosCommand(heros.getId()));

        // ASSERT
        verify(persistanceAdapter).load_heros(heros.getId());
    }
}
