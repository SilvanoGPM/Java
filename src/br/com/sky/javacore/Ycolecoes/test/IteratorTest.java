package br.com.sky.javacore.Ycolecoes.test;

import br.com.sky.javacore.Ycolecoes.classes.Produto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        Produto produto1 = new Produto("123", "Laptop Lenovo", 2000.0, 0);
        Produto produto2 = new Produto("321", "Picanha", 26.4, 10);
        Produto produto3 = new Produto("879", "Teclado Razer", 100.0, 5);
        Produto produto4 = new Produto("000", "Samsumg Galaxy S7 64GB", 3250.5, 0);
        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);
        produtos.add(produto4);

        Iterator<Produto> produtoIterator = produtos.iterator();
        System.out.println(produtos.size());
        while (produtoIterator.hasNext()) {
            Produto produto = produtoIterator.next();
            if (produto.getQuantidades() == 0) {
                produtoIterator.remove();
            }
        }
        System.out.println(produtos.size());
    }
}
