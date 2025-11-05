package Ejercicio3;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        final BigInteger MAX_INT = BigInteger.valueOf(Integer.MAX_VALUE);
        System.out.println("Ingrese la cantidad de entradas que le dará al programa");
        int n=Integer.parseInt(sc.nextLine());
        for(int i=1;i<=n;i++){
            System.out.print("Ingresa una expresión (ej. 123 + 456): ");
            String linea = sc.nextLine();
            System.out.println(linea);
            String[] partes = linea.split(" ");
            if (partes.length != 3) {
                System.out.println("Formato inválido. Usa: número operador número"); continue;
            }
            BigInteger num1 = new BigInteger(partes[0]);
            String operador = partes[1];
            BigInteger num2 = new BigInteger(partes[2]);

            if (num1.compareTo(MAX_INT) > 0) {
                System.out.println("first number too big");
            }

            if (num2.compareTo(MAX_INT) > 0) {
                System.out.println("second number too big");
            }

            BigInteger resultado;
            if (operador.equals("+")) {
                resultado = num1.add(num2);
            } else if (operador.equals("*")) {
                resultado = num1.multiply(num2);
            } else {
                System.out.println("Operador inválido. Usa '+' o '*'");
                continue;
            }

            if (resultado.compareTo(MAX_INT) > 0) {
                System.out.println("result too big");
            }

        }

    }
}