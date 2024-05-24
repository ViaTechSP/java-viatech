package model;

import banco.BancoConexao;
import entidade.EspecificacaoMaquina;
import org.springframework.jdbc.core.JdbcTemplate;

public class EspecificacaoMaquinaModel {
    public void inserirDadosEspecificacao(EspecificacaoMaquina especificacaoMaquina) {
        BancoConexao bancoConexao = new BancoConexao();
        JdbcTemplate conn = bancoConexao.getBancoConexao();

        conn.update("INSERT INTO especificacaoMaquina VALUES (null, ?, ?, ?, ?, ?, ?, ?)", especificacaoMaquina.getNomeCpu(), especificacaoMaquina.getFrequenciaCpu(), especificacaoMaquina.getQtdCpuFisica(),
                especificacaoMaquina.getQtdCpuLogica(), especificacaoMaquina.getCapacidadeTotalArmazenamento(),
                especificacaoMaquina.getRamTotal(), especificacaoMaquina.getFkMaquina());

    }
}
