package application.port.in.DTOs;

import application.port.out.CompteRepository;

public class RechercheJoueursCommand {
    private final CompteRepository repository;

    public RechercheJoueursCommand(CompteRepository repository) {
        this.repository = repository;
    }

    public CompteRepository getRepository() {
        return repository;
    }
}
