package src.domain.ports.client;

import src.domain.functional.DTOs.RechercheHistoryHeroCommand;
import src.domain.functional.model.Combat;

import java.util.List;

public interface RechercheHistoryHeroUseCase {
    List<Combat> combatHistory(RechercheHistoryHeroCommand rechercheHistoryHeroCommand);
}
