import com.sun.org.apache.bcel.internal.generic.RETURN;

public class Macchina {

    private final int cilindrata;
    private final String targa;
    private final String marca;
    private final String modello;

    public Macchina(int cilindrata, String targa, String marca, String modello) {
        this.cilindrata = cilindrata;
        this.targa = targa;
        this.marca = marca;
        this.modello = modello;
    }

    public int getCilindrata() {
        return cilindrata;
    }

    public String getTarga() {
        return targa;
    }

    public String getModello() {
        return modello;
    }

    public String getMarca() {
        return marca;
    }

    @Override
    public String toString() {
        return "Macchina: " +
                "cilindrata = " + cilindrata +
                ", targa = " + targa +
                ", marca =" + marca +
                ", modello = " + modello;
    }
}
