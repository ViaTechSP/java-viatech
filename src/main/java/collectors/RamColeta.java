package collectors;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.util.Conversor;

public class RamColeta {

    public static void coletaDeRam() throws ClassNotFoundException{
        Looca looca = new Looca();

        String ramUtilizada = Conversor.formatarBytes(looca.getMemoria().getEmUso());
        String totalRam = Conversor.formatarBytes (looca.getMemoria().getTotal());
        String diponivelRam = Conversor.formatarBytes(looca.getMemoria().getDisponivel());

        RamCollector metodoRam = new RamCollector();
        metodoRam.setMemoriaUtilizada(ramUtilizada);
        metodoRam.setMemoriaTotal(String.valueOf(totalRam));
        metodoRam.setDisponivel(String.valueOf(diponivelRam));
        new RamBanco().cadastrarDados(metodoRam);

    }
}


