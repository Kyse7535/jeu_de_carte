package application.port.in.DTOs;

import domain.Rarete;
import domain.Specialite;

import java.util.UUID;

public class CreationHerosCommand {
    private final String id;
    private final Specialite specialite;
    private final Rarete rarete;

    public String getId() {
        return id;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public Rarete getRarete() {
        return rarete;
    }

    public CreationHerosCommand(Specialite specialite, Rarete rarete) {
        this.id = UUID.randomUUID().toString();
        this.specialite = specialite;
        this.rarete = rarete;
    }
}
