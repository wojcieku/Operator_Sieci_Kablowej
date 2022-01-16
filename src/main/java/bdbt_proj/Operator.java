package bdbt_proj;

public class Operator {
    private String nrOperatora;
    private String nazwa;
    private String dataZalozenia;
    private String nrAdresu;
    private String adres;

    public Operator() {
    }

    public Operator(String nr_operatora, String nazwa, String data_zalozenia, String nrAdresu, String adres) {
        this.nrOperatora = nr_operatora;
        this.nazwa = nazwa;
        dataZalozenia = data_zalozenia;
        this.nrAdresu = nrAdresu;
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
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNrOperatora() {
        return nrOperatora;
    }

    public void setNrOperatora(String nrOperatora) {
        this.nrOperatora = nrOperatora;
    }

    public String getNrAdresu() {
        return nrAdresu;
    }

    public void setNrAdresu(String nrAdresu) {
        this.nrAdresu = nrAdresu;
    }

    public String getDataZalozenia() {
        return dataZalozenia;
    }

    public void setDataZalozenia(String dataZalozenia) {
        this.dataZalozenia = dataZalozenia;
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
                "Nr_operatora=" + nrOperatora +
                ", Nazwa='" + nazwa + '\'' +
                ", Data_zalozenia='" + dataZalozenia + '\'' +
                ", Nr_adresu=" + nrAdresu + '\'' +
                ", adres='" + adres + '\'' +
                '}';
    }
}
