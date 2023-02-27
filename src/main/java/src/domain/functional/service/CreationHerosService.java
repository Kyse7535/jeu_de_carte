package src.domain.functional.service;

import src.domain.functional.DTOs.CreationHerosCommand;
import src.domain.ports.client.CreationHerosUseCase;
import src.domain.ports.server.HerosPersistenceSpi;
import src.domain.functional.model.Heros;
import src.domain.functional.model.Rarete;
import src.domain.functional.model.Specialite;

public class CreationHerosService implements CreationHerosUseCase {
    private final HerosPersistenceSpi repository;

    public CreationHerosService(HerosPersistenceSpi repository) {
        this.repository = repository;
    }

    @Override
    public Heros create(CreationHerosCommand creationHerosCommand) {
        Heros heros = new Heros();
        if(creationHerosCommand.getCaracteristiques().getSpecialite().equals(Specialite.Tank)) {
            if(creationHerosCommand.getCaracteristiques().getRarete().equals(Rarete.Commun)) {
                heros = Heros.newCommunTank(creationHerosCommand.getId());
            }
            if(creationHerosCommand.getCaracteristiques().getRarete().equals(Rarete.Rare)) {
                heros = Heros.newRareTank(creationHerosCommand.getId());
            }
            if(creationHerosCommand.getCaracteristiques().getRarete().equals(Rarete.Legandaire)) {
                heros = Heros.newLegendaryTank(creationHerosCommand.getId());
            }
        }
        if(creationHerosCommand.getCaracteristiques().getSpecialite().equals(Specialite.Assassin)) {
            if(creationHerosCommand.getCaracteristiques().getRarete().equals(Rarete.Commun)) {
                heros = Heros.newCommunAssassin(creationHerosCommand.getId());
            }
            if(creationHerosCommand.getCaracteristiques().getRarete().equals(Rarete.Rare)) {
                heros = Heros.newRareAssassin(creationHerosCommand.getId());
            }
            if(creationHerosCommand.getCaracteristiques().getRarete().equals(Rarete.Legandaire)) {
                heros = Heros.newLegendaryAssassin(creationHerosCommand.getId());
            }
        }
        if(creationHerosCommand.getCaracteristiques().getSpecialite().equals(Specialite.Mage)) {
            if(creationHerosCommand.getCaracteristiques().getRarete().equals(Rarete.Commun)) {
                heros = Heros.newCommunMage(creationHerosCommand.getId());
            }
            if(creationHerosCommand.getCaracteristiques().getRarete().equals(Rarete.Rare)) {
                heros = Heros.newRareMage(creationHerosCommand.getId());
            }
            if(creationHerosCommand.getCaracteristiques().getRarete().equals(Rarete.Legandaire)) {
                heros = Heros.newLegendaryMage(creationHerosCommand.getId());
            }
        }

        repository.save(heros);
        return heros;
    }
}
