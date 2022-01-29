package projekt_bdbt.Oferta;

public class Oferta {
    private int nrOferty;
    private double cena;
    private String czasTrwania;
    private String dodatkiDoUmowy;
    private double kosztWypowiedzenia;
    private int nrOperatora;
    private String typOferty;
    public Oferta() {

    }
    public Oferta(int nrOferty, double cena, String czasTrwania, String dodatkiDoUmowy, double kosztWypowiedzenia, int nrOperatora, String typOferty) {
        this.nrOferty = nrOferty;
        this.cena = cena;
        this.czasTrwania = czasTrwania;
        this.dodatkiDoUmowy = dodatkiDoUmowy;
        this.kosztWypowiedzenia = kosztWypowiedzenia;
        this.nrOperatora = nrOperatora;
        this.typOferty = typOferty;
    }

    public int getNrOferty() {
        return nrOferty;
    }

    public void setNrOferty(int nrOferty) {
        this.nrOferty = nrOferty;
    }

    public double getCena() {
        return cena;
    }

    public String getTypOferty() {
        return typOferty;
    }

    public void setTypOferty(String typOferty) {
        this.typOferty = typOferty;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getCzasTrwania() {
        return czasTrwania;
    }

    public void setCzasTrwania(String czasTrwania) {
        this.czasTrwania = czasTrwania;
    }

    public String getDodatkiDoUmowy() {
        return dodatkiDoUmowy;
    }

    public void setDodatkiDoUmowy(String dodatkiDoUmowy) {
        this.dodatkiDoUmowy = dodatkiDoUmowy;
    }

    public double getKosztWypowiedzenia() {
        return kosztWypowiedzenia;
    }

    public void setKosztWypowiedzenia(double kosztWypowiedzenia) {
        this.kosztWypowiedzenia = kosztWypowiedzenia;
    }

    public int getNrOperatora() {
        return nrOperatora;
    }

    public void setNrOperatora(int nrOperatora) {
        this.nrOperatora = nrOperatora;
    }
}
