package application.port.in.UseCases;

import application.port.in.DTOs.RechercheJoueursCommand;
import domain.Compte;
import java.util.ArrayList;


public interface RechercheJoueursUseCase {
    ArrayList<Compte> recherche_liste_joueur(RechercheJoueursCommand rechercheJoueursCommand);
}
