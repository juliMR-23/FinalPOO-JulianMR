package Ejercicio2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

public class Main {
    static Scanner sc = new Scanner(System.in);

    static int elige(int a, int b) {
        while(true){
            try {
                int x = Integer.parseInt(sc.nextLine());
                if(x>=a && x<=b){
                    return x;
                }
                System.out.println("Ingrese un numero entre "+a+" y "+b);
            }catch(NumberFormatException e){
                System.out.println("Ingrese un numero entero");
            }
        }
    }

    static <T> T crearPersona(ArrayList<Persona> personas) throws ValidarNombre {
        System.out.println("Ingrese el id de la persona");
        String id = sc.nextLine();
        for(int i=0;i<personas.size();i++){
            if(personas.get(i).getId().equals(id)){
                System.out.println("El id de la persona ya existe, ingrese otro");
                id = sc.nextLine(); i=-1;
            }
        }
        System.out.println("Ingrese el nombre de la persona");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el número según el rol\n1. Administrador\n2. Cliente\n0. Cancelar creación");
        switch (elige(0, 2)){
            case 1:
                Administrador a;
                try {
                    a = new Administrador(id, nombre);
                }catch (ValidarNombre e){
                    System.out.println(e.getMessage()); return null;
                }
                return (T) a;
            case 2:
                System.out.println("Ingrese el monto de compra");
                BigDecimal monto = new BigDecimal(sc.nextLine());
                Cliente c;
                try {
                    c = new Cliente(id, nombre, monto);
                }catch (ValidarNombre e){
                    System.out.println(e.getMessage()); return null;
                }
                return (T) c;
        }
        return null;
    }
    static int menu(){
        System.out.println("===========MENU===========");
        System.out.println("1. Crear persona");
        System.out.println("2. Cliente con mayor monto");
        System.out.println("3. Promedio de monto");
        System.out.println("0. Salir");
        return elige(0, 3);
    }

    public static void main(String[] args) throws ValidarNombre {
        ArrayList<Persona> personas = new ArrayList<>();
        personas.add(new Administrador("admin01", "Rafael"));
        personas.add(new Administrador("admin02", "Esteban"));
        personas.add(new Administrador("admin03", "Manuela"));
        personas.add(new Cliente("cliente01", "Juan", new BigDecimal(130000)));
        personas.add(new Cliente("cliente02", "Juan", new BigDecimal(65000)));
        personas.add(new Cliente("cliente03", "Juan", new BigDecimal(200000)));//más platudo
        boolean salir=false;
        while(!salir){
            switch (menu()){
                case 1:
                    Persona persona = crearPersona(personas);
                    if(persona!=null){
                        personas.add(persona);
                        System.out.println("Creación exitosa"); break;
                    }
                    System.out.println("Operación cancelada");
                    break;
                case 2:
                    Cliente clienteMayor = null;
                    for (Persona p : personas) {
                        if (p instanceof Cliente) {
                            Cliente c = (Cliente) p;
                            if (clienteMayor == null || c.getMontoCompra().compareTo(clienteMayor.getMontoCompra()) > 0) {
                                clienteMayor = c;
                            }
                        }
                    }
                    if (clienteMayor == null) {
                        System.out.println("No existe ningún cliente"); break;
                    } else {
                        System.out.println("Cliente con mayor monto:");
                        System.out.println("ID: " + clienteMayor.getId());
                        System.out.println("Nombre: " + clienteMayor.getNombre());
                        System.out.println("Monto de compra: " + clienteMayor.getMontoCompra());
                    }
                    break;
                case 3:
                    int count=0; BigDecimal suma = BigDecimal.ZERO;
                    for (Persona p : personas) {
                        if (p instanceof Cliente) {
                            count++;
                            suma = suma.add(((Cliente) p).getMontoCompra());
                        }
                    }
                    if(count==0){
                        System.out.println("No existe ningún cliente"); break;
                    }
                    BigDecimal promedio = suma.divide(BigDecimal.valueOf(count), 3, BigDecimal.ROUND_HALF_UP);
                    System.out.println("Promedio monto de compra: "+promedio);
                    break;
                case 0: salir=true;
            }
        }


    }

}