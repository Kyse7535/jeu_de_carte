package src.domain.ports.client;

import src.domain.functional.DTOs.OuverturePackCommand;
import src.domain.functional.model.Heros;

import java.util.ArrayList;

public interface OuverturePackUseCase {
    ArrayList<Heros> ouvrePack(OuverturePackCommand ouverturePackCommand);
}
