package br.com.sky.javacore.l21resourcebundle.test;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest {
    public static void main(String[] args) {
        // Locale locale = new Locale("en", "US");
        // ResourceBundle rb = ResourceBundle.getBundle("messages",locale);
        // 1° messages_en_US.properties
        // 2° messages_en.properties
        // 3° messages_pt_BR.properties
        // 4° messages_pt_properties
        // 5° messages.properties
        // Lança uma exception
        System.out.println(Locale.getDefault());
        ResourceBundle rb = ResourceBundle.getBundle("messages", new Locale("pt","BR"));
        System.out.println(rb.getString("hello"));
        rb = ResourceBundle.getBundle("messages", new Locale("en", "US"));
        System.out.println(rb.getString("hello"));
        System.out.println(rb.getString("dance"));
    }
}
