package pkg;

public class Cuenta {

	String numero;
	String titular;
	double saldo;
	
	public Cuenta(double saldo) {
		this.saldo = saldo;
	}

	public void ingresar(double i) {
		// TODO Auto-generated method stub
		this.saldo += i;
	}

	public void retirar(double i) {
		// TODO Auto-generated method stub
		this.saldo -= i;
	}
	
	public double getSaldo() {
		// TODO Auto-generated method stub
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
