package projekt_bdbt.Klient;

public class Klient {
    private int nrKlienta;
    private String imie;
    private String nazwisko;
    private String nrTelefonu;
    private String dataDolaczenia;
    private String aktywnaUmowa;
    private String nrDowodu;
    private String pesel;
    private String nrPaszportu;
    private int nrOperatora;
    private int nrAdresu;
    private String email;
    private String haslo;
    private String authority;
    private String czyAktywne;

    public Klient() {
    }

    public Klient(int nrKlienta, String imie, String nazwisko, String nrTelefonu, String dataDolaczenia, String aktywnaUmowa, String nrDowodu, String pesel, String nrPaszportu, int nrOperatora, int nrAdresu, String email, String haslo, String authority, String czyAktywne) {
        super();
        this.nrKlienta = nrKlienta;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nrTelefonu = nrTelefonu;
        this.dataDolaczenia = dataDolaczenia;
        this.aktywnaUmowa = aktywnaUmowa;
        this.nrDowodu = nrDowodu;
        this.pesel = pesel;
        this.nrPaszportu = nrPaszportu;
        this.nrOperatora = nrOperatora;
        this.nrAdresu = nrAdresu;
        this.email = email;
        this.haslo = haslo;
        this.authority = authority;
        this.czyAktywne = czyAktywne;
    }

    public int getNrKlienta() {
        return nrKlienta;
    }

    public void setNrKlienta(int nrKlienta) {
        this.nrKlienta = nrKlienta;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getNrTelefonu() {
        return nrTelefonu;
    }

    public void setNrTelefonu(String nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
    }

    public String getDataDolaczenia() {
        return dataDolaczenia;
    }

    public void setDataDolaczenia(String dataDolaczenia) {
        this.dataDolaczenia = dataDolaczenia;
    }

    public String getAktywnaUmowa() {
        return aktywnaUmowa;
    }

    public void setAktywnaUmowa(String aktywnaUmowa) {
        this.aktywnaUmowa = aktywnaUmowa;
    }

    public String getNrDowodu() {
        return nrDowodu;
    }

    public void setNrDowodu(String nrDowodu) {
        this.nrDowodu = nrDowodu;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getNrPaszportu() {
        return nrPaszportu;
    }

    public void setNrPaszportu(String nrPaszportu) {
        this.nrPaszportu = nrPaszportu;
    }

    public int getNrOperatora() {
        return nrOperatora;
    }

    public void setNrOperatora(int nrOperatora) {
        this.nrOperatora = nrOperatora;
    }

    public int getNrAdresu() {
        return nrAdresu;
    }

    public void setNrAdresu(int nrAdresu) {
        this.nrAdresu = nrAdresu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getCzyAktywne() {
        return czyAktywne;
    }

    public void setCzyAktywne(String czyAktywne) {
        this.czyAktywne = czyAktywne;
    }

    @Override
    public String toString() {
        return "Klient{" +
                "nrKlienta=" + nrKlienta +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", nrTelefonu='" + nrTelefonu + '\'' +
                ", dataDolaczenia='" + dataDolaczenia + '\'' +
                ", aktywnaUmowa='" + aktywnaUmowa + '\'' +
                ", nrDowodu='" + nrDowodu + '\'' +
                ", pesel='" + pesel + '\'' +
                ", nrPaszportu='" + nrPaszportu + '\'' +
                ", nrOperatora=" + nrOperatora +
                ", nrAdresu=" + nrAdresu +
                ", email='" + email + '\'' +
                ", haslo='" + haslo + '\'' +
                ", authority='" + authority + '\'' +
                ", czyAktywne='" + czyAktywne + '\'' +
                '}';
    }
}
