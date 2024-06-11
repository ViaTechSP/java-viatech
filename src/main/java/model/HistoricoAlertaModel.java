package model;

import banco.MysqlBancoConexao;
import banco.SqlServerBancoConexao;
import org.springframework.jdbc.core.JdbcTemplate;

public class HistoricoAlertaModel {
    public void inserirHistoricoAlertaMySql(String tipo, String componente, Double valor, Integer fkRegistro){
        MysqlBancoConexao bancoConexao = new MysqlBancoConexao();
        JdbcTemplate connMySql = bancoConexao.getJdbcTemplate();

        String query = "INSERT into historicoAlerta VALUES (null, default, ?, ?, ?, ?)";
        connMySql.update(query, tipo, componente, valor, fkRegistro);
    }

    public void inserirHistoricoAlertaSqlServer(String tipo, String componente, Double valor, Integer fkRegistro){
        SqlServerBancoConexao bancoConexao = new SqlServerBancoConexao();
        JdbcTemplate connSqlServer = bancoConexao.getJdbcTemplate();

        String query = "INSERT into historicoAlerta (tipo, componente, valorRegistrado, fkRegistro) VALUES (?, ?, ?, ?)";
        connSqlServer.update(query, tipo, componente, valor, fkRegistro);
    }
}
