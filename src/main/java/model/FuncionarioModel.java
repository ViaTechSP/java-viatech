package model;

import banco.BancoConexao;
import entidade.Funcionario;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class FuncionarioModel {
    public Funcionario buscarFuncionario(String email, String senha) {
        BancoConexao bancoConexao = new BancoConexao();
        JdbcTemplate connSqlServer = bancoConexao.sqlServerJdbcTemplate(bancoConexao.sqlServerDataSource());
        JdbcTemplate connMySql = bancoConexao.mysqlJdbcTemplate(bancoConexao.mysqlDataSource());

        String querySqlServer = "SELECT * FROM funcionario WHERE email = ? AND senha = ?";
        try {
            return connSqlServer.queryForObject(querySqlServer, new BeanPropertyRowMapper<>(Funcionario.class), email, senha);
        } catch (EmptyResultDataAccessException e) {
            // Se não encontrar no SQL Server, tenta buscar no MySQL
            try{
            String queryMySql = "SELECT * FROM funcionario WHERE email = ? AND senha = ?";
            return connMySql.queryForObject(queryMySql, new BeanPropertyRowMapper<>(Funcionario.class), email, senha);
        } catch (EmptyResultDataAccessException ex) {
            return null; // Retorna null se não encontrar em nenhum dos bancos
        }

    }}}
