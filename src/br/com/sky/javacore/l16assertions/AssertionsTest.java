package br.com.sky.javacore.l16assertions;

public class AssertionsTest {
    public static void main(String[] args) {
        calculaSalario(-10);
    }

    public static void calculaSalario(double salario) {
        assert !(salario > 0);
    }
}
