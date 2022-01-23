package bdbt_proj;

public class Umowa {
    private String nrUmowy;
    private String data;
    private String nrKlienta;

    public Umowa() {
    }

    public Umowa(String nrUmowy, String data, String nrKlienta) {
        this.nrUmowy = nrUmowy;
        this.data = data;
        this.nrKlienta = nrKlienta;
    }

    public String getNrUmowy() {
        return nrUmowy;
    }

    public void setNrUmowy(String nrUmowy) {
        this.nrUmowy = nrUmowy;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNrKlienta() {
        return nrKlienta;
    }

    public void setNrKlienta(String nrKlienta) {
        this.nrKlienta = nrKlienta;
    }

    @Override
    public String toString() {
        return "Umowa{" +
                "nrUmowy='" + nrUmowy + '\'' +
                ", data='" + data + '\'' +
                ", nrKlienta='" + nrKlienta + '\'' +
                '}';
    }
}
