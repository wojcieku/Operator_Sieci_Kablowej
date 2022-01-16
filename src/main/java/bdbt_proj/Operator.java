package bdbt_proj;

public class Operator {
    private String Nr_operatora;
    private String Nazwa;
    private String Data_zalozenia;
    private String Nr_adresu;
    private String adres;

    public Operator() {
    }

    public Operator(String nr_operatora, String nazwa, String data_zalozenia, String nr_adresu, String adres) {
        Nr_operatora = nr_operatora;
        Nazwa = nazwa;
        Data_zalozenia = data_zalozenia;
        Nr_adresu = nr_adresu;
        this.adres = adres;
    }


    //    public int getNr_operatora() {
//        return Nr_operatora;
//    }
//
//    public void setNr_operatora(int nr_operatora) {
//        Nr_operatora = nr_operatora;
//    }

    public String getNazwa() {
        return Nazwa;
    }

    public void setNazwa(String nazwa) {
        Nazwa = nazwa;
    }

    public String getNr_operatora() {
        return Nr_operatora;
    }

    public void setNr_operatora(String nr_operatora) {
        Nr_operatora = nr_operatora;
    }

    public String getNr_adresu() {
        return Nr_adresu;
    }

    public void setNr_adresu(String nr_adresu) {
        Nr_adresu = nr_adresu;
    }

    public String getData_zalozenia() {
        return Data_zalozenia;
    }

    public void setData_zalozenia(String data_zalozenia) {
        Data_zalozenia = data_zalozenia;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

//    public int getNr_adresu() {
//        return Nr_adresu;
//    }
//
//    public void setNr_adresu(int nr_adresu) {
//        Nr_adresu = nr_adresu;
//    }

    @Override
    public String toString() {
        return "Operator{" +
                "Nr_operatora=" + Nr_operatora +
                ", Nazwa='" + Nazwa + '\'' +
                ", Data_zalozenia='" + Data_zalozenia + '\'' +
                ", Nr_adresu=" + Nr_adresu + '\'' +
                ", adres='" + adres + '\'' +
                '}';
    }
}
