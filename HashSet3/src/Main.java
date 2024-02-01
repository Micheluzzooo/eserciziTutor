import java.util.HashSet;
import java.util.Iterator;

/*
    Scrivere una funzione che restituisca un hashset riempito
    Creare un oggeto dello stesso tipo inserito nell'HashSet e popolarlo
    Scorrere il set, per ogni elemento verificare se è uguale all'oggetto creato ed eliminarlo
    Svuotare l'hashset, verificarlo e stampare il risultato

*/
public class Main {
    public static void main(String[] args) {

        HashSet<String> carSet = cars();
        String car = "Audi";
        for(int i = 0; i < cars().size(); i++) {
            if(carSet.contains(car)) {
                carSet.remove(car);
            }
        }
        System.out.println(carSet);
        carSet.clear();
        System.out.println(carSet);

        HashSet carSet2 = cars();
        String car1 = "Opel";
        Iterator<String> iterator =  carSet2.iterator();
        while(iterator.hasNext()) {
            String element = iterator.next();
            //System.out.println(element);
            if(element.equals(car1)) {
                carSet2.remove(car1);
            }
        }
        System.out.println(carSet2);
        carSet2.clear();
        System.out.println(carSet2);
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
