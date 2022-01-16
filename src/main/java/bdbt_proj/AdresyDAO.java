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
public class AdresyDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AdresyDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Adres> list() {
        String sql = "SELECT * FROM Adresy";
        List<Adres> adresList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adres.class));

        return adresList;
    }

    public String save(Adres adres) {
        if (adres.getMiasto().matches("^[a-zA-Z-AaĄąBbCcĆćDdEeĘęFfGgHhIiJjKkLlŁłMmNnŃńOoÓóPpRrSsŚśTtUuWwYyZzŹźŻż]+$")) { //^ i $?
            SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
            insertActor.withTableName("Adresy").usingColumns("Miasto", "Ulica", "Nr_domu", "Nr_lokalu", "Nr_poczty");

            BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adres);
            String id = insertActor.usingGeneratedKeyColumns("Nr_adresu").executeAndReturnKey(param).toString();
            return id;
        } else return "false"; //do poprawy - lepiej validate
    }
    public Boolean validate(Adres adres){
        //przykladowo dla miasta czy nie ma cyfr:
        if (adres.getMiasto().matches("^[a-zA-Z-AaĄąBbCcĆćDdEeĘęFfGgHhIiJjKkLlŁłMmNnŃńOoÓóPpRrSsŚśTtUuWwYyZzŹźŻż]+$")) {
            return Boolean.TRUE;
        }
        else return Boolean.FALSE;
    }
    public Adres get(String Nr_adresu){
        String sql = "SELECT * FROM Adresy where Nr_adresu = ?";
        Adres adres = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Adres.class),Nr_adresu);
        return adres;
    }
    public void update(Adres adres){
        String sql = "UPDATE ADRESY SET miasto=:miasto, ulica=:ulica, nr_domu=:nr_domu, nr_lokalu=:nr_lokalu WHERE Nr_adresu=:Nr_adresu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adres);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);

    }
    public void delete(String Nr_adresu){

    }


}
