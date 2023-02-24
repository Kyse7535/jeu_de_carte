package adapter.out.database;


import javax.persistence.*;

@Entity
public class CombatData {

    @ManyToOne
    @JoinColumn(name = "attacker_id")
    private HerosData attaquant;

    @ManyToOne
    @JoinColumn(name = "defender_id")
    private HerosData adversaire;
    private boolean combatEnCours = true;

    @ManyToOne
    @JoinColumn(name = "winner_id")
    private HerosData gagnant;
    @Id
    @GeneratedValue
    private Long id;


    public CombatData(HerosData attaquant, HerosData adversaire) {
        this.attaquant = attaquant;
        this.adversaire = adversaire;
    }

    public CombatData() {

    }

    public void unAttaque() {
        float damage = 0;
        if(this.attaquant.getCaracteristiques().getSpecialite() == SpecialiteData.Tank && this.adversaire.getCaracteristiques().getSpecialite() == SpecialiteData.Mage) {
            damage = this.attaquant.getPuissance() + this.attaquant.getPuissanceSupplementaire() - this.adversaire.getArmure() ;
        }
        else if(this.attaquant.getCaracteristiques().getSpecialite() == SpecialiteData.Assassin && this.adversaire.getCaracteristiques().getSpecialite() == SpecialiteData.Tank) {
            damage = this.attaquant.getPuissance() + this.attaquant.getPuissanceSupplementaire() - this.adversaire.getArmure() ;
        }
        else if(this.attaquant.getCaracteristiques().getSpecialite() == SpecialiteData.Mage && this.adversaire.getCaracteristiques().getSpecialite() == SpecialiteData.Assassin) {
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
        if(this.adversaire.getCaracteristiques().getSpecialite() == SpecialiteData.Tank && this.attaquant.getCaracteristiques().getSpecialite() == SpecialiteData.Mage) {
            damage = this.adversaire.getPuissance() + this.adversaire.getPuissanceSupplementaire() - this.attaquant.getArmure() ;
        }
        else if(this.adversaire.getCaracteristiques().getSpecialite() == SpecialiteData.Assassin && this.attaquant.getCaracteristiques().getSpecialite() == SpecialiteData.Tank) {
            damage = this.adversaire.getPuissance() + this.adversaire.getPuissanceSupplementaire() - this.attaquant.getArmure() ;
        }
        else if(this.adversaire.getCaracteristiques().getSpecialite() == SpecialiteData.Mage && this.attaquant.getCaracteristiques().getSpecialite() == SpecialiteData.Assassin) {
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

    public HerosData getGagnant() {
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

    public HerosData getAttaquant() {
        return this.attaquant;
    }

    public HerosData getAdversaire() {
        return this.adversaire;
    }

    public void combatHistory() {
        attaquant.combatHistory(this);
        adversaire.combatHistory(this);
    }

    public void setAdversaire(HerosData adversaire) {
        this.adversaire = adversaire;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
