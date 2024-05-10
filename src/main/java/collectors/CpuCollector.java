package collectors;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.sistema.Sistema;

public class CpuCollector {

    Looca looca = new Looca();
    Sistema sistema = new Sistema();

    private String nomeCpu;
    private String cpuFisica;
    private String cpuLogica;
    private String frequencia;


    public String getNomeCpu() {
        return nomeCpu = looca.getProcessador().getNome();
    }

    public void setNomeCpu(String nomeCpu) {
        this.nomeCpu = nomeCpu;
    }

    public String getCpuFisica() {
        return cpuFisica = String.valueOf(looca.getProcessador().getNumeroCpusFisicas());
    }

    public void setCpuFisica(String cpuFisica) {
        this.cpuFisica = cpuFisica;
    }

    public String getCpuLogica() {
        return cpuLogica = String.valueOf(looca.getProcessador().getNumeroCpusLogicas());
    }

    public void setCpuLogica(String cpuLogica) {
        this.cpuLogica = cpuLogica;
    }

    public String getFrequencia() {
        return frequencia = String.valueOf(looca.getProcessador().getFrequencia() / 1e9);
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }


}