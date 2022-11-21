package application.port.in.UseCases;

import application.port.in.DTOs.CreationCompteCommand;
import domain.Compte;

public interface CreationCompteUseCase {
    Compte creationCompte(CreationCompteCommand creationCompteCommand);
}
