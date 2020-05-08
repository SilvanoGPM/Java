
package br.com.sky.javacore.Qwrappers.test;

public class WrappersTest {
    public static void main(String[] args) {
        byte bytePrimitivo = 1;
        short shortPrimitivo = 1;
        int intPrimitivo = 1;
        long longPrimitivo = 1;
        float floatPrimitivo = 1;
        double doublePrimitivo = 1;
        char charPrimitivo = 1;
        boolean boolPrimitivo = true;

        Byte byteWrapper = 1;
        Short shortWrapper = 1;
        Integer integerWrapper = 1;
        Long longWrapper = Long.valueOf("10");
        Float floatWrapper = 1f;
        Double doubleWrapper = 1d;
        Character characterWrapper = '1';
        Boolean boolWrapper = true;
        System.out.println(Character.compare('A','A'));
    }
}
