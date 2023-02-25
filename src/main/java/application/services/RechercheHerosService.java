package application.services;

import application.port.in.DTOs.RechercheHerosCommand;
import application.port.in.UseCases.RechercheHerosUseCase;
import application.port.out.HerosPersistenceSpi;
import domain.Heros;


public class RechercheHerosService implements RechercheHerosUseCase {
    private final HerosPersistenceSpi repository;

    public RechercheHerosService(HerosPersistenceSpi repository) {
        this.repository = repository;
    }

    @Override
    public Heros rechercheHerosDispo(RechercheHerosCommand rechercheHerosCommand) {
        return repository.load_heros(String.valueOf(rechercheHerosCommand.id));
    }
}
