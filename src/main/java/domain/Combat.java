package domain;

public class Combat {
    private final Heros attaquant;
    private final Heros adversaire;
    private boolean combat_en_cours = true;


    public Combat(Heros attaquant, Heros adversaire) {
        this.attaquant = attaquant;
        this.adversaire = adversaire;
    }
    public void un_attaque() {
        float damage = this.attaquant.getPuissance() - this.adversaire.getArmure() ;
        if (damage > 0) {
            this.adversaire.setPoint_de_vie(this.adversaire.getPoint_de_vie()-damage);
        }
        else {
            this.adversaire.setArmure(this.adversaire.getArmure() + damage);
        }
    }

    public void un_contre_attaque() {
        float damage = this.adversaire.getPuissance() - this.attaquant.getArmure() ;
        if (damage > 0) {
            this.attaquant.setPoint_de_vie(this.attaquant.getPoint_de_vie()-damage);
        }
        else {
            this.attaquant.setArmure(this.attaquant.getArmure() + damage);
        }
    }

    public void attaque() {
        while(this.attaquant.getPoint_de_vie() > 0 && this.adversaire.getPoint_de_vie() > 0) {
            un_attaque();
            un_contre_attaque();
        }
        this.combat_en_cours = false;
    }

    public Heros getGagnant() {
        Heros gagnant = new Heros(null,null,null);
        if (this.combat_en_cours == false) {
            if(this.attaquant.getPoint_de_vie() <= 0)  { gagnant = adversaire; }
            if(this.adversaire.getPoint_de_vie() <= 0) { gagnant = attaquant; }
            return gagnant;
        }
        else throw new RuntimeException("Le combat n'est pas fini encore!");
    }

}
