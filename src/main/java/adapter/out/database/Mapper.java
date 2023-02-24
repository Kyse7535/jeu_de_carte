package adapter.out.database;

import domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Mapper {


    public static Rarete rareteToDomain(RareteData rareteData) {
        Rarete rarete = Rarete.Rare;
        switch ((int) rareteData.getProcentage()) {
            case 0:
                rarete = Rarete.Commun;
                break;
            case 10:
                rarete = Rarete.Rare;
                break;
            case 20:
                rarete = Rarete.Legandaire;
                break;
        }
        return rarete;
    }

    public static Specialite specialiteToDomain(SpecialiteData specialiteData) {
        Specialite specialite = Specialite.Tank;
        switch (specialiteData.name()) {
            case "Tank":
                specialite = Specialite.Tank;
                break;
            case "Assassin":
                specialite = Specialite.Assassin;
                break;
            case "Mage":
                specialite = Specialite.Mage;
                break;
        }
        return specialite;
    }

    public static Caracteristiques caracteristiqueToDomain(CaracteristiquesData caracteristiquesData) {

        return new Caracteristiques(Mapper.specialiteToDomain(caracteristiquesData.getSpecialite())
                , rareteToDomain(caracteristiquesData.getRarete()));
    }

    public static ArrayList<Combat> listCombatDataToDomain(List<CombatData> combatDataList){
        return (ArrayList<Combat>) combatDataList.stream().map(combatData ->
                Mapper.combatdataToDomain(combatData)).collect(Collectors.toList());
    }

    public static Combat combatdataToDomain(CombatData combatData) {
        return  new Combat(Mapper.heroDatatoDomain(combatData.getAttaquant()),
                Mapper.heroDatatoDomain(combatData.getAdversaire()));
    }

    public static ArrayList<Heros> listHeroDataToDomain(List<HerosData> herosDataList){
        return (ArrayList<Heros>) herosDataList.stream().map(herosData ->
                Mapper.heroDatatoDomain(herosData)).collect(Collectors.toList());
    }
    public static Heros heroDatatoDomain(HerosData herosData) {
        return new Heros(
                herosData.getId(), Mapper.caracteristiqueToDomain(herosData.getCaracteristiques()), herosData.getNiveau(),
        herosData.getPointDeVie(), herosData.getPointExp(),herosData.getPuissance(), herosData.getArmure(),
        herosData.getPuissanceSupplementaire(), listCombatDataToDomain(herosData.getCombatHistory()), herosData.getEnVie()
        );
    }
    public static Deck deckDataToDomain(DeckData deckData) {
        return new Deck(listHeroDataToDomain(deckData.getListCartes()));
    }

    public static Pack packDataToDomain(PackData packData) {
        Pack pack = Pack.argent;
        switch (packData.getPrix()) {
            case 1:
                pack = Pack.argent;
                break;
            case 2:
                pack = Pack.diamant;
                break;
        }
        return pack;
    }

    public static Compte compteDataToDomain(CompteData compteData) {
        return new Compte(compteData.getPseudo(), compteData.getNombreJetons(),
                Mapper.deckDataToDomain(compteData.getDeck()));
    }



    public static RareteData rareteToData(Rarete rarete) {
        RareteData rareteData = RareteData.Rare;
        switch ((int) rarete.getProcentage()) {
            case 0:
                rareteData = RareteData.Commun;
                break;
            case 10:
                rareteData = RareteData.Rare;
                break;
            case 20:
                rareteData = RareteData.Legandaire;
                break;
        }
        return rareteData;
    }

    public static SpecialiteData specialiteToData(Specialite specialite) {
        SpecialiteData specialiteData = SpecialiteData.Tank;
        switch (specialite.name()) {
            case "Tank":
                specialiteData = SpecialiteData.Tank;
                break;
            case "Assassin":
                specialiteData = SpecialiteData.Assassin;
                break;
            case "Mage":
                specialiteData = SpecialiteData.Mage;
                break;
        }
        return specialiteData;
    }

    public static CaracteristiquesData caracteristiqueToData(Caracteristiques caracteristiques) {

        return new CaracteristiquesData(Mapper.specialiteToData(caracteristiques.getSpecialite())
                , Mapper.rareteToData(caracteristiques.getRarete()));
    }

    public static ArrayList<Compte> compteDataToDomain(ArrayList<CompteData> compteDataArrayList) {
        return (ArrayList<Compte>) compteDataArrayList.stream().map(compte ->
                Mapper.compteDataToDomain(compte)).collect(Collectors.toList());
    }

    public static ArrayList<CombatData> listCombatDataToData(List<Combat> combatList){
        return (ArrayList<CombatData>) combatList.stream().map(combat ->
                Mapper.combatToData(combat)).collect(Collectors.toList());
    }

    public static CombatData combatToData(Combat combat) {
        return  new CombatData(Mapper.HerotoData(combat.getAttaquant()),
                Mapper.HerotoData(combat.getAdversaire()));
    }

    public static ArrayList<HerosData> listHeroToData(List<Heros> herosList){
        return (ArrayList<HerosData>) herosList.stream().map(heros ->
                Mapper.HerotoData(heros)).collect(Collectors.toList());
    }
    public static HerosData HerotoData(Heros heros) {
        return new HerosData(
                heros.getId(), Mapper.caracteristiqueToData(heros.getCaracteristiques()), heros.getNiveau(),
                heros.getPointDeVie(), heros.getPointExp(),heros.getPuissance(), heros.getArmure(),
                heros.getPuissanceSupplementaire(), listCombatDataToData(heros.getCombatHistory()), heros.getEnVie()
        );
    }
    public static DeckData deckToData(Deck deck) {
        return new DeckData(listHeroToData(deck.getListCartes()));
    }

    public static PackData packToData(Pack pack) {
        PackData packdata = PackData.argent;
        switch (pack.getPrix()) {
            case 1:
                packdata = PackData.argent;
                break;
            case 2:
                packdata = PackData.diamant;
                break;
        }
        return packdata;
    }

    public static CompteData comptetoData(Compte compte) {
        return new CompteData(compte.getPseudo(), compte.getNombreJetons(),
                Mapper.deckToData(compte.getDeck()));
    }


}
