package collectors;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.sistema.Sistema;

public class CpuCollector {

    Looca looca = new Looca();
    Sistema sistema = new Sistema();

    public String getNomeCpu() {
        return looca.getProcessador().getNome();
    }

    public String getCpuFisica() {
        return String.valueOf(looca.getProcessador().getNumeroCpusFisicas());
    }



    public String getCpuLogica() {
        return String.valueOf(looca.getProcessador().getNumeroCpusLogicas());
    }

    public Double getUsoCpu() {
        return looca.getProcessador().getUso();
    }

    public String getFrequencia() {
        return String.valueOf(looca.getProcessador().getFrequencia() / 1e9);
    }




}