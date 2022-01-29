package projekt_bdbt.Oferta.OfertaInternet;
import projekt_bdbt.Oferta.Oferta;

public class OfertaInternet extends Oferta{
    private String  predkoscPobieraniaWMb;
    private String typInternetu;
    private String limitTransferu;
    private String predkoscWysylaniaWMb;

    public OfertaInternet () {

    }

    public OfertaInternet(int nrOferty, double cena, String czasTrwania, String dodatkiDoUmowy, double kosztWypowiedzenia, int nrOperatora, String typOferty, String predkoscPobieraniaWMb, String typInternetu, String limitTransferu, String predkoscWysylaniaWMb) {
        super(nrOferty, cena, czasTrwania, dodatkiDoUmowy, kosztWypowiedzenia, nrOperatora, typOferty);
        this.predkoscPobieraniaWMb = predkoscPobieraniaWMb;
        this.typInternetu = typInternetu;
        this.limitTransferu = limitTransferu;
        this.predkoscWysylaniaWMb = predkoscWysylaniaWMb;
    }

    public String  getPredkoscPobieraniaWMb() {
        return predkoscPobieraniaWMb;
    }

    public void setPredkoscPobieraniaWMb(String predkoscPobieraniaWMb) {
        this.predkoscPobieraniaWMb = predkoscPobieraniaWMb;
    }

    public String getTypInternetu() {
        return typInternetu;
    }

    public void setTypInternetu(String typInternetu) {
        this.typInternetu = typInternetu;
    }

    public String getLimitTransferu() {
        return limitTransferu;
    }

    public void setLimitTransferu(String limitTransferu) {
        this.limitTransferu = limitTransferu;
    }

    public String getPredkoscWysylaniaWMb() {
        return predkoscWysylaniaWMb;
    }

    public void setPredkoscWysylaniaWMb(String predkoscWysylaniaWMb) {
        this.predkoscWysylaniaWMb = predkoscWysylaniaWMb;
    }
    @Override
    public String toString() {
        return "OfertaInternet{" +
                "nrOferty=" + super.getNrOferty() +
                ", cena=" + super.getCena() +
                ", czasTrwania='" + super.getCzasTrwania() + '\'' +
                ", dodatkiDoUmowy='" + super.getDodatkiDoUmowy() + '\'' +
                ", kosztWypowiedzenia=" + super.getKosztWypowiedzenia() +
                ", nrOperatora=" + super.getNrOperatora() +
                ", predkoscPobieraniaWMb='" + predkoscPobieraniaWMb + '\'' +
                ", typInternetu='" + typInternetu + '\'' +
                ", limitTransferu='" + limitTransferu + '\'' +
                ", predkoscWysylaniaWMb='" + predkoscWysylaniaWMb + '\'' +
                '}';
    }
}
