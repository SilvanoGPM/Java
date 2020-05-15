package br.com.sky.javacore.l25colecoes.test;

import br.com.sky.javacore.l25colecoes.classes.Celular;
import br.com.sky.javacore.l25colecoes.classes.Produto;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;


class CelularNomeComparator  implements Comparator<Celular> {

    @Override
    public int compare(Celular o1, Celular o2) {
        return o1.getNome().compareTo(o2.getNome());
    }

}

public class TreeSetTest {
    public static void main(String[] args) {
        Produto produto1 = new Produto("123", "Laptop Lenovo", 2000.0, 0);
        Produto produto2 = new Produto("321", "Picanha", 26.4, 10);
        Produto produto3 = new Produto("879", "Teclado Razer", 100.0, 5);
        Produto produto4 = new Produto("000", "Samsumg Galaxy S7 64GB", 3250.5, 0);
        Produto produto5 = new Produto("000", "Samsumg Galaxy S7 64GB", 3250.5, 0);
        Celular celular = new Celular("Iphone 7", "1234");
        NavigableSet<Produto> produtoNavigableSet = new TreeSet<>();
        NavigableSet<Celular> celularNavigableSet = new TreeSet<>(new CelularNomeComparator());
        produtoNavigableSet.add(produto1);
        produtoNavigableSet.add(produto2);
        produtoNavigableSet.add(produto3);
        produtoNavigableSet.add(produto4);
        produtoNavigableSet.add(produto5);

        // Para ordem decresente, .descendingSet()

        for (Produto produto : produtoNavigableSet.descendingSet()) {
            System.out.println(produto);
        }

        // lower <
        // floor <=
        // higher >
        // ceiling >=

        System.out.println("-----------------------------");
        System.out.println(produtoNavigableSet.lower(produto4));

        // pollLast : Retorna o primeiro item do treeSet e o remove.
        // pollFirst : Retorna o último item do treeSet e o remove.
    }
}
