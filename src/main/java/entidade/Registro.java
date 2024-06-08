package entidade;

import java.time.LocalDateTime;

public class Registro {
    private Integer idRegistro;
    private LocalDateTime dtHora;
    private Double cpuUtilizada;
    private Double discoDisponivel;
    private Double ramUtilizada;
    private Integer qtdDispositivosUsb;
    private Integer fkEspecificacaoMaquina;

    public Registro(Integer idRegistro, LocalDateTime dtHora, Double cpuPorcentagemUso, Double discoDisponivel, Double ramUtilizada, Integer qtdDispositivosUsb, Integer fkEspecificacaoMaquina) {
        this.idRegistro = idRegistro;
        this.dtHora = dtHora;
        this.cpuUtilizada = cpuPorcentagemUso;
        this.discoDisponivel = discoDisponivel;
        this.ramUtilizada = ramUtilizada;
        this.qtdDispositivosUsb = qtdDispositivosUsb;
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

    public Double getCpuUtilizada() {
        return cpuUtilizada;
    }

    public void setCpuUtilizada(Double cpuUtilizada) {
        this.cpuUtilizada = cpuUtilizada;
    }

    public Double getDiscoDisponivel() {
        return discoDisponivel;
    }

    public void setDiscoDisponivel(Double discoDisponivel) {
        this.discoDisponivel = discoDisponivel;
    }

    public Double getRamUtilizada() {
        return ramUtilizada;
    }

    public void setRamUtilizada(Double ramUtilizada) {
        this.ramUtilizada = ramUtilizada;
    }

    public Integer getQtdDispositivosUsb() {
        return qtdDispositivosUsb;
    }

    public void setQtdDispositivosUsb(Integer qtdDispositivosUsb) {
        this.qtdDispositivosUsb = qtdDispositivosUsb;
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
                ", cpuUtilizada=" + cpuUtilizada +
                ", discoDisponivel=" + discoDisponivel +
                ", ramUtilizada=" + ramUtilizada +
                ", qtdDispositivosUsb=" + qtdDispositivosUsb +
                ", fkEspecificacaoMaquina=" + fkEspecificacaoMaquina +
                '}';
    }
}
