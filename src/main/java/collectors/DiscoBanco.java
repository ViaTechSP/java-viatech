package collectors;

import Banco.BancoConexao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DiscoBanco {

    public static void cadastrarDados() {

        DiscoCollector Disco = new DiscoCollector();

        String sql = "INSERT INTO disco (quantidadeDisco, gigabytesLeitura, gigabytesEscrita, totalGigabytes) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = BancoConexao.getbancoConexao().prepareStatement(sql);
            ps.setString(1, String.valueOf(Disco.getQuantidadeDisco()));
            ps.setString(2, Disco.getGigabytesLeituras());
            ps.setString(3, Disco.getGigabytesEscritas());
            ps.setString(4, Disco.getTotalGigabytesDisco());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}


