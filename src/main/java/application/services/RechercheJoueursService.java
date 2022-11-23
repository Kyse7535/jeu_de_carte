package application.services;

import application.port.in.DTOs.RechercheHerosCommand;
import application.port.in.DTOs.RechercheJoueursCommand;
import application.port.in.UseCases.RechercheJoueursUseCase;
import application.port.out.Repository;
import domain.Compte;
import domain.Deck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RechercheJoueursService implements RechercheJoueursUseCase {
    private final Repository<Compte> repository;

    public RechercheJoueursService(Repository<Compte> repository) {
        this.repository = repository;
    }

    @Override
    public Map<Compte, Deck> recherche_liste_joueur(RechercheJoueursCommand rechercheJoueursCommandd) {

        ArrayList<Compte> listJoueurs = repository.findAll();
        Map<Compte, Deck> listJoueursAvecHeros = new HashMap<>();

        Iterator<Compte> it = listJoueurs.iterator();
        while(it.hasNext()) {
            Deck listHeros = it.next().getDeck();
            listJoueursAvecHeros.put(it.next(), listHeros);
        }
        return listJoueursAvecHeros;
    }


}
