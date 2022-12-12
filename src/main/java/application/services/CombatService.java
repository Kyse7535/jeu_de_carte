package application.services;

import application.port.in.DTOs.CombatCommand;
import application.port.in.UseCases.CombatUseCase;
import application.port.out.HerosRepository;
import domain.Combat;

public class CombatService implements CombatUseCase {
    private final HerosRepository repository;

    public CombatService(HerosRepository repository) {
        this.repository = repository;
    }

    @Override
    public Combat attack(CombatCommand combatCommand) {
        Combat combat = combatCommand.getCombat();
        combat.attaque();
        combat.combat_history();
        combat.getGagnant();
        repository.update(combatCommand.getCombat().getAttaquant());
        repository.update(combatCommand.getCombat().getAdversaire());
        return combat;
    }
}
