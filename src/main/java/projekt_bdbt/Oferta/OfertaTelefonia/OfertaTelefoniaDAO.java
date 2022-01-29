package projekt_bdbt.Oferta.OfertaTelefonia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OfertaTelefoniaDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public OfertaTelefoniaDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<OfertaTelefonia> list() {
        String sql = "SELECT * FROM OFERTY INNER JOIN TELEFONIA ON OFERTY.nr_oferty = TELEFONIA.nr_oferty INNER JOIN GENERACJE G on G.NR_GENERACJI = TELEFONIA.NR_GENERACJI";
        List<OfertaTelefonia> listOferta = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(OfertaTelefonia.class));
        System.out.println(listOferta);
        return listOferta;
    }

    public void save(OfertaTelefonia ofertaTelefonia) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
        insert.withTableName("OFERTY").usingColumns("Cena", "Czas_trwania", "Dodatki_do_umowy", "Koszt_wypowiedzenia", "Nr_operatora", "typ_oferty").usingGeneratedKeyColumns("Nr_oferty");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(ofertaTelefonia);
        ofertaTelefonia.setNrOferty(insert.executeAndReturnKey(param).intValue());
        try {
            insert = new SimpleJdbcInsert(jdbcTemplate);
            insert.withTableName("GENERACJE").usingColumns("Nazwa_generacji", "Opis").usingGeneratedKeyColumns("nr_generacji");
            param = new BeanPropertySqlParameterSource(ofertaTelefonia);
            ofertaTelefonia.setNrGeneracji(insert.executeAndReturnKey(param).intValue());
        } catch (DuplicateKeyException dke) {
            String sql = "SELECT nr_generacji from GENERACJE WHERE nazwa_generacji = ?";
            ofertaTelefonia.setNrGeneracji(jdbcTemplate.queryForObject(sql, Integer.class, ofertaTelefonia.getNazwaGeneracji()));
        }
        System.out.println(ofertaTelefonia.getNrGeneracji());
        System.out.println(ofertaTelefonia.getNrOferty());
        String sql = "INSERT INTO TELEFONIA (Nr_oferty, pakiet_danych, pakiet_polaczen_krajowych, pakiet_polaczen_zagranica, pakiet_wiadomosci, koszt_wiadomosci, polaczenia_krajowe_koszt, polaczenia_zagranica_koszt, NR_GENERACJI) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, ofertaTelefonia.getNrOferty(), ofertaTelefonia.getPakietDanych(), ofertaTelefonia.getPakietPolaczenKrajowych(), ofertaTelefonia.getPakietPolaczenZagranica(), ofertaTelefonia.getPakietWiadomosci(), ofertaTelefonia.getKosztWiadomosci(), ofertaTelefonia.getPolaczeniaKrajoweKoszt(), ofertaTelefonia.getPolaczeniaZagranicaKoszt(), ofertaTelefonia.getNrGeneracji());
    }

    public OfertaTelefonia get(int nrOferty) {
        OfertaTelefonia ofertaTelefonia;
        try {
            String sql = "SELECT * FROM OFERTY INNER JOIN TELEFONIA ON OFERTY.nr_oferty = TELEFONIA.nr_oferty INNER JOIN GENERACJE G on G.NR_GENERACJI = TELEFONIA.NR_GENERACJI WHERE OFERTY.nr_oferty = ?";
            ofertaTelefonia = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(OfertaTelefonia.class), nrOferty);
        } catch (EmptyResultDataAccessException e) {
            ofertaTelefonia = null;
        }
        return ofertaTelefonia;
    }

    public void update(OfertaTelefonia ofertaTelefonia) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(ofertaTelefonia);
        try {
            insert.withTableName("GENERACJE").usingColumns("Nazwa_generacji", "Opis").usingGeneratedKeyColumns("nr_generacji");
            param = new BeanPropertySqlParameterSource(ofertaTelefonia);
            ofertaTelefonia.setNrGeneracji(insert.executeAndReturnKey(param).intValue());
        } catch (DuplicateKeyException dke) {
            String sql = "SELECT nr_generacji from GENERACJE WHERE nazwa_generacji = ?";
            ofertaTelefonia.setNrGeneracji(jdbcTemplate.queryForObject(sql, Integer.class, ofertaTelefonia.getNazwaGeneracji()));
        }
        String sql = "UPDATE TELEFONIA SET pakiet_danych = ?, pakiet_polaczen_krajowych = ?, pakiet_polaczen_zagranica = ?, pakiet_wiadomosci = ?, koszt_wiadomosci = ?, polaczenia_krajowe_koszt = ?, polaczenia_zagranica_koszt = ?, nr_generacji = ? WHERE nr_oferty = ?";
        jdbcTemplate.update(sql, ofertaTelefonia.getPakietDanych(), ofertaTelefonia.getPakietPolaczenKrajowych(), ofertaTelefonia.getPakietPolaczenZagranica(), ofertaTelefonia.getPakietWiadomosci(), ofertaTelefonia.getKosztWiadomosci(), ofertaTelefonia.getPolaczeniaKrajoweKoszt(), ofertaTelefonia.getPolaczeniaZagranicaKoszt(), ofertaTelefonia.getNrGeneracji(), ofertaTelefonia.getNrOferty());
        sql = "UPDATE OFERTY SET cena = ?, czas_trwania = ?, dodatki_do_umowy = ?, koszt_wypowiedzenia = ? WHERE nr_oferty = ?";
        jdbcTemplate.update(sql, ofertaTelefonia.getCena(), ofertaTelefonia.getCzasTrwania(), ofertaTelefonia.getDodatkiDoUmowy(), ofertaTelefonia.getKosztWypowiedzenia(), ofertaTelefonia.getNrOferty());
    }

    public void delete(int nrOferty) {
        String sql = "DELETE FROM OFERTY WHERE nr_oferty = ?";
        jdbcTemplate.update(sql, nrOferty);
        sql = "DELETE FROM TELEFONIA WHERE nr_oferty = ?";
        jdbcTemplate.update(sql, nrOferty);
    }
}
