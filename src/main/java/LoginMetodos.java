public class LoginMetodos {
    boolean validarEmail(String emailUsuario) {
        boolean validar = true;

        if (emailUsuario.contains("@") && emailUsuario.contains(".")) {

        } else {
            System.out.println("O e-mail está inválido");
            validar = false;
        }
        return validar;
    }

    boolean validarSenha(String senhaUsuario) {
        boolean validar = true;

        if (senhaUsuario.length() >= 6 && (senhaUsuario.contains("!") || senhaUsuario.contains("@") || senhaUsuario.contains("#") || senhaUsuario.contains("$") || senhaUsuario.contains("%") || senhaUsuario.contains("?"))) {
        } else {
            System.out.println("A senha está inválida!");
            validar = false;
        }
        return validar;
    }
}
