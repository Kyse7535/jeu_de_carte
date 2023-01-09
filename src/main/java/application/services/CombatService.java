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
        if (combat.getAdversaire().getNiveau() < combat.getAttaquant().getNiveau()) {
            throw new RuntimeException("le heros a le niveau trop petit");
        }
        else if (combat.getAdversaire().getEn_vie() == false || combat.getAttaquant().getEn_vie() == false) {
            throw new RuntimeException("un heros mort ne peut pas participer a un combat.");
        }
        else
        {
            combat.attaque();
            //combat.combat_history();
            repository.update(combatCommand.getCombat().getAttaquant());
            repository.update(combatCommand.getCombat().getAdversaire());
            return combat;
        }

    }
}
