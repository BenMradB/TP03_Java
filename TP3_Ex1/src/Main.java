public class Main {
    public static void main(String[] args) {
        String pat1 = "Flen";
        String pat2 = "Allen";

        String ord1 = "Ord 1";
        String ord2 = "Brd 1";
        String ord3 = "Prd 1";
        String ord4 = "Ard 1";

        String[] ords1 = { ord1, ord2, ord3 };
        String[] ords2 = { ord2, ord3, ord4 };

        DossierPharmacie dp = new DossierPharmacie("Ph 1");

        dp.ajoutPatient(pat1, ords1);
        dp.ajoutPatient(pat2, ords2);
        dp.affiche();

    }
}
