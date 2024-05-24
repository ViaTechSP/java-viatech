package collectors;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.temperatura.Temperatura;

import javax.annotation.processing.Processor;

public class TemperaturaCollector {
    Processador processador = new Processador();
    Looca looca = new Looca();
    public Double getTemperatura() {
        return processador.getUso();
    }



}
