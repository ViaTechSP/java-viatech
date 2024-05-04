package collectors;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.temperatura.Temperatura;

public class TemperaturaCollector {

    Looca looca = new Looca();
    public Temperatura getTemperatura() {
       return looca.getTemperatura();
    }



}
