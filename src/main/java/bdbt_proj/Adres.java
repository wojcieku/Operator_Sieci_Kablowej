package bdbt_proj;

public class Adres {
    private String nrAdresu;
    private String miasto;
    private String ulica;
    private String nrDomu;
    private String nrLokalu;
    private String nrPoczty = "1";

    public Adres() {
    }


    public Adres(String nrAdresu, String miasto, String ulica, String nrDomu, String nrLokalu, String nrPoczty) {
        this.nrAdresu = nrAdresu;
        this.miasto = miasto;
        this.ulica = ulica;
        this.nrDomu = nrDomu;
        this.nrLokalu = nrLokalu;
        this.nrPoczty = nrPoczty;
    }

    public void setNrAdresu(String nrAdresu) {
        this.nrAdresu = nrAdresu;
    }

    public void setNrDomu(String nrDomu) {
        this.nrDomu = nrDomu;
    }

    public void setNrLokalu(String nrLokalu) {
        this.nrLokalu = nrLokalu;
    }

    public void setNrPoczty(String nrPoczty) {
        this.nrPoczty = nrPoczty;
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

    public String getNrAdresu() {
        return nrAdresu;
    }

    public String getNrDomu() {
        return nrDomu;
    }

    public String getNrLokalu() {
        return nrLokalu;
    }

    public String getNrPoczty() {
        return nrPoczty;
    }

    @Override
    public String toString() {
        return "Adres{" +
                "Nr_adresu='" + nrAdresu + '\'' +
                ", Miasto='" + miasto + '\'' +
                ", Ulica='" + ulica + '\'' +
                ", Nr_domu='" + nrDomu + '\'' +
                ", Nr_lokalu='" + nrLokalu + '\'' +
                ", Nr_poczty='" + nrPoczty + '\'' +
                '}';
    }
}
