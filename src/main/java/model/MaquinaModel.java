package model;

import banco.BancoConexao;
import entidade.Maquina;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class MaquinaModel {
    public void inserirMaquina(Maquina maquina){
        BancoConexao bancoConexao = new BancoConexao();
        JdbcTemplate conn = bancoConexao.getBancoConexao();

        String query = "INSERT INTO maquina VALUES (null, ?, ?, ?, 1)";
        conn.update(query, maquina.getDominio(), maquina.getIp(), maquina.getSistemaOperacional());
    }

    public Maquina exibirMaquina (Maquina maquina){
        BancoConexao bancoConexao = new BancoConexao();
        JdbcTemplate conn = bancoConexao.getBancoConexao();

        try{
            String query = "SELECT * FROM maquina WHERE dominio = ?";
            return conn.queryForObject(query, new BeanPropertyRowMapper<>(Maquina.class), maquina.getDominio());
        } catch (Exception e){
            return null;
        }
    }
}
