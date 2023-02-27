package src.domain.ports.server;

import src.domain.functional.model.Compte;

import java.util.List;


public interface ComptePersistenceSpi {


    void save(Compte compte);
    Compte load_compte(String pseudo);
    void update(Compte compte);
    List<Compte> findAllPlayers();
}
