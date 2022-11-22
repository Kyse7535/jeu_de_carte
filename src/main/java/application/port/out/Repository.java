package application.port.out;

public interface Repository<T> {
    void save(T t);
    T loadCompte(String pseudo);
    void update(T t);
}
