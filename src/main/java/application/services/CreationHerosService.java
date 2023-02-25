package application.services;

import application.port.in.DTOs.CreationHerosCommand;
import application.port.in.UseCases.CreationHerosUseCase;
import application.port.out.HerosPersistenceSpi;
import domain.Heros;
import domain.Rarete;
import domain.Specialite;

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
