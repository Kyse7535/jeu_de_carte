package application.port.out;

import domain.Compte;

import java.util.ArrayList;

public interface CompteRepository {


    void save(Compte compte);
    Compte load_compte(String pseudo);
    void update(Compte compte);
    ArrayList<Compte> findAllPlayers();
}
