package collectors;

import Banco.BancoConexao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsbBanco {

    public void cadastrarDados(UsbCollector metodoUsb) throws ClassNotFoundException{

        String sql = "INSERT INTO usb (quantidadeUsb, dispositivoConectado) VALUES (?, ?)";

        PreparedStatement ps = null;

        try {
            ps = BancoConexao.getbancoConexao().prepareStatement(sql);
            ps.setString(1, metodoUsb.getQuantidadeUsb());
            ps.setString(2, metodoUsb.getDispositivoConectado());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
