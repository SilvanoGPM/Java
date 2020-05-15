package br.com.sky.javacore.l2introducaometodos.classes;

public class Metodos {

    public void mensagem (String msg1, String msg2) {
        System.out.println(msg1+msg2);
    }

    public void vddOuFalso (boolean vdd, boolean falso) {
        if (vdd == true) {
            System.out.println("Verdade");
        } else if (falso == false) {
            System.out.println("Falso");
        } else {
            System.out.println("eR%oR");
        }
    }

    public void questionario (char A, char B, char C, char D) {
        System.out.println("Questão 1: "+A);
        System.out.println("Questão 2: "+B);
        System.out.println("Questão 3: "+C);
        System.out.println("Questão 4: "+D);
    }

    public boolean gayOuNao (String nome) {
        if (nome == "Silvano") {
            return false;
        }
        return true;
    }


}
