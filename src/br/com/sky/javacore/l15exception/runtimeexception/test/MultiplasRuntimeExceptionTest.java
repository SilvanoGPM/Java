package br.com.sky.javacore.l15exception.runtimeexception.test;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class MultiplasRuntimeExceptionTest {
    public static void main(String[] args) {
        try{

        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Dentro do ArrayIndexOutOfBoundsException");
        }catch (IllegalArgumentException e) {
            System.out.println("Dentro do IllegalArgumentException");
        }catch (ArithmeticException e) {
            System.out.println("Dentro do ArithmeticException");
        }

        try {
            talvezLanceException();
        } catch (IOException | SQLException e) {

        }
    }

    private static void talvezLanceException() throws SQLException, FileNotFoundException {

    }
}
