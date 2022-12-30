package application.services;

import adapter.out.PersistanceAdapter;
import application.port.in.DTOs.CreationHerosCommand;
import domain.Caracteristiques;
import domain.Heros;
import domain.Rarete;
import domain.Specialite;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CreationHerosServiceTest {

    @InjectMocks
    CreationHerosService creationHerosService;


    @Test
    public void create() {
        CreationHerosCommand creationHerosCommand = new CreationHerosCommand(new Caracteristiques(Specialite.Tank, Rarete.Commun));
        Heros heros = creationHerosService.create(creationHerosCommand);


        Assertions.assertEquals(heros.getCaracteristiques().getRarete(),Rarete.Commun);
        Assertions.assertNotEquals(heros.getCaracteristiques().getSpecialite(),Specialite.Mage);
        Assertions.assertEquals(heros.getCaracteristiques().getSpecialite(),Specialite.Tank);
        Assertions.assertEquals(heros.getArmure(),20);
        Assertions.assertEquals(heros.getNiveau(),1);
        Assertions.assertEquals(heros.getPoint_exp(),0);
        Assertions.assertEquals(heros.getPuissance(),100);
        Assertions.assertEquals(heros.getPoint_de_vie(),1000);
        Assertions.assertEquals(heros.getPoint_exp(),0);

    }
}