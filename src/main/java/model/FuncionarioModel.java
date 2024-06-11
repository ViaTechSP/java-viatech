package model;

import banco.SqlServerBancoConexao;
import entidade.Funcionario;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class FuncionarioModel {
    public Funcionario buscarFuncionario(Funcionario funcionario) {
        SqlServerBancoConexao bancoConexao = new SqlServerBancoConexao();
        JdbcTemplate connSqlServer = bancoConexao.getJdbcTemplate();

        String query = "SELECT * FROM funcionario WHERE email = ? AND senha = ?";
        return connSqlServer.queryForObject(query, new BeanPropertyRowMapper<>(Funcionario.class), funcionario.getEmail(), funcionario.getSenha());
    }
}
