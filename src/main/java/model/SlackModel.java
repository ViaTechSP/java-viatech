package model;

import alerta.SlackConfig;
import banco.BancoConexao;
import entidade.Funcionario;
import entidade.Maquina;
import entidade.Registro;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;

public class SlackModel {
    Registro registro = new Registro();
    BancoConexao bancoConexao = new BancoConexao();
    JdbcTemplate conn = bancoConexao.getBancoConexao();
    SlackConfig slackConfig = new SlackConfig();

    public void verificarRegistro(Registro registro, Maquina maquina){
        verificarCpu(registro.getCpuPorcentagemUso(), buscarMetrica(null, maquina.getIdMaquina()));

    }

    public Funcionario buscarMetrica(Funcionario funcionario, Integer idMaquina) {
        BancoConexao bancoConexao = new BancoConexao();
        JdbcTemplate conn = bancoConexao.getBancoConexao();

        String query = "SELECT * FROM metrica WHERE fkMaquina = ?";
        return conn.queryForObject(query, new BeanPropertyRowMapper<>(Funcionario.class), idMaquina);
    }

    private void enviarMensagem(String mensagem, String channel){
        try {
            slackConfig.sendMessage(mensagem, channel);
        } catch (Exception e) {
            System.out.println("ERRO.");
        }
    }

    private void verificarCpu(Double porcentagemDeUsoDaCpu, Funcionario funcionario){
        if (porcentagemDeUsoDaCpu > funcionario.getId()){
            enviarMensagem("% CPU maior que", "#cpu");
        }
    }
}
