package model;

import banco.MysqlBancoConexao;
import banco.SqlServerBancoConexao;
import entidade.Registro;
import entidade.Slack;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Map;
import java.util.Objects;

public class RegistroModel {
    public int inserirRegistroMySql(Registro registro, Integer fkEspecificacaoMaquina) {
        MysqlBancoConexao bancoConexao = new MysqlBancoConexao();
        JdbcTemplate connMySql = bancoConexao.getJdbcTemplate();

        KeyHolder keyHolder = new GeneratedKeyHolder();
        connMySql.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO registro VALUES (null, default, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setObject(1, registro.getCpuUtilizada());
            ps.setObject(2, registro.getDiscoDisponivel());
            ps.setObject(3, registro.getRamUtilizada());
            ps.setObject(4, registro.getQtdDispositivosUsb());
            ps.setObject(5, fkEspecificacaoMaquina);
            return ps;
        }, keyHolder);

        return Objects.requireNonNull(keyHolder.getKey()).intValue();
    }


    public int inserirDadosRegistroSqlServer(Registro registro, Integer fkEspecificacaoMaquina) {
        SqlServerBancoConexao bancoConexao = new SqlServerBancoConexao();
        JdbcTemplate connSqlServer = bancoConexao.getJdbcTemplate();

        connSqlServer.update("INSERT INTO registro (dtHora, cpuUtilizada, discoDisponivel, ramUtilizada, qtdDispositivosUsb, fkEspecificacaoMaquina) " +
                        "VALUES (default, ?, ?, ?, ?, ?)", registro.getCpuUtilizada(), registro.getDiscoDisponivel(),
                registro.getRamUtilizada(), registro.getQtdDispositivosUsb(), fkEspecificacaoMaquina);

        // Recuperando o último ID inserido
        Map<String, Object> result = connSqlServer.queryForMap("SELECT IDENT_CURRENT('registro') as last_id");
        return ((Number) result.get("last_id")).intValue();
    }



    public String buscarTokenBot(){
        SqlServerBancoConexao bancoConexao = new SqlServerBancoConexao();
        JdbcTemplate connSqlServer = bancoConexao.getJdbcTemplate();

        String query = "SELECT slack.token FROM slack";
        return connSqlServer.queryForObject(query, new BeanPropertyRowMapper<>(Slack.class)).getToken();
    }
}
