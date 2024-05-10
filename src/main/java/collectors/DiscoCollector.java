package collectors;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.util.Conversor;

public class DiscoCollector  {
     Looca looca = new Looca();

     private String quantidadeDisco;
     private String gigabytesLeituras;
     private String gigabytesEscritas;
     private String totalGigabytesDisco;


    public String getQuantidadeDisco() {
        return this.quantidadeDisco = String.valueOf((looca.getGrupoDeDiscos().getQuantidadeDeDiscos()));
    }

    public void setQuantidadeDisco(String quantidadeDisco) {
        this.quantidadeDisco = quantidadeDisco;
    }


    public String getGigabytesLeituras() {
        return gigabytesLeituras = Conversor.formatarBytes(looca.getGrupoDeDiscos().getDiscos().get(0).getBytesDeLeitura());
    }

    public void setGigabytesLeituras(String gigabytesLeituras) {
        this.gigabytesLeituras = gigabytesLeituras;
    }

    public String getGigabytesEscritas() {
        return gigabytesEscritas = Conversor.formatarBytes(looca.getGrupoDeDiscos().getDiscos().get(0).getBytesDeEscritas());
    }

    public void setGigabytesEscritas(String gigabytesEscritas) {
        this.gigabytesEscritas = gigabytesEscritas;
    }

    public String getTotalGigabytesDisco() {
        return totalGigabytesDisco = Conversor.formatarBytes(looca.getGrupoDeDiscos().getTamanhoTotal());
    }

    public void setTotalGigabytesDisco(String totalGigabytesDisco) {
        this.totalGigabytesDisco = totalGigabytesDisco;
    }


}
