package model;

import banco.MysqlBancoConexao;
import banco.SqlServerBancoConexao;
import entidade.Maquina;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class MaquinaModel {

    public Maquina exibirMaquinaMySql(String dominio){
        MysqlBancoConexao bancoConexao = new MysqlBancoConexao();
        JdbcTemplate connMySql = bancoConexao.getJdbcTemplate();

        try{
            String query = "SELECT * FROM maquina WHERE dominio = ?";
            return connMySql.queryForObject(query, new BeanPropertyRowMapper<>(Maquina.class), dominio);
        } catch (Exception e){
            return null;
        }
    }
    public void inserirMaquinaMySql(Maquina maquina, Integer idEstacao){
        MysqlBancoConexao bancoConexao = new MysqlBancoConexao();
        JdbcTemplate connMySql = bancoConexao.getJdbcTemplate();

        String query = "INSERT INTO maquina VALUES (null, ?, ?, ?, ?)";
        connMySql.update(query, maquina.getDominio(), maquina.getIp(), maquina.getSistemaOperacional(), idEstacao);
    }

    public Maquina exibirMaquinaSqlServer(String dominio){
        SqlServerBancoConexao bancoConexao = new SqlServerBancoConexao();
        JdbcTemplate connSqlServer = bancoConexao.getJdbcTemplate();

        try{
            String query = "SELECT * FROM maquina WHERE dominio = ?";
            return connSqlServer.queryForObject(query, new BeanPropertyRowMapper<>(Maquina.class), dominio);
        } catch (Exception e){
            return null;
        }
    }

    public void inserirMaquinaSqlServer(Maquina maquina, Integer idEstacao){
        SqlServerBancoConexao bancoConexao = new SqlServerBancoConexao();
        JdbcTemplate connSqlServer = bancoConexao.getJdbcTemplate();

        String query = "INSERT INTO maquina (dominio, ip, sistemaOperacional, fkEstacao) VALUES (?, ?, ?, ?)";
        connSqlServer.update(query, maquina.getDominio(), maquina.getIp(), maquina.getSistemaOperacional(), idEstacao);
    }

}
