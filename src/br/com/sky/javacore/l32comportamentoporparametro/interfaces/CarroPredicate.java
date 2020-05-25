package br.com.sky.javacore.l32comportamentoporparametro.interfaces;

import br.com.sky.javacore.l32comportamentoporparametro.classes.Carro;

@FunctionalInterface
public interface CarroPredicate {

    boolean test(Carro carro);

}
