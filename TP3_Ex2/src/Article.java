public class Article {
    private String nom;
    private double PU;


    public Article(String nom, double PU) {
        this.nom = nom;
        this.PU = PU;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPU() {
        return PU;
    }

    public void setPU(double PU) {
        this.PU = PU;
    }


    @Override
    public String toString() {
        return "Article{" +
                "nom='" + nom + '\'' +
                ", PU=" + PU +
                '}';
    }


}
