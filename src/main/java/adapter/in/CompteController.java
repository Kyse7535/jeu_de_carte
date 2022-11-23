package adapter.in;

import application.port.in.DTOs.CreationHerosCommand;
import application.port.in.DTOs.RechercheHerosCommand;
import application.port.in.UseCases.CreationHerosUseCase;
import application.port.in.UseCases.RechercheHerosUseCase;
import domain.Compte;
import domain.Heros;
import domain.Rarete;
import domain.Specialite;

import java.util.ArrayList;

public class HerosController {
    private final CreationHerosUseCase creationHerosUseCase;
    private final RechercheHerosUseCase rechercheHerosUseCase;

    public HerosController(CreationHerosUseCase creationHerosUseCase, RechercheHerosUseCase rechercheHerosUseCase) {
        this.creationHerosUseCase = creationHerosUseCase;
        this.rechercheHerosUseCase = rechercheHerosUseCase;
    }

    public void create(Specialite specialite, Rarete rarete) {
        creationHerosUseCase.create(new CreationHerosCommand(specialite,rarete));
    }

    public ArrayList<Heros> recherche(Compte compte) {
        return rechercheHerosUseCase.recherche_heros_dispo(new RechercheHerosCommand(compte));
    }
}
