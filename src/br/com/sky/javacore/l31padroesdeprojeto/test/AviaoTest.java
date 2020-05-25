package br.com.sky.javacore.l31padroesdeprojeto.test;

import br.com.sky.javacore.l31padroesdeprojeto.classes.Aviao;
import br.com.sky.javacore.l31padroesdeprojeto.classes.AviaoSingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AviaoTest {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        agendarAssento("1A");
        agendarAssento("1A");
        AviaoSingleton aviaoSingleton = AviaoSingleton.getINSTANCE();
        AviaoSingleton aviaoSingleton2 = null;
        Constructor[] constructors = AviaoSingleton.class.getDeclaredConstructors();
        for (Constructor c : constructors) {
            c.setAccessible(true);
            aviaoSingleton2 = (AviaoSingleton) c.newInstance();
            break;
        }
        System.out.println(aviaoSingleton.hashCode());
        System.out.println(aviaoSingleton2.hashCode());
    }

    private static void agendarAssento(String assento) {
        Aviao a = Aviao.createAviao();
        System.out.println(a.bookAssento(assento));
    }

}
