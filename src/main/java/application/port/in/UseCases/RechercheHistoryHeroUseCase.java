package application.port.in.UseCases;

import application.port.in.DTOs.RechercheHistoryHeroCommand;
import domain.Combat;

import java.util.List;

public interface RechercheHistoryHeroUseCase {
    List<Combat> combatHistory(RechercheHistoryHeroCommand rechercheHistoryHeroCommand);
}
