import java.util.LinkedList;

/*
    Creare una classe Fruit che accenti nel costruttore il parametro name (String)
    In questa classe avere i metodi pubblici per ottenere le informazioni.
    Creare un LinkedList con elementi e stamparlo in console.
    Aggiungere un elemento al primo posto della lista e uno all'ultimo
    Stampare la collezione aggiornata
*/
public class Main {
    public static void main(String[] args) {
        LinkedList<Fruit> fruits = new LinkedList<>();
        fruits.add(new Fruit("Apple"));
        fruits.add(new Fruit("Kiwi"));
        fruits.add(new Fruit("Orange"));

        for(Fruit fruit : fruits) {
            System.out.println(fruit.getName());
        }

        System.out.println("\n-----------------\n");

        fruits.addFirst(new Fruit("Strawberry"));
        fruits.addLast(new Fruit("Coconut"));
        for(Fruit fruit : fruits) {
            System.out.println(fruit.getName());
        }
    }
}