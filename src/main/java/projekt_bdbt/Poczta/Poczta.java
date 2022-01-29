package projekt_bdbt.Poczta;

public class Poczta {
    int nrPoczty;
    String kodPocztowy;
    String poczta;
    public Poczta() {

    }
    public Poczta(int nrPoczty, String kodPocztowy, String poczta) {
        super();
        this.nrPoczty = nrPoczty;
        this.kodPocztowy = kodPocztowy;
        this.poczta = poczta;
    }

    @Override
    public String toString() {
        return "Poczta{" +
                "nrPoczty=" + nrPoczty +
                ", kodPocztowy='" + kodPocztowy + '\'' +
                ", poczta='" + poczta + '\'' +
                '}';
    }

    public int getNrPoczty() {
        return nrPoczty;
    }

    public void setNrPoczty(int nrPoczty) {
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
}
