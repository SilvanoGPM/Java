package br.com.sky.javacore.l32comportamentoporparametro.predicate;

import br.com.sky.javacore.l32comportamentoporparametro.classes.Carro;
import br.com.sky.javacore.l32comportamentoporparametro.interfaces.CarroPredicate;

import java.util.Calendar;

public class CarrosDezAnosRecentePredicate implements CarroPredicate {

    @Override
    public boolean test(Carro carro) {
        return carro.getAno() > (Calendar.getInstance().get(Calendar.YEAR)) - 10;
    }

}
