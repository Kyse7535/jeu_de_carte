package adapter.out.database;

public enum PackData {
    argent(1, 3, new int[]{5, 20, 75}),
    diamant(2, 5, new int[]{15,35,5});


    private int prix;
    private int nbrCartes;
    private int[] probabilites = {};

    private PackData(int prix, int nbrCartes, int[] probabilites) {
        this.prix = prix;
        this.nbrCartes = nbrCartes;
        this.probabilites = probabilites;
    }

    public int[] getProbabilites() {
        return probabilites;
    }

    public int getPrix() {
        return prix;
    }

    public int getNbrCartes() {
        return nbrCartes;
    }
}
