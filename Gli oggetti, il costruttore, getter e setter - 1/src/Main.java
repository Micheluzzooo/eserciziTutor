public class Main {
    public static void main(String[] args) {

        Studente studente = new Studente("Mario", "Rossi", 65338);
        Studente studente2 = new Studente("Luca", "Bianchi", 64299);
        System.out.println(studente);
        System.out.println("Studente: " + studente2.getNome() + " " + studente2.getCognome() + " " + studente2.getId());
    }
}