public class Main {
    public static void main(String[] args) {
        Macchina macchina = new Macchina(2000, "ED1234FF", "Audi", "A1");

        System.out.println("Macchina:");
        System.out.println("Cilindrata: " + macchina.getCilindrata());
        System.out.println("Targa: " + macchina.getTarga());
        System.out.println("Marca: " + macchina.getMarca());
        System.out.println("Modello: " + macchina.getModello());


    }
}