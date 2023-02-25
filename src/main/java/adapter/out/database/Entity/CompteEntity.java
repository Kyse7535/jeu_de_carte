package adapter.out.database.Entity;

import adapter.in.DeckDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name="comptes")
public class CompteEntity {
    @Id
    public String pseudo;
    public int nombreJetons;
    @OneToOne(cascade= ALL)
    public DeckEntity deck;

    public CompteEntity(String pseudo, int nombreJetons, DeckEntity deck) {
        this.pseudo = pseudo;
        this.nombreJetons = nombreJetons;
        this.deck = deck;
    }

    public CompteEntity() {
    }

    @Override
    public String toString() {
        return "CompteEntity{" +
                "pseudo='" + pseudo + '\'' +
                ", nombre_jetons=" + nombreJetons +
                ", deck=" + deck +
                '}';
    }

}
