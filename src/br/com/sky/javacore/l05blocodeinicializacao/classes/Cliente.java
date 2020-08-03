package br.com.sky.javacore.l05blocodeinicializacao.classes;

public class Cliente {
    // 1° - Alocação da memória para criação do objeto.
    // 2° - Atributos de classes são criados e inicializados com os seus valores padrões ou explicitos.
    // 3° - Bloco de inicialização é executado.
    // 4° - O contrutor é executado.
    private int[] parcelas;
    {
        this.parcelas = new int[100];
        System.out.println("Bloco de inicialização");
        for (int i = 1; i<=100; i++) {
            this.parcelas[i-1] = i;
        }
    }
    public Cliente() {
        for (int par : this.parcelas) {
            System.out.print(par);
            if (par != 100) {
                System.out.print(", ");
            } else {
                continue;
            }
        }
    }

    public int[] getParcelas() {
        return parcelas;
    }

    public void setParcelas(int[] parcelas) {
        this.parcelas = parcelas;
    }
}
