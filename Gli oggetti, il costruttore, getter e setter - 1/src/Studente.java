public class Studente {

    private final String nome;
    private final String cognome;
    private final int id;

    public Studente(String nome, String cognome, int id) {
        this.nome = nome;
        this.cognome = cognome;
        this.id = id;
    }
     public String getNome() {
        return nome;
     }

    public String getCognome() {
        return cognome;
    }

    public int getId() {
        return id;
    }



    @Override
    public String toString() {
        return "Studente: " + "nome = " + nome + ", cognome = " + cognome + ", id = " + id;
    }
}
