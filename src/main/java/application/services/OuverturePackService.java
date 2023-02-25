package application.services;

import application.port.in.DTOs.CreationHerosCommand;
import application.port.in.DTOs.OuverturePackCommand;
import application.port.in.UseCases.CreationHerosUseCase;
import application.port.in.UseCases.OuverturePackUseCase;
import application.port.out.ComptePersistenceSpi;
import application.port.out.HerosPersistenceSpi;
import domain.*;

import java.util.ArrayList;
import java.util.Random;

public class OuverturePackService implements OuverturePackUseCase {
    private final CreationHerosUseCase creationHerosUseCase;
    private final HerosPersistenceSpi repository;
    private final ComptePersistenceSpi compteRepository;

    public OuverturePackService(CreationHerosUseCase creationHerosUseCase, HerosPersistenceSpi repository, ComptePersistenceSpi compteRepository) {
        this.creationHerosUseCase = creationHerosUseCase;
        this.repository = repository;
        this.compteRepository = compteRepository;
    }

    @Override
    public ArrayList<Heros> ouvrePack(OuverturePackCommand ouverturePackCommand) {
        if(ouverturePackCommand.getCompte().getNombreJetons() < ouverturePackCommand.getPack().getPrix()) {
            throw new RuntimeException("Le compte n'a pas suffisamment de jetons pour ouvrir un tel pack");
        }
        ArrayList<Heros> liste_cartes = new ArrayList<>();
        Compte compte = ouverturePackCommand.getCompte();
        compte.diminueNombre_jetons(ouverturePackCommand.getPack().getPrix());

        for(int i = 0; i<ouverturePackCommand.getPack().getNbrCartes(); i++) {

            Random r1 = new Random();
            int probability_rarete = r1.nextInt(100);

            if (probability_rarete < ouverturePackCommand.getPack().getProbabilites()[0]) {

                Heros heros = creationHerosUseCase.create(new CreationHerosCommand(new Caracteristiques(Specialite.random(), Rarete.Legandaire)));
                liste_cartes.add(heros);
                compte.getDeck().ajouteCarte(heros);
                repository.save(heros);

            } else if (probability_rarete < (ouverturePackCommand.getPack().getProbabilites()[0] + ouverturePackCommand.getPack().getProbabilites()[1])) {

                Heros heros = creationHerosUseCase.create(new CreationHerosCommand(new Caracteristiques(Specialite.random(), Rarete.Rare)));
                liste_cartes.add(heros);
                compte.getDeck().ajouteCarte(heros);
                repository.save(heros);

            } else {

                Heros heros = creationHerosUseCase.create(new CreationHerosCommand(new Caracteristiques(Specialite.random(), Rarete.Commun)));
                liste_cartes.add(heros);
                compte.getDeck().ajouteCarte(heros);
                repository.save(heros);
            }
        }
        compteRepository.update(compte);

        return liste_cartes;
    }

}


