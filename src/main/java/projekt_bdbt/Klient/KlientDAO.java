package projekt_bdbt.Klient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KlientDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public KlientDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Klient> list() {
        String sql = "SELECT nr_klienta, imie, NAZWISKO, NR_TELEFONU, TO_CHAR(DATA_DOLACZENIA, 'yyyy/mm/dd') as DATA_DOLACZENIA, AKTYWNA_UMOWA, NR_DOWODU, PESEL, NR_PASZPORTU, NR_OPERATORA, NR_ADRESU, EMAIL, HASLO, AUTHORITY, CZY_AKTYWNE FROM KLIENCI";
        List<Klient> listKlient = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Klient.class));
        return listKlient;
    }
    public Klient get(int id) {
        String sql = "SELECT nr_klienta, imie, NAZWISKO, NR_TELEFONU, TO_CHAR(DATA_DOLACZENIA, 'yyyy/mm/dd') as DATA_DOLACZENIA, AKTYWNA_UMOWA, NR_DOWODU, PESEL, NR_PASZPORTU, NR_OPERATORA, NR_ADRESU, EMAIL, HASLO, AUTHORITY, CZY_AKTYWNE FROM KLIENCI WHERE NR_KLIENTA = ?";
        Klient klient = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Klient.class), id);
        return klient;
    }
    public int getClientIdByEmail(String email){
        String sql = "SELECT nr_klienta FROM KLIENCI where email = ?";
        int id = jdbcTemplate.queryForObject(sql, Integer.class ,email);
        return id;
    }
    public void save(Klient klient) {
        int nrAdresu;

        //SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
        //insert.withTableName("KLIENCI").usingColumns("IMIE", "NAZWISKO", "NR_TELEFONU", "DATA_DOLACZENIA", "NR_DOWODU", "PESEL", "NR_PASZPORTU", "NR_OPERATORA", "NR_ADRESU", "EMAIL", "HASLO", "AUTHORITY", "CZY_AKTYWNE").usingGeneratedKeyColumns("NR_KLIENTA");
        //BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klient);
        //insert.execute(param);
        try {
            String sql = "SELECT nr_klienta from KLIENCI WHERE email = ?";
            nrAdresu = jdbcTemplate.queryForObject(sql, Integer.class, klient.getEmail());
            System.out.println("Adres jest już zajęty!");
            //sql = "INSERT INTO KLIENCI (IMIE, NAZWISKO, NR_TELEFONU, DATA_DOLACZENIA, AKTYWNA_UMOWA, NR_DOWODU, PESEL, NR_PASZPORTU, NR_OPERATORA, NR_ADRESU, EMAIL, HASLO, AUTHORITY, CZY_AKTYWNE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            //jdbcTemplate.update(sql, klient.getImie(), klient.getNazwisko(), klient.getNrTelefonu(), klient.getDataDolaczenia(), klient.getAktywnaUmowa(), klient.getNrDowodu(), klient.getPesel(), klient.getNrPaszportu(), klient.getNrOperatora(), nrAdresu, klient.getEmail(), klient.getHaslo(), klient.getAuthority(), klient.getCzyAktywne());
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            String sql = "INSERT INTO KLIENCI (IMIE, NAZWISKO, NR_TELEFONU, DATA_DOLACZENIA, AKTYWNA_UMOWA, NR_DOWODU, PESEL, NR_PASZPORTU, NR_OPERATORA, NR_ADRESU, EMAIL, HASLO, AUTHORITY, CZY_AKTYWNE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, klient.getImie(), klient.getNazwisko(), klient.getNrTelefonu(), klient.getDataDolaczenia(), klient.getAktywnaUmowa(), klient.getNrDowodu(), klient.getPesel(), klient.getNrPaszportu(), klient.getNrOperatora(), klient.getNrAdresu(), klient.getEmail(), klient.getHaslo(), klient.getAuthority(), klient.getCzyAktywne());
        }
    }

    public void update(Klient klient) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
        //insert.withTableName("KLIENCI").usingColumns("IMIE", "NAZWISKO", "NR_TELEFONU", "DATA_DOLACZENIA", "NR_DOWODU", "PESEL", "NR_PASZPORTU", "NR_OPERATORA", "NR_ADRESU", "EMAIL", "HASLO", "AUTHORITY", "CZY_AKTYWNE").usingGeneratedKeyColumns("NR_KLIENTA");
        //BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klient);
        //insert.execute(param);
        String sql = "UPDATE KLIENCI SET IMIE = ?, NAZWISKO = ?, NR_TELEFONU = ?, AKTYWNA_UMOWA = ?, NR_DOWODU = ?, PESEL = ?, NR_PASZPORTU = ?, NR_ADRESU = ?, EMAIL = ?, HASLO = ?, AUTHORITY = ?, CZY_AKTYWNE = ? WHERE NR_KLIENTA = ?";
        jdbcTemplate.update(sql, klient.getImie(), klient.getNazwisko(), klient.getNrTelefonu(), klient.getAktywnaUmowa(), klient.getNrDowodu(), klient.getPesel(), klient.getNrPaszportu(), klient.getNrAdresu(), klient.getEmail(), klient.getHaslo(), klient.getAuthority(), klient.getCzyAktywne(), klient.getNrKlienta());
    }
    public void delete(int id) {
        String sql = "DELETE FROM KLIENCI WHERE nr_klienta = ?";
        jdbcTemplate.update(sql, id);
    }
}
