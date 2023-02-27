package src.domain.functional.DTOs;

import src.domain.functional.model.Combat;

public class CombatCommand {
    private final Combat combat;


    public CombatCommand(Combat combat) {
        this.combat = combat;
    }

    public Combat getCombat() {
        return this.combat;
    }

}
