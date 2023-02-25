package adapter.out.database.Entity;

import domain.Caracteristiques;
import domain.Combat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

}
