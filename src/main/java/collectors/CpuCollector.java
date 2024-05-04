package collectors;

import com.github.britooo.looca.api.core.Looca;
public class CpuCollector {

    Looca looca = new Looca();

    public Double getProcessadorEmUso() {
        return looca.getProcessador().getUso();
    }

    public Double getFrequenciaProcessador() {
        return looca.getProcessador().getFrequencia() / 1e9;
    }

    public String getNomeProcessador() {
        return looca.getProcessador().getNome();
    }



}
