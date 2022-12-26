package application.port.in.UseCases;

import application.port.in.DTOs.RechercheUnJoueurCommand;
import domain.Compte;

public interface RechercheUnJoueurUseCase {
    Compte recherche_un_joueur(RechercheUnJoueurCommand rechercheUnJoueurCommand);
}
