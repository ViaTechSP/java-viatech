import collectors.*;
import entidade.Funcionario;
import entidade.Maquina;
import entidade.Registro;
import model.*;
import org.springframework.dao.DataAccessException;

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
        Registro registro = new Registro();
        Funcionario funcionario = new Funcionario();
        FuncionarioModel funcionarioModel = new FuncionarioModel();
        Maquina maquina = new Maquina();
        RegistroModel registroModel = new RegistroModel();

        System.out.println(discoCollector.getGigabytesEscritas());

        Scanner input = new Scanner(System.in);
        LoginMetodos usar = new LoginMetodos();
        Boolean validacao;

        do{
            System.out.println("Digite seu email:");
            String email = input.next();
            validacao = usar.validarEmail(email);
            funcionario.setEmail(email);

        } while (!validacao);

        do {
            System.out.println("Digite sua senha:");
            String senha = input.next();
            validacao = usar.validarSenha(senha);
            funcionario.setSenha(senha);
        } while (validacao == false);

        funcionario = funcionarioModel.buscarFuncionario(funcionario);

        try {
            if (validacao = funcionario.getId() != 0){
                System.out.println("Bem vindo, %s".formatted(funcionario.getNome()));
            } else {
                System.out.println("E-mail ou senha inválidos. Tente novamente");
            }
        } catch (DataAccessException e){
            System.out.println("erro");
        }

        if(validacao == true){
            System.out.println("""

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

                    TimerTask tarefa = new TimerTask(){
                       Integer contagem = 0;
                        public void run() {
                            registro.setDiscoGigabyteLeitura(discoCollector.getGigabytesLeituras());
                            registro.setDiscoGigabyteEscrita(discoCollector.getGigabytesEscritas());
                            registro.setCpuPorcentagemUso(cpuCollector.getUsoCpu());
                            registro.setCpuTemperatura(temperaturaCollector.getTemperatura());
                            registro.setRamUtilizada(ramCollector.getMemoriaUtilizada());
                            registro.setQtdDispositivosConectados(usbCollector.getQuantidadeUsbConectados());
                            registro.setFkEspecificacaoMaquina(maquina.getIdMaquina());
                            contagem++;
                            LocalDateTime dataHorario = LocalDateTime.now();

                            System.out.println("""
                                    Coletando... %d
                                    """.formatted(contagem));

                            DateTimeFormatter formatadorDataHora =  DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                            System.out.println("""
                            Registro %d
                            Data e horario: %s
                            """.formatted(contadorRegistros, formatadorDataHora.format(dataHorario)));

                            registroModel.inserirDadosRegistro(registro);

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
