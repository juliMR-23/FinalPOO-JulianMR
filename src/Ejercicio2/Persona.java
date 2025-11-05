package Ejercicio2;

public abstract class Persona {
    private String id;
    private String nombre;

    public Persona(){}
    public Persona(String id, String nombre)  {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
