package adapter.out.database.Entity;

import adapter.in.HerosDTO;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name="deck")
public class DeckEntity {

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    public String id;
    @OneToMany(cascade = ALL)
    public List<HerosEntity> listCartes = new ArrayList<>();

    public DeckEntity() {}



    public DeckEntity(ArrayList<HerosEntity> listCartes) {
        this.listCartes = listCartes;
    }

    @Override
    public String toString() {
        return "DeckEntity{" +
                "listCartes=" + listCartes +
                '}';
    }
}
