public class Main {
    public static void main(String[] args) {
        Macchina macchina = new Macchina(2000, "ED1234FF", "Audi", "A1");
        System.out.println("Macchina: " + macchina.getCilindrata() + " " + macchina.getTarga() + " " + macchina.getMarca() + " " + macchina.getModello());
    }
}