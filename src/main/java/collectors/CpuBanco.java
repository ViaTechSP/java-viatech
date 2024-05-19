package collectors;

import Banco.BancoConexao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CpuBanco {

    public static void cadastrarDados() throws ClassNotFoundException {

        CpuCollector processador = new CpuCollector();

        String sql = "INSERT INTO processador (nomeCPU, cpuFisica, cpuLogica, frequencia) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = BancoConexao.getbancoConexao().prepareStatement(sql);
            ps.setString(1, processador.getNomeCpu());
            ps.setString(2, processador.getCpuFisica());
            ps.setString(3, processador.getCpuLogica());
            ps.setString(4, String.valueOf(processador.getFrequencia()));
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

