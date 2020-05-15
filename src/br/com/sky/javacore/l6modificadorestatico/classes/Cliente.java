package br.com.sky.javacore.l6modificadorestatico.classes;

public class Cliente {
    // 1° - Bloco de inicialização estatico é executado (apenas uma vez) quando a JVM carregar a classe.
    // 2° - Alocação da memória para criação do objeto.
    // 3° - Atributos de classes são criados e inicializados com os seus valores padrões ou explicitos.
    // 4° - Bloco de inicialização é executado.
    // 5° - O construtor é executado.
    private static int[] parcelas;

     static {
        parcelas = new int[100];
        System.out.println("Bloco de inicialização");
        for (int i = 1; i <= 100; i++) {
            parcelas[i - 1] = i;
        }
    }

    public Cliente() {
    }

    public static int[] getParcelas() {
        return Cliente.parcelas;
    }

}
