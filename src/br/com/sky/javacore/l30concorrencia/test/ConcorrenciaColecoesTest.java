package br.com.sky.javacore.l30concorrencia.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcorrenciaColecoesTest {
    public static void main(String[] args) {
        // ConcurrentHashMap
        // ConcurrentLinkedDeque
        // ConcurrentLinkedQueue
        // ConcurrentSkipListMap
        // ConcurrentSkipLisSet

        ConcurrentMap<String, String> map = new ConcurrentHashMap<>();


        map.put("1", "2");
        map.putIfAbsent("1", "1");
        System.out.println(map.get("1"));

    }
}
