package model;

import banco.BancoConexao;
import entidade.HistoricoAlerta;
import entidade.Registro;
import org.springframework.jdbc.core.JdbcTemplate;

public class HistoricoAlertaModel {
    public void inserirHistoricoAlerta(String tipo, String componente, Double valor, Integer fkRegistro){
        BancoConexao bancoConexao = new BancoConexao();
        JdbcTemplate conn = bancoConexao.mysqlJdbcTemplate(bancoConexao.mysqlDataSource());

        String query = "INSERT into historicoAlerta VALUES (null, default, ?, ?, ?, ?)";
        conn.update(query, tipo, componente, valor, fkRegistro);
    }
}
