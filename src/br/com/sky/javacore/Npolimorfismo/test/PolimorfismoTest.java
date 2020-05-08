package br.com.sky.javacore.Npolimorfismo.test;

import br.com.sky.javacore.Npolimorfismo.classes.Gerente;
import br.com.sky.javacore.Npolimorfismo.classes.RelatorioPagamento;
import br.com.sky.javacore.Npolimorfismo.classes.Vendedor;

public class PolimorfismoTest {
    public static void main(String[] args) {
        Gerente g = new Gerente(5000,"Silvano",2000);
        Vendedor v = new Vendedor(2000, "Yuri", 20000);
        RelatorioPagamento relatorio = new RelatorioPagamento();
        relatorio.relatorioPagamentoGenerio(g);
        System.out.println("--------------------------------------");
        relatorio.relatorioPagamentoGenerio(v);

    }
}
