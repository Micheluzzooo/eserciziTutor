public class Triangolo extends Forma{
    int area = calcolaAreaTriangolo(2, 5);

    @Override
    public String toString() {
        return "Area triangolo = " + area;
    }
}
