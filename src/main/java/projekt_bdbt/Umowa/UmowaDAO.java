package projekt_bdbt.Umowa;

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

    public List<Umowa> listForClient(String email){
        String sql = "SELECT * FROM (SELECT umowy.nr_umowy, umowy.data, umowy.nr_klienta, umowy.nr_oferty, klienci.imie||' '||klienci.nazwisko as imieNazwisko, klienci.email as email FROM umowy INNER JOIN klienci ON umowy.nr_klienta=klienci.nr_klienta) \n" +
                "where email = ?";
        List<Umowa> umowaList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Umowa.class), email); //email is unique
        return umowaList;
    }
    public List<Umowa> listForAdmin(){
        String sql = "SELECT umowy.nr_umowy,umowy.data, umowy.nr_klienta, umowy.nr_oferty, klienci.imie||' ' ||klienci.nazwisko as imieNazwisko FROM umowy INNER JOIN klienci ON umowy.nr_klienta=klienci.nr_klienta ORDER BY umowy.nr_umowy";
        List<Umowa> umowaList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Umowa.class));
        return umowaList;
    }
    public Umowa get(String nrUmowy){
        String sql = "SELECT * FROM UMOWY where Nr_umowy = ?";
        Umowa umowa = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Umowa.class), nrUmowy);
        umowa.setData(umowa.getData().substring(0,10));
        return umowa;
    }
    public void update(Umowa umowa){
        String sql = "UPDATE UMOWY SET data=:data, nr_klienta=:nrKlienta, nr_oferty=:nrOferty where nr_umowy=:nrUmowy";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(umowa);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }
    public String save(Umowa umowa){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("Umowy").usingColumns("Data", "Nr_klienta", "Nr_Oferty");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(umowa);

        String key = insertActor.usingGeneratedKeyColumns("Nr_Umowy").executeAndReturnKey(param).toString();
        return key;
    }
    public void delete(String nrUmowy){
        String sql ="DELETE FROM Umowy where Nr_umowy=?";
        jdbcTemplate.update(sql, nrUmowy);
    }
    public String getClientIdByEmail(String email){
        String sql = "SELECT nr_klienta FROM Klienci where klienci.email = ?";
        String id = jdbcTemplate.queryForObject(sql, String.class, email);
        return id;
    }
}
