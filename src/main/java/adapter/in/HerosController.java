package adapter.in;

import application.port.in.DTOs.CreationHerosCommand;
import application.port.in.UseCases.CreationHerosUseCase;
import domain.Rarete;
import domain.Specialite;

public class HerosController {
    private final CreationHerosUseCase creationHerosUseCase;

    public HerosController(CreationHerosUseCase creationHerosUseCase) {
        this.creationHerosUseCase = creationHerosUseCase;
    }

    public void create(String id, Specialite specialite, Rarete rarete) {
        creationHerosUseCase.create(new CreationHerosCommand(id,specialite,rarete));
    }
}
