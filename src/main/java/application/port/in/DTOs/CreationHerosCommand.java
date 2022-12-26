package application.port.in.DTOs;

import domain.Caracteristiques;
import domain.Rarete;
import domain.Specialite;

import java.util.UUID;

public class CreationHerosCommand {
    private final String id;
    private final Caracteristiques caracteristiques;

    public String getId() {
        return id;
    }

    public Caracteristiques getCaracteristiques() {
        return caracteristiques;
    }

    public CreationHerosCommand(Caracteristiques caracteristiques) {
        this.id = UUID.randomUUID().toString();
        this.caracteristiques = caracteristiques;
    }
}
