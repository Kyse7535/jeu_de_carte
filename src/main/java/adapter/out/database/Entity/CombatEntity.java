package adapter.out.database.Entity;

import domain.Heros;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="combats")
public class CombatEntity {

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private int id;
    @OneToOne
    private HerosEntity attaquant;
    @OneToOne
    private  HerosEntity adversaire;
    private boolean combatEnCours = true;
    @OneToOne
    private HerosEntity gagnant;

    public CombatEntity(int id, HerosEntity attaquant, HerosEntity adversaire, boolean combatEnCours, HerosEntity gagnant) {
        this.id = id;
        this.attaquant = attaquant;
        this.adversaire = adversaire;
        this.combatEnCours = combatEnCours;
        this.gagnant = gagnant;
    }

    public CombatEntity(HerosEntity attaquant, HerosEntity adversaire) {
        this.attaquant = attaquant;
        this.adversaire = adversaire;
    }

    public CombatEntity() {}

    public int getId() {
        return id;
    }

    public HerosEntity getAttaquant() {
        return attaquant;
    }

    public HerosEntity getAdversaire() {
        return adversaire;
    }

    public boolean isCombatEnCours() {
        return combatEnCours;
    }

    public HerosEntity getGagnant() {
        return gagnant;
    }
}
