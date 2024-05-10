package collectors;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.util.Conversor;

public class UsbColeta {

    public static void coletaDeUsb() throws ClassNotFoundException{
        Looca looca = new Looca();


        String quantidadeUsb = String.valueOf(looca.getDispositivosUsbGrupo().getTotalDispositvosUsbConectados());
        String dispositivoConectado = String.valueOf(looca.getDispositivosUsbGrupo().getDispositivosUsbConectados());

        UsbCollector metodoUsb = new UsbCollector();
        metodoUsb.setQuantidadeUsb(quantidadeUsb);
        metodoUsb.setDispositivoConectado(String.valueOf(metodoUsb));

        new UsbBanco().cadastrarDados(metodoUsb);

    }

}
