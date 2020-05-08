package br.com.sky.javacore.Texpressoesregulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressoesRegulares {
    public static void main(String[] args) {
        // \d = Somente dígitos.
        // \D = Tudo que não for dígito.
        // \s = Somente espaços em brancos.
        // \S = Tudo que não for espaço em branco. (\t \n \f \r)
        // \w = Caracteres usados para escrever palavras. ( a-z A-Z 0... _ )
        // \W = Caracteres não usados para escrever palavras.
        // [] = Tudo colocado dentro dos colchetes é pesquisado. EX: [abcABC0124] ou [a-fA-Z0-9]
        // ! = Zero ou Uma Ocorrência.
        // * = Zero ou Mais Ocorrência.
        // + = Uma ou Mais Ocorrência.
        // - = Indicação de range. EX: [a-z](vai de a(minusculo) ate z(minusculo).
        // {n,m} = De N ate M ocorrências.
        // ( ) = Agrupar.
        // | = Ou(or).
        // ^ = Começo de linha.
        // $ = Fim de Linha.
        // . = Caractere Coringa. (pode ser substituido por qualquer caractere)
        // ~ = Excluir determinado caractere.
//        String padrao = "0[xX]([0-9a-fA-F])+(\\s|$)";
//        String textoParaProcurar = "0X 12 0XFFABC 0X10G 0X1";
//        String padrao = "([a-zA-Z0-9\\._-])+@([a-zA-z])+(\\.([a-zA-z])+)+";
//        String textoParaProcurar = "fulano@hotmail.com 102Abc@gmail.com  #!@abrao@mail.coString padrao = "([a-zA-Z0-9\\._-])+@([a-zA-z])+(\\.([a-zA-z])+)+";
        String padrao = "\\d{2}/\\d{2}/(\\d{2}|\\d{4})(\\s|$)";
        String textoParaProcurar ="05/10/2010 05/5/2015 01/1/03 01/05/853 ";
        Pattern pattern = Pattern.compile(padrao);
        Matcher matcher = pattern.matcher(textoParaProcurar);
        System.out.println("Texto:  " + textoParaProcurar);
        System.out.println("Índice: 0123456789");
        System.out.println("Expressão a ser encontrada: " + matcher.pattern());
        System.out.println("Expressões encontradas no íncides: ");
        while (matcher.find()) {
            System.out.print(matcher.start() + " : ");
            System.out.println(matcher.group());
        }
    }
}
