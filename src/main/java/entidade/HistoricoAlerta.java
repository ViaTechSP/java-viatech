package entidade;

import java.time.LocalDateTime;

public class HistoricoAlerta {
    Integer idHistoricoAlerta;
    LocalDateTime dtHora;
    String tipo;
    String componente;
    Double valor;

    public HistoricoAlerta(Integer idHistoricoAlerta, LocalDateTime dtHora, String tipo, String componente, Double valor) {
        this.idHistoricoAlerta = idHistoricoAlerta;
        this.dtHora = dtHora;
        this.tipo = tipo;
        this.componente = componente;
        this.valor = valor;
    }

    public HistoricoAlerta() {
    }

    public Integer getIdHistoricoAlerta() {
        return idHistoricoAlerta;
    }

    public void setIdHistoricoAlerta(Integer idHistoricoAlerta) {
        this.idHistoricoAlerta = idHistoricoAlerta;
    }

    public LocalDateTime getDtHora() {
        return dtHora;
    }

    public void setDtHora(LocalDateTime dtHora) {
        this.dtHora = dtHora;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getComponente() {
        return componente;
    }

    public void setComponente(String componente) {
        this.componente = componente;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "HistoricoAlerta{" +
                "idHistoricoAlerta=" + idHistoricoAlerta +
                ", dtHora=" + dtHora +
                ", tipo='" + tipo + '\'' +
                ", componente='" + componente + '\'' +
                ", valor=" + valor +
                '}';
    }
}
