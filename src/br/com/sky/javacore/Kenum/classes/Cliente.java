package br.com.sky.javacore.Kenum.classes;

public class Cliente {
    public enum TipoPagamento {
        AVISTA(1,"A vista"), APRAZO(2, "A prazo");

        private int tipo;
        private String nome;

        TipoPagamento(int tipo, String nome) {
            this.tipo = tipo;
            this.nome = nome;
        }
    }
    private TipoPagamento tipoPagamento;
    private String nome;
    private TipoCliente TIPO;

    public Cliente(String nome, TipoCliente TIPO, TipoPagamento tipoPagamento) {
        this.nome = nome;
        this.TIPO = TIPO;
        this.tipoPagamento = tipoPagamento;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "tipoPagamento=" + tipoPagamento.tipo +
                ", nome='" + nome + '\'' +
                ", TIPO=" + TIPO.getNome() +
                '}';
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public TipoCliente getTIPO() {
        return TIPO;
    }

    public void setTIPO(TipoCliente TIPO) {
        this.TIPO = TIPO;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
