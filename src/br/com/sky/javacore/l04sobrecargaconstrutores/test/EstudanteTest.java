package br.com.sky.javacore.l04sobrecargaconstrutores.test;

import br.com.sky.javacore.l04sobrecargaconstrutores.classes.Estudante;

public class EstudanteTest {
    public static void main(String[] args) {
        Estudante estudante = new Estudante("122212","Goku", new double[]{10,6,8},"20/10/1999");
        estudante.imprime();
    }
}
