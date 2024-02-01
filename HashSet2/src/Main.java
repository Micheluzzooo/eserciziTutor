/*
    Scrivere una funzione che restituisca un HashSet riempito
    Creare un oggetto dello stesso tipo inserito nell'HashSet e popolarlo
    Verificare che l' elemento sia parte del Set  e stampare il risultato
    .contains(), .add(),

*/
import java.util.*;
public class Main {
    public static void main(String[] args) {

        String car1 = "Tesla";
        System.out.println(cars().contains(car1));
        if(cars().contains(car1)) {
            System.out.println("Auto contenuta: " + car1);
        } else {
            System.out.println("Auto non presente");
        }

    }

    public static HashSet<String> cars() {
        HashSet<String> cars = new HashSet<>();
        cars.add("Audi");
        cars.add("BMW");
        cars.add("VW");
        cars.add("Opel");
        cars.add("Fiat");
        cars.add("Mercedes");
        return cars;
    }
}