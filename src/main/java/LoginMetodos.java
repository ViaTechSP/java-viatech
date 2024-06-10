import log.Log;
import com.github.britooo.looca.api.core.Looca;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class LoginMetodos {

    private void salvarLog(Log log) {
        // formatar a data atual para usar no nome do arquivo de log
        String dataAtual = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String nomeArquivoLog = String.format("./logs/log-%s.txt", dataAtual);

        try (FileWriter writer = new FileWriter(nomeArquivoLog, true)) {
            writer.write(log.toString() + "\n");
        } catch (IOException e) {
            System.out.println("Erro ao salvar log: " + e.getMessage());
        }
    }

    boolean validarEmail(String emailUsuario) {
        Looca looca = new Looca();
        Log log = new Log();
        boolean validar = true;

        if (emailUsuario.contains("@") && emailUsuario.contains(".")) {
            // configurando log para sucesso de validação de email
            log.setSistemaOperacional(looca.getSistema().getSistemaOperacional());
            log.setArquitetura(looca.getSistema().getArquitetura());
            log.setHostname(looca.getRede().getParametros().getHostName());
            log.setData(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS").format(new Date()));
            log.setMensagem("Validação de email realizada com sucesso");
            log.setLogLevel("INFO");
            log.setStatusCode(200);

            // exibindo e salvando log
            System.out.println(log.toString());
            salvarLog(log);
        } else {
            System.out.println("O e-mail está inválido");
            validar = false;

            // configurando log para erro de validação de email
            log.setSistemaOperacional(looca.getSistema().getSistemaOperacional());
            log.setArquitetura(looca.getSistema().getArquitetura());
            log.setHostname(looca.getRede().getParametros().getHostName());
            log.setData(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS").format(new Date()));
            log.setMensagem("Erro ao validar email: e-mail invalido");
            log.setLogLevel("ERROR");
            log.setStatusCode(400);

            // exibindo e salvando log
            System.out.println(log.toString());
            salvarLog(log);
        }
        return validar;
    }

    boolean validarSenha(String senhaUsuario) {
        Looca looca = new Looca();
        Log log = new Log();
        boolean validar = true;

        if (senhaUsuario.length() >= 6 && (senhaUsuario.contains("!") || senhaUsuario.contains("@") || senhaUsuario.contains("#") || senhaUsuario.contains("$") || senhaUsuario.contains("%") || senhaUsuario.contains("?"))) {
            // configurando log para sucesso de validação de senha
            log.setSistemaOperacional(looca.getSistema().getSistemaOperacional());
            log.setArquitetura(looca.getSistema().getArquitetura());
            log.setHostname(looca.getRede().getParametros().getHostName());
            log.setData(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS").format(new Date()));
            log.setMensagem("Validação de senha realizada com sucesso");
            log.setLogLevel("INFO");
            log.setStatusCode(200);

            // exibindo e salvando log
            System.out.println(log.toString());
            salvarLog(log);
        } else {
            System.out.println("A senha está inválida!");
            validar = false;

            // configurando log para erro de validação de senha
            log.setSistemaOperacional(looca.getSistema().getSistemaOperacional());
            log.setArquitetura(looca.getSistema().getArquitetura());
            log.setHostname(looca.getRede().getParametros().getHostName());
            log.setData(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS").format(new Date()));
            log.setMensagem("Erro ao validar senha: senha incorreta");
            log.setLogLevel("ERROR");
            log.setStatusCode(400);

            // exibindo e salvando log
            System.out.println(log.toString());
            salvarLog(log);
        }
        return validar;
    }
}