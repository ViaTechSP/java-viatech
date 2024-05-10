import collectors.*;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.sistema.Sistema;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        RamCollector ramCollector = new RamCollector();
        DiscoCollector discoCollector = new DiscoCollector();
        CpuCollector cpuCollector = new CpuCollector();
        UsbCollector usbCollector = new UsbCollector();
        TemperaturaCollector temperaturaCollector = new TemperaturaCollector();


        Scanner input = new Scanner(System.in);
        LoginMetodos usar = new LoginMetodos();
        Boolean validacao;

        do{
            System.out.println("Digite seu email:");
            String email = input.next();
            validacao = usar.validarEmail(email);

        } while (validacao == false);
        System.out.println("""
                """);
        do {
            System.out.println("Digite sua senha:");
            String senha = input.next();
            validacao = usar.validarSenha(senha);

        } while (validacao == false);

        if(validacao == true){
            System.out.println("""
                    Bem-vindo!!

                    ██╗   ██╗██╗ █████╗ ████████╗███████╗ ██████╗██╗  ██╗
                    ██║   ██║██║██╔══██╗╚══██╔══╝██╔════╝██╔════╝██║  ██║
                    ██║   ██║██║███████║   ██║   █████╗  ██║     ███████║
                    ╚██╗ ██╔╝██║██╔══██║   ██║   ██╔══╝  ██║     ██╔══██║
                     ╚████╔╝ ██║██║  ██║   ██║   ███████╗╚██████╗██║  ██║
                      ╚═══╝  ╚═╝╚═╝  ╚═╝   ╚═╝   ╚══════╝ ╚═════╝╚═╝  ╚═╝
                      
                      """);

            Integer opcao;


            Integer contadorRegistros = 1;
            while (true) {
                System.out.println("""
                    .-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-.
                    |                                                                       |
                    |           Opções:                                                     |
                    |           Pressione 1 para verificar os dados na máquina              |
                    |           Pressione 2 para sair                                       |
                    !                                                                       !
                    `-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-' 
                    """);
                opcao = input.nextInt();

                if (opcao == 1){
                    Timer timer = new Timer();
                    LocalDateTime dataHorario = LocalDateTime.now();
                    TimerTask tarefa = new TimerTask(){
                       Integer contagem = 0;
                        public void run() {
                            contagem++;

                            System.out.println("""
                                    Coletando... %d
                                    """.formatted(contagem));

                            DateTimeFormatter formatadorDataHora =  DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                    System.out.println("""
                            Registro %d
                            Data e horario: %s
                            """.formatted(contadorRegistros, formatadorDataHora.format(dataHorario)));

                    System.out.println("""                            
                            -----------------------------------------
                            INFORMAÇÕES DO DISCO:
                            Quantidade de discos: %s
                            Gigabytes de leitura: %s
                            Gigabytes de escrita: %s
                            Capacidade total dos discos: %s
                            -----------------------------------------
                            """.formatted(discoCollector.getQuantidadeDisco(), discoCollector.getGigabytesLeituras(), discoCollector.getGigabytesEscritas(), discoCollector.getTotalGigabytesDisco()));


                    System.out.println("""
                            -----------------------------------------
                            INFORMAÇÕES DA MEMÓRIA RAM:
                            Memória RAM em uso: %s
                            Memória RAM total: %s
                            Memória RAM disponível: %s
                            -----------------------------------------
                            """.formatted(ramCollector.getMemoriaUtilizada(), ramCollector.getMemoriaTotal(), ramCollector.getDisponivel()));

                    System.out.println("""
                            -----------------------------------------
                            INFORMAÇÕES DO PROCESSADOR:
                            Numero de CPUs físicas: %s
                            Numero de CPUs logicas: %s
                            Frequência: %s GHz
                            Nome: %s
                            -----------------------------------------
                            """.formatted(cpuCollector.getCpuFisica(),  cpuCollector.getCpuLogica(), cpuCollector.getFrequencia(), cpuCollector.getNomeCpu()));

                    System.out.println("""
                            -----------------------------------------
                            INFORMAÇÕES USB:
                            Quantidade dispositivos conectados: %s
                            Dispositivos conectados: %s 
                            -----------------------------------------
                            """.formatted(usbCollector.getQuantidadeUsbConectados(), usbCollector.getNomeDosDispositivos()));


                    DiscoColeta.coletarDadosDisco();
                    try {
                        RamColeta.coletaDeRam();
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        CpuColeta.coletaDeProcessador();
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        UsbColeta.coletaDeUsb();
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                        }
                    };
                    timer.scheduleAtFixedRate(tarefa, 200, 5000L);
                } else if (opcao == 2) {
                    System.out.println("Até logo!!");
                    break;
                } else {
                    System.out.println("Insira um número válido\n");
                }
            }
         }



    }
}
