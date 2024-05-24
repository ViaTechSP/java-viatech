package entidade;

public class EspecificacaoMaquina {
    private Integer idEspecificacaoMaquina;
    private String nomeCpu;
    private Double frequenciaCpu;
    private Integer qtdCpuFisica;
    private Integer qtdCpuLogica;
    private Double capacidadeTotalArmazenamento;
    private Double ramTotal;
    private Integer fkMaquina;

    public EspecificacaoMaquina(Integer idEspecificacaoMaquina, String nomeCpu, Double frequenciaCpu, Integer qtdCpuFisica, Integer qtdCpuLogica, Double capacidadeTotalArmazenamento, Double ramTotal, Integer fkMaquina) {
        this.idEspecificacaoMaquina = idEspecificacaoMaquina;
        this.nomeCpu = nomeCpu;
        this.frequenciaCpu = frequenciaCpu;
        this.qtdCpuFisica = qtdCpuFisica;
        this.qtdCpuLogica = qtdCpuLogica;
        this.capacidadeTotalArmazenamento = capacidadeTotalArmazenamento;
        this.ramTotal = ramTotal;
        this.fkMaquina = fkMaquina;
    }

    public EspecificacaoMaquina() {
    }

    public Integer getIdEspecificacaoMaquina() {
        return idEspecificacaoMaquina;
    }

    public void setIdEspecificacaoMaquina(Integer idEspecificacaoMaquina) {
        this.idEspecificacaoMaquina = idEspecificacaoMaquina;
    }

    public String getNomeCpu() {
        return nomeCpu;
    }

    public void setNomeCpu(String nomeCpu) {
        this.nomeCpu = nomeCpu;
    }

    public Double getFrequenciaCpu() {
        return frequenciaCpu;
    }

    public void setFrequenciaCpu(Double frequenciaCpu) {
        this.frequenciaCpu = frequenciaCpu;
    }

    public Integer getQtdCpuFisica() {
        return qtdCpuFisica;
    }

    public void setQtdCpuFisica(Integer qtdCpuFisica) {
        this.qtdCpuFisica = qtdCpuFisica;
    }

    public Integer getQtdCpuLogica() {
        return qtdCpuLogica;
    }

    public void setQtdCpuLogica(Integer qtdCpuLogica) {
        this.qtdCpuLogica = qtdCpuLogica;
    }

    public Double getCapacidadeTotalArmazenamento() {
        return capacidadeTotalArmazenamento;
    }

    public void setCapacidadeTotalArmazenamento(Double capacidadeTotalArmazenamento) {
        this.capacidadeTotalArmazenamento = capacidadeTotalArmazenamento;
    }

    public Double getRamTotal() {
        return ramTotal;
    }

    public void setRamTotal(Double ramTotal) {
        this.ramTotal = ramTotal;
    }

    public Integer getFkMaquina() {
        return fkMaquina;
    }

    public void setFkMaquina(Integer fkMaquina) {
        this.fkMaquina = fkMaquina;
    }

    @Override
    public String toString() {
        return "EspecificacaoMaquina{" +
                "idEspecificacaoMaquina=" + idEspecificacaoMaquina +
                ", nomeCpu='" + nomeCpu + '\'' +
                ", frequenciaCpu=" + frequenciaCpu +
                ", qtdCpuFisica=" + qtdCpuFisica +
                ", qtdCpuLogica=" + qtdCpuLogica +
                ", capacidadeTotalArmazenamento=" + capacidadeTotalArmazenamento +
                ", ramTotal=" + ramTotal +
                ", fkMaquina=" + fkMaquina +
                '}';
    }
}
