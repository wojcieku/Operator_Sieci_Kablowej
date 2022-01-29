package projekt_bdbt.Adres;

public class AdresExtended extends Adres{
    String kodPocztowy;
    String poczta;
    int nrPoczty;
    public AdresExtended() {

    }

    public AdresExtended(int nrAdresu, String miasto, String ulica, String nrDomu, String nrLokalu, int nrPoczty, String kodPocztowy, String poczta) {
        super(nrAdresu, miasto, ulica, nrDomu, nrLokalu);
        this.kodPocztowy = kodPocztowy;
        this.poczta = poczta;
        this.nrPoczty = nrPoczty;
    }
    public AdresExtended(int nrAdresu, String miasto, String ulica, String nrDomu, String nrLokalu) {
        super(nrAdresu, miasto, ulica, nrDomu, nrLokalu);
    }

    public int getNrPoczty() {
        return nrPoczty;
    }

    public void setNrPoczty(int nrPoczty) {
        this.nrPoczty = nrPoczty;
    }

    @Override
    public String toString() {
        return "AdresExtended{" +
                "kodPocztowy='" + kodPocztowy + '\'' +
                ", poczta='" + poczta + '\'' +
                '}';
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
