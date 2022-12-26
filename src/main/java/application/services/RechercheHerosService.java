package application.services;

import application.port.in.DTOs.RechercheHerosCommand;
import application.port.in.UseCases.RechercheHerosUseCase;
import application.port.out.HerosRepository;
import domain.Heros;

import java.util.ArrayList;


public class RechercheHerosService implements RechercheHerosUseCase {
    private final HerosRepository repository;

    public RechercheHerosService(HerosRepository repository) {
        this.repository = repository;
    }

    @Override
    public Heros recherche_heros_dispo(RechercheHerosCommand rechercheHerosCommand) {
        return repository.load_heros(rechercheHerosCommand.id);
    }
}
