package br.com.sky.javacore.Oexception.customexception;

public class LoginInvalidoException extends Exception{

    public LoginInvalidoException() {
        super("Usuario ou senha inválidos!");
    }
}
