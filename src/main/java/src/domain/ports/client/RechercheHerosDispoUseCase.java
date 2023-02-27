package src.domain.ports.client;

import src.domain.functional.model.Heros;

import java.util.List;

public interface RechercheHerosDispoUseCase {
    List<Heros> rechercheListeHerosDispos();
}
