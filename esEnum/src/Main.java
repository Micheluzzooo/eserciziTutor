public class Main {
    public static void main(String[] args) {
        Tipologia ret = Tipologia.rettangolo;
        Tipologia tria = Tipologia.triangolo;
        Rettangolo rettangolo = new Rettangolo();
        Triangolo triangolo = new Triangolo();
        System.out.println(tria + " " +  triangolo.calcolaArea(2, 3));
        System.out.println(ret + " " + rettangolo.calcolaArea(2, 3));

    }
}