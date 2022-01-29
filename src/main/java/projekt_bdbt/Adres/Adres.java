package projekt_bdbt.Adres;

public class Adres {
    private int nrAdresu;
    private String miasto;
    private String ulica;
    private String nrDomu;
    private String nrLokalu;
    private int nrPoczty;
    public Adres() {

    }
    public Adres(int nrAdresu, String miasto, String ulica, String  nrDomu, String  nrLokalu) {
        super();
        this.nrAdresu = nrAdresu;
        this.miasto = miasto;
        this.ulica = ulica;
        this.nrDomu = nrDomu;
        this.nrLokalu = nrLokalu;
    }

    @Override
    public String toString() {
        return "Address{" +
                "nrAdresu=" + nrAdresu +
                ", miasto='" + miasto + '\'' +
                ", ulica='" + ulica + '\'' +
                ", nrDomu=" + nrDomu +
                ", nrLokalu=" + nrLokalu +
                '}';
    }

    public int getNrPoczty() {
        return nrPoczty;
    }

    public void setNrPoczty(int nrPoczty) {
        this.nrPoczty = nrPoczty;
    }

    public int getNrAdresu() {
        return nrAdresu;
    }

    public void setNrAdresu(int nrAdresu) {
        this.nrAdresu = nrAdresu;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNrDomu() {
        return nrDomu;
    }

    public void setNrDomu(String nrDomu) {
        this.nrDomu = nrDomu;
    }

    public String  getNrLokalu() {
        return nrLokalu;
    }

    public void setNrLokalu(String  nrLokalu) {
        this.nrLokalu = nrLokalu;
    }
}
