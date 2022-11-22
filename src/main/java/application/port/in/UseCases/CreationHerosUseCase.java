package application.port.in.UseCases;

import application.port.in.DTOs.CreationHerosCommand;

public interface CreationHerosUseCase {
    void create(CreationHerosCommand creationHerosCommand);
}
