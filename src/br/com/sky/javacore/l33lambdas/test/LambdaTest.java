package br.com.sky.javacore.l33lambdas.test;

import br.com.sky.javacore.l33lambdas.classes.Carro;
import br.com.sky.javacore.l33lambdas.interfaces.CarroPredicate;

import java.util.function.Predicate;

public class LambdaTest {
    // anonima
    // função
    // passada a métodos e vaviáveis
    // concisa
    // (Carro carro) -> carro.getCor().equals("Verde);
    // (String s) -> s.length();
    // (int a, int b) -> System.out.print(a+b);
    public static void main(String[] args) {

        CarroPredicate carroPredicate = new CarroPredicate() {
            @Override
            public boolean test(Carro carro) {
                return carro.getCor().equals("Verde");
            }
        };

        Predicate<Carro> carroPredicate2 = (Carro carro) -> carro.getCor().equals("Verde");

        System.out.println(carroPredicate2.test(new Carro("Verde", 2004)));

        Runnable runnable = () -> System.out.println("Dentro do run");

        new Thread(runnable).start();
        new Thread(() -> System.out.println("A")).start();

    }

}
