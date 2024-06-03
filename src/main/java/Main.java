import collectors.*;
import entidade.*;
import model.*;

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
        MaquinaCollector maquinaCollector = new MaquinaCollector();
        Registro registro = new Registro();
        FuncionarioModel funcionarioModel = new FuncionarioModel();
        Maquina maquina = new Maquina();
        Funcionario funcionario = new Funcionario();
        Maquina maquinaMySql;
        Maquina maquinaSqlServer;
        EspecificacaoMaquina especificacaoMaquina = new EspecificacaoMaquina();
        RegistroModel registroModel = new RegistroModel();
        EspecificacaoMaquinaModel especificacaoMaquinaModel = new EspecificacaoMaquinaModel();
        MaquinaModel maquinaModel = new MaquinaModel();
        SlackModel slackModel = new SlackModel();
        EstacaoModel estacaoModel = new EstacaoModel();
        MainModel mainModel = new MainModel();

        Scanner input = new Scanner(System.in);
        String email, senha;

        System.out.println("Digite seu email:");
        email = input.next();

        System.out.println("Digite sua senha:");
        senha = input.next();

        try {

            funcionario = funcionarioModel.buscarFuncionario(email, senha);

            if (funcionario == null) {
                System.out.println("E-mail ou senha inválidos. Tente novamente.");
                return;  // Encerrar o programa se o login falhar
            }

            System.out.println("Bem vindo, %s".formatted(funcionario.getNome()));

            System.out.println("""

                    ██╗   ██╗██╗ █████╗ ████████╗███████╗ ██████╗██╗  ██╗
                    ██║   ██║██║██╔══██╗╚══██╔══╝██╔════╝██╔════╝██║  ██║
                    ██║   ██║██║███████║   ██║   █████╗  ██║     ███████║
                    ╚██╗ ██╔╝██║██╔══██║   ██║   ██╔══╝  ██║     ██╔══██║
                     ╚████╔╝ ██║██║  ██║   ██║   ███████╗╚██████╗██║  ██║
                      ╚═══╝  ╚═╝╚═╝  ╚═╝   ╚═╝   ╚══════╝ ╚═════╝╚═╝  ╚═╝

                      """);

            int opcao;

            System.out.println("""
                    .-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-.
                    |                                                                       |
                    |           Opções:                                                     |
                    |           Pressione 1 para verificar os dados na máquina              |
                    |           Pressione 2 para sair                                       |
                    !                                                                       !
                    `-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-'
                    """);
            while (true) {
                opcao = input.nextInt();

                if (opcao == 1) {
                    maquina.setDominio(maquinaCollector.getDominio());
                    maquina.setIp(maquinaCollector.getIp());
                    maquina.setSistemaOperacional(maquinaCollector.getSistemaOperacional());

                    especificacaoMaquina.setCapacidadeTotalArmazenamento(discoCollector.getTotalGigabytesDisco());
                    especificacaoMaquina.setFrequenciaCpu(cpuCollector.getFrequencia());
                    especificacaoMaquina.setNomeCpu(cpuCollector.getNomeCpu());
                    especificacaoMaquina.setQtdCpuFisica(cpuCollector.getCpuFisica());
                    especificacaoMaquina.setQtdCpuLogica(cpuCollector.getCpuLogica());
                    especificacaoMaquina.setRamTotal(ramCollector.getMemoriaTotal());

                    if (!mainModel.maquinaExists(maquina.getDominio())) {
                        System.out.println("Máquina sem cadastrado! Escolha uma estação para essa máquina:");

                        List<Estacao> estacoesDisponiveis = estacaoModel.listaEstacoesDisponiveis();
                        int estacao;
                        System.out.println("Estações disponíveis:");
                        for (int i = 0; i < estacoesDisponiveis.size(); i++) {
                            System.out.println("""
                                     %d - %s
                                    """.formatted(i + 1, estacoesDisponiveis.get(i).getNome()));
                        }
                        estacao = input.nextInt();

                        maquinaModel.inserirMaquinaMySql(maquina, estacoesDisponiveis.get(estacao - 1).getIdEstacao());
                        maquinaModel.inserirMaquinaSqlServer(maquina, estacoesDisponiveis.get(estacao - 1).getIdEstacao());

                        System.out.println("Máquina cadastrada com sucesso!");
                    } else {
                        System.out.println("Máquina já cadastrada.");
                    }

                    maquinaMySql = maquinaModel.exibirMaquinaMySql(maquina.getDominio());
                    maquinaSqlServer = maquinaModel.exibirMaquinaSqlServer(maquina.getDominio());

                    EspecificacaoMaquina especificacaoMaquinaMySql = new EspecificacaoMaquina(especificacaoMaquina, maquinaMySql.getIdMaquina());
                    EspecificacaoMaquina especificacaoMaquinaSqlServer = new EspecificacaoMaquina(especificacaoMaquina, maquinaSqlServer.getIdMaquina());

                    if (!mainModel.especificacaoMaquinaExists(maquinaMySql.getIdMaquina(), maquinaSqlServer.getIdMaquina())) {
                        especificacaoMaquinaModel.inserirDadosEspecificacaoMySql(especificacaoMaquinaMySql);
                        especificacaoMaquinaModel.inserirDadosEspecificacaoSqlServer(especificacaoMaquinaSqlServer);

                        System.out.println("Especificações da máquina cadastradas com sucesso!");
                    } else {
                        System.out.println("Especificações já cadastradas.");
                    }

                    final EspecificacaoMaquina finalEspecificacaoMaquinaMySql = especificacaoMaquinaModel.
                            verificarExistenciaMaquinaMySql(maquinaMySql.getIdMaquina());

                    final EspecificacaoMaquina finalEspecificacaoMaquinaSqlServer = especificacaoMaquinaModel.
                            verificarExistenciaMaquinaSqlServer(maquinaSqlServer.getIdMaquina());

                    Timer timer = new Timer();

                    TimerTask tarefa = new TimerTask() {
                        Integer contagem = 0;

                        public void run() {

                            registro.setCpuPorcentagemUso(cpuCollector.getUsoCpu());
                            registro.setDiscoDisponivel(discoCollector.getDiscoDisponivel());
                            registro.setRamUtilizada(ramCollector.getMemoriaUtilizada());
                            registro.setQtdDispositivosConectados(usbCollector.getQuantidadeUsbConectados());
                            contagem++;
                            LocalDateTime dataHorario = LocalDateTime.now();

                            System.out.println("""
                                    Coletando... %d
                                    """.formatted(contagem));

                            DateTimeFormatter formatadorDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                            System.out.println("""
                                    Registro %d
                                    Data e horario: %s
                                    """.formatted(contagem, formatadorDataHora.format(dataHorario)));

                            registroModel.inserirRegistroMySql(registro, finalEspecificacaoMaquinaMySql.getIdEspecificacaoMaquina());
                            registroModel.inserirDadosRegistroSqlServer(registro, finalEspecificacaoMaquinaSqlServer.getIdEspecificacaoMaquina());

                            System.out.println("Registros inseridos!");
//                                slackModel.verificarRegistro(registro, especificacaoMaquinaMySql);
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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }}