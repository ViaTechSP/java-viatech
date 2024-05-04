package collectors;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.util.Conversor;

public class DiscoCollector  {
    private Looca looca = new Looca();

    public Integer getQuantidadeDeDiscos(){
        return looca.getGrupoDeDiscos().getQuantidadeDeDiscos();
    }

    public String getGigabytesLeitura() {
        return Conversor.formatarBytes(looca.getGrupoDeDiscos().getDiscos().get(0).getBytesDeLeitura());
    }

    public String getGigabytesEscrita() {
        return Conversor.formatarBytes(looca.getGrupoDeDiscos().getDiscos().get(0).getBytesDeEscritas());
    }
    public String getTamanhoTotalDiscosEmGigabyte(){
        return Conversor.formatarBytes(looca.getGrupoDeDiscos().getTamanhoTotal());
    }

}
