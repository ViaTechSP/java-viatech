package entidade;

public class Estacao {
    private Integer idEstacao;
    private String nome;
    private Integer fkLinha;

    public Estacao(Integer idEstacao, String nome, Integer fkLinha) {
        this.idEstacao = idEstacao;
        this.nome = nome;
        this.fkLinha = fkLinha;
    }

    public Estacao() {
    }

    public Integer getIdEstacao() {
        return idEstacao;
    }

    public void setIdEstacao(Integer idEstacao) {
        this.idEstacao = idEstacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getFkLinha() {
        return fkLinha;
    }

    public void setFkLinha(Integer fkLinha) {
        this.fkLinha = fkLinha;
    }
}
