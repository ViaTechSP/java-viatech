package collectors;
import Banco.BancoConexao;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.util.Conversor;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RamBanco {

    public static void cadastrarDados() throws ClassNotFoundException {

        RamCollector metodoRam = new RamCollector();

        String sql = "INSERT INTO ram (memoriaDisponivel, memoriaTotal, memoriaUtilizada) VALUES (?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = BancoConexao.getbancoConexao().prepareStatement(sql);
            ps.setString(1, metodoRam.getDisponivel());
            ps.setString(2, metodoRam.getMemoriaTotal());
            ps.setString(3, metodoRam.getMemoriaTotal());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

