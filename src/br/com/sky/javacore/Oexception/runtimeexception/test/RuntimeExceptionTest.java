package br.com.sky.javacore.Oexception.runtimeexception.test;

public class RuntimeExceptionTest {
    public static void main(String[] args) {
        divisao(10,0);

    }

    private static void divisao(double num1, double num2) {
        if(num2 == 0) {
            throw new IllegalArgumentException("Digite um valor diferente de zero");
        } else {
            double num3 = num1 / num2;
            System.out.println(num3);
        }
    }
}
//-----------------------------------------------------------------------------------
//        ArithimeticException:                                                     |
//                                                                                  |
//        int a = 10;                                                               |
//        int b = -12;                                                              |
//        if(b != 0) {                                                              |
//            int c = a / b;                                                        |
//            System.out.println(c);                                                |
//        }                                                                         |
//-----------------------------------------------------------------------------------
//        NullPointerException:                                                     |
//                                                                                  |
//        Object o = null;                                                          |
//        System.out.println(o.toString());                                         |
//-----------------------------------------------------------------------------------

















