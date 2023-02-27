package src.domain.ports.client;

import src.domain.functional.DTOs.CreationHerosCommand;
import src.domain.functional.model.Heros;

public interface CreationHerosUseCase {
    Heros create(CreationHerosCommand creationHerosCommand);
}
