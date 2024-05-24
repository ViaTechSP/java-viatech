package collectors;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.util.Conversor;

public class RamCollector {
    Looca looca = new Looca();

    public Double getDisponivel() {
        return looca.getMemoria().getDisponivel() / 1e9;
    }


    public Double getMemoriaTotal() {
        return looca.getMemoria().getTotal() / 1e9;
    }


    public Double getMemoriaUtilizada() {
        return looca.getMemoria().getEmUso() / 1e9;
    }



}







