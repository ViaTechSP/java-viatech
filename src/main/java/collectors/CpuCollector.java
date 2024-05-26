package collectors;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.sistema.Sistema;

public class CpuCollector {

    Looca looca = new Looca();
    Sistema sistema = new Sistema();

    public String getNomeCpu() {
        return looca.getProcessador().getNome();
    }

    public Integer getCpuFisica() {
        return looca.getProcessador().getNumeroCpusFisicas();
    }

    public Integer getCpuLogica() {
        return looca.getProcessador().getNumeroCpusLogicas();
    }

    public Double getUsoCpu() {
        return Math.round(looca.getProcessador().getUso())+1D;
    }

    public Double getFrequencia() {
        return looca.getProcessador().getFrequencia() / 1e9;
    }




}