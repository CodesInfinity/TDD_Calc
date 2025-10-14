package pkg;

import java.util.ArrayList;
import java.util.List;

public class Cuenta {
    private String numero;
    private String titular;
    private List<Movimiento> movimientos;
    private static final double LIMITE_DESCUBIERTO = 500.0;
    
    public Cuenta(String numero, String titular, double saldoInicial) {
        this.numero = numero;
        this.titular = titular;
        this.movimientos = new ArrayList<>();
        
        // Registrar saldo inicial como un ingreso
        if (saldoInicial > 0) {
            movimientos.add(new Movimiento(saldoInicial, Movimiento.Signo.H, "Saldo inicial"));
        }
    }
    
    public void ingresar(double x) {
        if (x > 0) {
            movimientos.add(new Movimiento(x, Movimiento.Signo.H, "Ingreso"));
        }
    }
    
    public void retirar(double x) {
        if (x > 0) {
            double saldoActual = getSaldo();
            if (saldoActual - x >= -LIMITE_DESCUBIERTO) {
                movimientos.add(new Movimiento(x, Movimiento.Signo.D, "Reintegro"));
            } else {
                throw new IllegalArgumentException("Fondos insuficientes. Saldo: " + saldoActual + "€, Límite: " + LIMITE_DESCUBIERTO + "€");
            }
        }
    }
    
    public double getSaldo() {
        double saldo = 0.0;
        for (Movimiento mov : movimientos) {
            if (mov.getSigno() == Movimiento.Signo.H) {
                saldo += mov.getImporte();
            } else {
                saldo -= mov.getImporte();
            }
        }
        return saldo;
    }
    
    public String getNumero() { return numero; }
    public String getTitular() { return titular; }
    public List<Movimiento> getMovimientos() { return movimientos; }
}
