package application.port.in.DTOs;

import application.port.out.HerosRepository;

public class RechercheHerosCommand {
    public final String id;


    public RechercheHerosCommand(String id) {
        this.id = id;
    }


}
