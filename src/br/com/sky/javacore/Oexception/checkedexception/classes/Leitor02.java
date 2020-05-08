package br.com.sky.javacore.Oexception.checkedexception.classes;

public class Leitor02 implements AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("Fechando leitor02");
    }
}
