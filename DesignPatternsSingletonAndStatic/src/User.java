public class User {

    public static User istance;

    private String nome;
    private int eta;

    private User() {

    }
    
    public static User getInstance() {
        if(istance == null) {
            istance = new User();
            istance.setNome("Mario");
            istance.setEta(33);
        }
        return istance;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    @Override
    public String toString() {
        return "User{" +
                "nome='" + nome + '\'' +
                ", eta=" + eta +
                '}';
    }
}
