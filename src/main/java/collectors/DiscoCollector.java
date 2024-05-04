package collectors;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.util.Conversor;

public class DiscoCollector  {
    private Looca looca = new Looca();

    public String getTamanhoTotalDiscosEmGigabyte(){
       return Conversor.formatarBytes(looca.getGrupoDeDiscos().getTamanhoTotal());
    }

    public Integer getQuantidadeDeDiscos(){
        return looca.getGrupoDeDiscos().getQuantidadeDeDiscos();
    }
}
