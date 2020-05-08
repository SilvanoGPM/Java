package br.com.sky.javacore.Ycolecoes.test;

import br.com.sky.javacore.Ycolecoes.classes.Produto;

import java.util.*;

class ProdutoNomeComparator implements Comparator<Produto> {

    @Override
    public int compare(Produto o1, Produto o2) {
        return o1.getNome().compareTo(o2.getNome());
    }
}

public class SortProdutoTest {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        Produto[] produtos1 = new Produto[4];

        produtos.add(new Produto("123","Laptop Lenovo", 2000.0));
        produtos.add(new Produto("321","Picanha", 26.4));
        produtos.add(new Produto("879","Teclado Razer", 100.0));
        produtos.add(new Produto("000","Samsumg Galaxy S7 64GB", 3250.5));

        produtos1[0] = produtos.get(0);
        produtos1[1] = produtos.get(1);
        produtos1[2] = produtos.get(2);
        produtos1[3] = produtos.get(3);

        Collections.sort(produtos, new ProdutoNomeComparator());
        Arrays.sort(produtos1);
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
        System.out.println("------------------------------");
        for (Produto produto : produtos1) {
            System.out.println(produto);
        }
    }
}
