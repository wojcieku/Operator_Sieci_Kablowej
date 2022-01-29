package projekt_bdbt.Adres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class AdresDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AdresDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<AdresExtended> list() {
        String sql = "SELECT nr_adresu, miasto, ulica, nr_domu, nr_lokalu, adresy.nr_poczty, kod_pocztowy, poczta FROM ADRESY INNER JOIN POCZTY ON ADRESY.nr_poczty = POCZTY.nr_poczty";
        List<AdresExtended> listAdres = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(AdresExtended.class));
        return listAdres;
    }

    public int save(Adres adres) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
        int nrAdresu;
        try {
            String sql = "SELECT ADRESY.nr_adresu FROM ADRESY LEFT JOIN KLIENCI ON klienci.nr_adresu = adresy.nr_adresu WHERE MIASTO = ? AND ULICA = ? AND NR_DOMU = ? AND NR_LOKALU = ? AND NR_POCZTY = ? AND KLIENCI.NR_ADRESU IS NULL FETCH FIRST 1 ROWS ONLY";
            nrAdresu = jdbcTemplate.queryForObject(sql, Integer.class, adres.getMiasto(), adres.getUlica(), adres.getNrDomu(), adres.getNrLokalu(), adres.getNrPoczty());
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            insert.withTableName("ADRESY").usingColumns("miasto", "ulica", "nr_domu", "nr_lokalu", "nr_poczty").usingGeneratedKeyColumns("nr_adresu");
            BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adres);
            nrAdresu = insert.executeAndReturnKey(param).intValue();
        }
        return nrAdresu;
    }

    public AdresExtended get(int id) {
        String sql = "SELECT nr_adresu, miasto, ulica, nr_domu, nr_lokalu, adresy.nr_poczty, kod_pocztowy, poczta FROM ADRESY INNER JOIN POCZTY ON ADRESY.nr_poczty = POCZTY.nr_poczty AND nr_adresu = ?";
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(AdresExtended.class), id);
    }

    public void update(Adres adres, int id) {
        adres.setNrPoczty(id);
        String sql = "UPDATE ADRESY SET miasto = ?, ulica = ?, nr_domu = ?, nr_lokalu = ?, nr_poczty = ? WHERE nr_adresu = ?";
        SimpleJdbcInsert template = new SimpleJdbcInsert(jdbcTemplate);
        //BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adres);
        jdbcTemplate.update(sql, adres.getMiasto(), adres.getUlica(), adres.getNrDomu(), adres.getNrLokalu(), adres.getNrPoczty(), adres.getNrAdresu());
        System.out.println("done");
    }

    public void delete(int id) {
        String sql = "DELETE FROM ADRESY WHERE nr_adresu = ?";
        jdbcTemplate.update(sql, id);
    }
}
