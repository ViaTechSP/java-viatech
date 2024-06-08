package model;

import banco.BancoConexao;
import entidade.EspecificacaoMaquina;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class EspecificacaoMaquinaModel {
    public void inserirDadosEspecificacaoMySql(EspecificacaoMaquina especificacaoMaquina) {
        BancoConexao bancoConexao = new BancoConexao();
        JdbcTemplate connMySql = bancoConexao.mysqlJdbcTemplate(bancoConexao.mysqlDataSource());

        connMySql.update("INSERT INTO especificacaoMaquina VALUES (null, ?, ?, ?, ?)", especificacaoMaquina.getNomeCpu(),
                especificacaoMaquina.getArmazenamentoTotal(),
                especificacaoMaquina.getRamTotal(), especificacaoMaquina.getFkMaquina());
    }

    public void inserirDadosEspecificacaoSqlServer(EspecificacaoMaquina especificacaoMaquina) {
        BancoConexao bancoConexao = new BancoConexao();
        JdbcTemplate connSqlServer = bancoConexao.sqlServerJdbcTemplate(bancoConexao.sqlServerDataSource());

        connSqlServer.update("INSERT INTO especificacaoMaquina (nomeCpu, armazenamentoTotal, ramTotal, fkMaquina) VALUES (?, ?, ?, ?)",
                especificacaoMaquina.getNomeCpu(),
                especificacaoMaquina.getArmazenamentoTotal(),
                especificacaoMaquina.getRamTotal(),
                especificacaoMaquina.getFkMaquina());
    }

    public EspecificacaoMaquina verificarExistenciaMaquinaMySql(Integer fkMaquina){
        BancoConexao bancoConexao = new BancoConexao();
        JdbcTemplate connMySql = bancoConexao.mysqlJdbcTemplate(bancoConexao.mysqlDataSource());

        try{
            String query = "SELECT * FROM especificacaoMaquina WHERE fkMaquina = ?";
            return connMySql.queryForObject(query, new BeanPropertyRowMapper<>(EspecificacaoMaquina.class), fkMaquina);
        } catch (Exception e){
            return null;
        }
    }

    public EspecificacaoMaquina verificarExistenciaMaquinaSqlServer(Integer fkMaquina){
        BancoConexao bancoConexao = new BancoConexao();
        JdbcTemplate connSqlServer = bancoConexao.sqlServerJdbcTemplate(bancoConexao.sqlServerDataSource());

        try{
            String query = "SELECT * FROM especificacaoMaquina WHERE fkMaquina = ?";
            return connSqlServer.queryForObject(query, new BeanPropertyRowMapper<>(EspecificacaoMaquina.class), fkMaquina);
        } catch (Exception e){
            return null;
        }
    }
}
