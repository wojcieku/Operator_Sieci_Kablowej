package projekt_bdbt.Poczta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PocztaDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PocztaDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Poczta> list() {
        String sql = "SELECT nr_poczty, kod_pocztowy, poczta FROM POCZTY";
        List<Poczta> listPoczta = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Poczta.class));
        return listPoczta;
    }

    public int save(Poczta poczta) {
        int nrPoczty;
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
        try {
            insert.withTableName("POCZTY").usingColumns("kod_pocztowy", "poczta").usingGeneratedKeyColumns("nr_poczty");
            BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(poczta);
            nrPoczty = insert.executeAndReturnKey(param).intValue();
            System.out.println("Nie ma w tabeli " + nrPoczty);
        } catch (DuplicateKeyException dke) {
             String sql = "SELECT nr_poczty from POCZTY WHERE kod_pocztowy = ? AND poczta = ?";
            nrPoczty =  jdbcTemplate.queryForObject(sql, Integer.class, poczta.getKodPocztowy(), poczta.getPoczta());
            System.out.println("Jest już w tabeli");
        }
        return nrPoczty;
    }

    public int update(Poczta poczta) {
        int nrPoczty;
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
        try {
            insert.withTableName("POCZTY").usingColumns("kod_pocztowy", "poczta").usingGeneratedKeyColumns("nr_poczty");
            BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(poczta);
            nrPoczty = insert.executeAndReturnKey(param).intValue();
        } catch (DuplicateKeyException dke) {
            String sql = "SELECT nr_poczty from POCZTY WHERE kod_pocztowy = ? AND poczta = ?";
            nrPoczty =  jdbcTemplate.queryForObject(sql, Integer.class, poczta.getKodPocztowy(), poczta.getPoczta());
        }
        return nrPoczty;
    }

    public void delete(int id) {

    }

}
