package projekt_bdbt.Oferta.OfertaTelefonia;

import projekt_bdbt.Oferta.Oferta;

public class OfertaTelefonia extends Oferta {
    private int pakietDanych;
    private String pakietPolaczenKrajowych;
    private String pakietPolaczenZagranica;
    private String pakietWiadomosci;
    private double kosztWiadomosci;
    private double polaczeniaKrajoweKoszt;
    private double polaczeniaZagranicaKoszt;
    private int nrGeneracji;
    private String nazwaGeneracji;
    private String opis;

    public OfertaTelefonia() {

    }

    public OfertaTelefonia(int nrOferty, double cena, String czasTrwania, String dodatkiDoUmowy, double kosztWypowiedzenia, int nrOperatora, String typOferty, int pakietDanych, String pakietPolaczenKrajowych, String pakietPolaczenZagranica, String pakietWiadomosci, double kosztWiadomosci, double polaczeniaKrajoweKoszt, double  polaczeniaZagranicaKoszt, String nazwaGeneracji, String opis) {
        super(nrOferty, cena, czasTrwania, dodatkiDoUmowy, kosztWypowiedzenia, nrOperatora, typOferty);
        this.pakietDanych = pakietDanych;
        this.pakietPolaczenKrajowych = pakietPolaczenKrajowych;
        this.pakietPolaczenZagranica = pakietPolaczenZagranica;
        this.pakietWiadomosci = pakietWiadomosci;
        this.kosztWiadomosci = kosztWiadomosci;
        this.polaczeniaKrajoweKoszt = polaczeniaKrajoweKoszt;
        this.polaczeniaZagranicaKoszt = polaczeniaZagranicaKoszt;
        this.nazwaGeneracji = nazwaGeneracji;
        this.opis = opis;
    }

    public int getPakietDanych() {
        return pakietDanych;
    }

    public void setPakietDanych(int pakietDanych) {
        this.pakietDanych = pakietDanych;
    }

    public String getPakietPolaczenKrajowych() {
        return pakietPolaczenKrajowych;
    }

    public void setPakietPolaczenKrajowych(String pakietPolaczenKrajowych) {
        this.pakietPolaczenKrajowych = pakietPolaczenKrajowych;
    }

    public String getPakietPolaczenZagranica() {
        return pakietPolaczenZagranica;
    }

    public void setPakietPolaczenZagranica(String pakietPolaczenZagranica) {
        this.pakietPolaczenZagranica = pakietPolaczenZagranica;
    }

    public String getPakietWiadomosci() {
        return pakietWiadomosci;
    }

    public void setPakietWiadomosci(String pakietWiadomosci) {
        this.pakietWiadomosci = pakietWiadomosci;
    }

    public double getKosztWiadomosci() {
        return kosztWiadomosci;
    }

    public void setKosztWiadomosci(double kosztWiadomosci) {
        this.kosztWiadomosci = kosztWiadomosci;
    }

    public double getPolaczeniaKrajoweKoszt() {
        return polaczeniaKrajoweKoszt;
    }

    public void setPolaczeniaKrajoweKoszt(double polaczeniaKrajoweKoszt) {
        this.polaczeniaKrajoweKoszt = polaczeniaKrajoweKoszt;
    }

    public double getPolaczeniaZagranicaKoszt() {
        return polaczeniaZagranicaKoszt;
    }

    public void setPolaczeniaZagranicaKoszt(double polaczeniaZagranicaKoszt) {
        this.polaczeniaZagranicaKoszt = polaczeniaZagranicaKoszt;
    }

    public int getNrGeneracji() {
        return nrGeneracji;
    }

    public void setNrGeneracji(int nrGeneracji) {
        this.nrGeneracji = nrGeneracji;
    }

    public String getNazwaGeneracji() {
        return nazwaGeneracji;
    }

    public void setNazwaGeneracji(String nazwaGeneracji) {
        this.nazwaGeneracji = nazwaGeneracji;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opisGeneracji) {
        this.opis = opisGeneracji;
    }

    @Override
    public String toString() {
        return "OfertaTelefonia{" +
                "pakietDanych=" + pakietDanych +
                ", pakietPolaczenKrajowych='" + pakietPolaczenKrajowych + '\'' +
                ", pakietPolaczenZagranica='" + pakietPolaczenZagranica + '\'' +
                ", pakietSMS='" + pakietWiadomosci + '\'' +
                ", SMSKoszt=" + kosztWiadomosci +
                ", polaczeniaKrajoweKoszt=" + polaczeniaKrajoweKoszt +
                ", polaczeniaZagranicaKoszt=" + polaczeniaZagranicaKoszt +
                ", nrGeneracji='" + nrGeneracji + '\'' +
                ", nazwaGeneracji='" + nazwaGeneracji + '\'' +
                ", opisGeneracji='" + opis + '\'' +
                '}';
    }
}
