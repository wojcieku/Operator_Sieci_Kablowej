package projekt_bdbt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import static java.lang.Integer.parseInt;

@Repository
public class OperatorzyDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public OperatorzyDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Operator> list(){
        String sql = "SELECT operatorzy.nr_operatora, operatorzy.nazwa, CAST(operatorzy.data_zalozenia as varchar(10)) as data_zalozenia, operatorzy.nr_adresu,\n" +
                "NVL2(adresy.nr_lokalu, adresy.miasto||' ul. ' || adresy.ulica || ' ' || adresy.nr_domu || '/' || adresy.nr_lokalu, adresy.miasto||' ul. ' || adresy.ulica || ' ' || adresy.nr_domu) as Adres\n" +
                "FROM operatorzy INNER JOIN adresy ON adresy.nr_adresu=operatorzy.nr_adresu";

        List<Operator> operatorList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Operator.class));
        System.out.println(operatorList);
        return operatorList;
    }
    public void save(Operator operator){

        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("Operatorzy").usingColumns("Nazwa","Data_zalozenia","Nr_adresu");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(operator);
        insertActor.execute(param);
    }
    public Boolean validate(Operator operator){
        //sprawdzenie pól operatora (data etc.)
        return Boolean.TRUE;
    }
    public Operator get(String Nr_operatora) {
        String sql = "SELECT * FROM Operatorzy where Nr_operatora = ?";
        Operator operator = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Operator.class), Nr_operatora);
        operator.setDataZalozenia(operator.getDataZalozenia().substring(0,10)); //wyciagniecie samej daty bez godziny
        System.out.println(operator);
        return operator;
    }

    public void update(Operator operator){
        System.out.println(operator);
        String sql = "UPDATE OPERATORZY SET nazwa=:nazwa, data_zalozenia=:dataZalozenia WHERE nr_operatora=:nrOperatora";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(operator);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);

    }
    public void delete(String Nr_operatora){
        String sql = "DELETE FROM OPERATORZY WHERE Nr_operatora ="+Nr_operatora;
        jdbcTemplate.update(sql);
    }
}
