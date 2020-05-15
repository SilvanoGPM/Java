package br.com.sky.javacore.l25colecoes.classes;


public class Celular {

    // ATTRIBUTES

    private String nome;
    private String imei;

    // CONSTRUCTORS

    public Celular(String nome, String imei) {
        this.nome = nome;
        this.imei = imei;
    }

    // OVERRIDES

    @Override
    public String toString() {
        return "Celular:" +
                "\nNome: "+ this.nome +
                "\nIMEI: "+ this.imei;

    }

    // Reflexivo: x.equals(x) tem que ser true ne o X não for nulo.
    // Simetrico: Se x.equals(y) == true, y.equals(x) tem que ser == true também(Desde de que x e y sejam diferentes de nulo).
    // Transitividade: Se x.equals(y) == true, y.equals(x) == true E z.equals(x) == true, z.equals(y) também tem que ser true(Desde de que x, y e z sejam diferentes de nulo).
    // Consistente: x.equals(y) tem que retornar sempre o mesmo valor.
    // Qualquer coisa comparada com null(NULO) tem que retornar false(FALSO).

    @Override
    public int hashCode() {
        return imei != null ? imei.hashCode() : 1;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (this.getClass() != obj.getClass()) return false;
        Celular outroCelular = (Celular) obj;
        return imei != null && imei.equals(outroCelular.getImei());
    }

    // GETTERS AND SETTERS

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }
}
