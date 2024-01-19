public class Macchina {

    private int cilindrata;
    private String targa;
    private String marca;
    private String modello;

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

    public void setCilindrata(int cillindrata) {
        this.cilindrata = cilindrata;

    }

    public void setTarga(String targa) {
        this.targa = targa;

    }

    public void setModello(String modello) {
        this.modello = modello;

    }

    public void setMarca(String marca) {
        this.marca = marca;

    }

}