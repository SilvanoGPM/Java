package br.com.sky.javacore.l34default.interfaces;

public interface MyList {

    static void sort() {
        System.out.println("Dentro do sort");
    }

    void add();

    default void remove(){
        System.out.println("Dentro do remove");
    };

}
