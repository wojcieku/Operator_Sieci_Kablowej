package projekt_bdbt.UmowaSzczegoly;

public class UmowaSzczegoly {
    private String nrOferty;
    private String nrUmowy;

    public UmowaSzczegoly() {
    }

    public UmowaSzczegoly(String nrOferty, String nrUmowy) {
        this.nrOferty = nrOferty;
        this.nrUmowy = nrUmowy;
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

    @Override
    public String toString() {
        return "UmowaSzczegoly{" +
                "nrOferty='" + nrOferty + '\'' +
                ", nrUmowy='" + nrUmowy + '\'' +
                '}';
    }
}
