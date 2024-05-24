package model;

import banco.BancoConexao;
import entidade.Registro;
import org.springframework.jdbc.core.JdbcTemplate;

public class RegistroModel {
    public void inserirDadosRegistro(Registro registro){
        BancoConexao bancoConexao = new BancoConexao();
        JdbcTemplate conn = bancoConexao.getBancoConexao();

        conn.update("INSERT INTO registro VALUES (null, default, ?, ?, ?, ?, ?, ?, ?)", registro.getDiscoGigabyteLeitura(), registro.getDiscoGigabyteEscrita(), registro.getCpuPorcentagemUso(),
                registro.getCpuTemperatura(), registro.getRamUtilizada(),
                registro.getQtdDispositivosConectados(), registro.getFkEspecificacaoMaquina());
    }
}
