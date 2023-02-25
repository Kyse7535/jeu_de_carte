package application.port.in.UseCases;

import application.port.in.DTOs.RechercheUnHerosCommand;
import domain.Heros;

public interface RechercheUnHerosUseCase {
    Heros rechercheHerosDispo(RechercheUnHerosCommand rechercheUnHerosCommand);
}
