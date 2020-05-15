package br.com.sky.javacore.l12classesabstratas.test;

import br.com.sky.javacore.l12classesabstratas.classes.Gerente;
import br.com.sky.javacore.l12classesabstratas.classes.Vendedor;

public class FuncionarioTest {
    public static void main(String[] args) {
        Vendedor f = new Vendedor("Silvano","22011-2",2000,503);
        Gerente g = new Gerente("Anno","22011-2",2000);
        f.calculaSalario();
        g.calculaSalario();
        System.out.println(g);
        System.out.println(f);
    }
}
