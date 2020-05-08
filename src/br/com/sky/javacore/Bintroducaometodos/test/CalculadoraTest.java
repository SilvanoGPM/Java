package br.com.sky.javacore.Bintroducaometodos.test;

import br.com.sky.javacore.Bintroducaometodos.classes.Calculadora;

public class CalculadoraTest {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        calc.somaDoisNumeros();
        calc.subtraiDoisNumeros();
        int n1 = 5;  int n2 = 5;
        calc.multiplicaDoisNumeros(n1,n2);
        double divisao = calc.divideDoisNumeros(20, 2);
        if (divisao == 0) {
            System.out.println("Zero não pode ser dividido");
        } else {
            System.out.println(divisao);
        }

        int[] numeros = {1,2,3,4,5};
        calc.somaArray(numeros);
        calc.somaVarArgs(1,2,3,4,5);
    }
}
