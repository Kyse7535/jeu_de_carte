package application.port.in.UseCases;

import application.port.in.DTOs.RechercheHistoryHeroCommand;
import domain.Combat;

import java.util.ArrayList;

public interface RechercheHistoryHeroUseCase {
    ArrayList<Combat> combat_history(RechercheHistoryHeroCommand rechercheHistoryHeroCommand);
}
