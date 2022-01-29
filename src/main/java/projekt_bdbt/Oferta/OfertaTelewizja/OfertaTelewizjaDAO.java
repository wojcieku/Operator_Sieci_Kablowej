package projekt_bdbt.Oferta.OfertaTelewizja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OfertaTelewizjaDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public OfertaTelewizjaDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<OfertaTelewizja> list() {
        String sql = "SELECT * FROM OFERTY INNER JOIN TELEWIZJA ON OFERTY.nr_oferty = TELEWIZJA.nr_oferty";
        List<OfertaTelewizja> listOferta = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(OfertaTelewizja.class));
        return listOferta;
    }

    public void save(OfertaTelewizja ofertaTelewizja) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
        insert.withTableName("OFERTY").usingColumns("Cena", "Czas_trwania", "Dodatki_do_umowy", "Koszt_wypowiedzenia", "Nr_operatora", "typ_oferty").usingGeneratedKeyColumns("Nr_oferty");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(ofertaTelewizja);
        ofertaTelewizja.setNrOferty(insert.executeAndReturnKey(param).intValue());
        String sql = "INSERT INTO TELEWIZJA (Nr_oferty, LACZNA_LICZBA_KANALOW, CZY_KANALY_ZAGRANICZNE, LICZBA_KANALOW_WYSOKIEJ_JAKOSCI, CZY_HOME_BOX_OFFICE, CZY_CINEMAX, CZY_DZIECI) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, ofertaTelewizja.getNrOferty(), ofertaTelewizja.getLacznaLiczbaKanalow(), ofertaTelewizja.getCzyKanalyZagraniczne(), ofertaTelewizja.getLiczbaKanalowWysokiejJakosci(), ofertaTelewizja.getCzyHomeBoxOffice(), ofertaTelewizja.getCzyCinemax(), ofertaTelewizja.getCzyDzieci());
    }

    public OfertaTelewizja get(int nrOferty) {
        OfertaTelewizja ofertaTelewizja;
        try {
            String sql = "SELECT * FROM OFERTY INNER JOIN TELEWIZJA ON OFERTY.nr_oferty = TELEWIZJA.nr_oferty WHERE OFERTY.nr_oferty = ?";
            ofertaTelewizja = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(OfertaTelewizja.class), nrOferty);
        } catch (EmptyResultDataAccessException e) {
            ofertaTelewizja = null;
        }

        return ofertaTelewizja;
    }

    public void update(OfertaTelewizja ofertaTelewizja) {
        String sql = "UPDATE OFERTY SET cena = ?, czas_trwania = ?, dodatki_do_umowy = ?, koszt_wypowiedzenia = ? WHERE nr_oferty = ?";
        jdbcTemplate.update(sql, ofertaTelewizja.getCena(), ofertaTelewizja.getCzasTrwania(), ofertaTelewizja.getDodatkiDoUmowy(), ofertaTelewizja.getKosztWypowiedzenia(), ofertaTelewizja.getNrOferty());
        sql = "UPDATE TELEWIZJA SET LACZNA_LICZBA_KANALOW = ?, CZY_KANALY_ZAGRANICZNE = ?, LICZBA_KANALOW_WYSOKIEJ_JAKOSCI = ?, CZY_HOME_BOX_OFFICE = ?, CZY_CINEMAX = ?, CZY_DZIECI = ? WHERE nr_oferty = ?";
        jdbcTemplate.update(sql, ofertaTelewizja.getLacznaLiczbaKanalow(), ofertaTelewizja.getCzyKanalyZagraniczne(), ofertaTelewizja.getLiczbaKanalowWysokiejJakosci(), ofertaTelewizja.getCzyHomeBoxOffice(), ofertaTelewizja.getCzyCinemax(), ofertaTelewizja.getCzyDzieci(), ofertaTelewizja.getNrOferty());

    }

    public void delete(int nrOferty) {
        String sql = "DELETE FROM OFERTY WHERE nr_oferty = ?";
        jdbcTemplate.update(sql, nrOferty);
        sql = "DELETE FROM TELEWIZJA WHERE nr_oferty = ?";
        jdbcTemplate.update(sql, nrOferty);
    }

}
