package br.com.sky.javacore.l38completablefuture.classes;

import java.util.concurrent.TimeUnit;

public class Desconto {
    public enum Code {
        NENHUM(0), SILVER(5), GOLD(10), PLATINUM(15), ELITE(20);
        private final int porcentagem;

        Code(int porcentagem) {
            this.porcentagem = porcentagem;
        }

        public int getPorcentagem() {
            return porcentagem;
        }
    }

    public static String calcularDesconto(Orcamento orcamento) {
        return String.format("%s o preco original: %.2f, desconto: %d, preço final: %.2f",
                orcamento.getNomeLoja(),
                orcamento.getPreco(),
                orcamento.getDesconto().getPorcentagem(),
                calculoDesconto(
                        orcamento.getPreco(),
                        orcamento.getDesconto().getPorcentagem()
                ));

    }

    private static double calculoDesconto(double preco, int code) {
        delay();
        return  preco -(preco * code) / 100;
    }

    private static void delay() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
