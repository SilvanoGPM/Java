package br.com.sky.javacore.Oexception.checkedexception.test;

import br.com.sky.javacore.Oexception.customexception.LoginInvalidoException;

public class CustomExceptionTest {
    public static void main(String[] args) {
        try {
            logar();
        } catch (LoginInvalidoException e) {
            e.printStackTrace();
        }
    }

    private static void logar() throws LoginInvalidoException {
        String usuario = "Goku";
        String senha = "111";
        String usuarioDigitado = "Goku";
        String senhaDigitada = "113";
        if(!usuario.equals(usuarioDigitado) || !senha.equals(senhaDigitada)) {
            throw new LoginInvalidoException();
        } else {
            System.out.println("LOGADO!");
        }

    }
}

