package bdbt_proj;

public class Adres {
    private String Nr_adresu;
    private String Miasto;
    private String Ulica;
    private String Nr_domu;
    private String Nr_lokalu;
    private String Nr_poczty = "1";

    public Adres() {
    }


    public Adres(String nr_adresu, String miasto, String ulica, String nr_domu, String nr_lokalu, String nr_poczty) {
        Nr_adresu = nr_adresu;
        Miasto = miasto;
        Ulica = ulica;
        Nr_domu = nr_domu;
        Nr_lokalu = nr_lokalu;
        Nr_poczty = nr_poczty;
    }

    public void setNr_adresu(String nr_adresu) {
        Nr_adresu = nr_adresu;
    }

    public void setNr_domu(String nr_domu) {
        Nr_domu = nr_domu;
    }

    public void setNr_lokalu(String nr_lokalu) {
        Nr_lokalu = nr_lokalu;
    }

    public void setNr_poczty(String nr_poczty) {
        Nr_poczty = nr_poczty;
    }


    public String getMiasto() {
        return Miasto;
    }

    public void setMiasto(String miasto) {
        Miasto = miasto;
    }

    public String getUlica() {
        return Ulica;
    }

    public void setUlica(String ulica) {
        Ulica = ulica;
    }

    public String getNr_adresu() {
        return Nr_adresu;
    }

    public String getNr_domu() {
        return Nr_domu;
    }

    public String getNr_lokalu() {
        return Nr_lokalu;
    }

    public String getNr_poczty() {
        return Nr_poczty;
    }

    @Override
    public String toString() {
        return "Adres{" +
                "Nr_adresu='" + Nr_adresu + '\'' +
                ", Miasto='" + Miasto + '\'' +
                ", Ulica='" + Ulica + '\'' +
                ", Nr_domu='" + Nr_domu + '\'' +
                ", Nr_lokalu='" + Nr_lokalu + '\'' +
                ", Nr_poczty='" + Nr_poczty + '\'' +
                '}';
    }
}
