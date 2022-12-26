package adapter;

import adapter.out.PersistanceAdapter;
import application.port.in.UseCases.*;
import application.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public PersistanceAdapter persistanceAdapter() {
        return new PersistanceAdapter();
    }

    @Bean
    public CreationCompteUseCase creationCompteUseCase() {
        return new CreationCompteService(persistanceAdapter());
    }

    @Bean
    public RechercheHerosUseCase rechercheHerosUseCase() {
        return new RechercheHerosService(persistanceAdapter());
    }

    @Bean
    public RechercheJoueursUseCase rechercheJoueursUseCase() {
        return new RechercheJoueursService(persistanceAdapter());
    }

    @Bean
    public CombatUseCase combatUseCase() {
        return new CombatService(persistanceAdapter());
    }

    @Bean
    public CreationHerosUseCase creationHerosUseCase() {
        return new CreationHerosService(persistanceAdapter());
    }


    @Bean
    public OuverturePackUseCase ouverturePackUseCase() {
        return new OuverturePackService(creationHerosUseCase(),persistanceAdapter());
    }

    @Bean
    public RechercheHistoryHeroUseCase rechercheHistoryHeroUseCase() {
        return new RechercheHistoryHeroService(persistanceAdapter());
    }

    @Bean
    public RechercheUnJoueurUseCase rechercheUnJoueurUseCase() {
        return new RechercheUnJoueurService(persistanceAdapter());
    }
}
