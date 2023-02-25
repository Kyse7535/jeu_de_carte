package application.port.out;

import domain.Heros;

import java.util.ArrayList;
import java.util.List;

public interface HerosPersistenceSpi {
    void save(Heros heros);
    Heros load_heros(String id);
    void update(Heros heros);
    List<Heros> findAllHeros();
}
