package entidade;

import java.util.List;

public class Linha {
    private Integer idLinha;
    private String nome;
    private Integer numero;
    private Integer fkEmpresa;
    private List<Estacao> estacoes;

    public Integer getIdLinha() {
        return idLinha;
    }

    public void setIdLinha(Integer idLinha) {
        this.idLinha = idLinha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(Integer fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }

    public List<Estacao> getEstacoes() {
        return estacoes;
    }

    public void setEstacoes(List<Estacao> estacoes) {
        this.estacoes = estacoes;
    }
}
