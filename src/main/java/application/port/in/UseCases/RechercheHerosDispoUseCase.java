package application.port.in.UseCases;

import domain.Compte;
import domain.Heros;

import java.util.List;

public interface RechercheHerosDispoUseCase {
    List<Heros> rechercheListeHerosDispos();
}
