package model;

import banco.BancoConexao;
import entidade.Estacao;
import entidade.Maquina;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.List;

public class EstacaoModel {

    public List<Estacao> listaEstacoesDisponiveis (){
        BancoConexao bancoConexao = new BancoConexao();
        JdbcTemplate conn = bancoConexao.mysqlJdbcTemplate(bancoConexao.mysqlDataSource());

        try {
            String query = "SELECT e.nome, e.idEstacao FROM estacao AS e " +
                    "LEFT JOIN maquina AS m ON m.fkEstacao = e.idEstacao " +
                    "WHERE m.idMaquina IS NULL";
            RowMapper<Estacao> rowMapper = new BeanPropertyRowMapper<>(Estacao.class);
            return conn.query(query, rowMapper);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
