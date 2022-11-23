package application.services;

import application.port.in.DTOs.RechercheHerosCommand;
import application.port.in.UseCases.RechercheHerosUseCase;
import application.port.out.Repository;
import domain.Heros;

import java.util.ArrayList;


public class RechercheHerosService implements RechercheHerosUseCase {
    private final Repository<Heros> repository;

    public RechercheHerosService(Repository<Heros> repository) {
        this.repository = repository;
    }

    @Override
    public ArrayList<Heros> recherche_heros_dispo(RechercheHerosCommand rechercheHerosCommand) {

        ArrayList<Heros> listHeros = repository.findAll();
        return listHeros;
    }

}
