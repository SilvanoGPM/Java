package br.com.sky.javacore.l32comportamentoporparametro.predicate;

import br.com.sky.javacore.l32comportamentoporparametro.classes.Carro;
import br.com.sky.javacore.l32comportamentoporparametro.interfaces.CarroPredicate;

public class CarrosCorVerdePredicate implements CarroPredicate {

    @Override
    public boolean test(Carro carro) {

        return carro.getCor().equals("Verde");

    }

}
