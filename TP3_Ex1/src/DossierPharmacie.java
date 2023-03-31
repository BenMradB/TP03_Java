import java.util.*;

public class DossierPharmacie {
    private String nomPharmacie;
    private HashMap<String, Patient> patients;

    DossierPharmacie(String nomPh) {
        this.nomPharmacie = nomPh;
        this.patients = new HashMap<>();
    }


    public String getNomPharmacie() {
        return nomPharmacie;
    }

    public void setNomPharmacie(String nomPharmacie) {
        this.nomPharmacie = nomPharmacie;
    }

    public HashMap<String, Patient> getPatients() {
        return patients;
    }

    public void setPatients(HashMap<String, Patient> patients) {
        this.patients = patients;
    }

    public void ajoutPatient(String nom, String[] ords) {
        Patient p = new Patient(nom);
        for (String ord : ords) {
            p.ajoutMedicament(ord);
        }

        if (!this.patients.containsKey(nom.toLowerCase())) {
            this.patients.put(nom.toLowerCase(), p);
        }
    }

    public boolean ajoutMedicament(String nomP, String nomMed) {
        if (this.patients.containsKey(nomP)) {
            Patient p = this.patients.get(nomP);
            p.ajoutMedicament(nomMed);
            return true;
        } else {
            return false;
        }

    }

    public void affichePatient(String nomP) {
        Patient p = this.patients.get(nomP);
        p.affiche();
    }

    public void affiche() {
        TreeMap<String, Patient> patientTreeMap = new TreeMap<String, Patient>(this.patients);
        for(Map.Entry<String, Patient> entry : patientTreeMap.entrySet()) {
            entry.getValue().trieOrdonnance();
        }
        System.out.println(patientTreeMap);
    }
}
