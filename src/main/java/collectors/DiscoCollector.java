package collectors;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.util.Conversor;
import oshi.hardware.HWDiskStore;

import java.util.List;

public class DiscoCollector  {

     Looca looca = new Looca();

    public String getQuantidadeDisco() {
        return String.valueOf((looca.getGrupoDeDiscos().getQuantidadeDeDiscos()));
    }


    public Double getGigabytesLeituras() {
//        Double somaTotalVolume = 0.0;
//        for (Volume volume = looca.getGrupoDeDiscos().getVolumes()){
//           somaTotalVolume += volume.getDisponivel();
//        }
//        return somaTotalVolume;
        return looca.getGrupoDeDiscos().getDiscos().get(0).getBytesDeLeitura() / 1e9;
    }


    public Double getGigabytesEscritas() {
        return looca.getGrupoDeDiscos().getDiscos().get(0).getBytesDeEscritas() / 1e9;
    }


    public Double getTotalGigabytesDisco() {
        return looca.getGrupoDeDiscos().getVolumes().get(0).getDisponivel() / 1e9;
    }




}
