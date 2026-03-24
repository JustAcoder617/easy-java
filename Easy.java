package br.com.justacoder.easyjava; // Endereço oficial do seu pacote

import java.util.Scanner;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpResponse.BodySubscribers;
public class Easy{
    private static Scanner leitor = new Scanner(System.in);

    // Seu método print (usando System.out em vez de err para cor padrão)
    public static void print(Object printar) {
        System.out.println(printar);
    }

    // Seu scanf estilo C
    public static Object scanf(String tipo) {
        if (tipo.equals("i")) {
            int coisa = leitor.nextInt();
            leitor.nextLine();
            return coisa;
        }
        if (tipo.equals("d")) {
            double coisa = leitor.nextDouble();
            leitor.nextLine();
            return coisa;
        }
        if (tipo.equals("s")) {
            return leitor.next();
        }
        return null;
    }

    public static String fgets() {
        return leitor.nextLine();
    }
    public static int strlen(String s) {
        return s.length();
    }

    public static boolean strcmp(String s1, String s2) {
        return s1.equals(s2);
    }
}