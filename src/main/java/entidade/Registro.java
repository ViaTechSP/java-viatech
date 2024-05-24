package entidade;

import java.time.LocalDateTime;

public class Registro {
    private Integer idRegistro;
    private LocalDateTime dtHora;
    private Double discoGigabyteLeitura;
    private Double discoGigabyteEscrita;
    private Double cpuPorcentagemUso;
    private Double cpuTemperatura;
    private Double ramUtilizada;
    private Integer qtdDispositivosConectados;
    private Integer fkEspecificacaoMaquina;

    public Registro(Integer idRegistro, LocalDateTime dtHora, Double discoGigabyteLeitura, Double discoGigabyteEscrita, Double cpuPorcentagemUso, Double cpuTemperatura, Double ramUtilizada, Integer qtdDispositivosConectados, Integer fkEspecificacaoMaquina) {
        this.idRegistro = idRegistro;
        this.dtHora = dtHora;
        this.discoGigabyteLeitura = discoGigabyteLeitura;
        this.discoGigabyteEscrita = discoGigabyteEscrita;
        this.cpuPorcentagemUso = cpuPorcentagemUso;
        this.cpuTemperatura = cpuTemperatura;
        this.ramUtilizada = ramUtilizada;
        this.qtdDispositivosConectados = qtdDispositivosConectados;
        this.fkEspecificacaoMaquina = fkEspecificacaoMaquina;
    }

    public Registro() {
    }

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public LocalDateTime getDtHora() {
        return dtHora;
    }

    public void setDtHora(LocalDateTime dtHora) {
        this.dtHora = dtHora;
    }

    public Double getDiscoGigabyteLeitura() {
        return discoGigabyteLeitura;
    }

    public void setDiscoGigabyteLeitura(Double discoGigabyteLeitura) {
        this.discoGigabyteLeitura = discoGigabyteLeitura;
    }

    public Double getDiscoGigabyteEscrita() {
        return discoGigabyteEscrita;
    }

    public void setDiscoGigabyteEscrita(Double discoGigabyteEscrita) {
        this.discoGigabyteEscrita = discoGigabyteEscrita;
    }

    public Double getCpuPorcentagemUso() {
        return cpuPorcentagemUso;
    }

    public void setCpuPorcentagemUso(Double cpuPorcentagemUso) {
        this.cpuPorcentagemUso = cpuPorcentagemUso;
    }

    public Double getCpuTemperatura() {
        return cpuTemperatura;
    }

    public void setCpuTemperatura(Double cpuTemperatura) {
        this.cpuTemperatura = cpuTemperatura;
    }

    public Double getRamUtilizada() {
        return ramUtilizada;
    }

    public void setRamUtilizada(Double ramUtilizada) {
        this.ramUtilizada = ramUtilizada;
    }

    public Integer getQtdDispositivosConectados() {
        return qtdDispositivosConectados;
    }

    public void setQtdDispositivosConectados(Integer qtdDispositivosConectados) {
        this.qtdDispositivosConectados = qtdDispositivosConectados;
    }

    public Integer getFkEspecificacaoMaquina() {
        return fkEspecificacaoMaquina;
    }

    public void setFkEspecificacaoMaquina(Integer fkEspecificacaoMaquina) {
        this.fkEspecificacaoMaquina = fkEspecificacaoMaquina;
    }

    @Override
    public String toString() {
        return "Registro{" +
                "idRegistro=" + idRegistro +
                ", dtHora=" + dtHora +
                ", discoGigabyteLeitura='" + discoGigabyteLeitura + '\'' +
                ", discoGigabyteEscrita='" + discoGigabyteEscrita + '\'' +
                ", cpuPorcentagemUso=" + cpuPorcentagemUso +
                ", cpuTemperatura=" + cpuTemperatura +
                ", ramUtilizada='" + ramUtilizada + '\'' +
                ", qtdDispositivosConectados=" + qtdDispositivosConectados +
                ", fkEspecificacaoMaquina=" + fkEspecificacaoMaquina +
                '}';
    }
}
