package br.com.sky.javacore.l31padroesdeprojeto.classes;

public interface Moeda {

    String getSimbolo();


}
class Real implements Moeda {

    @Override
    public String getSimbolo() {
        return "R$";
    }
}

class USDolar implements Moeda {

    @Override
    public String getSimbolo() {
        return "USD";
    }

}