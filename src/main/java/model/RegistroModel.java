package model;

import banco.BancoConexao;
import entidade.Registro;
import org.springframework.jdbc.core.JdbcTemplate;

public class RegistroModel {
    public void inserirRegistroMySql(Registro registro, Integer fkEspecificacaoMaquina){
        BancoConexao bancoConexao = new BancoConexao();
        JdbcTemplate conn = bancoConexao.mysqlJdbcTemplate(bancoConexao.mysqlDataSource());

        conn.update("INSERT INTO registro VALUES (null, default, ?, ?, ?, ?, ?)", registro.getCpuPorcentagemUso(),
                registro.getDiscoDisponivel() ,registro.getRamUtilizada(),registro.getQtdDispositivosConectados(),
                fkEspecificacaoMaquina);
    }

    public void inserirDadosRegistroSqlServer(Registro registro, Integer fkEspecificacaoMaquina){
        BancoConexao bancoConexao = new BancoConexao();
        JdbcTemplate connSqlServer = bancoConexao.sqlServerJdbcTemplate(bancoConexao.sqlServerDataSource());

        connSqlServer.update("INSERT INTO registro (dtHora, cpuPorcentagemUso, discoDisponivel, ramUtilizada," +
                        " qtdDispositivos, fkEspecificacaoMaquina) VALUES (default, ?, ?, ?, ?, ?)",
                registro.getCpuPorcentagemUso(),
                registro.getDiscoDisponivel(),
                registro.getRamUtilizada(),
                registro.getQtdDispositivosConectados(),
                fkEspecificacaoMaquina);
    }
}
