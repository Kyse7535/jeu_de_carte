package domain;

public class Combat {
    private final Heros attaquant;
    private final Heros adversaire;
    private boolean combat_en_cours = true;
    private Heros gagnant;


    public Combat(Heros attaquant, Heros adversaire) {
        this.attaquant = attaquant;
        this.adversaire = adversaire;
    }
    public void un_attaque() {
        float damage = 0;
        if(this.adversaire.getNiveau() < this.attaquant.getNiveau()) { throw new RuntimeException("Le niveau de l'adversaire est trop petit");}
        if(this.attaquant.getSpecialite() == Specialite.Tank && this.adversaire.getSpecialite() == Specialite.Mage) {
            damage = this.attaquant.getPuissance() + this.attaquant.getPuissance_supplementaire() - this.adversaire.getArmure() ;
        }
        else if(this.attaquant.getSpecialite() == Specialite.Assassin && this.adversaire.getSpecialite() == Specialite.Tank) {
            damage = this.attaquant.getPuissance() + this.attaquant.getPuissance_supplementaire() - this.adversaire.getArmure() ;
        }
        else if(this.attaquant.getSpecialite() == Specialite.Mage && this.adversaire.getSpecialite() == Specialite.Assassin) {
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
        if(this.adversaire.getSpecialite() == Specialite.Tank && this.attaquant.getSpecialite() == Specialite.Mage) {
            damage = this.adversaire.getPuissance() + this.adversaire.getPuissance_supplementaire() - this.attaquant.getArmure() ;
        }
        else if(this.adversaire.getSpecialite() == Specialite.Assassin && this.attaquant.getSpecialite() == Specialite.Tank) {
            damage = this.adversaire.getPuissance() + this.adversaire.getPuissance_supplementaire() - this.attaquant.getArmure() ;
        }
        else if(this.adversaire.getSpecialite() == Specialite.Mage && this.attaquant.getSpecialite() == Specialite.Assassin) {
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
        while(this.attaquant.getPoint_de_vie() > 0 && this.adversaire.getPoint_de_vie() > 0) {
            un_attaque();
            if(this.adversaire.getPoint_de_vie() <= 0) { break;}
            un_contre_attaque();
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

    @Override
    public String toString() {
        return "Combat{" +
                "attaquant=" + attaquant.getId() +
                ", adversaire=" + adversaire.getId() +
                ", combat_en_cours=" + combat_en_cours +
                ", gagnant=" + gagnant +
                '}';
    }
}
