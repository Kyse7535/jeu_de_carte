package application.services;

import application.port.in.DTOs.CreationHerosCommand;
import application.port.in.UseCases.CreationHerosUseCase;
import application.port.out.HerosRepository;
import domain.Heros;

public class CreationHerosService implements CreationHerosUseCase {
    private final HerosRepository repository;

    public CreationHerosService(HerosRepository repository) {
        this.repository = repository;
    }

    @Override
    public Heros create(CreationHerosCommand creationHerosCommand) {
        Heros heros = new Heros(creationHerosCommand.getId(),creationHerosCommand.getSpecialite(),creationHerosCommand.getRarete());
        repository.save(heros);
        return heros;
    }
}
