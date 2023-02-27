package src.bootstrap;


import src.domain.functional.service.*;
import src.domain.ports.client.*;
import src.domain.ports.server.ComptePersistenceSpi;
import src.domain.ports.server.HerosPersistenceSpi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {


    @Bean
    public CreationCompteUseCase creationCompteUseCase(ComptePersistenceSpi spi) {
        return new CreationCompteService(spi);
    }

    @Bean
    public RechercheJoueursUseCase rechercheJoueursUseCase(ComptePersistenceSpi spi) {
        return new RechercheJoueursService(spi);
    }

    @Bean
    public RechercheHerosDispoUseCase rechercheHerosDispoUseCase(HerosPersistenceSpi spi) {
        return new RechercheHerosDisposService(spi);
    }

    @Bean
    public CreationHerosUseCase creationHerosUseCase(HerosPersistenceSpi spi) {
        return new CreationHerosService(spi);
    }

    @Bean
    public RechercheUnHerosUseCase rechercheHerosUseCase(HerosPersistenceSpi spi) {
        return new RechercheUnHerosService(spi);
    }

    @Bean
    public RechercheUnJoueurUseCase rechercheUnJoueurUseCase(ComptePersistenceSpi spi) {
        return new RechercheUnJoueurService(spi);
    }

    @Bean
    public CombatUseCase combatUseCase(HerosPersistenceSpi spi) {
        return new CombatService(spi);
    }

    @Bean
    public OuverturePackUseCase ouverturePackUseCase(HerosPersistenceSpi spi, ComptePersistenceSpi compte_spi) {
        return new OuverturePackService(creationHerosUseCase(spi),spi, compte_spi);
    }

    @Bean
    public RechercheHistoryHeroUseCase rechercheHistoryHeroUseCase(HerosPersistenceSpi spi) {
        return new RechercheHistoryHeroService(spi);
    }

}
