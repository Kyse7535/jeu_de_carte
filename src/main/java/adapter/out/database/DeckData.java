package adapter.out.database;

import domain.Heros;

import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Embeddable
public class DeckData {

    @OneToMany
    private List<HerosData> listCartes;

    public DeckData() {
        this.listCartes = new ArrayList<>();
    }

    public DeckData(ArrayList<HerosData> listCartes) { this.listCartes = listCartes;}


    public List<HerosData> getListCartes() {
        return listCartes;
    }

    public void ajouteCarte(HerosData heros) {
        listCartes.add(heros);
    }

    @Override
    public String toString() {
        return "Deck{" +
                "listCartes=" + listCartes +
                '}';
    }
}
