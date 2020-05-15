package br.com.sky.javacore.l15exception.customexception;

public class LoginInvalidoException extends Exception{

    public LoginInvalidoException() {
        super("Usuario ou senha inválidos!");
    }
}
