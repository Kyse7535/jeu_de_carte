package src.domain.functional.model;

public class Combat {

    private  Heros attaquant;
    private  Heros adversaire;
    private boolean combatEnCours = true;
    private Heros gagnant;


    public Combat(Heros attaquant, Heros adversaire) {
        this.attaquant = attaquant;
        this.adversaire = adversaire;
    }

    public void unAttaque() {
        float damage = 0;
        if(this.attaquant.getCaracteristiques().getSpecialite() == Specialite.Tank && this.adversaire.getCaracteristiques().getSpecialite() == Specialite.Mage) {
            damage = this.attaquant.getPuissance() + this.attaquant.getPuissanceSupplementaire() - this.adversaire.getArmure() ;
        }
        else if(this.attaquant.getCaracteristiques().getSpecialite() == Specialite.Assassin && this.adversaire.getCaracteristiques().getSpecialite() == Specialite.Tank) {
            damage = this.attaquant.getPuissance() + this.attaquant.getPuissanceSupplementaire() - this.adversaire.getArmure() ;
        }
        else if(this.attaquant.getCaracteristiques().getSpecialite() == Specialite.Mage && this.adversaire.getCaracteristiques().getSpecialite() == Specialite.Assassin) {
            damage = this.attaquant.getPuissance() + this.attaquant.getPuissanceSupplementaire() - this.adversaire.getArmure() ;
        }
        else {
            damage = this.attaquant.getPuissance() - this.adversaire.getArmure() ;
        }
        if (damage > 0) {
            this.adversaire.setPointDeVie(this.adversaire.getPointDeVie()-damage);
            this.adversaire.setArmure(0);
        }
        else {
            this.adversaire.setArmure(this.adversaire.getArmure() + damage);
        }
    }

    public void unContreAttaque() {
        float damage = 0;
        if(this.adversaire.getCaracteristiques().getSpecialite() == Specialite.Tank && this.attaquant.getCaracteristiques().getSpecialite() == Specialite.Mage) {
            damage = this.adversaire.getPuissance() + this.adversaire.getPuissanceSupplementaire() - this.attaquant.getArmure() ;
        }
        else if(this.adversaire.getCaracteristiques().getSpecialite() == Specialite.Assassin && this.attaquant.getCaracteristiques().getSpecialite() == Specialite.Tank) {
            damage = this.adversaire.getPuissance() + this.adversaire.getPuissanceSupplementaire() - this.attaquant.getArmure() ;
        }
        else if(this.adversaire.getCaracteristiques().getSpecialite() == Specialite.Mage && this.attaquant.getCaracteristiques().getSpecialite() == Specialite.Assassin) {
            damage = this.adversaire.getPuissance() + this.adversaire.getPuissanceSupplementaire() - this.attaquant.getArmure() ;
        }
        else {
            damage = this.adversaire.getPuissance() - this.attaquant.getArmure() ;
        }

        if (damage > 0) {
            this.attaquant.setPointDeVie(this.attaquant.getPointDeVie()-damage);
            this.attaquant.setArmure(0);
        }
        else {
            this.attaquant.setArmure(this.attaquant.getArmure() + damage);
        }
    }

    public void attaque() {
        if(this.adversaire.getNiveau() < this.attaquant.getNiveau()) { throw new RuntimeException("Le niveau de l'adversaire est trop petit");}
        while(this.attaquant.getPointDeVie() > 0 && this.adversaire.getPointDeVie() > 0) {
            unAttaque();
            if(this.adversaire.getPointDeVie() <= 0) {this.adversaire.setEnVie(false); break;}
            unContreAttaque();
            if(this.attaquant.getPointDeVie() <= 0) {this.attaquant.setEnVie(false); break;}
        }
        this.combatEnCours = false;
    }

    public Heros getGagnant() {
        if (!this.combatEnCours) {
            if(this.attaquant.getPointDeVie() <= 0)  {
                adversaire.gagnerUnCombat();
                this.gagnant = adversaire;
                return adversaire;
            }
            if(this.adversaire.getPointDeVie() <= 0) {
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

    public void combatHistory() {
        attaquant.combatHistory(this);
        adversaire.combatHistory(this);
    }



}
