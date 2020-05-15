package br.com.sky.javacore.l25colecoes.test;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<String> queue = new PriorityQueue<>();
        queue.add("C");
        queue.add("D");
        queue.add("A");
        queue.add("B");
        System.out.println(queue.poll());

        // remove = Retorna e remove o primeiro elemento dessa Queue, lança uma excessão se estiver vazia.
        // peek = Pega o primeiro elemento sem o remove-lo.
        // poll = Pega o primeiro elemnto e o remove.
    }
}
