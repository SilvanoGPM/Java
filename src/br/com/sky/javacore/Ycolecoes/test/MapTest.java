package br.com.sky.javacore.Ycolecoes.test;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("teklado", "teclado");
        map.put("mause", "mouse");
        map.put("vc", "você");

        for (String key : map.values()) {
            System.out.println(key);
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey()+ " = " +entry.getValue());
        }
    }
}
