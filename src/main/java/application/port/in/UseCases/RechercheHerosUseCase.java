package application.port.in.UseCases;

import application.port.in.DTOs.RechercheHerosCommand;
import domain.Heros;

import java.util.ArrayList;

public interface RechercheHerosUseCase {
    Heros recherche_heros_dispo(RechercheHerosCommand rechercheHerosCommand);
}
