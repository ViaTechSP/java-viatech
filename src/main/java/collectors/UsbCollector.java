package collectors;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.dispositivos.DispositivoUsb;
import oshi.hardware.UsbDevice;

import java.util.ArrayList;
import java.util.List;

public class UsbCollector {
    Looca looca = new Looca();

    public Integer getQuantidadeUsbConectados() {
        return looca.getDispositivosUsbGrupo().getTotalDispositvosUsbConectados();
    }

    public List<String> getNome(){
        List<String> nomes = new ArrayList<>();
        for (DispositivoUsb dispositivoUsb : looca.getDispositivosUsbGrupo().getDispositivosUsb()){
            nomes.add(dispositivoUsb.getNome());
        }
        return nomes;
    }

    public List<String> getNomeDosDispositivosConectados() {
        List<String> nomesDispositivos = new ArrayList<>();
        for (int i = 0; i < looca.getDispositivosUsbGrupo().getDispositivosUsbConectados().size(); i++) {
            nomesDispositivos.add(looca.getDispositivosUsbGrupo().getDispositivosUsb().get(i).getNome());
        }
        return nomesDispositivos;
    }
}
