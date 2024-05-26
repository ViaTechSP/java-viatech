package entidade;

public class Maquina {
    private Integer idMaquina;
    private String dominio;
    private String ip;
    private String sistemaOperacional;
    private Integer fkEstacao;

    public Maquina(Integer idMaquina, String dominio, String ip, String sistemaOperacional, Integer fkEstacao) {
        this.idMaquina = idMaquina;
        this.dominio = dominio;
        this.ip = ip;
        this.sistemaOperacional = sistemaOperacional;
        this.fkEstacao = fkEstacao;
    }

    public Maquina() {
    }

    public Integer getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public Integer getFkEstacao() {
        return fkEstacao;
    }

    public void setFkEstacao(Integer fkEstacao) {
        this.fkEstacao = fkEstacao;
    }

    @Override
    public String   toString() {
        return "Maquina{" +
                "idMaquina=" + idMaquina +
                ", dominio='" + dominio + '\'' +
                ", ip='" + ip + '\'' +
                ", sistemaOperacional='" + sistemaOperacional + '\'' +
                ", fkEstacao=" + fkEstacao +
                '}';
    }
}
