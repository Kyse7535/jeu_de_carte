package application.port.out;

import domain.Compte;
import domain.Heros;

import java.util.ArrayList;
import java.util.UUID;

public interface HerosRepository {
    void save(Heros heros);
    Heros load(UUID id);
    void update(Heros heros);
    ArrayList<Heros> findAllHeros();
}
