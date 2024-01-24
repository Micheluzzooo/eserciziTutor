public class Main {
    public static void main(String[] args) {

        Rettangolo rettangolo = new Rettangolo();
        Triangolo triangolo = new Triangolo();

        System.out.println("Area rettangolo: " + rettangolo.calcolaArea(2, 3));
        System.out.println("Area triangolo: " + triangolo.calcolaArea(2, 3));


    }
}