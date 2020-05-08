package br.com.sky.introducao;

public class Exercicio06 {
    public static void main(String[] args) {
            double valorTotal = 30000;
            for (int parcela = 1; parcela <= valorTotal; parcela++) {
                double valorParcela = valorTotal / parcela;
                System.out.printf("Parcela "+parcela+" R$ %.2f",valorParcela);
                System.out.println();
                if (valorParcela < 1000) {
                    break;
                }
            }
        System.out.println("Fora");
    }
}
