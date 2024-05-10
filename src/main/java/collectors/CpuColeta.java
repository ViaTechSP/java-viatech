package collectors;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.util.Conversor;

public class CpuColeta {




        public static void coletaDeProcessador() throws ClassNotFoundException {
            Looca looca = new Looca();



            String modeloProcessador = looca.getProcessador().getNome();
            String frequencia = String.valueOf(looca.getProcessador().getFrequencia());
            String logica = String.valueOf(looca.getProcessador().getNumeroCpusLogicas());
            String fisica = String.valueOf(looca.getProcessador().getNumeroCpusFisicas());

            CpuCollector processador = new CpuCollector();

            processador.setNomeCpu(modeloProcessador);
            processador.setFrequencia(frequencia);
            processador.setCpuLogica(logica);
            processador.setCpuFisica(fisica);
            new CpuBanco().cadastrarDados(processador);
        }

    }



