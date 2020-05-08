package br.com.sky.javacore.Kenum.test;

import br.com.sky.javacore.Kenum.classes.Cliente;
import br.com.sky.javacore.Kenum.classes.TipoCliente;

public class ClienteTest {
    public static void main(String[] args) {
        Cliente c = new Cliente("Anna", TipoCliente.PESSOA_FISICA, Cliente.TipoPagamento.AVISTA);
        System.out.println(TipoCliente.PESSOA_FISICA.getId());
        System.out.println(TipoCliente.PESSOA_JURIDICA.getId());
        System.out.println(c);
    }
}
