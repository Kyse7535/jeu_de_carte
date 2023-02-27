package src.domain.ports.client;

import src.domain.functional.DTOs.RechercheUnHerosCommand;
import src.domain.functional.model.Heros;

public interface RechercheUnHerosUseCase {
    Heros rechercheHerosDispo(RechercheUnHerosCommand rechercheUnHerosCommand);
}
