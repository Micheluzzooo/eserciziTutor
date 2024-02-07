/*
    Creare una classe Student che accenti nel costruttore il parametro name (String) e age (Int)
    In questa classe avere i metodi pubblici per ottenere le informazioni.
    Creare un ArrayList con n elementi e stamparlo in console.
    Aggiungere 4 elementi alla collezione e stampare la collezione aggiornata in console

*/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Student s1 = new Student("Mario", 18);
        Student s2 = new Student("Luca", 25);
        Student s3 = new Student("Gianni", 28);
        Student s4 = new Student("Lucia", 23);
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);

        for (Student student : students) {
            System.out.println(("Nome: " + student.getName() + " Età: " + student.getAge()));
        }
    }

}