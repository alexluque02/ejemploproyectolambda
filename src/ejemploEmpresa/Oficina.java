package ejemploEmpresa;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Oficina {

	private List <Trabajador> lista = new ArrayList <Trabajador> ();

	public Oficina(List<Trabajador> lista) {
		super();
		this.lista = lista;
	}

	public List<Trabajador> getLista() {
		return lista;
	}

	public void setLista(List<Trabajador> lista) {
		this.lista = lista;
	}

	@Override
	public String toString() {
		return "Oficina [lista=" + lista + "]";
	}
	
	public void agregar(Trabajador t) {
		lista.add(t);
		//Esta la posibilidad de añadirlo con interfaces funcionales pero no 
		//va a tener uso en métodos por lo que es un sin sentido
	}
	
	public void mostrar() {
		lista.forEach(System.out::println);
	}
	
	public void editHoras (Trabajador t, double horas) {
		t.setHorasTrabajadas(horas);
	}
	
	public void borrar (Trabajador t) {
		lista.remove(t);
	}
	
	public void mostrarOrdenado() {
		lista.sort((a, b)->a.getNombre().toLowerCase().compareTo(b.getNombre().toLowerCase()));
	}
	
	public Double calcularSueldoUnEmpleado(Trabajador t, double sueldoHora) {
		BiFunction<Trabajador, Double, Double> calculo = Trabajador::calcularSueldo;
		return calculo.apply(t, sueldoHora);
	}
	
	public Trabajador findByDni(String dni) {
		return lista.stream()
				.filter(e->e.getDni().equalsIgnoreCase(dni))
				.findFirst()
				.get();
	}
	
	public void mostrarEmpleado(Trabajador t) {
		if(t!=null){
			System.out.println(t);
		}else {
			System.out.println("No se ha encontrado");
		}
	}
	
	public boolean comprobarMayoresSesenta(Trabajador t) {
		Predicate <Trabajador> mayores = a -> a.getEdad()>60;
		return mayores.test(t);
	}
	
	public Trabajador comprobarMayor() {
		Trabajador t=new Trabajador();
		Function<Trabajador, Trabajador> trabajadorMayor= (mayor) -> {
			int i=0;
			mayor=lista.get(0);
			while(i<lista.size()) {
				if(lista.get(i).getEdad()>mayor.getEdad()) {
					mayor=lista.get(i);
				}
				i++;
			}
			return mayor;
		};
		return trabajadorMayor.apply(t);
	}
	
	public List<Trabajador> listarMayores (){
		Supplier <List<Trabajador>> listaMayores = () -> {
				List <Trabajador> encontrado = new ArrayList <Trabajador> ();
				for (Trabajador trabajador : lista) {
					if(trabajador.getEdad()>60) {
						encontrado.add(trabajador);
					}
				}
				return encontrado;
		};
		return listaMayores.get();
	}
	
	public double calcularMediaSueldo(double sueldoHora) {
		double suma=0;
		BiFunction <Double, Double, Double> op = (n, n1) -> {
			for (Trabajador trabajador : lista) {
				n+=trabajador.calcularSueldo(n1);
			}
			return n/lista.size();
		};
		return op.apply(suma, sueldoHora);
	}
}
