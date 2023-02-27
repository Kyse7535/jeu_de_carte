package src.domain.ports.server;

import src.domain.functional.model.Heros;

import java.util.List;

public interface HerosPersistenceSpi {
    void save(Heros heros);
    Heros load_heros(String id);
    void update(Heros heros);
    List<Heros> findAllHeros();
}
