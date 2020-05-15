package br.com.sky.javacore.l15exception.checkedexception.classes;

public class Leitor02 implements AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("Fechando leitor02");
    }
}
