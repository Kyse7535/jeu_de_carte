package application.port.in.DTOs;

import domain.Combat;

public class CombatCommand {
    private final Combat combat;


    public CombatCommand(Combat combat) {
        this.combat = combat;
    }

    public Combat getCombat() {
        return this.combat;
    }

}
