package collectors;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.util.Conversor;

import java.util.List;

public class DiscoColeta {
    public static void coletarDadosDisco() {
        Looca looca = new Looca();
        Sistema sistema = new Sistema();
        DiscoGrupo grupoDeDiscos = looca.getGrupoDeDiscos();

        List<Volume> discos = grupoDeDiscos.getVolumes();



        for (Volume disco : discos) {

            String quantidadeDisco = String.valueOf(looca.getGrupoDeDiscos().getQuantidadeDeDiscos());
            String gigabytesLeituras = Conversor.formatarBytes(looca.getGrupoDeDiscos().getDiscos().get(0).getBytesDeLeitura());
            String gigabytesEscritas = Conversor.formatarBytes(looca.getGrupoDeDiscos().getDiscos().get(0).getBytesDeEscritas());
            String totalGigabytesDisco = Conversor.formatarBytes(looca.getGrupoDeDiscos().getTamanhoTotal());



            DiscoCollector metodoDisc = new DiscoCollector();
            metodoDisc.setQuantidadeDisco(String.valueOf((quantidadeDisco)));
            metodoDisc.setGigabytesLeituras(gigabytesLeituras);
            metodoDisc.setGigabytesEscritas(gigabytesEscritas);
            metodoDisc.setTotalGigabytesDisco(totalGigabytesDisco);


            new DiscoBanco().cadastrarDados(metodoDisc);

        }



    }
}

