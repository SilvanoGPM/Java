package br.com.sky.javacore.l05blocodeinicializacao.classes;

public class ClienteDois {
    private int[] parcelas = {1,2,3,4,5,6,7,8,9,10};

    {

    }

    public void mostrarParcelas() {
        System.out.println("Parcelas: ");
        for (int par : this.parcelas) {
            System.out.print(par+".. ");
        }
    }


    public int[] getParcelas() {
        return parcelas;
    }

    public void setParcelas(int[] parcelas) {
        this.parcelas = parcelas;
    }
}
