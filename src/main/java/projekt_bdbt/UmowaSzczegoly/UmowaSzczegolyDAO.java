package projekt_bdbt.UmowaSzczegoly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class UmowaSzczegolyDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UmowaSzczegolyDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public UmowaSzczegoly get(String nrUmowy){
        String sql = "SELECT * FROM Umowy_szczegoly where nrUmowy = ?";
        UmowaSzczegoly umowaSzczegoly = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(UmowaSzczegoly.class), nrUmowy);
        return umowaSzczegoly;
    }

    public void save(UmowaSzczegoly umowaSzczegoly){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("Umowy_szczegoly").usingColumns("Nr_oferty", "Nr_umowy");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(umowaSzczegoly);

        insertActor.execute(param);
    }
    public void update(UmowaSzczegoly umowaSzczegoly){
        String sql = "UPDATE Umowy_szczegoly SET nr_oferty=:nrOferty, nr_umowy=:nrUmowy";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(umowaSzczegoly);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }
    public void delete(String nrUmowy){
        String sql ="DELETE FROM Umowy_szczegoly where Nr_umowy=?";
        jdbcTemplate.update(sql, nrUmowy);
    }

}
