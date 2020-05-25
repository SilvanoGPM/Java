package br.com.sky.javacore.l33lambdas.interfaces;

import br.com.sky.javacore.l33lambdas.classes.Carro;

@FunctionalInterface
public interface CarroPredicate {

    boolean test(Carro carro);

}
