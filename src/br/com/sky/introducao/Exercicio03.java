package br.com.sky.introducao;

public class Exercicio03 {
    public static void main(String[] args) {
        float salario = 5500f;
        float imposto;
        if (salario < 1000) {
            imposto = (salario *= 0.05);
        } else if ( salario >= 1000 && salario < 2000) {
            imposto = (salario *= 0.1);
        } else if (salario >= 2000 && salario < 4000) {
            imposto = (salario *= 0.15);
        } else {
            imposto = (salario *= 0.2);
        }
        System.out.println("O imposto foi de: R$"+imposto+" reais");
    }
}
