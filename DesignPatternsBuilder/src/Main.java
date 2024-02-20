/*
    Crea una classe Person con i campi firstName, lastName, age e address, i getter and i setter
    Il costruttore accetterà un Builder in input
    Creare una classe Builder che attraverso il costruttore e dei metodi specifici
    (tranne nome e cognome, gli altri campi sono opzionali) per costruire l'oggetto Person.
    Creare due oggetti Person e stamparli a video

*/
public class Main {
    public static void main(String[] args) {
        Builder builder1 = new Builder().setFirstName("Michele").setLastName("Sapo").setAge(25).setAddress("via roma 16");
        Builder builder2 = new Builder().setFirstName("Mario").setLastName("Rossi").setAge(44).setAddress("via lazio 156");
        Person persona1 = builder1.build();
        Person persona2 = builder2.build();
        System.out.println(persona1);
        System.out.println(persona2);
    }
}