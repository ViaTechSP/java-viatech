package collectors;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.dispositivos.DispositivoUsb;

import java.util.ArrayList;
import java.util.List;

public class UsbCollector {
    Looca looca = new Looca();


    private String quantidadeUsb;
    private String dispositivoConectado;



    public String getQuantidadeUsb() {
        return quantidadeUsb = String.valueOf(looca.getDispositivosUsbGrupo().getTotalDispositvosUsbConectados());
    }

    public void setQuantidadeUsb(String quantidadeUsb) {
        this.quantidadeUsb = quantidadeUsb;
    }

    public String getDispositivoConectado() {
        return dispositivoConectado = String.valueOf(looca.getDispositivosUsbGrupo().getDispositivosUsbConectados());
    }

    public void setDispositivoConectado(String dispositivoConectado) {
        this.dispositivoConectado = dispositivoConectado;
    }









    public Integer getQuantidadeUsbConectados() {
        return looca.getDispositivosUsbGrupo().getTotalDispositvosUsbConectados();
    }

    public Integer getQuantidadeUsbMaquina() {
        return looca.getDispositivosUsbGrupo().getTotalDispositvosUsb();
    }

    public List<DispositivoUsb> getDispositivosUsbConectados () {
        return looca.getDispositivosUsbGrupo().getDispositivosUsbConectados();
    }

    public List<DispositivoUsb> getDispositivosUsb() {
        return looca.getDispositivosUsbGrupo().getDispositivosUsb();
    }

    public List<String> getNomeDosDispositivos() {
        List<String> nomesDispositivos = new ArrayList<>();
        for (int i = 0; i < looca.getDispositivosUsbGrupo().getDispositivosUsb().size(); i++) {
            nomesDispositivos.add(looca.getDispositivosUsbGrupo().getDispositivosUsb().get(i).getNome());
        }
        return nomesDispositivos;
    }
}
