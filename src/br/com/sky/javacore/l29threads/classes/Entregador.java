package br.com.sky.javacore.l29threads.classes;

public class Entregador implements Runnable {

    private ListaMembros listaMembros;

    public Entregador(ListaMembros listaMembros) {
        this.listaMembros = listaMembros;
    }

    @Override
    public void run() {
        String nomeThread = Thread.currentThread().getName();
        System.out.println(nomeThread+" Comecando as entregas!");
        int quantidadePendente = listaMembros.getEmailsPedentes();
        boolean aberta = listaMembros.isAberta();
        while (aberta || quantidadePendente > 0) {
            try {
                String email = listaMembros.obterEmailMembro();
                if (email != null) {
                    System.out.println(nomeThread+": Enviando email para "+email);
                    Thread.sleep(2000);
                    System.out.println("Envio para "+email+" concluido com sucesso!");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            aberta = listaMembros.isAberta();
            quantidadePendente = listaMembros.getEmailsPedentes();
        }
        System.out.println("Atividades finalizadas!");
    }
}
