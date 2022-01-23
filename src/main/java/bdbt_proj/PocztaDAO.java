package bdbt_proj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class PocztaDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PocztaDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public Poczta get(String nrPoczty){
        String sql = "SELECT * FROM Poczty where Nr_poczty = ?";
        Poczta poczta = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Poczta.class), nrPoczty);
        return poczta;
    }
    public String save(Poczta poczta){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("Poczty").usingColumns("Kod_pocztowy","Poczta");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(poczta);
        String id = insertActor.usingGeneratedKeyColumns("Nr_poczty").executeAndReturnKey(param).toString();
        return id;
    }
    public void update(Poczta poczta){
        String sql = "UPDATE POCZTY SET kod_pocztowy=:kod_pocztowy, poczta=:poczta where nr_poczty=:nr_poczty";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(poczta);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }


}
