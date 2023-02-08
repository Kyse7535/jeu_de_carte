package application.port.in.UseCases;

import application.port.in.DTOs.RechercheHerosCommand;
import domain.Heros;

public interface RechercheHerosUseCase {
    Heros rechercheHerosDispo(RechercheHerosCommand rechercheHerosCommand);
}
