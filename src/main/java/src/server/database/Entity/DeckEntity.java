package src.server.database.Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name="deck")
public class DeckEntity {

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    public String id;
    @OneToMany(cascade = ALL)
    public List<HerosEntity> listCartes;

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
