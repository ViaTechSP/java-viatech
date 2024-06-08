package model;

import banco.BancoConexao;
import org.springframework.jdbc.core.JdbcTemplate;

public class HistoricoAlertaModel {
    public void inserirHistoricoAlertaMySql(String tipo, String componente, Double valor, Integer fkRegistro){
        BancoConexao bancoConexao = new BancoConexao();
        JdbcTemplate conn = bancoConexao.mysqlJdbcTemplate(bancoConexao.mysqlDataSource());

        String query = "INSERT into historicoAlerta VALUES (null, default, ?, ?, ?, ?)";
        conn.update(query, tipo, componente, valor, fkRegistro);
    }

    public void inserirHistoricoAlertaSqlServer(String tipo, String componente, Double valor, Integer fkRegistro){
        BancoConexao bancoConexao = new BancoConexao();
        JdbcTemplate conn = bancoConexao.sqlServerJdbcTemplate(bancoConexao.sqlServerDataSource());

        String query = "INSERT into historicoAlerta (tipo, componente, valorRegistrado, fkRegistro) VALUES (?, ?, ?, ?)";
        conn.update(query, tipo, componente, valor, fkRegistro);
    }
}
