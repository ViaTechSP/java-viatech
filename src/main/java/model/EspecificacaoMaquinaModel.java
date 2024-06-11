package model;

import banco.MysqlBancoConexao;
import banco.SqlServerBancoConexao;
import entidade.EspecificacaoMaquina;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class EspecificacaoMaquinaModel {
    public void inserirDadosEspecificacaoMySql(EspecificacaoMaquina especificacaoMaquina) {
        MysqlBancoConexao bancoConexao = new MysqlBancoConexao();
        JdbcTemplate connMySql = bancoConexao.getJdbcTemplate();

        connMySql.update("INSERT INTO especificacaoMaquina VALUES (null, ?, ?, ?, ?)", especificacaoMaquina.getNomeCpu(),
                especificacaoMaquina.getArmazenamentoTotal(),
                especificacaoMaquina.getRamTotal(), especificacaoMaquina.getFkMaquina());
    }

    public void inserirDadosEspecificacaoSqlServer(EspecificacaoMaquina especificacaoMaquina) {
        SqlServerBancoConexao bancoConexao = new SqlServerBancoConexao();
        JdbcTemplate connSqlServer = bancoConexao.getJdbcTemplate();

        connSqlServer.update("INSERT INTO especificacaoMaquina (nomeCpu, armazenamentoTotal, ramTotal, fkMaquina) VALUES (?, ?, ?, ?)",
                especificacaoMaquina.getNomeCpu(),
                especificacaoMaquina.getArmazenamentoTotal(),
                especificacaoMaquina.getRamTotal(),
                especificacaoMaquina.getFkMaquina());
    }

    public EspecificacaoMaquina verificarExistenciaMaquinaMySql(Integer fkMaquina){
        MysqlBancoConexao bancoConexao = new MysqlBancoConexao();
        JdbcTemplate connMySql = bancoConexao.getJdbcTemplate();

        try{
            String query = "SELECT * FROM especificacaoMaquina WHERE fkMaquina = ?";
            return connMySql.queryForObject(query, new BeanPropertyRowMapper<>(EspecificacaoMaquina.class), fkMaquina);
        } catch (Exception e){
            return null;
        }
    }

    public EspecificacaoMaquina verificarExistenciaMaquinaSqlServer(Integer fkMaquina){
        SqlServerBancoConexao bancoConexao = new SqlServerBancoConexao();
        JdbcTemplate connSqlServer = bancoConexao.getJdbcTemplate();

        try{
            String query = "SELECT * FROM especificacaoMaquina WHERE fkMaquina = ?";
            return connSqlServer.queryForObject(query, new BeanPropertyRowMapper<>(EspecificacaoMaquina.class), fkMaquina);
        } catch (Exception e){
            return null;
        }
    }
}
