package br.com.sky.javacore.l32comportamentoporparametro.test;

import br.com.sky.javacore.l32comportamentoporparametro.classes.Carro;
import br.com.sky.javacore.l32comportamentoporparametro.interfaces.CarroPredicate;
import br.com.sky.javacore.l32comportamentoporparametro.predicate.CarrosCorVerdePredicate;
import br.com.sky.javacore.l32comportamentoporparametro.predicate.CarrosDezAnosRecentePredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.util.Arrays.asList;

public class CarroTest {

    private static List<Carro> filtrarCarroPorCor(List<Carro> carros, String cor) {
        List<Carro> result = new ArrayList<>();

        for (Carro carro : carros) {
            if (carro.getCor().equals(cor)) result.add(carro);
        }

        return result;

    }

    public static List<Carro> filtrarCarros(List<Carro> carros, CarroPredicate carroPredicate) {

        List<Carro> result = new ArrayList<>();
        for (Carro carro : carros) {
            if (carroPredicate.test(carro)) {
                result.add(carro);
            }
        }

        return result;

    }

    public static <T> List<T> filtrar(List<T> carros, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();

        for (T e : carros) {
            if (predicate.test(e)) result.add(e);
        }

        return result;

    }

    public static void main(String[] args) {
        List<Carro> carros = asList(new Carro("Verde", 2011), new Carro("Vermelho", 1995), new Carro("Preto",2017));

        List<Integer> numbers = asList(1,2,3,4,5,6,7,8,9,10);

        System.out.println(filtrarCarros(carros, new CarrosCorVerdePredicate()));
        System.out.println(filtrarCarros(carros, new CarrosDezAnosRecentePredicate()));
        System.out.println(filtrarCarros(carros, new CarroPredicate() {
            @Override
            public boolean test(Carro carro) {
                return carro.getCor().equals("Vermelho");
            }
        }));

        System.out.println(filtrar(numbers, new Predicate<Integer>() {

            @Override
            public boolean test(Integer num) {
                return num % 2 == 0;
            }

        }));


    }



}
