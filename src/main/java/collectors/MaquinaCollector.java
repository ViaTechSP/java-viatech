package collectors;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import oshi.SystemInfo;

import java.time.LocalDateTime;

public class MaquinaCollector {
    Looca looca = new Looca();
    SystemInfo systemInfo = new SystemInfo();

    public String getSistemaOperacional(){
        return looca.getSistema().getSistemaOperacional();
    }

    public String getDominio(){
        return looca.getRede().getParametros().getHostName();
    }

    public String getIp(){
        return looca.getRede().getGrupoDeInterfaces().getInterfaces().get(0).getEnderecoIpv6().get(0);
    }
}
