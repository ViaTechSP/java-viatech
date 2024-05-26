package entidade;

public class Metrica {
    Integer idMetrica;
    Integer minCuidadoDisco;
    Integer maxCuidadoDisco;
    Integer minCuidadoCpu;
    Integer maxCuidadoCpu;
    Integer minCuidadoRam;
    Integer maxCuidadoRam;
    Integer minIdealTemp;
    Integer maxIdealTemp;
    Integer fkMaquina;

    public Metrica(Integer idMetrica, Integer minCuidadoDisco, Integer maxCuidadoDisco, Integer minCuidadoCpu, Integer maxCuidadoCpu, Integer minCuidadoRam, Integer maxCuidadoRam, Integer minIdealTemp, Integer maxIdealTemp, Integer fkMaquina) {
        this.idMetrica = idMetrica;
        this.minCuidadoDisco = minCuidadoDisco;
        this.maxCuidadoDisco = maxCuidadoDisco;
        this.minCuidadoCpu = minCuidadoCpu;
        this.maxCuidadoCpu = maxCuidadoCpu;
        this.minCuidadoRam = minCuidadoRam;
        this.maxCuidadoRam = maxCuidadoRam;
        this.minIdealTemp = minIdealTemp;
        this.maxIdealTemp = maxIdealTemp;
        this.fkMaquina = fkMaquina;
    }

    public Metrica() {
    }

    


}
