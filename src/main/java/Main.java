import alerta.SlackConfig;
import collectors.*;
import entidade.EspecificacaoMaquina;
import entidade.Funcionario;
import entidade.Maquina;
import entidade.Registro;
import model.*;

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
        MaquinaCollector maquinaCollector = new MaquinaCollector();
        Registro registro = new Registro();
        Funcionario funcionario = new Funcionario();
        FuncionarioModel funcionarioModel = new FuncionarioModel();
        Maquina maquina = new Maquina();
        RegistroModel registroModel = new RegistroModel();
        EspecificacaoMaquina especificacaoMaquina = new EspecificacaoMaquina();
        EspecificacaoMaquinaModel especificacaoMaquinaModel = new EspecificacaoMaquinaModel();
        MaquinaModel maquinaModel = new MaquinaModel();
        SlackModel slackModel = new SlackModel();
        SlackConfig slackConfig = new SlackConfig();

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



        try {
            funcionario = funcionarioModel.buscarFuncionario(funcionario);
            System.out.println("Bem vindo, %s".formatted(funcionario.getNome()));

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
                        maquina.setDominio(maquinaCollector.getDominio());
                        maquina.setIp(maquinaCollector.getIp());
                        maquina.setSistemaOperacional(maquinaCollector.getSistemaOperacional());

                        especificacaoMaquina.setCapacidadeTotalArmazenamento(discoCollector.getTotalGigabytesDisco());
                        especificacaoMaquina.setFrequenciaCpu(cpuCollector.getFrequencia());
                        especificacaoMaquina.setNomeCpu(cpuCollector.getNomeCpu());
                        especificacaoMaquina.setQtdCpuFisica(cpuCollector.getCpuFisica());
                        especificacaoMaquina.setQtdCpuLogica(cpuCollector.getCpuLogica());
                        especificacaoMaquina.setRamTotal(ramCollector.getMemoriaTotal());

                        maquina = maquinaModel.exibirMaquina(maquina) != null ? maquinaModel.exibirMaquina(maquina) : maquina;
                        if (maquina.getIdMaquina() == null){
                            maquinaModel.inserirMaquina(maquina);
                            maquina = maquinaModel.exibirMaquina(maquina);
                            System.out.println("Máquina cadastrada com sucesso!");
                        } else {
                            System.out.println("Máquina já cadastrada.");
                        }


                        especificacaoMaquina.setFkMaquina(maquina.getIdMaquina());
                        System.out.println(maquina);

                        especificacaoMaquina = especificacaoMaquinaModel.verificarExistenciaMaquina(especificacaoMaquina) != null ? especificacaoMaquinaModel.verificarExistenciaMaquina(especificacaoMaquina) : especificacaoMaquina;
                        if (especificacaoMaquina.getIdEspecificacaoMaquina() == null){
                            especificacaoMaquinaModel.inserirDadosEspecificacao(especificacaoMaquina);
                            especificacaoMaquina = especificacaoMaquinaModel.verificarExistenciaMaquina(especificacaoMaquina);
                            System.out.println("Especificações da máquina cadastradas com sucesso!");
                        } else {
                            System.out.println("Especificações já cadastradas.");
                        }

                        System.out.println(especificacaoMaquina);

                        final EspecificacaoMaquina especificacaoMaquinaConst = especificacaoMaquina;

                        Timer timer = new Timer();

                        Maquina finalMaquina = maquina;
                        TimerTask tarefa = new TimerTask(){
                            Integer contagem = 0;
                            public void run() {

                                registro.setCpuPorcentagemUso(cpuCollector.getUsoCpu());
                                registro.setCpuTemperatura(temperaturaCollector.getTemperatura());
                                registro.setDiscoDisponivel(discoCollector.getDiscoDisponivel());
                                registro.setRamUtilizada(ramCollector.getMemoriaUtilizada());
                                registro.setQtdDispositivosConectados(usbCollector.getQuantidadeUsbConectados());
                                registro.setFkEspecificacaoMaquina(especificacaoMaquinaConst.getIdEspecificacaoMaquina());
                                contagem++;
                                LocalDateTime dataHorario = LocalDateTime.now();
                                System.out.println(registro);

                                System.out.println("""
                                    Coletando... %d
                                    """.formatted(contagem));

                                DateTimeFormatter formatadorDataHora =  DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                                System.out.println("""
                            Registro %d
                            Data e horario: %s
                            """.formatted(contadorRegistros, formatadorDataHora.format(dataHorario)));

                                registroModel.inserirDadosRegistro(registro);
                                slackModel.verificarRegistro(registro, finalMaquina);
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
        } catch (Exception e){
            System.out.println("E-mail ou senha inválidos. Tente novamente.");;
        }
    }
}
