package application.port.in.UseCases;

import application.port.in.DTOs.OuverturePackCommand;
import domain.Heros;

import java.util.ArrayList;

public interface OuverturePackUseCase {
    ArrayList<Heros> ouvrePack(OuverturePackCommand ouverturePackCommand);
}
