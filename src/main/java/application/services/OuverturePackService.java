package application.services;

import application.port.in.DTOs.CreationHerosCommand;
import application.port.in.DTOs.OuverturePackCommand;
import application.port.in.UseCases.CreationHerosUseCase;
import application.port.in.UseCases.OuverturePackUseCase;
import application.port.out.HerosRepository;
import domain.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class OuverturePackService implements OuverturePackUseCase {
    private final CreationHerosUseCase creationHerosUseCase;
    private final HerosRepository repository;

    public OuverturePackService(CreationHerosUseCase creationHerosUseCase, HerosRepository repository) {
        this.creationHerosUseCase = creationHerosUseCase;
        this.repository = repository;
    }

    @Override
    public ArrayList<Heros> ouvre_pack(OuverturePackCommand ouverturePackCommand) {
        if(ouverturePackCommand.getCompte().getNombre_jetons() < ouverturePackCommand.getPack().prix) {
            throw new RuntimeException("Le compte n'a pas suffisamment de jetons pour ouvrir un tel pack");
        }
        ArrayList<Heros> liste_cartes = new ArrayList<>();
        ouverturePackCommand.getCompte().diminueNombre_jetons(ouverturePackCommand.getPack().prix);

        for(int i=0;i<ouverturePackCommand.getPack().nbr_cartes;i++) {

            Random r1 = new Random();
            int probability_rarete = r1.nextInt(100);

            if (probability_rarete < ouverturePackCommand.getPack().getProbabilites()[0]) {

                Heros heros = creationHerosUseCase.create(new CreationHerosCommand(new Caracteristiques(Specialite.random(), Rarete.Legandaire)));
                liste_cartes.add(heros);
                repository.save(heros);

            } else if (probability_rarete < (ouverturePackCommand.getPack().getProbabilites()[0] + ouverturePackCommand.getPack().getProbabilites()[1])) {

                Heros heros = creationHerosUseCase.create(new CreationHerosCommand(new Caracteristiques(Specialite.random(), Rarete.Rare)));
                liste_cartes.add(heros);
                repository.save(heros);

            } else {

                Heros heros = creationHerosUseCase.create(new CreationHerosCommand(new Caracteristiques(Specialite.random(), Rarete.Commun)));
                liste_cartes.add(heros);
                repository.save(heros);
            }
        }

        return liste_cartes;
    }

}


