package src.server.database.Entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name="heros")
public class HerosEntity {

    @Id
    public String id;
    @OneToOne(cascade = ALL)
    public CaracteristiquesEntity caracteristiques;
    public float niveau;
    public float pointDeVie;
    public float pointExp;
    public float puissance;
    public float armure;
    public float puissanceSupplementaire;
    @OneToMany(cascade=ALL)
    public List<CombatEntity> combatHistory;
    public boolean enVie;

    public HerosEntity(String id, CaracteristiquesEntity caracteristiques, float niveau,
                       float pointDeVie, float pointExp, float puissance, float armure,
                       float puissanceSupplementaire, List<CombatEntity> combatHistory, boolean enVie) {
        this.id = id;
        this.caracteristiques = caracteristiques;
        this.niveau = niveau;
        this.pointDeVie = pointDeVie;
        this.pointExp = pointExp;
        this.puissance = puissance;
        this.armure = armure;
        this.puissanceSupplementaire = puissanceSupplementaire;
        this.combatHistory = combatHistory;
        this.enVie = enVie;
    }
    public HerosEntity() {}

    @Override
    public String toString() {
        return "HerosEntity{" +
                "id='" + id + '\'' +
                ", caracteristiques=" + caracteristiques +
                ", niveau=" + niveau +
                ", pointDeVie=" + pointDeVie +
                ", pointExp=" + pointExp +
                ", puissance=" + puissance +
                ", armure=" + armure +
                ", puissanceSupplementaire=" + puissanceSupplementaire +
                ", combatHistory=" + combatHistory +
                ", enVie=" + enVie +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HerosEntity heros)) return false;
        return Float.compare(heros.niveau, niveau) == 0 && Float.compare(heros.pointDeVie, pointDeVie) == 0 && Float.compare(heros.pointExp, pointExp) == 0 && Float.compare(heros.puissance, puissance) == 0 && Float.compare(heros.armure, armure) == 0 && Float.compare(heros.puissanceSupplementaire, puissanceSupplementaire) == 0 && enVie == heros.enVie && id.equals(heros.id) && caracteristiques.equals(heros.caracteristiques) && combatHistory.equals(heros.combatHistory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, caracteristiques, niveau, pointDeVie, pointExp, puissance, armure, puissanceSupplementaire, combatHistory, enVie);
    }
}
