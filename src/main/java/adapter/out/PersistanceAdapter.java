package adapter.out;

import application.port.out.Repository;

import java.util.ArrayList;

public class PersistanceAdapter implements Repository {


    @Override
    public void save(Object o) {
        // TO DO implementation BDD
    }

    @Override
    public Object load(String pseudo) {
        // TO DO implementation BDD
        return null;
    }

    @Override
    public void update(Object o) {
        // TO DO implementation BDD
    }

    @Override
    public ArrayList findAll() {
        return null;
    }


}
