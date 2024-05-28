import alerta.SlackConfig;
import collectors.*;
import com.github.britooo.looca.api.core.Looca;
import entidade.*;
import model.*;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.UsbDevice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
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
        EstacaoModel estacaoModel = new EstacaoModel();

        Looca looca = new Looca();

        Scanner input = new Scanner(System.in);
        LoginMetodos usar = new LoginMetodos();
        Boolean validacao;

        System.out.println(usbCollector.getNome());
        System.out.println(usbCollector.getNomeDosDispositivosConectados());
        System.out.println(usbCollector.getQuantidadeUsbConectados());

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
                            System.out.println("Máquina sem cadastrado! Escolha uma estação para essa máquina:");

                            List<Estacao> estacoesDisponiveis = estacaoModel.listaEstacoesDisponiveis();
                            Integer estacao;
                            System.out.println("Estações disponíveis:");
                            for (int i = 0; i < estacoesDisponiveis.size() ; i++) {
                                System.out.println("""
                                  %d - %s
                                 """.formatted(i + 1, estacoesDisponiveis.get(i).getNome()));
                            }
                            estacao = input.nextInt();

                            maquinaModel.inserirMaquina(maquina, estacoesDisponiveis.get(estacao - 1).getIdEstacao());
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
                        EspecificacaoMaquina finalEspecificacaoMaquina = especificacaoMaquina;
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
                                slackModel.verificarRegistro(registro, finalEspecificacaoMaquina);
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
