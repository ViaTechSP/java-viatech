package entidade;

public class EspecificacaoMaquina {
    private Integer idEspecificacaoMaquina;
    private String nomeCpu;
    private Double armazenamentoTotal;
    private Double ramTotal;
    private Integer fkMaquina;

    public EspecificacaoMaquina( EspecificacaoMaquina especificacaoMaquina,Integer fkMaquina) {
        this.idEspecificacaoMaquina = especificacaoMaquina.idEspecificacaoMaquina;
        this.nomeCpu = especificacaoMaquina.nomeCpu;
        this.armazenamentoTotal = especificacaoMaquina.armazenamentoTotal;
        this.ramTotal = especificacaoMaquina.ramTotal;
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

    public Double getArmazenamentoTotal() {
        return armazenamentoTotal;
    }

    public void setArmazenamentoTotal(Double armazenamentoTotal) {
        this.armazenamentoTotal = armazenamentoTotal;
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
                ", capacidadeTotalArmazenamento=" + armazenamentoTotal +
                ", ramTotal=" + ramTotal +
                ", fkMaquina=" + fkMaquina +
                '}';
    }
}
