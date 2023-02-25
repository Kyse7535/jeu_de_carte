package application.services;

import application.port.in.DTOs.CombatCommand;
import application.port.in.UseCases.CombatUseCase;
import application.port.out.HerosPersistenceSpi;
import domain.Combat;

public class CombatService implements CombatUseCase {
    private final HerosPersistenceSpi repository;

    public CombatService(HerosPersistenceSpi repository) {
        this.repository = repository;
    }

    @Override
    public Combat attack(CombatCommand combatCommand) {
        Combat combat = combatCommand.getCombat();
        if (combat.getAdversaire().getNiveau() < combat.getAttaquant().getNiveau()) {
            throw new RuntimeException("le heros a le niveau trop petit");
        }
        else if (combat.getAdversaire().getEnVie() == false || combat.getAttaquant().getEnVie() == false) {
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
