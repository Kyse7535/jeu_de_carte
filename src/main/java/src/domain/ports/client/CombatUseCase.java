package src.domain.ports.client;

import src.domain.functional.DTOs.CombatCommand;
import src.domain.functional.model.Combat;

public interface CombatUseCase {
    Combat attack(CombatCommand combatCommand);
}
