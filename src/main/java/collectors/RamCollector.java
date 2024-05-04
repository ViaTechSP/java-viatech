package collectors;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.util.Conversor;

public class RamCollector {
    Looca looca = new Looca();

    public String getMemoriaTotalEmGigabytes () {
        return Conversor.formatarBytes(looca.getMemoria().getTotal());
    }

    public String getMemoriaEmUsoEmGigabytes(){
        return Conversor.formatarBytes(looca.getMemoria().getEmUso());
    }

    public String getMemoriaDisponivelEmGigabytes(){
        return Conversor.formatarBytes(looca.getMemoria().getDisponivel());
    }

}
