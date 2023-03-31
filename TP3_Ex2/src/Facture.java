import java.util.ArrayList;

public class Facture {
    private ArrayList<LigneFacture> lignes;
    private Stock stock;

    public Facture(Stock stock) {
        this.stock = stock;

        lignes = new ArrayList<>();
    }

    public boolean addLigne(int qt, String a) {
        boolean added = false;
        if (this.stock.verifArticle(a)) {
            if (this.stock.getQt(a) >= qt) {
                Article art = this.stock.getArticle(a);
                LigneFacture newLinge = new LigneFacture(1, qt, art);
                this.stock.changeQt(a, qt);
                this.lignes.add(newLinge);
                added = true;
            }
        }

            return added;
    }

    public boolean removeLigne(int id) {
        int size = lignes.size();
        if (id < size) return false;
        else {
            LigneFacture l = lignes.get(id - 1);
            int qt = l.getQt();
            stock.changeQt(l.getArticle().getNom(), qt);
            lignes.remove(id - 1);
            for (int i = id - 1; i < size - 1; i++)
                lignes.get(i).setId(i + 1);

            return true;
        }
    }

    public double getMontantTotal() {
        double result = 0;
        for (LigneFacture ligne : this.lignes) {
            result += ligne.getMontantTotal();
        }
        return result;
    }
}
