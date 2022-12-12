package application.services;

import application.port.in.DTOs.CreationHerosCommand;
import application.port.in.DTOs.OuverturePackCommand;
import application.port.in.UseCases.OuverturePackUseCase;
import application.port.out.HerosRepository;
import domain.Heros;
import domain.Rarete;
import domain.Specialite;

import java.util.ArrayList;

public class OuverturePackService implements OuverturePackUseCase {
    private final CreationHerosService creationHerosService;
    private final HerosRepository repository;

    public OuverturePackService(CreationHerosService creationHerosService, HerosRepository repository) {
        this.creationHerosService = creationHerosService;
        this.repository = repository;
    }

    @Override
    public ArrayList<Heros> ouvre_pack(OuverturePackCommand ouverturePackCommand) {
        ArrayList<Heros> liste_cartes = new ArrayList<>();
        for(int i=0;i<ouverturePackCommand.getPack().nbr_cartes;i++) {
            Heros heros = creationHerosService.create(new CreationHerosCommand(Specialite.Tank, Rarete.Rare));
            liste_cartes.add(heros);
            repository.save(heros);
        }
        return liste_cartes;
    }
}
