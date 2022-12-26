package application.services;

import application.port.in.DTOs.CreationHerosCommand;
import application.port.in.DTOs.OuverturePackCommand;
import application.port.in.UseCases.CreationHerosUseCase;
import application.port.in.UseCases.OuverturePackUseCase;
import application.port.out.HerosRepository;
import domain.Caracteristiques;
import domain.Heros;
import domain.Rarete;
import domain.Specialite;

import java.util.ArrayList;

public class OuverturePackService implements OuverturePackUseCase {
    private final CreationHerosUseCase creationHerosUseCase;
    private final HerosRepository repository;

    public OuverturePackService(CreationHerosUseCase creationHerosUseCase, HerosRepository repository) {
        this.creationHerosUseCase = creationHerosUseCase;
        this.repository = repository;
    }

    @Override
    public ArrayList<Heros> ouvre_pack(OuverturePackCommand ouverturePackCommand) {
        ArrayList<Heros> liste_cartes = new ArrayList<>();
        for(int i=0;i<ouverturePackCommand.getPack().nbr_cartes;i++) {
            Heros heros = creationHerosUseCase.create(new CreationHerosCommand(new Caracteristiques(Specialite.Tank, Rarete.Rare)));
            liste_cartes.add(heros);
            repository.save(heros);
        }
        return liste_cartes;
    }
}
