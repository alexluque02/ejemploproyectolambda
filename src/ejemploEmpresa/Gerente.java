package ejemploEmpresa;

public class Gerente extends Trabajador{
	
	private double porcExtra;

	public Gerente(String dni, String nombre, int edad, double horasTrabajadas, double porcExtra) {
		super(dni, nombre, edad, horasTrabajadas);
		this.porcExtra=porcExtra;
	}

	public double getPorcExtra() {
		return porcExtra;
	}

	public void setPorcExtra(double porcExtra) {
		this.porcExtra = porcExtra;
	}

	@Override
	public String toString() {
		return super.toString()+"Gerente [porcExtra=" + porcExtra + "]";
	}

	public double calcularSueldo(double sueldoHora) {
		return super.calcularSueldo(sueldoHora)+super.calcularSueldo(sueldoHora)*sueldoHora/100;
	}
}
