package application.port.out;

import domain.Compte;

public interface CompteRepository {
    void save(Compte compte);
    Compte loadCompte(String pseudo);
    void update(Compte compte);
}
