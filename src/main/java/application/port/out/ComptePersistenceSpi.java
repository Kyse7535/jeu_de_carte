package application.port.out;

import domain.Compte;

import java.util.ArrayList;
import java.util.List;


public interface ComptePersistenceSpi {


    void save(Compte compte);
    Compte load_compte(String pseudo);
    void update(Compte compte);
    List<Compte> findAllPlayers();
}
