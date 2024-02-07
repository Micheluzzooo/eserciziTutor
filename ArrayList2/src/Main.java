import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Mario", 18));
        students.add(new Student("Alice", 19));
        students.add(new Student("Luca", 21));
        students.add(new Student("Sara", 24));
        students.add(new Student("Maria", 18));
        students.add(new Student("Ida", 28));
        students.add(new Student("Vita", 30));
        students.add(new Student("Giuseppe", 26));
        students.add(new Student("Antonio", 25));
        students.add(new Student("Marika", 28));
        students.add(new Student("Giovanni", 29));
        students.add(new Student("Daniele", 23));

        //ordine per età crescente
        students.sort(Comparator.comparing(Student::getAge));
        for (Student student : students) {
            System.out.println(("Nome: " + student.getName() + " Età: " + student.getAge()));
        }
        System.out.println("----------------------\n");

        //ordine per nome in ordine alfabetico
        students.sort(Comparator.comparing(Student::getName));
        for (Student student : students) {
            System.out.println(("Nome: " + student.getName() + " Età: " + student.getAge()));
        }

    }
}