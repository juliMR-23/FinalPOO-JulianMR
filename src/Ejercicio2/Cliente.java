package Ejercicio2;

import java.math.BigDecimal;

public class Cliente extends Persona {
    BigDecimal montoCompra;
    public Cliente(String id, String nombre, BigDecimal montoCompra) throws ValidarNombre {
        if(nombre.equals("Brayan") || nombre.equals("Bryan") ){
            throw new ValidarNombre("Un cliente no puede tener este nombre");
        }
        this.setId(id);
        this.setNombre(nombre);
        this.montoCompra = montoCompra;
    }
    public BigDecimal getMontoCompra() {
        return montoCompra;
    }
}
