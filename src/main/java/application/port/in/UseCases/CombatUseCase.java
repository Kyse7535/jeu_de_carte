package application.port.in.UseCases;

import application.port.in.DTOs.CombatCommand;
import domain.Combat;

public interface CombatUseCase {
    Combat attack(CombatCommand combatCommand);
}
