package bdbt_proj;

public class Poczta {
    private String nrPoczty;
    private String kodPocztowy;
    private String poczta;

    public Poczta() {
    }

    public Poczta(String nrPoczty, String kodPocztowy, String poczta) {
        this.nrPoczty = nrPoczty;
        this.kodPocztowy = kodPocztowy;
        this.poczta = poczta;
    }

    public String getNrPoczty() {
        return nrPoczty;
    }

    public void setNrPoczty(String nrPoczty) {
        this.nrPoczty = nrPoczty;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public String getPoczta() {
        return poczta;
    }

    public void setPoczta(String poczta) {
        this.poczta = poczta;
    }

    @Override
    public String toString() {
        return "Poczta{" +
                "nrPoczty='" + nrPoczty + '\'' +
                ", kodPocztowy='" + kodPocztowy + '\'' +
                ", poczta='" + poczta + '\'' +
                '}';
    }
}
