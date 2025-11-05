package Ejercicio3;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        final int MAX_INT = Integer.MAX_VALUE;
        System.out.println("Ingrese la cantidad de entradas que le dará al programa");
        int n=Integer.parseInt(sc.nextLine());
        for(int i=1;i<=n;i++){
            System.out.print("Ingresa una expresión (ej. 123 + 456): ");
            String linea = sc.nextLine();
            System.out.println(linea);
            String[] partes = linea.split(" ");
            if (partes.length != 3) {
                System.out.println("Formato inválido"); continue;
            }
            long num1 = Long.parseLong(partes[0]);
            String operador = partes[1];
            long num2 = Long.parseLong(partes[2]);

            if (num1>MAX_INT) {
                System.out.println("first number too big");
            }

            if (num2>MAX_INT) {
                System.out.println("second number too big");
            }

            long resultado;
            if (operador.equals("+")) {
                resultado = num1+num2;
            } else if (operador.equals("*")) {
                resultado = num1*num2;
            } else {
                System.out.println("Operador inválido");
                continue;
            }

            if (resultado>MAX_INT) {
                System.out.println("result too big");
            }

        }

    }
}