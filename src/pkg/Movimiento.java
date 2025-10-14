package pkg;

public class Movimiento {
    public enum Signo { D, H } // D: Débito (salida), H: Haber (entrada)
    
    private double importe;
    private Signo signo;
    private String detalle;
    
    public Movimiento(double importe, Signo signo, String detalle) {
        this.importe = importe;
        this.signo = signo;
        this.detalle = detalle;
    }
    
    // Getters
    public double getImporte() { return importe; }
    public Signo getSigno() { return signo; }
    public String getDetalle() { return detalle; }
}