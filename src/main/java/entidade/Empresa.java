package entidade;

import java.util.List;

public class Empresa {
    private Integer idEmpresa;
    private String razaoSocial;
    private String apelido;
    private String CNPJ;
    private String nomeFantasia;
    private List<Funcionario> funcionarios;

    public Empresa(Integer idEmpresa, String razaoSocial, String apelido, String CNPJ, String nomeFantasia, List<Funcionario> funcionarios) {
        this.idEmpresa = idEmpresa;
        this.razaoSocial = razaoSocial;
        this.apelido = apelido;
        this.CNPJ = CNPJ;
        this.nomeFantasia = nomeFantasia;
        this.funcionarios = funcionarios;
    }

    public Empresa() {
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
}
