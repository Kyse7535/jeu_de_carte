package src.domain.ports.client;

import src.domain.functional.DTOs.RechercheUnJoueurCommand;
import src.domain.functional.model.Compte;

public interface RechercheUnJoueurUseCase {
    Compte rechercheUnJoueur(RechercheUnJoueurCommand rechercheUnJoueurCommand);
}
