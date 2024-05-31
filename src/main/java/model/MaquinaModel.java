package model;

import banco.BancoConexao;
import entidade.Maquina;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class MaquinaModel {

    public Maquina exibirMaquinaMySql(String dominio){
        BancoConexao bancoConexao = new BancoConexao();
        JdbcTemplate connMySql = bancoConexao.mysqlJdbcTemplate(bancoConexao.mysqlDataSource());

        try{
            String query = "SELECT * FROM maquina WHERE dominio = ?";
            return connMySql.queryForObject(query, new BeanPropertyRowMapper<>(Maquina.class), dominio);
        } catch (Exception e){
            return null;
        }
    }
    public void inserirMaquinaMySql(Maquina maquina, Integer idEstacao){
        BancoConexao bancoConexao = new BancoConexao();
        JdbcTemplate connMySql = bancoConexao.mysqlJdbcTemplate(bancoConexao.mysqlDataSource());

        String query = "INSERT INTO maquina VALUES (null, ?, ?, ?, ?)";
        connMySql.update(query, maquina.getDominio(), maquina.getIp(), maquina.getSistemaOperacional(), idEstacao);
    }

    public Maquina exibirMaquinaSqlServer(String dominio){
        BancoConexao bancoConexao = new BancoConexao();
        JdbcTemplate connSqlServer = bancoConexao.sqlServerJdbcTemplate(bancoConexao.sqlServerDataSource());

        try{
            String query = "SELECT * FROM maquina WHERE dominio = ?";
            return connSqlServer.queryForObject(query, new BeanPropertyRowMapper<>(Maquina.class), dominio);
        } catch (Exception e){
            return null;
        }
    }

    public void inserirMaquinaSqlServer(Maquina maquina, Integer idEstacao){
        BancoConexao bancoConexao = new BancoConexao();
        JdbcTemplate connSqlServer = bancoConexao.sqlServerJdbcTemplate(bancoConexao.sqlServerDataSource());

        String query = "INSERT INTO maquina (dominio, ip, sistemaOperacional, fkEstacao) VALUES (?, ?, ?, ?)";
        connSqlServer.update(query, maquina.getDominio(), maquina.getIp(), maquina.getSistemaOperacional(), idEstacao);
    }

}
