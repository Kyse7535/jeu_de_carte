package src.domain.ports.client;

import src.domain.functional.DTOs.CreationCompteCommand;
import src.domain.functional.model.Compte;

public interface CreationCompteUseCase {
    Compte create(CreationCompteCommand creationCompteCommand);
}
