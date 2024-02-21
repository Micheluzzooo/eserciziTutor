/*
    Crea una classe User che abbia i parametri privati nome ed età e i getter e setter
    All'interno di User ci sarà anche una funzione che stampi a video le informazioni di età e il nome.
    Creare 2 oggetti User di cui creerà un'istanza.
    Del primo si stamperanno le informazioni di default, del secondo si cambieranno le
    informazioni e poi si stamperanno a video

*/

public class Main {
    public static void main(String[] args) {
        User user = User.getInstance();
        User user2 = User.getInstance();

        System.out.println(user.getNome() + " " + user.getEta());

        user2.setNome("Luigi");
        user2.setEta(18);
        System.out.println(user2);
