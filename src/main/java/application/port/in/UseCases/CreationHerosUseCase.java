package application.port.in.UseCases;

import application.port.in.DTOs.CreationHerosCommand;
import domain.Heros;

public interface CreationHerosUseCase {
    Heros create(CreationHerosCommand creationHerosCommand);
}
