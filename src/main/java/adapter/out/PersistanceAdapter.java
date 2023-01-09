package adapter.out;

import application.port.out.CompteRepository;
import application.port.out.HerosRepository;
import domain.Compte;
import domain.Heros;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PersistanceAdapter implements CompteRepository, HerosRepository {
    private final Map<String, Compte> registryCompte = new HashMap<>();
    private final Map<String, Heros> registryHeros = new HashMap<>();

    @Override
    public void save(Compte compte) {
        registryCompte.put(compte.getPseudo(),compte);
    }

    @Override
    public Compte load_compte(String pseudo) {
        return registryCompte.get(pseudo);
    }

    @Override
    public void update(Compte compte) {

    }

    @Override
    public ArrayList<Compte> findAllPlayers() {
        ArrayList<Compte> list = new ArrayList<>(registryCompte.values());
        return list;
        }


    @Override
    public void save(Heros heros) {
        registryHeros.put(heros.getId(),heros);
    }

    @Override
    public Heros load_heros(String id) {
        return registryHeros.computeIfAbsent(id,
                key -> {
                    throw new RuntimeException("heros not found");
                });
    }

    @Override
    public void update(Heros heros) {
        registryHeros.put(heros.getId(),heros);
    }

    @Override
    public ArrayList<Heros> findAllHeros() {
        ArrayList<Heros> list = new ArrayList<>(registryHeros.values());
        return list;
    }
}
