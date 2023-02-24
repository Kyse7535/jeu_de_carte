package domain.services;

import adapter.out.PersistanceAdapter;
import application.port.in.DTOs.CreationHerosCommand;
import application.services.CreationHerosService;
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

@ExtendWith(MockitoExtension.class)
class CreationHerosServiceTest {

    @InjectMocks
    CreationHerosService creationHerosService;

    @Mock
    private PersistanceAdapter persistanceAdapter;

    @Test
    public void create() {
        CreationHerosCommand creationHerosCommand = new CreationHerosCommand(new Caracteristiques(Specialite.Tank, Rarete.Commun));
        Heros heros = creationHerosService.create(creationHerosCommand);
        Heros heros2 = creationHerosService.create(new CreationHerosCommand(new Caracteristiques(Specialite.Tank,Rarete.Legandaire)));
        Heros heros3 = creationHerosService.create(new CreationHerosCommand(new Caracteristiques(Specialite.Assassin,Rarete.Commun)));
        Heros heros4 = creationHerosService.create(new CreationHerosCommand(new Caracteristiques(Specialite.Assassin,Rarete.Legandaire)));
        Heros heros5 = creationHerosService.create(new CreationHerosCommand(new Caracteristiques(Specialite.Assassin,Rarete.Rare)));
        Heros heros6 = creationHerosService.create(new CreationHerosCommand(new Caracteristiques(Specialite.Mage,Rarete.Commun)));
        Heros heros7 = creationHerosService.create(new CreationHerosCommand(new Caracteristiques(Specialite.Mage,Rarete.Rare)));
        Heros heros8 = creationHerosService.create(new CreationHerosCommand(new Caracteristiques(Specialite.Mage,Rarete.Legandaire)));

        Assertions.assertEquals(heros8.getCaracteristiques().getRarete(),Rarete.Legandaire);
        Assertions.assertEquals(heros7.getCaracteristiques().getRarete(),Rarete.Rare);
        Assertions.assertEquals(heros6.getCaracteristiques().getRarete(),Rarete.Commun);
        Assertions.assertEquals(heros4.getCaracteristiques().getSpecialite(),Specialite.Assassin);
        Assertions.assertEquals(heros3.getCaracteristiques().getRarete(),Rarete.Commun);
        Assertions.assertEquals(heros5.getCaracteristiques().getRarete(),Rarete.Rare);
        Assertions.assertEquals(heros2.getCaracteristiques().getRarete(),Rarete.Legandaire);
        Assertions.assertEquals(heros.getCaracteristiques().getRarete(),Rarete.Commun);
        Assertions.assertNotEquals(heros.getCaracteristiques().getSpecialite(),Specialite.Mage);
        Assertions.assertEquals(heros.getCaracteristiques().getSpecialite(),Specialite.Tank);
        Assertions.assertEquals(heros.getArmure(),20);
        Assertions.assertEquals(heros.getNiveau(),1);
        Assertions.assertEquals(heros.getPointExp(),0);
        Assertions.assertEquals(heros.getPuissance(),100);
        Assertions.assertEquals(heros.getPointDeVie(),1000);
        Assertions.assertEquals(heros.getPointExp(),0);

    }
}
