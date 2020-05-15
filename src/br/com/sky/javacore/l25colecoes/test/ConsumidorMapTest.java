package br.com.sky.javacore.l25colecoes.test;

import br.com.sky.javacore.l25colecoes.classes.Consumidor;
import br.com.sky.javacore.l25colecoes.classes.Produto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsumidorMapTest {
    public static void main(String[] args) {
        Consumidor  consumidor = new Consumidor("Silvano", "122");
        Consumidor skyPage = new Consumidor("SkyPage", "231");
        Produto produto1 = new Produto("123", "Laptop Lenovo", 2000.0, 0);
        Produto produto2 = new Produto("321", "Picanha", 26.4, 10);
        Produto produto3 = new Produto("879", "Teclado Razer", 100.0, 5);
        Produto produto4 = new Produto("000", "Samsumg Galaxy S7 64GB", 3250.5, 0);

        Map<Consumidor, List<Produto>> map = new HashMap<>();
        List<Produto> produtoList = new ArrayList<>();
        produtoList.add(produto1);
        produtoList.add(produto2);

        List<Produto> produtoList2 = new ArrayList<>();
        produtoList2.add(produto3);
        produtoList2.add(produto4);

        map.put(consumidor, produtoList);
        map.put(skyPage, produtoList2);

        for (Map.Entry<Consumidor, List<Produto>> entry : map.entrySet()) {
            System.out.print(entry.getKey().getNome() + " = ");
            for (Produto produto : entry.getValue()) {
                System.out.println(produto.getNome());
            }
        }
    }
}
