import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class Patient {
    private String nom;
    private ArrayList<String> ordonnance;

    public Patient(String nom) {
        this.nom = nom;
        this.ordonnance = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<String> getOrdonnance() {
        return ordonnance;
    }

    public void setOrdonnance(ArrayList<String> ordonnance) {
        this.ordonnance = ordonnance;
    }

    public boolean contientMedicament(String m) {
        return this.ordonnance.contains(m);
    }

    public void ajoutMedicament(String nomMed) {
        if (!this.contientMedicament(nomMed.toLowerCase())) {
            this.ordonnance.add(nomMed.toLowerCase());
        }
    }

    public void affiche() {
        System.out.println(this);
    }

    public void trieOrdonnance() {
        Collections.sort(this.ordonnance, new SortByName());
    }

    @Override
    public String toString() {

        String myStr = "";
        for (String ord : this.ordonnance) {
            myStr += ord + "\n";
        }
        return "Le Nom De Patient " + this.nom + " La Listes Des Ordonnances : \n" + myStr;

    }
}
