package adapter.out.database.Entity;

import domain.Rarete;
import domain.Specialite;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="caracteristiques")
public class CaracteristiquesEntity {
    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private SpecialiteEntity specialite;
    private RareteEntity rarete;

    public CaracteristiquesEntity(SpecialiteEntity specialite, RareteEntity rarete) {
        this.specialite = specialite;
        this.rarete = rarete;
    }

    public CaracteristiquesEntity() {
    }

    public String getId() {
        return id;
    }

    public SpecialiteEntity getSpecialite() {
        return specialite;
    }

    public RareteEntity getRarete() {
        return rarete;
    }
}
