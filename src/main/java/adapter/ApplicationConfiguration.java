package adapter;


import application.port.in.UseCases.*;
import application.port.out.ComptePersistenceSpi;
import application.port.out.HerosPersistenceSpi;
import application.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

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
    public CreationHerosUseCase creationHerosUseCase(HerosPersistenceSpi spi) {
        return new CreationHerosService(spi);
    }
    @Bean
    public RechercheHerosUseCase rechercheHerosUseCase(HerosPersistenceSpi spi) {
        return new RechercheHerosService(spi);
    }

    /*


    @Bean
    public CombatUseCase combatUseCase(ComptePersistenceSpi spi) {
        return new CombatService(spi);
    }

    @Bean
    public OuverturePackUseCase ouverturePackUseCase(ComptePersistenceSpi spi) {
        return new OuverturePackService(creationHerosUseCase(),persistanceAdapter());
    }

    @Bean
    public RechercheHistoryHeroUseCase rechercheHistoryHeroUseCase(ComptePersistenceSpi spi) {
        return new RechercheHistoryHeroService(persistanceAdapter());
    }

    @Bean
    public RechercheUnJoueurUseCase rechercheUnJoueurUseCase(ComptePersistenceSpi spi) {
        return new RechercheUnJoueurService(spi);
    }

     */

}
