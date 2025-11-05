package Ejercicio2;

import java.math.BigDecimal;

public class Cliente extends Persona {
    BigDecimal montoCompra;
    public Cliente(String id, String nombre, BigDecimal montoCompra) {
        super(id, nombre);
        this.montoCompra = montoCompra;
    }
    public BigDecimal getMontoCompra() {
        return montoCompra;
    }
}
