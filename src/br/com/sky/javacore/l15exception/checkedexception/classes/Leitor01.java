package br.com.sky.javacore.l15exception.checkedexception.classes;

public class Leitor01 implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("Fechando leitor01");
    }
}
