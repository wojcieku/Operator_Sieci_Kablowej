package projekt_bdbt.Umowa;

public class Umowa {
    private String nrUmowy;
    private String data;
    private String nrKlienta;
    private String nrOferty;
    private String imieNazwisko;

    public Umowa() {
    }

    public Umowa(String nrUmowy, String data, String nrKlienta, String nrOferty, String imieNazwisko) {
        this.nrUmowy = nrUmowy;
        this.data = data;
        this.nrKlienta = nrKlienta;
        this.nrOferty = nrOferty;
        this.imieNazwisko = imieNazwisko;
    }

    public String getNrOferty() {
        return nrOferty;
    }

    public void setNrOferty(String nrOferty) {
        this.nrOferty = nrOferty;
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

    public String getImieNazwisko() {
        return imieNazwisko;
    }

    public void setImieNazwisko(String imieNazwisko) {
        this.imieNazwisko = imieNazwisko;
    }

    @Override
    public String toString() {
        return "Umowa{" +
                "nrUmowy='" + nrUmowy + '\'' +
                ", data='" + data + '\'' +
                ", nrKlienta='" + nrKlienta + '\'' +
                ", nrOferty='" + nrOferty + '\'' +
                ", imieNazwisko='" + imieNazwisko + '\'' +
                '}';
    }
}
