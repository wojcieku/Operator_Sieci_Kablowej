package bdbt_proj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UmowaDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UmowaDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Umowa> listForClient(String nrKlienta){
        String sql = "SELECT * FROM Umowy where Nr_klienta = ?";
        List<Umowa> umowaList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Umowa.class),nrKlienta);
        return umowaList;
    }
    public Umowa get(String nrUmowy){
        String sql = "SELECT * FROM Umowy where Nr_umowy = ?";
        Umowa umowa = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Umowa.class), nrUmowy);
        return umowa;
    }
    public void update(Umowa umowa){
        String sql = "UPDATE UMOWY SET data=:data, nr_klienta=:nr_klienta where nr_umowy=:nr_umowy";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(umowa);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }
    public void save(Umowa umowa){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("Umowy").usingColumns("Data", "Nr_klienta");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(umowa);

        insertActor.execute(param);

    }
}
