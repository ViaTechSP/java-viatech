package collectors;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.util.Conversor;
import oshi.hardware.HWDiskStore;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class DiscoCollector  {

     Looca looca = new Looca();

    public String getQuantidadeDisco() {
        return String.valueOf((looca.getGrupoDeDiscos().getQuantidadeDeDiscos()));
    }


    public Double getDiscoDisponivel() {
        Double discoDisponivel = 0.0;
        for (Volume volume : looca.getGrupoDeDiscos().getVolumes()){
            discoDisponivel += volume.getDisponivel() / 1e9;
        }
        return discoDisponivel;
    }

    public Double getTotalGigabytesDisco() {
        Double totalGigabyteDisco = 0.0;
        for (Volume volume : looca.getGrupoDeDiscos().getVolumes()){
            totalGigabyteDisco += volume.getTotal() / 1e9;
        }
        return totalGigabyteDisco;
    }




}
