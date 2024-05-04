package collectors;

import com.github.britooo.looca.api.core.Looca;
public class CpuCollector {

    Looca looca = new Looca();

    public Integer getQtdCpusFisicas() {
        return looca.getProcessador().getNumeroCpusFisicas();
    }

    public Integer getQtdCpusLogicas() {
        return looca.getProcessador().getNumeroCpusLogicas();
    }

    public Double getFrequenciaProcessador() {
        return looca.getProcessador().getFrequencia() / 1e9;
    }

    public Double getProcessadorEmUso() {
        return looca.getProcessador().getUso();
    }

    public String getNomeProcessador() {
        return looca.getProcessador().getNome();
    }



}
