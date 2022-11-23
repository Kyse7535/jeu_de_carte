package application.services;

import application.port.in.DTOs.CreationHerosCommand;
import application.port.in.UseCases.CreationHerosUseCase;
import application.port.out.Repository;
import domain.Heros;

public class CreationHerosService implements CreationHerosUseCase {
    private final Repository<Heros> repository;

    public CreationHerosService(Repository<Heros> repository) {
        this.repository = repository;
    }

    @Override
    public void create(CreationHerosCommand creationHerosCommand) {
        Heros heros = new Heros(creationHerosCommand.getId(),creationHerosCommand.getSpecialite(),creationHerosCommand.getRarete());
        repository.save(heros);
    }
}
