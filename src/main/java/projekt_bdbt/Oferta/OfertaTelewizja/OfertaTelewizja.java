package projekt_bdbt.Oferta.OfertaTelewizja;

import projekt_bdbt.Oferta.Oferta;

public class OfertaTelewizja extends Oferta {
    private int lacznaLiczbaKanalow;
    private int liczbaKanalowWysokiejJakosci;
    private String czyKanalyZagraniczne;
    private String czyHomeBoxOffice;
    private String czyCinemax;
    private String czyDzieci;

    public OfertaTelewizja() {

    }

    public OfertaTelewizja(int nrOferty, double cena, String czasTrwania, String dodatkiDoUmowy, double kosztWypowiedzenia, int nrOperatora, String typOferty, int lacznaLiczbaKanalow, String czyKanalyZagraniczne, int liczbaKanalowWysokiejJakosci, String czyHomeBoxOffice, String czyCinemax, String czyDzieci) {
        super(nrOferty, cena, czasTrwania, dodatkiDoUmowy, kosztWypowiedzenia, nrOperatora, typOferty);
        this.lacznaLiczbaKanalow = lacznaLiczbaKanalow;
        this.czyKanalyZagraniczne = czyKanalyZagraniczne;
        this.liczbaKanalowWysokiejJakosci = liczbaKanalowWysokiejJakosci;
        this.czyHomeBoxOffice = czyHomeBoxOffice;
        this.czyCinemax = czyCinemax;
        this.czyDzieci = czyDzieci;
    }

    public int getLacznaLiczbaKanalow() {
        return lacznaLiczbaKanalow;
    }

    public void setLacznaLiczbaKanalow(int lacznaLiczbaKanalow) {
        this.lacznaLiczbaKanalow = lacznaLiczbaKanalow;
    }

    public String getCzyKanalyZagraniczne() {
        return czyKanalyZagraniczne;
    }

    public void setCzyKanalyZagraniczne(String czyKanalyZagraniczne) {
        this.czyKanalyZagraniczne = czyKanalyZagraniczne;
    }

    public int getLiczbaKanalowWysokiejJakosci() {
        return liczbaKanalowWysokiejJakosci;
    }

    public void setLiczbaKanalowWysokiejJakosci(int liczbaKanalowWysokiejJakosci) {
        this.liczbaKanalowWysokiejJakosci = liczbaKanalowWysokiejJakosci;
    }

    public String getCzyHomeBoxOffice() {
        return czyHomeBoxOffice;
    }

    public void setCzyHomeBoxOffice(String czyHomeBoxOffice) {
        this.czyHomeBoxOffice = czyHomeBoxOffice;
    }

    public String getCzyCinemax() {
        return czyCinemax;
    }

    public void setCzyCinemax(String czyCinemax) {
        this.czyCinemax = czyCinemax;
    }

    public String getCzyDzieci() {
        return czyDzieci;
    }

    public void setCzyDzieci(String czyDzieci) {
        this.czyDzieci = czyDzieci;
    }

    @Override
    public String toString() {
        return "OfertaTelewizja{" +
                "lacznaLiczbaKanalow=" + lacznaLiczbaKanalow +
                ", czyKanalyZagraniczne='" + czyKanalyZagraniczne + '\'' +
                ", liczbaKanalowWysokiejJakosci=" + liczbaKanalowWysokiejJakosci +
                ", czyHBO='" + czyHomeBoxOffice + '\'' +
                ", czyCinemax='" + czyCinemax + '\'' +
                ", czyDzieci='" + czyDzieci + '\'' +
                '}';
    }
}
