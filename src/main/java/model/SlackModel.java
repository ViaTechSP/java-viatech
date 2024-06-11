package model;

import alerta.SlackConfig;
import banco.SqlServerBancoConexao;
import entidade.EspecificacaoMaquina;
import entidade.Metrica;
import entidade.Registro;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class SlackModel {
    SqlServerBancoConexao bancoConexao = new SqlServerBancoConexao();
    JdbcTemplate connSqlServer = bancoConexao.getJdbcTemplate();
    SlackConfig slackConfig = new SlackConfig();
    HistoricoAlertaModel historicoAlertaModel = new HistoricoAlertaModel();

    public void verificarRegistro(Registro registro, Integer idUltimoRegistroMySql, Integer idUltimoRegistroSqlServer, EspecificacaoMaquina especificacaoMaquina){
        Metrica metrica = buscarMetrica(especificacaoMaquina.getFkMaquina());

        verificarCpu(idUltimoRegistroMySql, idUltimoRegistroSqlServer, registro.getCpuUtilizada(), metrica);
        verificarRam(idUltimoRegistroMySql, idUltimoRegistroSqlServer, registro.getRamUtilizada(), metrica, especificacaoMaquina);
        verificarDisco(idUltimoRegistroMySql, idUltimoRegistroSqlServer, registro.getDiscoDisponivel(), metrica);
        verificarUsb(idUltimoRegistroMySql, idUltimoRegistroSqlServer, registro.getQtdDispositivosUsb(), metrica);
    }

    public Metrica buscarMetrica(Integer fkMaquina) {
        String query = "SELECT m.* FROM metrica as m\n" +
                "JOIN linha AS l on l.idLinha = m.fkLinha \n" +
                "JOIN estacao AS e on e.fkLinha = l.idLinha\n" +
                "JOIN maquina AS maq on e.idEstacao = maq.fkEstacao WHERE idMaquina = ?;";
        return connSqlServer.queryForObject(query, new BeanPropertyRowMapper<>(Metrica.class), fkMaquina);
    }

    private void enviarMensagem(String mensagem, String channel){
        try {
            slackConfig.sendMessage(mensagem, channel);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void verificarCpu(Integer idUltimoRegistroMySql, Integer idUltimoRegistroSqlServer, Double porcentagemDeUsoDaCpu, Metrica metrica){

        if (porcentagemDeUsoDaCpu >= metrica.getProblemaCpu()){
            enviarMensagem("PROBLEMA no uso da CPU!", "#cpu");

            historicoAlertaModel.inserirHistoricoAlertaMySql("problema", "cpu", porcentagemDeUsoDaCpu, idUltimoRegistroMySql);
            historicoAlertaModel.inserirHistoricoAlertaSqlServer("problema", "cpu", porcentagemDeUsoDaCpu, idUltimoRegistroSqlServer);
        } else if (porcentagemDeUsoDaCpu >= metrica.getCuidadoCpu()){
            enviarMensagem("CUIDADO com o uso da CPU!", "#cpu");

            historicoAlertaModel.inserirHistoricoAlertaMySql("cuidado", "cpu", porcentagemDeUsoDaCpu, idUltimoRegistroMySql);
            historicoAlertaModel.inserirHistoricoAlertaSqlServer("cuidado", "cpu", porcentagemDeUsoDaCpu, idUltimoRegistroSqlServer);
        }
    }

    private void verificarRam(Integer idUltimoRegistroMySql, Integer idUltimoRegistroSqlServer, Double ramUtilizada, Metrica metrica, EspecificacaoMaquina especificacaoMaquina){
        Double porcentagemRam = ramUtilizada / especificacaoMaquina.getRamTotal() * 100;

        if (porcentagemRam >= metrica.getProblemaRam()){
            enviarMensagem("PROBLEMA no uso da RAM!", "#ram");

            historicoAlertaModel.inserirHistoricoAlertaMySql("problema", "ram", porcentagemRam, idUltimoRegistroMySql);
            historicoAlertaModel.inserirHistoricoAlertaSqlServer("problema", "ram", porcentagemRam, idUltimoRegistroSqlServer);
        } else if (porcentagemRam >= metrica.getCuidadoRam()){
            enviarMensagem("CUIDADO com o uso da RAM!", "#ram");

            historicoAlertaModel.inserirHistoricoAlertaMySql("cuidado", "ram", porcentagemRam, idUltimoRegistroMySql);
            historicoAlertaModel.inserirHistoricoAlertaSqlServer("cuidado", "ram", porcentagemRam, idUltimoRegistroSqlServer);
        }
    }

    private void verificarDisco(Integer idUltimoRegistroMySql, Integer idUltimoRegistroSqlServer, Double discoDisponivel, Metrica metrica){
        if (discoDisponivel <= metrica.getProblemaDisco()){
            enviarMensagem("PROBLEMA no espaço disponível!", "#disco");

            historicoAlertaModel.inserirHistoricoAlertaMySql("problema", "disco", discoDisponivel, idUltimoRegistroMySql);
            historicoAlertaModel.inserirHistoricoAlertaSqlServer("problema", "disco", discoDisponivel, idUltimoRegistroSqlServer);
        } else if (discoDisponivel <= metrica.getCuidadoDisco()){
            enviarMensagem("CUIDADO com o espaço disponível!", "#disco");

            historicoAlertaModel.inserirHistoricoAlertaMySql("cuidado", "disco", discoDisponivel, idUltimoRegistroMySql);
            historicoAlertaModel.inserirHistoricoAlertaSqlServer("cuidado", "disco", discoDisponivel, idUltimoRegistroSqlServer);

        }
    }

    private void verificarUsb(Integer idUltimoRegistroMySql, Integer idUltimoRegistroSqlServer, Integer qtdUsb, Metrica metrica){
        if (qtdUsb > metrica.getMaxUsb()){
            enviarMensagem("Limite de dispositivos USB excedido!", "#usb");

            historicoAlertaModel.inserirHistoricoAlertaMySql("problema", "usb", Double.valueOf(qtdUsb), idUltimoRegistroMySql);
            historicoAlertaModel.inserirHistoricoAlertaSqlServer("problema", "usb", Double.valueOf(qtdUsb), idUltimoRegistroSqlServer);
        }
    }
}
