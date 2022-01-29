package projekt_bdbt.Oferta.OfertaInternet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import projekt_bdbt.Oferta.Oferta;

import java.util.List;

@Repository
public class OfertaInternetDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public OfertaInternetDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<OfertaInternet> list() {
        String sql = "SELECT * FROM OFERTY INNER JOIN INTERNET ON OFERTY.nr_oferty = INTERNET.nr_oferty";
        List<OfertaInternet> listOferta = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(OfertaInternet.class));
        return listOferta;
    }

    public void save(OfertaInternet ofertaInternet) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
        insert.withTableName("OFERTY").usingColumns("Cena", "Czas_trwania", "Dodatki_do_umowy", "Koszt_wypowiedzenia", "Nr_operatora", "typ_oferty").usingGeneratedKeyColumns("Nr_oferty");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(ofertaInternet);
        ofertaInternet.setNrOferty(insert.executeAndReturnKey(param).intValue());
            String sql = "INSERT INTO INTERNET (Nr_oferty, Predkosc_pobierania_w_Mb, Typ_internetu, Limit_transferu, Predkosc_wysylania_w_Mb) VALUES (?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, ofertaInternet.getNrOferty(), ofertaInternet.getPredkoscPobieraniaWMb(), ofertaInternet.getTypInternetu(), ofertaInternet.getLimitTransferu(), ofertaInternet.getPredkoscWysylaniaWMb());
    }

    public OfertaInternet get(int nrOferty) {
        String sql = "SELECT * FROM OFERTY INNER JOIN INTERNET ON OFERTY.nr_oferty = INTERNET.nr_oferty WHERE OFERTY.nr_oferty = ?";
        OfertaInternet ofertaInternet = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(OfertaInternet.class), nrOferty);
        return ofertaInternet;
    }
    public Oferta getOferta(int nrOferty){
        String sql = "SELECT * FROM OFERTY where Nr_Oferty = ?";
        Oferta oferta = jdbcTemplate.queryForObject(sql,BeanPropertyRowMapper.newInstance(Oferta.class), nrOferty);
        return oferta;
    }

    public void update(OfertaInternet ofertaInternet) {
        String sql = "UPDATE INTERNET SET predkosc_pobierania_w_mb = ?, typ_internetu = ?, limit_transferu = ?, predkosc_wysylania_w_mb = ? WHERE nr_oferty = ?";
        jdbcTemplate.update(sql, ofertaInternet.getPredkoscPobieraniaWMb(), ofertaInternet.getTypInternetu(), ofertaInternet.getLimitTransferu(), ofertaInternet.getPredkoscWysylaniaWMb(), ofertaInternet.getNrOferty());
        sql = "UPDATE OFERTY SET cena = ?, czas_trwania = ?, dodatki_do_umowy = ?, koszt_wypowiedzenia = ? WHERE nr_oferty = ?";
        jdbcTemplate.update(sql, ofertaInternet.getCena(), ofertaInternet.getCzasTrwania(), ofertaInternet.getDodatkiDoUmowy(), ofertaInternet.getKosztWypowiedzenia(), ofertaInternet.getNrOferty());
    }

    public void delete(int nrOferty) {
        String sql = "DELETE FROM OFERTY WHERE nr_oferty = ?";
        jdbcTemplate.update(sql, nrOferty);
        sql = "DELETE FROM INTERNET WHERE nr_oferty = ?";
        jdbcTemplate.update(sql, nrOferty);
    }
    public String checkTypeOfOffer(int nrOferty){
        String sql = "SELECT typ_oferty FROM OFERTY where nr_oferty= ?";
        String type = jdbcTemplate.queryForObject(sql, String.class, nrOferty);
        return type;
    }
}
