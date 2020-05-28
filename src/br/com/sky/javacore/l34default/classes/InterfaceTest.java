package br.com.sky.javacore.l34default.classes;

import br.com.sky.javacore.l33lambdas.classes.Carro;
import br.com.sky.javacore.l33lambdas.classes.ComparadorCarro;
import br.com.sky.javacore.l34default.interfaces.MyList;

import java.util.ArrayList;
import java.util.List;

public class InterfaceTest implements MyList {
    public static void main(String[] args) {
        MyList.sort();
        new InterfaceTest().remove();
        List<Carro> s = new ArrayList<>();
        s.sort(ComparadorCarro::compareByColor);
    }

    @Override
    public void add() {
        System.out.println("Dentro do add");
    }
}
