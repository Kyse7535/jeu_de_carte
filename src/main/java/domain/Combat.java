package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Combat {

    @JsonProperty
    private  Heros attaquant;
    @JsonProperty
    private  Heros adversaire;
    @JsonProperty
    private boolean combat_en_cours = true;
    @JsonProperty
    private Heros gagnant;


    public Combat(Heros attaquant, Heros adversaire) {
        this.attaquant = attaquant;
        this.adversaire = adversaire;
    }

    Combat() {}

    public void un_attaque() {
        float damage = 0;
        if(this.attaquant.getCaracteristiques().getSpecialite() == Specialite.Tank && this.adversaire.getCaracteristiques().getSpecialite() == Specialite.Mage) {
            damage = this.attaquant.getPuissance() + this.attaquant.getPuissance_supplementaire() - this.adversaire.getArmure() ;
        }
        else if(this.attaquant.getCaracteristiques().getSpecialite() == Specialite.Assassin && this.adversaire.getCaracteristiques().getSpecialite() == Specialite.Tank) {
            damage = this.attaquant.getPuissance() + this.attaquant.getPuissance_supplementaire() - this.adversaire.getArmure() ;
        }
        else if(this.attaquant.getCaracteristiques().getSpecialite() == Specialite.Mage && this.adversaire.getCaracteristiques().getSpecialite() == Specialite.Assassin) {
            damage = this.attaquant.getPuissance() + this.attaquant.getPuissance_supplementaire() - this.adversaire.getArmure() ;
        }
        else {
            damage = this.attaquant.getPuissance() - this.adversaire.getArmure() ;
        }
        if (damage > 0) {
            this.adversaire.setPoint_de_vie(this.adversaire.getPoint_de_vie()-damage);
            this.adversaire.setArmure(0);
        }
        else {
            this.adversaire.setArmure(this.adversaire.getArmure() + damage);
        }
    }

    public void un_contre_attaque() {
        float damage = 0;
        if(this.adversaire.getCaracteristiques().getSpecialite() == Specialite.Tank && this.attaquant.getCaracteristiques().getSpecialite() == Specialite.Mage) {
            damage = this.adversaire.getPuissance() + this.adversaire.getPuissance_supplementaire() - this.attaquant.getArmure() ;
        }
        else if(this.adversaire.getCaracteristiques().getSpecialite() == Specialite.Assassin && this.attaquant.getCaracteristiques().getSpecialite() == Specialite.Tank) {
            damage = this.adversaire.getPuissance() + this.adversaire.getPuissance_supplementaire() - this.attaquant.getArmure() ;
        }
        else if(this.adversaire.getCaracteristiques().getSpecialite() == Specialite.Mage && this.attaquant.getCaracteristiques().getSpecialite() == Specialite.Assassin) {
            damage = this.adversaire.getPuissance() + this.adversaire.getPuissance_supplementaire() - this.attaquant.getArmure() ;
        }
        else {
            damage = this.adversaire.getPuissance() - this.attaquant.getArmure() ;
        }

        if (damage > 0) {
            this.attaquant.setPoint_de_vie(this.attaquant.getPoint_de_vie()-damage);
            this.attaquant.setArmure(0);
        }
        else {
            this.attaquant.setArmure(this.attaquant.getArmure() + damage);
        }
    }

    public void attaque() {
        if(this.adversaire.getNiveau() < this.attaquant.getNiveau()) { throw new RuntimeException("Le niveau de l'adversaire est trop petit");}
        while(this.attaquant.getPoint_de_vie() > 0 && this.adversaire.getPoint_de_vie() > 0) {
            un_attaque();
            if(this.adversaire.getPoint_de_vie() <= 0) {this.adversaire.setEn_vie(false); break;}
            un_contre_attaque();
            if(this.attaquant.getPoint_de_vie() <= 0) {this.attaquant.setEn_vie(false); break;}
        }
        this.combat_en_cours = false;
    }

    public Heros getGagnant() {
        if (!this.combat_en_cours) {
            if(this.attaquant.getPoint_de_vie() <= 0)  {
                adversaire.gagnerUnCombat();
                this.gagnant = adversaire;
                return adversaire;
            }
            if(this.adversaire.getPoint_de_vie() <= 0) {
                attaquant.gagnerUnCombat();

            }
        }
        else throw new RuntimeException("Le combat n'est pas fini encore!");
        this.gagnant = attaquant;
        return attaquant;
    }

    public Heros getAttaquant() {
        return this.attaquant;
    }

    public Heros getAdversaire() {
        return this.adversaire;
    }

    public void combat_history() {
        attaquant.combat_history(this);
        adversaire.combat_history(this);
    }
}
