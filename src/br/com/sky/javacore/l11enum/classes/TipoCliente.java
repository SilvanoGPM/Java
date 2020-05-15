package br.com.sky.javacore.l11enum.classes;

public enum TipoCliente {
    // constant specific class body.
    PESSOA_FISICA(1,"Pessoa física") {
        public String getId() {
            return "A";
        }
    }, PESSOA_JURIDICA(2, "Pessoa Jurídica");

    private int tipo;
    private String nome;

    TipoCliente(int tipo, String nome) {
        this.tipo = tipo;
        this.nome = nome;
    }

    public String getId() {
        return "B";
    }

    public int getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }
}
