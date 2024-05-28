package model;

import alerta.SlackConfig;
import banco.BancoConexao;
import entidade.EspecificacaoMaquina;
import entidade.HistoricoAlerta;
import entidade.Metrica;
import entidade.Registro;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;

public class SlackModel {
    BancoConexao bancoConexao = new BancoConexao();
    JdbcTemplate conn = bancoConexao.getBancoConexao();
    SlackConfig slackConfig = new SlackConfig();
    HistoricoAlertaModel historicoAlertaModel = new HistoricoAlertaModel();

    public void verificarRegistro(Registro registro, EspecificacaoMaquina especificacaoMaquina){
        Metrica metrica = buscarMetrica(registro.getFkEspecificacaoMaquina());

        verificarCpu(registro, registro.getCpuPorcentagemUso(), metrica);
        verificarRam(registro, metrica, especificacaoMaquina);
        verificarDisco(registro,registro.getDiscoDisponivel(), metrica);
    }

    public Metrica buscarMetrica(Integer fkMaquina) {
        BancoConexao bancoConexao = new BancoConexao();
        JdbcTemplate conn = bancoConexao.getBancoConexao();

        String query = "SELECT * FROM metrica WHERE fkMaquina = ?";
        return conn.queryForObject(query, new BeanPropertyRowMapper<>(Metrica.class), fkMaquina);
    }

    private void enviarMensagem(String mensagem, String channel){
        try {
            slackConfig.sendMessage(mensagem, channel);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void verificarCpu(Registro registro, Double porcentagemDeUsoDaCpu, Metrica metrica){

        if (porcentagemDeUsoDaCpu > metrica.getCuidadoCpu()){
            enviarMensagem("CUIDADO com o uso da CPU!", "#cpu");
            historicoAlertaModel.inserirHistoricoAlerta("cuidado", "cpu", porcentagemDeUsoDaCpu, registro.getIdRegistro());
        } else if (porcentagemDeUsoDaCpu > metrica.getProblemaCpu()){
            enviarMensagem("PROBLEMA no uso da CPU!", "#cpu");
            historicoAlertaModel.inserirHistoricoAlerta("problema", "cpu", porcentagemDeUsoDaCpu, registro.getIdRegistro());
        }
    }

    private void verificarRam(Registro registro, Metrica metrica, EspecificacaoMaquina especificacaoMaquina){
        Double porcentagemRam = registro.getRamUtilizada() / especificacaoMaquina.getRamTotal() * 100;

        if (porcentagemRam > metrica.getCuidadoRam()){
            enviarMensagem("CUIDADO com o uso da RAM!", "#ram");
            historicoAlertaModel.inserirHistoricoAlerta("cuidado", "ram", porcentagemRam, registro.getIdRegistro());
        } else if (porcentagemRam > metrica.getProblemaRam()){
            enviarMensagem("PROBLEMA no uso da RAM!", "#ram");
            historicoAlertaModel.inserirHistoricoAlerta("problema", "ram", porcentagemRam, registro.getIdRegistro());
        }
    }

    private void verificarDisco(Registro registro, Double discoDisponivel, Metrica metrica){
        if (discoDisponivel < metrica.getCuidadoDisco()){
            enviarMensagem("CUIDADO com o espaço disponível!", "#disco");
            historicoAlertaModel.inserirHistoricoAlerta("cuidado", "disco", discoDisponivel, registro.getIdRegistro());
        } else if (discoDisponivel < metrica.getProblemaDisco()){
            historicoAlertaModel.inserirHistoricoAlerta("problema", "disco", discoDisponivel, registro.getIdRegistro());
            enviarMensagem("PROBLEMA no espaço disponível!", "#disco");
        }
    }

    private void verificarUsb(Registro registro, Integer qtdUsb, Metrica metrica){
        if (qtdUsb >= metrica.getMaxUsb()){
            enviarMensagem("Limite de dispositivos USB excedido!", "#usb");
            historicoAlertaModel.inserirHistoricoAlerta("problema", "usb", Double.valueOf(qtdUsb), registro.getIdRegistro());
        }
    }
}
