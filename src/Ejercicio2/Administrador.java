package Ejercicio2;

public class Administrador extends Persona {
    public Administrador(String id, String nombre) throws ValidarNombre {
        if(nombre.equals("Daniela") || nombre.equals("Valeria") || nombre.equals("Valentina") || nombre.equals("Isaac")){
            throw new ValidarNombre("Un administrador no puede tener este nombre");
        }
        this.setId(id);
        this.setNombre(nombre);
    }
}
