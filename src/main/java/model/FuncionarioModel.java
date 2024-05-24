package model;

import banco.BancoConexao;
import entidade.Funcionario;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class FuncionarioModel {
    public Funcionario buscarFuncionario(Funcionario funcionario) {
        BancoConexao bancoConexao = new BancoConexao();
        JdbcTemplate conn = bancoConexao.getBancoConexao();

        String query = "SELECT * FROM funcionario WHERE email = ? AND senha = ?";
        return conn.queryForObject(query, new BeanPropertyRowMapper<>(Funcionario.class), funcionario.getEmail(), funcionario.getSenha());
    }

}
