package entidade;

public class Metrica {
   Integer idMetrica;
   Integer cuidadoDisco;
   Integer problemaDisco;
   Integer cuidadoCpu;
   Integer problemaCpu;
   Integer cuidadoRam;
   Integer problemaRam;
   Integer maxUsb;
   Integer fkLinha;

    public Metrica(Integer idMetrica, Integer cuidadoDisco, Integer problemaDisco, Integer cuidadoCpu, Integer problemaCpu, Integer cuidadoRam, Integer problemaRam, Integer maxUsb, Integer fkLinha) {
        this.idMetrica = idMetrica;
        this.cuidadoDisco = cuidadoDisco;
        this.problemaDisco = problemaDisco;
        this.cuidadoCpu = cuidadoCpu;
        this.problemaCpu = problemaCpu;
        this.cuidadoRam = cuidadoRam;
        this.problemaRam = problemaRam;
        this.maxUsb = maxUsb;
        this.fkLinha = fkLinha;
    }

    public Metrica() {
    }

    public Integer getIdMetrica() {
        return idMetrica;
    }

    public void setIdMetrica(Integer idMetrica) {
        this.idMetrica = idMetrica;
    }

    public Integer getCuidadoDisco() {
        return cuidadoDisco;
    }

    public void setCuidadoDisco(Integer cuidadoDisco) {
        this.cuidadoDisco = cuidadoDisco;
    }

    public Integer getProblemaDisco() {
        return problemaDisco;
    }

    public void setProblemaDisco(Integer problemaDisco) {
        this.problemaDisco = problemaDisco;
    }

    public Integer getCuidadoCpu() {
        return cuidadoCpu;
    }

    public void setCuidadoCpu(Integer cuidadoCpu) {
        this.cuidadoCpu = cuidadoCpu;
    }

    public Integer getProblemaCpu() {
        return problemaCpu;
    }

    public void setProblemaCpu(Integer problemaCpu) {
        this.problemaCpu = problemaCpu;
    }

    public Integer getCuidadoRam() {
        return cuidadoRam;
    }

    public void setCuidadoRam(Integer cuidadoRam) {
        this.cuidadoRam = cuidadoRam;
    }

    public Integer getProblemaRam() {
        return problemaRam;
    }

    public void setProblemaRam(Integer problemaRam) {
        this.problemaRam = problemaRam;
    }

    public Integer getMaxUsb() {
        return maxUsb;
    }

    public void setMaxUsb(Integer maxUsb) {
        this.maxUsb = maxUsb;
    }

    public Integer getFkLinha() {
        return fkLinha;
    }

    public void setFkLinha(Integer fkLinha) {
        this.fkLinha = fkLinha;
    }

    @Override
    public String toString() {
        return "Metrica{" +
                "idMetrica=" + idMetrica +
                ", cuidadoDisco=" + cuidadoDisco +
                ", problemaDisco=" + problemaDisco +
                ", cuidadoCpu=" + cuidadoCpu +
                ", problemaCpu=" + problemaCpu +
                ", cuidadoRam=" + cuidadoRam +
                ", problemaRam=" + problemaRam +
                ", maxUsb=" + maxUsb +
                ", fkMaquina=" + fkLinha +
                '}';
    }
}
