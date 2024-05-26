package model;

import banco.BancoConexao;
import entidade.EspecificacaoMaquina;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class EspecificacaoMaquinaModel {
    public void inserirDadosEspecificacao(EspecificacaoMaquina especificacaoMaquina) {
        BancoConexao bancoConexao = new BancoConexao();
        JdbcTemplate conn = bancoConexao.getBancoConexao();

        conn.update("INSERT INTO especificacaoMaquina VALUES (null, ?, ?, ?, ?, ?)", especificacaoMaquina.getNomeCpu(), especificacaoMaquina.getFrequenciaCpu(),
                especificacaoMaquina.getCapacidadeTotalArmazenamento(),
                especificacaoMaquina.getRamTotal(), especificacaoMaquina.getFkMaquina());
    }

    public EspecificacaoMaquina verificarExistenciaMaquina(EspecificacaoMaquina especificacaoMaquina){
        BancoConexao bancoConexao = new BancoConexao();
        JdbcTemplate conn = bancoConexao.getBancoConexao();

        try{
            String query = "SELECT * FROM especificacaoMaquina WHERE fkMaquina = ?";
            return conn.queryForObject(query, new BeanPropertyRowMapper<>(EspecificacaoMaquina.class), especificacaoMaquina.getFkMaquina());
        } catch (Exception e){
            return null;
        }
    }
}
