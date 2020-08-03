package br.com.sky.javacore.l03sobrecargametodos.test;

import br.com.sky.javacore.l03sobrecargametodos.classes.Funcionario;

public class FuncionarioTest {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("Silvano", "222-222-222-22", 5400, "13424");
        Funcionario funcionario1 = new Funcionario();
        funcionario1.init("Cu","222222222",4000,"2000");
        funcionario.imprime();
        funcionario1.imprime();
    }
}
